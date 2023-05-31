package camp.gui;

import camp.model.Product;
import camp.model.User;

import java.util.List;

public interface IGUI {
    public String showMenu(boolean admin);

    public String showFirstMenu();

    public String readProduct();

    public int readAmount();

    public void listProduct(List<Product> listaProduktow);

    public User readLoginAndPassword();
}
