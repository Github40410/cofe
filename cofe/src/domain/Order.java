package domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Order {

    private ArrayList<GetPrice> order;
    private ArrayList<Double> priceList;

    public Order(){
        this.order = new ArrayList<>();
        this.priceList = new ArrayList<>();
    }

    public void addProduct(GetPrice e){
        this.order.add(e);
        this.priceList.add((double) e.getPrice());
    }

    public ArrayList<Double> getPriceList() {
        return priceList;
    }

    public void setElementPrice(double price, int id){
        this.priceList.set(id, price);
    }

    public ArrayList<GetPrice> getOrder() {
        return order;
    }

    public void closeOrder(){
        this.order = new ArrayList<>();
    }

    public double getSum(){
        double sum = 0;
        for(double p: this.priceList){
            sum+=p;
        }
        return sum;
    }
}
