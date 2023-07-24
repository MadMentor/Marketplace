package Project;

import Project.Startpageconstants;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Startpage {
    public static void handleStartpage(Scanner scanner) {
        Integer selection = 0;
        while (true) {
            try {
                System.out.print(Startpageconstants.startpage);
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }
            switch (selection) {
                case 1:
                    handleSignup(scanner);
                    break;
                case 2:
                    handleSignin(scanner);
                    break;
                case 3:
                    System.out.println(Startpageconstants.exitMessage);
                    return;
                default:
                    break;
            }
        }
    }

    public static void handleSignup(Scanner scanner) {
        System.out.println(Startpageconstants.signupMessage);
        System.out.println("Enter Your Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        User user = MarketPlace.addUser(username, password);
        System.out.println(Startpageconstants.signupSuccessMessage);
//        HashMap<String, String> userHashMap = new HashMap<>();
//                userHashMap.put("name", username);
//                userHashMap.put("password", password);
//                try {
//                    FileWriter csvWriter = new FileWriter("Files/users.csv", true);
//                    csvWriter.append(userHashMap.get("name") +", " + userHashMap.get("password") + "\n");
//                    csvWriter.flush();
//                    csvWriter.close();
//                    System.out.println("User data saved successfully!");
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

//        public static void signUp() {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter your username:");
//            String username = scanner.nextLine();
//            System.out.println("Enter your password:");
//            String password = scanner.nextLine();
//
//            HashMap<Integer, User> userHashMap = HandleUserFile.read();
//
//            boolean isUsernameTaken = false;
//            for (User user : userHashMap.values()) {
//                if (user.getUsername().equals(username)) {
//                    isUsernameTaken = true;
//                    break;
//                }
//            }
//
//            if (isUsernameTaken) {
//                System.out.println("Username already taken. Please enter a different username.");
//                username = scanner.nextLine();
//                System.out.println("Enter your password:");
//                password = scanner.nextLine();
//            }
//
//            User newUser = new User(userHashMap.size() + 1, username, password);
//            userHashMap.put(newUser.getuId(), newUser);
//
//            HandleUserFile.append(newUser);
//        }
    }

    public static void handleSignin(Scanner scanner) {
        System.out.println(Startpageconstants.signinMessage);
        System.out.println("Enter Your Username: ");
        String username = scanner.nextLine();
        System.out.println("Enter Your Password: ");
        String password = scanner.nextLine();
        User loggedInUser = MarketPlace.signIn(username, password);
        if (loggedInUser != null) {
            boolean loggedIn = true;
            while (loggedIn) {
                Menu.handleMainMenu(scanner, loggedInUser);
                return;
            }
        } else {
            System.out.println("Invalid Username or Password!");
        }

    }
}