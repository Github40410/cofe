package service;

import domain.GetPrice;
import domain.Order;

public class CreateOrder {

    private static Order order = new Order();

    public static void createOrder(GetPrice e, int quantity){
        for(int i=0; i<quantity; i++){
            order.addProduct(e);
        }
    }

    public static Order getOrder() {
        return order;
    }
}
