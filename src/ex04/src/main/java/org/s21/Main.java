package org.s21;

import java.util.Scanner;

public class Main {

    public static int inputN() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number: ");

            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Couldn't parse a number. Please, try again");
            return inputN();
        }
    }

    public static int[] inputArray(int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array: ");
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            try {
                array[i] = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Couldn't parse a number. Please, try again");
                sc.nextLine();
                i--;
            }
        }

        return array;
    }

    public static int negativeMean(int[] array) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                count++;
                sum += array[i];
            }
        }

        if (count == 0) {
            return 0;
        } else {
            return sum / count;
        }
    }

    public static void main(String[] args) {
        int n = inputN();
        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            int res = negativeMean(inputArray(n));
            if (res == 0) {
                System.out.println("There are no negative elements");
            } else {
                System.out.println(res);
            }
        }
    }
}