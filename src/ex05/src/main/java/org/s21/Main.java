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
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            try {
                System.out.println("Enter element : ");
                arr[i] = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Couldn't parse a number. Please, try again");
                sc.nextLine();
                i--;
            }
        }
        return arr;
    }

    public static boolean sameFirstLast(int number) {
        int last = number % 10;
        int first = number;

        if (number == 0) return true;

        while (first >= 10) {
            first /= 10;
        }
        return first == last;
    }

    public static int[] filter(int[] numbers) {
        int count = 0;
        for (int number : numbers) {
            if (sameFirstLast(number)) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : numbers) {
            if (sameFirstLast(num)) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = inputN();
        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            int[] res = filter(inputArray(n));
            if (res.length == 0) {
                System.out.println("There are no such elements");
            } else {
                for (int num : res) {
                    System.out.print(num + " ");
                }
            }
        }
    }
}