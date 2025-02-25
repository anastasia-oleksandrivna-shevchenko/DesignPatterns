import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Warehouse implements AddProducts, UpdateQuantity, ShowData {
    private Map<Product, Integer> products;
    private LocalDate lastArrivalDate;

    public Warehouse(LocalDate lastArrivalDate) {
        this.products = new HashMap<>();
        this.lastArrivalDate = lastArrivalDate;
    }

    @Override
    public void addProduct(Product product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }
    @Override
    public void updateQuantity(Product product, int quantity) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + quantity);
        } else {
            throw new IllegalArgumentException("Product not found");
        }
    }
    @Override
    public void show() {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(product + ", quantity=" + quantity);
        }
    }
    public int getQuantity(Product product) {
        return products.getOrDefault(product, 0);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

}
