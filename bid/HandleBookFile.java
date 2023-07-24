package bid;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class HandleBookFile {

    public static HashMap<Integer, Book> read() {
        try {
            File file = new File("book.csv");
            Scanner dataReader = new Scanner(file);

            HashMap<Integer, Book> bookHashMap = new HashMap<>();
            while (dataReader.hasNextLine()) {
                String line = dataReader.nextLine();
                if (!line.trim().isEmpty()) {
                    String[] bookInfo = line.split(",");
                    Integer id = Integer.parseInt(bookInfo[0]);
                    String name = bookInfo[1];
                    String author = bookInfo[2];

                    Book book = new Book(id, name, author);

                    bookHashMap.put(book.getId(), book);
                }
            }
            dataReader.close();
            return bookHashMap;
        } catch (FileNotFoundException exception) {
            System.out.println("error occurred!");
            exception.printStackTrace();
        }
        return null;
    }
}
