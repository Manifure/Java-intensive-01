package org.s21;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    private static String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file path: ");
        return scanner.nextLine();
    }

    public static void fileRead(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file).useLocale(Locale.US)) {
            int size = readInt(scanner);
            if (size < 0) return;

            double[] numbers = readNumbers(scanner, size);
            if (numbers == null) return;

            printNumbers(numbers);
            saveMinMax(numbers);
        }


    }

    private static int readInt(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("Couldn't parse a number.");
            return -1;
        }

        int size = scanner.nextInt();
        if (size <= 0) {
            System.out.println("Input error. Size <= 0");
            return -1;
        }
        return size;
    }

    private static double[] readNumbers(Scanner scanner, int size) {
        double[] numbers = new double[size];
        int counter = 0;

        while (counter < size && scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                numbers[counter++] = scanner.nextDouble();
            } else {
                scanner.next();
            }
        }

        if (counter < size) {
            System.out.println("Input error. Insufficient number of elements");
            return null;
        }
        return numbers;
    }

    private static void printNumbers(double[] numbers) {
        System.out.println(numbers.length);
        for (double number : numbers) {
            System.out.printf("%.1f ", number);
        }
        System.out.println();
    }

    private static void saveMinMax(double[] arr) {
        double min = arr[0];
        double max = arr[0];

        for (double val : arr) {
            if (val < min) min = val;
            if (val > max) max = val;
        }

        try (PrintWriter pw = new PrintWriter("result.txt")) {
            pw.print(min + " " + max);
            System.out.println("Saving min and max values in file");
        } catch (FileNotFoundException e) {
            System.out.println("Error saving results");
        }
    }

    public static void main(String[] args) {
        String filePath = getFilePath();
        try {
            fileRead(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Input error. File isn't exist");
        }
    }
}