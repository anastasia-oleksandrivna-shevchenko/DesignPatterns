public class Money implements ShowData, SetMoney {

    private final String carrencyName;
    private int wholePart;
    private int fractionalPart;

    public Money (String carrencyName, int wholePart, int fractionalPart) {
        this.carrencyName = carrencyName;
        setMoney(wholePart, fractionalPart);
    }

    @Override
    public void show() {
        System.out.printf("Summa = %d.%02d %s ", wholePart, fractionalPart, carrencyName);
    }
    @Override
    public void setMoney(int wholePart, int fractionalPart) {
        if (wholePart < 0 || fractionalPart < 0) {
            throw new IllegalArgumentException("Money has to be positive");
        }
        this.wholePart = wholePart + fractionalPart / 100;
        this.fractionalPart = fractionalPart % 100;
    }

    public String getCarrencyName() {
        return carrencyName;
    }
    public int getWholePart() {
        return wholePart;
    }
    public int getFractionalPart() {
        return fractionalPart;
    }
    @Override
    public String toString() {
        return String.format("%d.%02d %s", wholePart, fractionalPart, carrencyName);
    }
}
