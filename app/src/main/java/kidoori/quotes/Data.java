package kidoori.quotes;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hosam on 12/3/17.
 */

public class Data {
    @SerializedName("has_next")
    boolean has_next;
    @SerializedName("page")
    int page;
    @SerializedName("quotes")
    List<Quote> quotes;

    public Data() {
    }

    public Data(boolean has_next, int page, List<Quote> quotes) {
        this.has_next = has_next;
        this.page = page;
        this.quotes = quotes;
    }

    public boolean isHas_next() {
        return has_next;
    }

    public void setHas_next(boolean has_next) {
        this.has_next = has_next;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }
}
