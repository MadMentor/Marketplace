package Project;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    public static void handleMainMenu(Scanner scanner, User loggedInUser) {
        Integer selection = 0;
        while ((loggedInUser != null)) {
            try {
                System.out.print(MenuConstants.mainMenu);
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }

            switch (selection) {
                case 1:
                    MarketPlace.viewMyprofile(loggedInUser);
                    break;
                case 2:
                    MarketPlace.viewProductList(loggedInUser);
                    break;
                case 3:
                    MarketPlace.viewByProductsCategory(scanner, loggedInUser);
                    break;
                case 4:
                    handleBuyProduct(scanner, loggedInUser);
                    break;
                case 5:
                    handlePostProduct(scanner, loggedInUser);
                    break;
                case 6:
                    MarketPlace.viewProductsBought(loggedInUser);
                    break;
                case 7:
                    MarketPlace.viewProductsSold(loggedInUser);
                    break;
                case 8:
                    MarketPlace.viewIncomeExpenditurestatement(loggedInUser);
                    break;
                case 9:
                    System.out.println(MenuConstants.exitMessage);
                    return;
                default:
                    break;
            }
        }
    }

    public static void handleBuyProduct(Scanner scanner, User loggedInUser) {
        try {
            System.out.println(MenuConstants.buyingProductMessageInitial);
            Integer pid = Integer.parseInt(scanner.nextLine());
            Product product = MarketPlace.getProductHashMap().get(pid);

            if (product != null) {
                if (!product.getSeller().equals(loggedInUser.getUsername())) { // Check if the seller is not the logged-in user
                    if (product.getPstock() > 0) {
                        product.setPstock(product.getPstock() - 1);
                        User seller = MarketPlace.getUserByUsername(product.getSeller());
                        if(seller != null) {
                            loggedInUser.bought(product); // Add this line to record the purchase
                            seller.sold(product);
                            System.out.println(MenuConstants.buyingProductMessageFinal);
                        }else{
                            System.out.println("Seller not found!!!");
                        }
                    } else {
                        System.out.println("Product is out of stock.");
                    }
                }else {
                    System.out.println("Ypu Can't Buy Your Own Product!!!");
                }
                } else {
                    System.out.println("Enter a Valid Product Id.");
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid Input!!!");
            }


    }


    public static void handlePostProduct(Scanner scanner, User loggedInUser) {
        try {
            System.out.print(MenuConstants.postingProductMessageInitial);
            String pname = scanner.nextLine();
            System.out.print(MenuConstants.postingProductMessageDescription);
            String pdescription = scanner.nextLine();
            Integer pstock = null;
            while(pstock == null) {
                try {
                    System.out.println("Enter the no. of stock: ");
                    pstock = Integer.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input!!! Please Enter Valid Numeric Values.");
                }
            }
            Double pprice = null;
            while (pprice == null) {
                try {
                    System.out.println("Enter the Price: ");
                    pprice = Double.valueOf(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input!!! Please Enter Valid Numeric Values.");
                }
            }
            Categories pcategories = null;
            while(pcategories == null) {
                try {
                    System.out.println("Enter the Product's Category(Electronics, Books, Clothing: ");
                    pcategories = Categories.valueOf(scanner.nextLine());
                    Categories categories = Categories.valueOf(String.valueOf(pcategories));

                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid Product Category!!! Please Enter a Valid Category(Electronics, Books, Clothing.");
                }
            }
            String seller = loggedInUser.getUsername();
            Product product = MarketPlace.postProduct(pname, pdescription, pprice, pstock, pcategories, seller);
            System.out.println(MenuConstants.postingProductMessageFinal + product.getPid());
        }catch (Exception e) {
            System.out.println("An error occurred while processing the product details.");
            e.printStackTrace();
        }
    }
}
