package view;

import domain.Drinks;
import domain.GetPrice;
import domain.Order;
import domain.Pizza;

import java.util.ArrayList;

public class Bill {

    public static void startBill(Order order, double sum){
        System.out.println("******Счёт*****");
        Pizza[] pizza = Pizza.values();
        Drinks[] drinks = Drinks.values();
        makBill(pizza, order);
        makBill(drinks, order);
        System.out.println("Итого к оплате с учётом скидок:   " + sum);
        System.out.println("_______________");
    }

    private static void makBill(Enum[] en, Order order){
        for(Enum e: en){
            int count = 0;
            int price = 0;
            ArrayList<Double> priceList = order.getPriceList();
            for (int i = 0; i<order.getOrder().size(); i++){
                if(order.getOrder().get(i).equals(e)){
                    count++;
                    price+=priceList.get(i);
                }
            }
            if(count>0){
                System.out.println(e.name() + "   " + count + "  " + "шт.  " + " цена: " + price);
            }
        }
    }
}
