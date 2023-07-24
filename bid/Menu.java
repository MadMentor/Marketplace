package bid;
//import bid.MenuConstants123;




import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void handleMainMenu(Scanner scanner) {
        Integer selection = 0;
        while (true) {
            try {
                System.out.print(MenuConstants123.mainMenu);
                selection = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                continue;
            }

            switch (selection) {
                case 1:
                    handleEnrollStudent(scanner);
                    break;
                case 2:
                    handleAddBook(scanner);
                    break;
                case 3:
                    LibraryManagement.viewStudentList();
                    break;
                case 4:
                    LibraryManagement.viewBookList();
                    break;
                case 5:
                    lendBook(scanner);
                    break;
                case 6:
                    returnBook(scanner);
                    break;
                case 7:
                    System.out.println(MenuConstants123.exitMessage);
                    return;
                default:
                    break;
            }
        }
    }

    public static void handleEnrollStudent(Scanner scanner) {
        System.out.print(MenuConstants123.studentEnrollmentMessageInitial);

        String name = scanner.next();

        Student student = LibraryManagement.addStudent(name);

        System.out.println(MenuConstants123.getStudentEnrollmentMessageFinal + student.getId());
    }

    public static void handleAddBook(Scanner scanner) {
        System.out.print(MenuConstants123.bookAddMessageInitial);

        String name = scanner.nextLine();

        System.out.print("Enter Author name: ");

        String author = scanner.nextLine();

        Book book = LibraryManagement.addBook(name, author);

        System.out.println(MenuConstants123.bookAddMessageFinal + book.getId());

    }

    public static void lendBook(Scanner scanner) {
        System.out.println("Lending book to student ... ")
        ;
        System.out.print("Enter Student ID: ");
        Integer studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Book ID:");
        Integer bookId = Integer.parseInt(scanner.nextLine());

        LibraryManagement.studentBorrowsBook(studentId, bookId);

        System.out.println("The book has been lent to the student. ");
    }

    public static void returnBook(Scanner scanner) {
        System.out.println("Accepting returned book from the student ... ")
        ;
        System.out.print("Enter Student ID: ");
        Integer studentId = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Book ID:");
        Integer bookId = Integer.parseInt(scanner.nextLine());

        LibraryManagement.studentReturnsBook(studentId, bookId);
        System.out.println("The book has been returned from the student. ");
    }

}
