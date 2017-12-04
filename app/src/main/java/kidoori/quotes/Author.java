package kidoori.quotes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hosam on 12/3/17.
 */

class Author {
    @SerializedName("author")
   String goodreads_link;
    @SerializedName("name")
    String name;
    @SerializedName("slug")
    String slug;

    ArrayList<Quote> quotes;

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }

    public Author() {
    }

    public Author(String goodreads_link, String name, String slug) {
        this.goodreads_link = goodreads_link;
        this.name = name;
        this.slug = slug;

    }

    public String getGoodreads_link() {
        return goodreads_link;
    }

    public void setGoodreads_link(String goodreads_link) {
        this.goodreads_link = goodreads_link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void addQuotes(Quote quote) {
        if (null==quotes)
        {
            quotes = new ArrayList<Quote>();
        }
        quotes.add(quote);

    }
}
