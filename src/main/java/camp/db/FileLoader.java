package camp.db;
import camp.model.Product;
import camp.model.User;
import camp.model.Writable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Component
public class FileLoader implements IFileLoader {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    public void readDataFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("db.csv"));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] objectData = line.split(";");
            String[] vars = Arrays.copyOfRange(objectData, 1, objectData.length);
            switch (objectData[0]) {
                case "Product":
                    this.productRepository.addProductFromFile(new Product(vars));
                    break;
                case "User":
                    this.userRepository.addUserFromFile(new User(vars));
                    break;
                default:
                    System.out.println("Nieoczekiwany typ klasy");
                    break;
            }
        }
        reader.close();
    }
    public void saveDataToFile() throws IOException {
        Collection<Writable> entries = new ArrayList<>();
        entries.addAll(this.productRepository.getProductList());
        entries.addAll(this.userRepository.getUsers());
        BufferedWriter writer =
                new BufferedWriter(new FileWriter("db.csv"));
        boolean firstTime = true;
        for (Writable entry : entries) {
            String lineInFile = entry.toCSV();
            if (!firstTime) {
                writer.newLine();
            }
            firstTime = false;
            writer.write(lineInFile);
        }
        writer.close();
    }
}
