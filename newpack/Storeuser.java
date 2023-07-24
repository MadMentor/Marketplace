//package Project;
//
//
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class Storeuser {
//    public static void storeuser(){
//        try {
//            File file = new File("Files/product.csv");
//            Scanner dataReader = new Scanner(file);
//            HashMap<Integer, Product> productHashMap = new HashMap<>();
//
//            while (dataReader.hasNextLine()){
//                String line = dataReader.nextLine();
//                if(!line.trim().isEmpty()) {
//                    String[] productInfo = line.split(",");
//                    Integer pid = Integer.parseInt(productInfo[0]);
//                    String pname = productInfo[1];
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
