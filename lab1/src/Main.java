//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Money money1 = new Money("USD", 100, 50);
        Money money2 = new Money("USD", 50, 75);

        money1.show();
        money2.show();

        System.out.println("\nAfter changing price:");
        money1.setMoney(120, 25);
        money1.show();

        Product bread = new Product("Bread", 10, 39, "loaves");
        Product potato = new Product("Potato", 15, 6, "kg");

        System.out.println("\nBefore reducing price:");
        bread.show();
        potato.show();

        bread.redusePrice(10.00);
        System.out.println("\nAfter reducing price:");
        bread.show();


        Warehouse warehouse = new Warehouse(LocalDate.of(2025, 2, 11));
        warehouse.addProduct(bread, 50);
        warehouse.addProduct(potato, 100);

        System.out.println("\nProducts in Warehouse:");
        warehouse.show();

        // Оновлення кількості товару в складі
        warehouse.updateQuantity(bread, 30);
        warehouse.updateQuantity(potato, -20);

        System.out.println("\nProducts in Warehouse After Update:");
        warehouse.show();

        Reporting reporting = new Reporting(warehouse);

        reporting.registerReceipt(bread, 30);
        reporting.registerReceipt(potato, 150);

        reporting.inventoryReport();

        reporting.registerShipment(bread, 30);

        reporting.inventoryReport();
    }
}