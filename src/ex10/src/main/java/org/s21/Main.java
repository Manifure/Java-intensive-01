package org.s21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = inputUsers();
        List<String> adultNames = filterAdultUsers(users);
        printResults(adultNames);
    }

    public static List<User> inputUsers() {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        int count = readInt(scanner);
        if (count <= 0) {
            return users;
        }

        for (int i = 0; i < count; i++) {
            User user = readUser();
            if (user != null) {
                users.add(user);
            } else {
                count++;
            }
        }
        return users;
    }

    public static int readInt(Scanner scanner) {
        try {
            System.out.println("Please enter a number: ");
            int number = scanner.nextInt();
            if (number <= 0) {
                System.out.println("Incorrect input. Number <= 0");
            }
            return number;
        } catch (NumberFormatException e) {
            System.out.println("Couldn't parse a number. Please, try again");
            return readInt(scanner);
        }
    }

    public static User readUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a name: ");
        String name = scanner.nextLine();

        int age = readUserAge(scanner);
        if (age <= 0) {
            return null;
        }
        return new User(name, age);
    }

    public static int readUserAge(Scanner scanner) {
        try {
            System.out.println("Please enter age: ");
            int age = scanner.nextInt();
            if (age <= 0) {
                System.out.println("Incorrect input. Age <= 0");
            }
            return age;
        } catch (NumberFormatException e) {
            System.out.println("Couldn't parse age. Please, try again");
            return readUserAge(scanner);
        }
    }

    public static List<String> filterAdultUsers(List<User> users) {
        return users.stream()
                .filter(user -> user.getAge() >= 18)
                .map(User::getName)
                .collect(Collectors.toList());
    }

    public static void printResults(List<String> names) {
        if (names.isEmpty()) {
            return;
        }
        System.out.println(String.join(", ", names));
    }
}