//package newpack;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//class Marketplace {
//    private Map<String, User123> users;
//    private List<Product123> product123s;
//    public List<Product123> getProducts() {
//        return product123s;
//    }
//
//
//    public Marketplace() {
//        this.users = new HashMap<>();
//        this.product123s = new ArrayList<>();
//    }
//
//    public void registerUser(String username, String password) {
//        User123 newUser123 = new User123(username, password);
//        users.put(username, newUser123);
//        System.out.println("User registered successfully!");
//    }
//
//    public User123 signIn(String username, String password) {
//        User123 user123 = users.get(username);
//        if (user123 != null && user123.getPassword().equals(password)) {
//            System.out.println("User signed in successfully!");
//            return user123;
//        } else {
//            System.out.println("Invalid username or password!");
//            return null;
//        }
//    }
//
//    public void postProduct(String name, String category, double price, User123 seller) {
//        Product123 newProduct123 = new Product123(name, category, price, seller.getUsername());
//        product123s.add(newProduct123);
//        seller.getProductsPosted().add(newProduct123);
//        System.out.println("Product posted successfully!");
//    }
//
//    public void displayProducts(User123 currentUser123) {
//        System.out.println("List of products:");
//        for (Product123 product123 : product123s) {
//            if (!product123.getSeller().equals(currentUser123.getUsername())) {
//                System.out.println("Name: " + product123.getName() + ", Category: " + product123.getCategory() + ", Price: $" + product123.getPrice());
//            }
//        }
//    }
//
//    public void displayProductsByCategory(String category, User123 currentUser123) {
//        System.out.println("List of products in the " + category + " category:");
//        for (Product123 product123 : product123s) {
//            if (product123.getCategory().equals(category) && !product123.getSeller().equals(currentUser123.getUsername())) {
//                System.out.println("Name: " + product123.getName() + ", Price: $" + product123.getPrice());
//            }
//        }
//    }
//
//    public void buyProduct(Product123 product123, User123 buyer) {
//        product123s.remove(product123);
//        buyer.getProductsBought().add(product123);
//        User123 seller = users.get(product123.getSeller());
//        seller.getProductsSold().add(product123);
//        System.out.println("Product purchased successfully!");
//    }
//
//    public void displayUserProducts(User123 user123) {
//        System.out.println("List of products posted by " + user123.getUsername() + ":");
//        for (Product123 product123 : user123.getProductsPosted()) {
//            System.out.println("Name: " + product123.getName() + ", Category: " + product123.getCategory() + ", Price: $" + product123.getPrice());
//        }
//    }
//
//    public void displayBoughtSoldProducts(User123 user123) {
//        System.out.println("List of products bought/sold by " + user123.getUsername() + ":");
//        System.out.println("Bought:");
//        for (Product123 product123 : user123.getProductsBought()) {
//            System.out.println("Name: " + product123.getName() + ", Category: " + product123.getCategory() + ", Price: $" + product123.getPrice());
//        }
//        System.out.println("Sold:");
//        for (Product123 product123 : user123.getProductsSold()) {
//            System.out.println("Name: " + product123.getName() + ", Category: " + product123.getCategory() + ", Price: $" + product123.getPrice());
//        }
//    }
//
//    public void generateIncomeExpenditureStatement(User123 user123) {
//        double totalIncome = 0;
//        double totalExpenditure = 0;
//
//        for (Product123 product123 : user123.getProductsSold()) {
//            totalIncome += product123.getPrice();
//        }
//
//        for (Product123 product123 : user123.getProductsBought()) {
//            totalExpenditure += product123.getPrice();
//        }
//
//        System.out.println("Income/Expenditure Statement for " + user123.getUsername());
//        System.out.println("Total Income: $" + totalIncome);
//        System.out.println("Total Expenditure: $" + totalExpenditure);
//        System.out.println("Net Profit/Loss: $" + (totalIncome - totalExpenditure));
//    }
//
//    public void saveUserDataToCSV() {
//        try (PrintWriter writer = new PrintWriter(new FileWriter("Project/users.csv"))) {
//            for (User123 user123 : users.values()) {
//                writer.println(user123.getUsername() + "," + user123.getPassword());
//            }
//            System.out.println("User data saved to users.csv");
//        } catch (IOException e) {
//            System.out.println("Failed to save user data to users.csv");
//        }
//    }
//
//    public void saveProductDataToCSV() {
//        try (PrintWriter writer = new PrintWriter(new FileWriter("Project/products.csv"))) {
//            for (Product123 product123 : product123s) {
//                writer.println(product123.getName() + "," + product123.getCategory() + "," + product123.getPrice() + "," + product123.getSeller());
//            }
//            System.out.println("Product data saved to products.csv");
//        } catch (IOException e) {
//            System.out.println("Failed to save product data to products.csv");
//        }
//    }
//
//    public void loadUserDataFromCSV() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("Project/users.csv"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",");
//                if (data.length == 2) {
//                    String username = data[0];
//                    String password = data[1];
//                    User123 user123 = new User123(username, password);
//                    users.put(username, user123);
//                }
//            }
//            System.out.println("User data loaded from users.csv");
//        } catch (IOException e) {
//            System.out.println("Failed to load user data from users.csv");
//        }
//    }
//
//    public void loadProductDataFromCSV() {
//        try (BufferedReader reader = new BufferedReader(new FileReader("Project/products.csv"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] data = line.split(",");
//                if (data.length == 4) {
//                    String name = data[0];
//                    String category = data[1];
//                    double price = Double.parseDouble(data[2]);
//                    String seller = data[3];
//                    Product123 product123 = new Product123(name, category, price, seller);
//                    product123s.add(product123);
//                }
//            }
//            System.out.println("Product data loaded from products.csv");
//        } catch (IOException e) {
//            System.out.println("Failed to load product data from products.csv");
//        }
//    }
//
//
//}
