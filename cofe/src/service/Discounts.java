package service;

import domain.Drinks;
import domain.GetPrice;
import domain.Order;
import domain.Pizza;

public class Discounts {

    private Order order;

    public double calculateTheCost(Order order){
        boolean dis = discountsDrinks(order);
        double priceDrinks;
        double sum;

        discountsPizza(order);
        priceDrinks = priceDrinks(order);

        sum = order.getSum();

        if(dis==true){
            sum = sum - priceDrinks*0.15;
        }

        if (sum>50){
            sum = sum*0.8;
        }

        return sum;
    }

    private void discountsPizza(Order order){
        int countPizza = 1;
        int id = 0;
        for (GetPrice e: order.getOrder()){
            for (Enum p: Pizza.values()){
                if(e.equals(p)&&countPizza%5==0){
                    countPizza++;
                    order.setElementPrice(0, id);
                }
                else if (e.equals(p)&&countPizza%5!=0) countPizza++;
            }
            id++;
        }
    }

    private boolean discountsDrinks(Order order){
        int countDrinks = 0;
        boolean discounts = false;
        for (GetPrice e: order.getOrder()){
            for (Enum p: Drinks.values()){
                if(e.equals(p)&&e.getPrice()>2){
                    countDrinks++;
                }
                if(countDrinks>3){
                    discounts = true;
                }
            }
        }
        return discounts;
    }

    private int priceDrinks(Order order){
        int sumDrinkPrice = 0;
        for (GetPrice e: order.getOrder()){
            for (Enum p: Drinks.values()){
                if(e.equals(p)){
                    sumDrinkPrice+=e.getPrice();
                }
            }
        }
        return sumDrinkPrice;
    }
}
