package Project;

import Project.Categories;
import java.io.*;
import java.util.*;

public class MarketPlace {
    private static int nextUserId = 1;
    private static final String USERS_FILE = "Files/users.csv";
    private static final String PRODUCTS_FILE = "Files/product.csv";
    private static final HashMap<Integer, User> userHashMap = new HashMap<>();
    private static final HashMap<Integer, Product> productHashMap = new HashMap<Integer, Product>();

    public static HashMap<Integer, Product> getProductHashMap() {
        return productHashMap;
    }
    private static List<User> userList  = new ArrayList<>();
    public static void main(String[] args) {
        loadUserDataFromCSV();
        loadProductDataFromCSV();

        Scanner scanner = new Scanner(System.in);
        Startpage.handleStartpage(scanner);
        scanner.close();

        writeUserDataToCSV();
        writeProductDataToCSV();
    }
    private static void loadUserDataFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Assuming the CSV structure is: uId,username,password
                int uId = Integer.parseInt(data[0]);
                String username = data[1];
                String password = data[2];
                User user = new User(username, password);
                userHashMap.put(uId, user);
                // Update nextUserId if necessary
                if (uId >= nextUserId) {
                    nextUserId = uId + 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeUserDataToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USERS_FILE))) {
            for (Map.Entry<Integer, User> entry : userHashMap.entrySet()) {
                Integer uId = entry.getKey();
                User user = entry.getValue();
                String userData = uId + "," + user.getUsername() + "," + user.getPassword();
                writer.write(userData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void loadProductDataFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Assuming the CSV structure is: pid,pname,pdescription,pprice,pstock,pcategories,seller
                int pid = Integer.parseInt(data[0]);
                String pname = data[1];
                String pdescription = data[2];
                double pprice = Double.parseDouble(data[3]);
                int pstock = Integer.parseInt(data[4]);
                Categories pcategories = Categories.valueOf(data[5]);
                String seller = data[6];
                Product product = new Product(pid, pname, pdescription, pprice, pstock, pcategories, seller);
                productHashMap.put(pid, product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void writeProductDataToCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PRODUCTS_FILE))) {
            for (Map.Entry<Integer, Product> entry : productHashMap.entrySet()) {
                Integer pid = entry.getKey();
                Product product = entry.getValue();
                String productData = pid + "," + product.getPname() + "," + product.getPdescription() + "," +
                        product.getPprice() + "," + product.getPstock() + "," +
                        product.getPcategories().toString() + "," + product.getSeller();
                writer.write(productData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void viewMyprofile(User loggedInUser) {
        System.out.println("Welcome to " + loggedInUser.getUsername() + "'s Profile.");
        System.out.println("UId: " + loggedInUser.getuId());

    }

    public static User signIn(String username, String password) {
        for (User user : userHashMap.values()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    public static Product postProduct(String pname, String pdescription, Double pprice, Integer pstock, Categories pcategories, String seller) {
        Product product = new Product(pname, pdescription, pprice, pstock, pcategories, seller);
        storeProduct(product);
        return product;
    }

    private static void storeProduct(Product product) {
        productHashMap.put(product.getPid(), product);

    }

    public static User addUser(String username, String password) {
        User user = new User(username, password);
        storeUser(user);
        nextUserId++;
        return user;
    }

    private static void storeUser(User user) {

        userHashMap.put(user.getuId(), user);
    }

    public static void viewProductList(User loggedInUser) {
        System.out.println("List of Products: ");
        for (Product product : productHashMap.values()) {
            if (!product.getSeller().equals(loggedInUser.getUsername())) {
                System.out.println("Id: " +product.getPid()+", Name: " + product.getPname() + ", Price: $" + product.getPprice() + ", Stock: "+product.getPstock()+", Category: " + product.getPcategories() );
            }
        }
    }
    public static void viewByProductsCategory(Scanner scanner, User loggedInUser) {
        System.out.println("Enter the Product Category(Electronics, Books, Clothing): ");
        String category = scanner.next();
        System.out.println("List of Products On Caregory: " + category);
        for (Product product : productHashMap.values()) {
            if (product.getPcategories().toString().equalsIgnoreCase(category) && !product.getSeller().equals(loggedInUser.getUsername())) {
                    System.out.println("Name: " + product.getPname() + ", Price: $" + product.getPprice());
            }
        }
    }
    public static void viewProductsBought(User loggedInUser) {
        System.out.println("Products Bought by " + loggedInUser.getUsername() + ":");
        List<Product> productsBought = loggedInUser.getProductsBought();
        if (productsBought.isEmpty()) {
            System.out.println("No products bought.");
        } else {
            for (Product product : productsBought) {
                System.out.println(product.toString());
            }
        }
    }
    public static void viewProductsSold(User loggedInUser) {
        System.out.println("Products Sold by " + loggedInUser.getUsername() + ":");
        List<Product> productsSold = loggedInUser.getProductsSold();
        if (productsSold.isEmpty()) {
            System.out.println("No products sold.");
        } else {
            for (Product product : productsSold) {
                System.out.println(product.toString());
            }
        }
    }
    public static User getUserByUsername(String username) {
        for (User user : userHashMap.values()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }
    public static void viewIncomeExpenditurestatement(User loggedInUser) {
        Double expenses = 0.0;
        Double income = 0.0;
        System.out.println("Income: ");
        List<Product> productsSold = loggedInUser.getProductsSold();
        if (productsSold.isEmpty()) {
            System.out.println("No products sold.");
        } else {
            for (Product product : productsSold) {
                income += product.getPprice();
            }
            System.out.println(income);
        }

        System.out.println("Expenditure: ");
        List<Product> productsBought = loggedInUser.getProductsBought();
        if (productsBought.isEmpty()) {
            System.out.println("No products bought.");
        } else {
            for (Product product : productsBought) {
                expenses += product.getPprice();
            }
        }
        System.out.println(expenses);
    }

}
