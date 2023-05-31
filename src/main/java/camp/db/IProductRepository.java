package camp.db;

import camp.model.Product;

import java.util.List;

public interface IProductRepository {

    public void changeInMag(String coChceKlient, int ileChceKlient);

    public void adminChangeInMag(String coChceAdmin, int ileChceAdmin);

    public List<Product> getProductList();
    public void addProductFromFile(Product product);

}
