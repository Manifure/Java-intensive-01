package org.s21;

import java.util.Scanner;

public class Main {

    public static void inputArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int temp = 0;
        int count = 0;

        if (!sc.hasNextInt()) {
            System.out.println("Input error");
            return;
        }

        while (sc.hasNextInt()) {

            int n = sc.nextInt();

            if (n >= temp) {
                temp = n;
                count++;
            } else {
                System.out.println("The sequence is not ordered from the ordinal number of the number " + count);
                return;
            }

        }
        System.out.println("The sequence is ordered in ascending order");
    }

    public static void main(String[] args) {
        inputArray();
    }
}