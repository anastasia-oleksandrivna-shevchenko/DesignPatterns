import java.util.Map;

public class Reporting implements ProductReceipt, ProductShipment, InventoryReport {
    private Warehouse warehouse;

    public Reporting(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void registerReceipt(Product product, int quantity) {
        if (warehouse.getProducts().containsKey(product)) {
            warehouse.updateQuantity(product, quantity);
        } else {
            warehouse.addProduct(product, quantity);
        }
        System.out.println("Product receipt: " + product.getName() + ", Quantity: " + quantity);
    }
    @Override
    public void registerShipment(Product product, int quantity) {
        if (warehouse.getQuantity(product) < quantity) {
            throw new IllegalArgumentException("Insufficient stock for shipment");
        }
        warehouse.updateQuantity(product, -quantity);
        System.out.println("Product shipment: " + product.getName() + ", Quantity: " + quantity);
    }
    @Override
    public void inventoryReport() {
        System.out.println("Inventory report:");
        for (Map.Entry<Product, Integer> entry : warehouse.getProducts().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Quantity: " + quantity);
        }
    }

}
