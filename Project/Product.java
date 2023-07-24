package Project;

import static Project.User.*;

public class Product {
    private static Integer idIncrementer = 0;
    private Integer pid;
    private String pname;
    private String pdescription;
    private Double pprice;
    private Integer pstock;
    private Categories pcategories;
    private String seller;
    public Product( String pname, String pdescription, Double pprice, Integer pstock, Categories pcategories, String seller){
        this.setPname(pname);
        this.setPdescription(pdescription);
        this.setPprice(pprice);
        this.setPstock(pstock);
        this.setPcategories(pcategories);
        this.pid = ++idIncrementer;
        this.seller = seller;
    }
    public Product(Integer pid, String pname, String pdescription, Double pprice, Integer pstock, Categories pcategories, String seller){
        this.setPname(pname);
        this.setPdescription(pdescription);
        this.setPprice(pprice);
        this.setPstock(pstock);
        this.setPcategories(pcategories);
        this.pid = pid;
        idIncrementer = pid;
        this.seller = seller;
    }

    public Integer getPid() {
        return this.pid;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPname() {
        return pname;
    }

    public void setPdescription(String pdescription) {
        this.pdescription = pdescription;
    }

    public String getPdescription() {
        return pdescription;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public Double getPprice() {
        return pprice;
    }

    public void setPstock(int pstock) {

        this.pstock = pstock;
    }

    public Integer getPstock() {

        return pstock;
    }

    public void setPcategories(Categories pcategories) {

        this.pcategories = pcategories;
    }

    public Categories getPcategories() {

        return pcategories;
    }
    @Override
    public String toString() {
        return "Product's Name: " + this.getPname() + "\nDescription: " + getPdescription() + "\nCategotry: " + getPcategories() + "\nPrice: " + getPprice()  +"\n_____________________________________________________";
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}