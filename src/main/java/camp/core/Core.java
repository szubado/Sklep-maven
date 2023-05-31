package camp.core;

import camp.db.IFileLoader;
import camp.db.IProductRepository;
import camp.db.IUserRepository;
import camp.gui.IGUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Core implements ICore {
    @Autowired
    private IAuthenticator authenticator;
    @Autowired
    private IProductRepository database;
    @Autowired
    private IUserRepository userRep;
    @Autowired
    private IGUI gui;
    @Autowired
    private IFileLoader fileLoader;

    @Override
    public void start() {
        try {
            fileLoader.readDataFromFile();
        } catch (IOException e) {
            System.out.println("Blad wczytywania bazy danych");
            return;
        }

        firstloop:
        while (true) {
            switch (gui.showFirstMenu()) {
                case "1":
                    int currentUser = authenticator.authenticate();
                    if (currentUser > 0) {
                        mainloop:
                        while (true) {
                            switch (gui.showMenu(currentUser == 1)) {
                                case "1":
                                    gui.listProduct(database.getProductList());
                                    break;
                                case "2":
                                    String whatClientWants = gui.readProduct();
                                    int howMuchClientWants = gui.readAmount();
                                    // uzyskanie dostepu po nazwie do ilosci
                                    database.changeInMag(whatClientWants.toUpperCase(), howMuchClientWants);
                                    break;
                                case "3":
                                    break mainloop;
                                case "4":
                                    String AdminToChange = gui.readProduct();
                                    int howMuchAdminWants = gui.readAmount();
                                    database.adminChangeInMag(AdminToChange.toUpperCase(), howMuchAdminWants);
                                    break;
                                default:
                                    System.out.println("Niepoprawny numer");
                                    break;
                            }
                        }
                    }
                    break;
                case "2":
                    userRep.addUser();
                    break;
                case "3":
                    try {
                        fileLoader.saveDataToFile();
                        break firstloop;
                    } catch (IOException e) {
                        System.out.println("Blad zapisu bazy danych !!");
                    }
            }
        }
    }
}
