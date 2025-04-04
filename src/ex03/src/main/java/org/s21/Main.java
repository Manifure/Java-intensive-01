package org.s21;

import java.util.Scanner;

public class Main {
    public static int fibbonacci(int n) {
        if (n <= 1) {
            return n;
        } else if (n == 2) {
            return 1;
        } else {
            return fibbonacci(n - 1) + fibbonacci(n - 2);
        }
    }

    public static int input() {
        try  {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Couldn't parse a number. Please, try again");
            return input();
        }
    }

    public static void main(String[] args) {
        int n = input();
        if (n > 45) {
            System.out.println("Too large n");
        } else {
            int result = fibbonacci(n);
            System.out.println(result);
        }
    }
}