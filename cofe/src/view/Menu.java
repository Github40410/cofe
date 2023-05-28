package view;

import domain.Drinks;
import domain.Order;
import domain.Pizza;
import service.CreateOrder;
import service.Discounts;
import service.Scan;

import java.util.Arrays;

public class Menu {

    public static void startMenu(){

        System.out.println("*****Меню*****");
        int num = Pizza.values().length;
        Arrays.stream(Pizza.values()).forEach(p-> System.out.println(p.ordinal()+1 + " " + p.name() + "     " + "Цена за шт.:   " + p.getPrice()));
        Arrays.stream(Drinks.values()).forEach(d->System.out.println(d.ordinal()+num+1 + " " + d.name() + "     " + "Цена за шт.:   " + d.getPrice()));
        System.out.println(num+Drinks.values().length+1 + " " + "Получить счёт");
        System.out.println(num+Drinks.values().length+2 + " " + "Выйти");

        boolean check = true;
        while (check) {
            int cod = 0;
            int quantity = 0;
            try {
                System.out.println("Введите код продукта: ");
                cod = Scan.newScan();
            } catch (Exception e) {
                System.out.println("Введите число! ");
            }
            if(cod!=8) {
                try {
                    System.out.println("Введите количество(шт.): ");
                    quantity = Scan.newScan();
                } catch (Exception e) {
                    System.out.println("Введите число! ");
                }
            }

            switch (cod){
                case 1:
                    CreateOrder.createOrder(Pizza.Pepperoni, quantity);
                    break;
                case 2:
                    CreateOrder.createOrder(Pizza.Margaret, quantity);
                    break;
                case 3:
                    CreateOrder.createOrder(Pizza.Hawaiian, quantity);
                    break;
                case 4:
                    CreateOrder.createOrder(Pizza.Carbonara, quantity);
                    break;
                case 5:
                    CreateOrder.createOrder(Drinks.Cola, quantity);
                    break;
                case 6:
                    CreateOrder.createOrder(Drinks.Pepsi, quantity);
                    break;
                case 7:
                    CreateOrder.createOrder(Drinks.Coffee, quantity);
                    break;
                case 8:
                    Order order = CreateOrder.getOrder();
                    Discounts discounts = new Discounts();
                    Bill.startBill(order, discounts.calculateTheCost(order));
                    order.closeOrder();
                case 9:
                    check = false;
                    break;
                default:
                    System.out.println("Некорректное значение. Попробуйте снова.");
            }
        }
    }
}