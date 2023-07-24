package bid;

import java.util.HashMap;
import java.util.Scanner;

public class LibraryManagement {
    private static HashMap<Integer, Book> bookMap = new HashMap<Integer, Book>();
    private static HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu.handleMainMenu(scanner);
        scanner.close();
    }

    public static Book addBook(String name, String author) {
        Book book = new Book(name, author);
        storeBook(book);
        return book;
    }
    public static Student addStudent(String name) {
        Student student = new Student(name);
        storeStudent(student);
        return student;
    }
    public static void viewStudentList() {
        System.out.println("ID, NAME, BOOKS");
        for (HashMap.Entry<Integer, Student> student : studentMap.entrySet()) {
            System.out.println(
                    student.getKey() + ", " +
                            student.getValue().getName() + ", " +
                            student.getValue().getBorrowedBooks()
            );
        }
    }
    public static void viewBookList() {
        System.out.println("ID, NAME, AUTHOR");
        bookMap.forEach((id, book) -> {
            System.out.println(
                    book.getId() + ", " +
                            book.getName() + ", " +
                            book.getAuthor()
            );
        });
    }

    public static void studentBorrowsBook(Integer studentId, Integer bookId) {
        Student student = studentMap.get(studentId);
        Book book = bookMap.get(bookId);

        student.borrowBook(book);
    }
    public static void studentReturnsBook(Integer studentId, Integer bookId) {
        Student student = studentMap.get(studentId);
        Book book = bookMap.get(bookId);

        student.returnBook(book);
    }

    private static void storeBook(Book book) {
        bookMap.put(book.getId(), book);
    }
    private static void storeStudent(Student student) {
        studentMap.put(student.getId(), student);
    }
}
