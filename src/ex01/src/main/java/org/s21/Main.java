package org.s21;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in).useLocale(Locale.US)) {
            System.out.println("Enter the triangle coordinate: ");
            double x1 = scan.nextDouble();
            double y1 = scan.nextDouble();
            double x2 = scan.nextDouble();
            double y2 = scan.nextDouble();
            double x3 = scan.nextDouble();
            double y3 = scan.nextDouble();

            //проверка на вырожденный треугольник
            double area = 0.5 * Math.abs((x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1));

            final double EPSILON = 1e-9;

            if (area < EPSILON) {
                System.out.println("It isn't triangle");
            } else {
                double ab = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                double bc = Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
                double ca = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));

                double perimeter = Math.round((ab + bc + ca) * 1000.0) / 1000.0;

                System.out.println("The perimeter is: " + perimeter);
            }
        } catch (Exception e) {
            System.out.println("Couldn't parse a number. Please, try again");
        }
    }
}