package camp.gui;
import camp.model.Product;
import camp.model.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Scanner;
@Component
public class GUI implements IGUI{
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String showMenu(boolean admin) {
        System.out.println("1. Wyswietl produkty");
        System.out.println("2. Kup produkt");
        System.out.println("3. Wyloguj");
        if (admin) {
            System.out.println("4. Zmien ilosc produktow");
        }
        String a = scanner.nextLine();
        return a;
    }
    @Override
    public String showFirstMenu() {
        System.out.println("1. Zaloguj");
        System.out.println("2. Zarejestruj");
        System.out.println("3. Exit");
        return scanner.nextLine();
    }
    @Override
    public String readProduct() {
        System.out.println("Wpisz nazwe produktu");
        return scanner.nextLine();
    }
    @Override
    public int readAmount() {
        System.out.println("Podaj ilosc prodktow");
        //wczytanie calej linii z enterem po czym zmiana na liczbe gdzie tracimy enter
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
    @Override
    public void listProduct(List<Product> productList) {
        for (Product product : productList) {
            if (product.getAmount() != 0) {
                System.out.println(new StringBuilder()
                        .append(product.getProductName())
                        .append(" Cena: ")
                        .append(product.getPrice())
                        .append(" Ilosc w magazynie: ")
                        .append(product.getAmount())
                        .toString());
            }
        }
    }
    @Override
    public User readLoginAndPassword() {
        String seed = "NJAPnSeP9zJoOcqNwgCZ2GHsTHfWQT";
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, DigestUtils.md5Hex(scanner.nextLine() + seed), "user");
    }
}


