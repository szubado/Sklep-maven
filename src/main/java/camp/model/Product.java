package camp.model;

public class Product implements Writable{

    private String productName;
    private int amount;
    private int price;

    public Product(String productName, int amount, int price) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }
    public Product(String[] vars) {
        this(vars[0], Integer.parseInt(vars[1]), Integer.parseInt(vars[2]));
    }
    public Product() {
    }
    @Override
    public String toCSV() {
        return new StringBuilder()
                .append(getClass().getSimpleName())
                .append(";")
                .append(this.productName)
                .append(";")
                .append(this.amount)
                .append(";")
                .append(this.price)
                .toString();
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String getProductName) {
        this.productName = getProductName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
