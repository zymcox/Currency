package se.lexicom;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine().trim();
            if (choice.equalsIgnoreCase("E")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
            handleChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\nCurrency Converter Menu:");
        System.out.println("1. Convert SEK to USD");
        System.out.println("2. Convert SEK to Euro");
        System.out.println("3. Convert USD to SEK");
        System.out.println("4. Convert USD to Euro");
        System.out.println("5. Convert Euro to SEK");
        System.out.println("6. Convert Euro to USD");
        System.out.println("E. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleChoice(String choice) {
        switch (choice) {
            case "1" -> convertCurrency("SEK", "USD");
            case "2" -> convertCurrency("SEK", "EUR");
            case "3" -> convertCurrency("USD", "SEK");
            case "4" -> convertCurrency("USD", "EUR");
            case "5" -> convertCurrency("EUR", "SEK");
            case "6" -> convertCurrency("EUR", "USD");
            default -> System.out.println("Invalid choice. Please try again.");
        }
    }

    private void convertCurrency(String from, String to) {
        System.out.print("Enter amount in " + from + ": ");
        try {
            double amount = Double.parseDouble(scanner.nextLine().trim());
            if (amount < 0) {
                System.out.println("Amount cannot be negative. Please try again.");
            } else {
                String result = Converter.convert(from, to, amount);
                System.out.println(result);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
