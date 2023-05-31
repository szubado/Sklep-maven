package camp.db;

import camp.model.Product;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository implements IProductRepository {

    private List<Product> productList = new ArrayList<>();

/*    public ProductRepository() {
        productList.add(new Product("Ekran", 5, 23));
        productList.add(new Product("Myszka", 3, 43));
        productList.add(new Product("Klawiatura", 8, 65));
        productList.add(new Product("Laptop", 2, 1234));
    }*/

    @Override
    public void changeInMag(String whatClientWants, int howMuchClientWants) {
        for (Product product : this.productList) {
            if (product.getProductName().toUpperCase().equals(whatClientWants)) {
                if (howMuchClientWants <= product.getAmount()) {
                    product.setAmount(product.getAmount() - howMuchClientWants);
                    System.out.println("Kwota do zaplaty : " + howMuchClientWants * product.getPrice() + " zl");
                    //return wychodzi z funkcji
                    return;
                } else {
                    System.out.println("W magazynie jest tylko " + product.getAmount());
                    return;
                }
            }
        }
        System.out.println("Niepoprawna nazwa produktu");
    }

    @Override
    public void adminChangeInMag(String whatAdminWants, int howMuchAdminWants) {
        for (Product product : this.productList) {
            if (product.getProductName().toUpperCase().equals(whatAdminWants)) {
                product.setAmount(product.getAmount() + howMuchAdminWants);
            }
        }
    }
    @Override
    public List<Product> getProductList() {
        return productList;
    }
    @Override
    public void addProductFromFile(Product product) {
        this.productList.add(product);
    }
}
