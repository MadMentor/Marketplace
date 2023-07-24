//package Project;
//
//import Project.Categories;
//import Project.Product;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class HandleProductFile {
////    public void saveProductDataToCSV() {
////        try (PrintWriter writer = new PrintWriter(new FileWriter("products.csv"))) {
////            for (Product123 product123 : products) {
////                writer.println(product123.getPname() + "," + product123.getPcategories() + "," + product123.getPprice() + "," + product123.getPseller());
////            }
////            System.out.println("Product data saved to products.csv");
////        } catch (IOException e) {
////            System.out.println("Failed to save product data to products.csv");
////        }
////    }
//
//    public static HashMap<Integer, Product> read() {
//        HashMap<Integer, Product> productHashMap = new HashMap<>();
//        try {
//            File file = new File("Files/product.csv");
//            Scanner dataReader = new Scanner(file);
////            HashMap<Integer, Product> productHashMap = new HashMap<>();
//            while (dataReader.hasNextLine()) {
//                String line = dataReader.nextLine();
//                if (!line.trim().isEmpty()) {
//                    String[] productInfo = line.split(",");
//                    Integer pid = Integer.parseInt(productInfo[0]);
//                    String pname = productInfo[1];
//                    String pdescription = productInfo[2];
//                    Double pprice = Double.parseDouble(productInfo[3]);
//                    Integer pstock = Integer.parseInt(productInfo[4]);
//                    Categories pcategories = Categories.valueOf(productInfo[5]);
//                    Product product = new Product(pid, pname, pdescription, pprice, pstock, pcategories);
//
//                    productHashMap.put(product.getPid(), product);
//
//                }
//            }
//            dataReader.close();
////            return productHashMap;
//        } catch (FileNotFoundException exception) {
//            System.out.println("An Error Occured!!!");
//            exception.printStackTrace();
//        }
//        return productHashMap;
//    }
//
//        public static void append (Product product){
//            String fileName = "Files/product.csv";
//
//            try {
//                FileWriter fileWriter = new FileWriter(fileName, true);
//                File file = new File(fileName);
//
//                if (file.exists() && file.length() > 0) {
//                    fileWriter.write(System.lineSeparator());
//                }
//                String data = product.getPid() + "," +
//                        product.getPname() + "," +
//                        product.getPprice() + ", " +
//                        product.getPstock() + ", " +
//                        product.getPcategories();
//
////                Writer append = fileWriter.append(data);
//                Writer appendableWriter = (Writer) fileWriter;
//                appendableWriter.append(data);
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while creating book. Please try again.");
//                e.printStackTrace();
//            }
//        }
//}
//
