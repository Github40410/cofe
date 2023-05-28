package service;

import java.util.Scanner;

public class Scan {

    public static int newScan() throws Exception{
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
