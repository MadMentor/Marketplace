package Project;


import java.util.ArrayList;
import java.util.List;

public class User {
        private static Integer uIdincrementor = 0;
        private Integer uId;
        private  String username;
        private String password;
        private List<Product> productsPosted;
        private List<Product> productsBought;
        private List<Product> productsSold;


         public User(String username, String password) {
                this.setUsername(username);
                this.setPassword(password);
                productsBought = new ArrayList<>();
                productsSold = new ArrayList<>();
                this.uId = ++uIdincrementor;
        }
        public User(Integer uId, String username, String password) {
                this.setUsername(username);
                this.setPassword(password);
                this.uId = uId;
                uIdincrementor = uId;
        }

        public Integer getuId() {
                return this.uId;
        }

        public  String getUsername() {
                return username;
        }
        public  String getUsernme(){
                 return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void bought(Product product) {
                 productsBought.add(product);
        }
        public void sold(Product product) {
             if(productsSold == null) {
                 productsSold = new ArrayList<>();
             }
             productsSold.add(product);
        }

        public List<Product> getProductsPosted() {

                 return productsPosted;
        }

        public List<Product> getProductsBought() {

                 return productsBought;
        }

        public List<Product> getProductsSold() {

                 return productsSold;
        }
}

