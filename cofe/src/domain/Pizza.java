package domain;

public enum Pizza implements GetPrice {
    Pepperoni(4),
    Margaret(5),
    Hawaiian(6),
    Carbonara(7);

    private final int price;

    Pizza(int price){
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
