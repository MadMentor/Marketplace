package bid;


public class Book {
    private static Integer idIncrementor = 0;

    public Book(String name, String author) {
        this.setName(name);
        this.setAuthor(author);
        this.id = ++idIncrementor;
    }

    public Book(Integer id, String name, String author) {
        this.setName(name);
        this.setAuthor(author);
        this.id = id;
        idIncrementor = id;
    }

    private Integer id;
    private String author;
    private String name;

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "| Name: " +   this.getName() + ", author: " + this.getAuthor();
    }
}
