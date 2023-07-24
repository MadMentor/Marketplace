//package Project;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Market {
//    private static Map<String, newpack.User123> users;
//    private static List<newpack.Product123> product123s;
////    public Market() {
////        this.users = new HashMap<String, newpack.User123>();
////        this.product123s = (List<newpack.Product123>) new HashMap<>();
////    }
//
//    public static newpack.User123 signIn(String username, String password) {
//        for (newpack.User123 user123 : users.values()) {
//            if (user123.getUsername().equals(username) && user123.getPassword().equals(password)) {
//                return user123;
//            }
//        }
//        return null;
//    }
//    public static void viewMyprofile() {
//        System.out.println("ID, USERNAME");
//        for (HandleUserFile.Entry<Integer, newpack.User123> user : users.entrySet()) {
//            System.out.println(
//                    user.getKey() + ", " +
//                            users.getValue().getUsername() + ","
//            );
//        }
//    }
//
//}
