//package newpack;
//
//import newpack.Marketplace;
//import newpack.Product123;
//import newpack.User123;
//
//import java.util.Scanner;
//
//public class Main {
//        public static void main(String[] args) {
//            Marketplace marketplace = new Marketplace();
//            User123 currentUser123 = null;
//            Scanner scanner = new Scanner(System.in);
//            int option;
//
//            marketplace.loadUserDataFromCSV();
//            marketplace.loadProductDataFromCSV();
//
//            do {
//                System.out.println("1. Sign In");
//                System.out.println("2. Sign Up");
//                System.out.println("3. Exit");
//                System.out.print("Please select an option: ");
//                option = scanner.nextInt();
//
//                switch (option) {
//                    case 1:
//                        System.out.print("Enter your username: ");
//                        String username = scanner.next();
//                        System.out.print("Enter your password: ");
//                        String password = scanner.next();
//                        currentUser123 = marketplace.signIn(username, password);
//                        break;
//                    case 2:
//                        System.out.print("Enter a username: ");
//                        String newUsername = scanner.next();
//                        System.out.print("Enter a password: ");
//                        String newPassword = scanner.next();
//                        marketplace.registerUser(newUsername, newPassword);
//                        break;
//                    case 3:
//                        marketplace.saveUserDataToCSV();
//                        marketplace.saveProductDataToCSV();
//                        System.out.println("Exiting the marketplace. Goodbye!");
//                        break;
//                    default:
//                        System.out.println("Invalid option. Please select again.");
//                }
//
//                if (currentUser123 != null) {
//                    while (option != 8) {
//                        System.out.println("1. Post Product");
//                        System.out.println("2. Display List of Products");
//                        System.out.println("3. Display Products by Category");
//                        System.out.println("4. Display User's Products");
//                        System.out.println("5. Buy Product");
//                        System.out.println("6. Display Products Bought/Sold");
//                        System.out.println("7. Income/Expenditure Statement");
//                        System.out.println("8. Log Out");
//                        System.out.print("Please select an option: ");
//                        option = scanner.nextInt();
//
//                        switch (option) {
//                            case 1:
//                                System.out.print("Enter product name: ");
//                                String productName = scanner.next();
//                                System.out.print("Enter product category (electronics, books, clothing): ");
//                                String productCategory = scanner.next();
//                                System.out.print("Enter product price: ");
//                                double productPrice = scanner.nextDouble();
//                                marketplace.postProduct(productName, productCategory, productPrice, currentUser123);
//                                break;
//                            case 2:
//                                marketplace.displayProducts(currentUser123);
//                                break;
//                            case 3:
//                                System.out.print("Enter category (electronics, books, clothing): ");
//                                String category = scanner.next();
//                                marketplace.displayProductsByCategory(category, currentUser123);
//                                break;
//                            case 4:
//                                marketplace.displayUserProducts(currentUser123);
//                                break;
//                            case 5:
//                                System.out.print("Enter the name of the product you want to buy: ");
//                                String productToBuy = scanner.next();
//                                for (Product123 product123 : marketplace.getProducts()) {
//                                    if (product123.getName().equals(productToBuy)) {
//                                        marketplace.buyProduct(product123, currentUser123);
//                                        break;
//                                    }
//                                }
//                                break;
//                            case 6:
//                                marketplace.displayBoughtSoldProducts(currentUser123);
//                                break;
//                            case 7:
//                                marketplace.generateIncomeExpenditureStatement(currentUser123);
//                                break;
//                            case 8:
//                                System.out.println("Logging out. Goodbye, " + currentUser123.getUsername() + "!");
//                                break;
//                            default:
//                                System.out.println("Invalid option. Please select again.");
//                        }
//                    }
//                }
//            } while (option != 3);
//        }
//}
