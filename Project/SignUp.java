import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SignUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Enter 1 to sign up or 2 to log in:");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Enter your name:");
                String name = scanner.nextLine();
                System.out.println("Enter your email:");
                String email = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();
                HashMap<String, String> user = new HashMap<>();
                user.put("name", name);
                user.put("email", email);
                user.put("password", password);
                try {
                    FileWriter csvWriter = new FileWriter("users.csv", true);
                    csvWriter.append(user.get("name") + ", " + user.get("email") + ", " + user.get("password") + "\n");
                    csvWriter.flush();
                    csvWriter.close();
                    System.out.println("User data saved successfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                System.out.println("Enter your email:");
                String email = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();
                // TODO: Implement login functionality
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Enter 1 to sign up again or 2 to log out:");
            int logoutChoice = scanner.nextInt();
            scanner.nextLine();
            if (logoutChoice == 2) {
                loggedIn = true;
            }
        }
    }
}
