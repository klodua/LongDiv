package ua.com.foxminded.longdivision;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input dividend and divisor");
        Scanner scan = new Scanner(System.in);
        int dividend = 0;
        int divisor = 0;
        while (true) {
            try {
                dividend = Integer.valueOf(scan.nextLine().trim());
                divisor  = Integer.valueOf(scan.nextLine().trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Only integers");
                return;
            }
        }
        ResultFormatter resultFormatter = new ResultFormatter();
        System.out.print(resultFormatter.divide(dividend, divisor));
    }
}