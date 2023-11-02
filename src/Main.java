import java.util.Scanner;

public class Main {
    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int userInput;
        while (true) {
            System.out.print(prompt);
            if (console.hasNextInt()) {
                userInput = console.nextInt();
                console.nextLine();  // Consume the newline character
                if (userInput >= low && userInput <= high) {
                    return userInput;
                } else {
                    System.out.println("Please enter a number within the specified range.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                console.nextLine();  // Consume the invalid input
            }
        }
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = console.next().trim().toLowerCase();
            console.nextLine();  // Consume the newline character
            if (input.equals("y") || input.equals("yes")) {
                return true;
            } else if (input.equals("n") || input.equals("no")) {
                return false;
            } else {
                System.out.println("Please enter 'Y' or 'N' to confirm.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int low = 1;
        int high = 100;
        int rowMove = Main.getRangedInt(console, "Enter a row number (1-100): ", low, high);
        int colMove = Main.getRangedInt(console, "Enter a column number (1-100): ", low, high);

        boolean isConfirmed = Main.getYNConfirm(console, "Do you want to proceed (Y/N)? ");
        if (isConfirmed) {
            System.out.println("User confirmed. Proceeding with row " + rowMove + " and column " + colMove + ".");
        } else {
            System.out.println("User chose not to proceed.");
        }

        console.close();
    }
}
