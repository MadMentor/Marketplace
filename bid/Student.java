package bid;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private static Integer studentCount = 0;

    Student(String name) {
        this.setName(name);
        this.id = ++studentCount;
    }

    private String name;

    private Integer id;

    private List<Book> books = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name.trim();
    }

    public Integer getId() {
        return this.id;
    }

    public void borrowBook(Book book) {
        this.books.add(book);
    }

    public void returnBook(Book book) {
        this.books.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return this.books;
    }

    public static Integer getStudentCount() {
        return studentCount;
    }
}
