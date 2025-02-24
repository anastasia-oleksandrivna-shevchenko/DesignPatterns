public class Product implements RedusePrice, ShowProduct {
    private final String name;
    private Money price;
    private final String unitOfMeasure;

    public Product(String name, int wholePart, int fractionalPart, String unitOfMeasure) {
        this.name = name;
        this.price = new Money("GRN", wholePart, fractionalPart);
        this.unitOfMeasure = unitOfMeasure;
    }

    @Override
    public void redusePrice(double amount) {
        double fullPrice = (double)price.getWholePart() + (double)price.getFractionalPart()/100.0;
        if(amount > fullPrice) {
            throw new IllegalArgumentException("Amount is greater than price");
        }
        else if(amount < 0) {
            throw new IllegalArgumentException("Amount can`t be less than zero");
        }
        double newPrice = fullPrice - amount;

        int newWholePart = (int)Math.round(newPrice);
        int newFractionalPart = (int)Math.round((newPrice - newWholePart)*100);

        this.price.setMoney(newWholePart, newFractionalPart);
    }
    @Override
    public void displayProduct()
    {
        System.out.println("Product Name: " + name);
        System.out.println("Product Price: " + price);
        System.out.println("Unit of Measure: " + unitOfMeasure);
    }

    public String getName() {
        return name;
    }
    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }
    public double getPrice() {
        return (double)(price.getWholePart() + (double)price.getFractionalPart()/100.0);
    }
    @Override
    public String toString() {
        return "name=" + name + ", unit=" + unitOfMeasure + ", price=" + price;
    }
}
