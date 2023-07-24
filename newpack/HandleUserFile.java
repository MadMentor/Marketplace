//package Project;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashMap;
//import java.util.Scanner;
//
//public class HandleUserFile {
////    public static void handleUserFile() {
//        public static HashMap<Integer, User> read() {
//
//            HashMap<Integer, User> userHashMap = new HashMap<>();
//            try {
//                File file = new File("Files/users.csv");
//                Scanner dataReader = new Scanner(file);
//
////            HashMap<Integer, User> userHashMap = new HashMap<>();
//                while (dataReader.hasNextLine()) {
//                    String line = dataReader.nextLine();
//                    if (!line.trim().isEmpty()) {
//                        String[] userInfo = line.split(",");
////                        Integer uId = Integer.parseInt(userInfo[0]);
//                        String username = userInfo[0];
//                        String password = userInfo[1];
//                        User user = new User(username, password);
//
//                        userHashMap.put(user.getuId(), user);
//                    }
//                }
//                dataReader.close();
//            } catch (FileNotFoundException exception) {
//                System.out.println("An Error Occured!!!");
//                exception.printStackTrace();
//            }
//            return userHashMap;
//        }
////    }
//}
