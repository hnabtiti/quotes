package kidoori.quotes;

/**
 * Created by hosam on 12/4/17.
 */

public class Shared {
    static Author author;

    public static void setAuthor(Author author) {
        Shared.author = author;
    }

    public static Author getAuthor() {
        return author;
    }
}
