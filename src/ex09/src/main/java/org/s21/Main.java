package org.s21;

import java.util.ArrayList;
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

    public static void addToList(ArrayList<String> list, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter strings: ");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
    }

    public static String inputSubstring() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter substring: ");

        return sc.nextLine();
    }

    private static void containSubstring(String string, String substring) {
        boolean found = false;
        if (string.length() > substring.length()) {
            for (int i = 0; i < string.length() - substring.length(); i++) {
                found = true;
                for (int j = 0; j < substring.length(); j++) {
                    if (string.charAt(i + j) != substring.charAt(j)) {
                        found = false;
                        break;
                    }
                }
            }
        }
        if (found) {
            System.out.printf("%s ", string);
        }
    }

    public static void findSubstring(ArrayList<String> list, String substring) {
        for (int i = 0; i < list.size(); i++) {
            containSubstring(list.get(i), substring);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        int n = inputN();

        addToList(list, n);

        String s = inputSubstring();

        findSubstring(list, s);
    }
}