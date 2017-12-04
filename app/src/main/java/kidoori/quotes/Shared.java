package kidoori.quotes;

import java.util.ArrayList;

/**
 * Created by hosam on 12/4/17.
 */

public class Shared {
    static Author author;
    static ArrayList<Author> authors;

    public static void setAuthor(Author author) {
        Shared.author = author;
    }

    public static Author getAuthor() {
        return author;
    }

    public static void setAuthors(ArrayList<Author> authors) {
        Shared.authors = authors;
    }

    public static ArrayList<Author> getAuthors() {
        return authors;
    }
}
