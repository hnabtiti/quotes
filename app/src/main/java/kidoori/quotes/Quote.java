package kidoori.quotes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hosam on 12/3/17.
 */

class Quote {
    @SerializedName("author")
    Author author;
    @SerializedName("text")
    String text;
    @SerializedName("tags")
    List<String> tags;

    public Quote() {
    }

    public Quote(Author author, String text, List<String> tags) {
        this.author = author;
        this.text = text;
        this.tags = tags;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
