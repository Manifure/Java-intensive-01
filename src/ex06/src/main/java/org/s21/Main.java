package org.s21;

import java.util.Locale;
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

    public static float[] inputArray(int n) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            try {
                System.out.println("Enter element : ");
                arr[i] = sc.nextFloat();
            } catch (Exception e) {
                System.out.println("Couldn't parse a number. Please, try again");
                sc.nextLine();
                i--;
            }
        }
        return arr;
    }

    public static void selectionSort(float[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int pos = i;
            float min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    pos = j;
                    min = arr[j];
                }
            }
            arr[pos] = arr[i];
            arr[i] = min;
        }
    }

    public static void main(String[] args) {
        int n = inputN();
        if (n <= 0) {
            System.out.println("Input error. Size <= 0");
        } else {
            float[] arr = inputArray(n);
            selectionSort(arr);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}