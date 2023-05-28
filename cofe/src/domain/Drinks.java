package domain;

public enum Drinks implements GetPrice {

    Cola(3),
    Pepsi(4),
    Coffee(2);

    private final int price;

    Drinks(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
