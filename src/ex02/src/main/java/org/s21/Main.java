package org.s21;

import java.util.Scanner;

public class Main {

    public static int in() {
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (Exception e) {
            System.out.println("Couldn't parse a number. Please, try again");
            return in();
        }
    }

    public static String calculate(int sec) {
        String res;
        if (sec < 0) {
            res = "Incorrect time";
        } else {
            res = String.format("%02d:%02d:%02d", sec / 3600, (sec % 3600) / 60, sec % 60);
        }

        return res;
    }

    public static void out(String res) {
        System.out.println(res);
    }

    public static void main(String[] args) {
        Main.out(Main.calculate(Main.in()));
    }
}