package view;

import service.Scan;

public class Start {

    public static void start() {

        boolean check = true;
        while (check){
            System.out.println("Стартовое меню:");
            System.out.println("Открыть меню  1");
            System.out.println("Уйти:         2");
            System.out.println("");
            System.out.print("Введите код операции: ");
            int cas = 0;
            try {
                cas = Scan.newScan();
            } catch (Exception e) {
                System.out.println("Введите число!");
                continue;
            }
            System.out.println("");

            switch (cas) {
                case 1:
                    Menu.startMenu();
                    break;
                case 2:
                    check = false;
                    break;
                default:
                    System.out.println("Некорректное значение. Попробуйте снова.");
            }
        }

    }
}
