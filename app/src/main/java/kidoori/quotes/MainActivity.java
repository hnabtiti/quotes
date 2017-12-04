package kidoori.quotes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity implements ApiFinish {

    private ListView listView;
    private Context context;
    private AuthorAdapter authorAdapter;
    private ArrayList<Author> authors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = this;
        new QuotesِِAsyncTask(this).execute();
        listView = (ListView) findViewById(R.id.dolist);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                intent=new Intent(context,quotesActivity.class);
                Shared.setAuthor(authors.get(i));
                context.startActivity(intent);
            }
        });


    }

    @Override
    public void sucess(Data data) {
        if (null != data) {
            if (null != data.getQuotes()) {
                 authors = new ArrayList<Author>();
                for (int i = 0; i < data.getQuotes().size(); i++) {
                    if (null != data.getQuotes().get(i)) {
                        Author mAuthor = data.getQuotes().get(i).getAuthor();
                        if (null != mAuthor) {

                            if (isHeNewAuthor(authors, mAuthor)) {
                                authors.add(mAuthor);
                            }
                            authors=addQuoteToAuthor(authors,mAuthor,data.getQuotes().get(i));

                        }
                    }

                }

                authorAdapter = new AuthorAdapter(context, authors);

                listView.post(new Runnable() {
                    @Override
                    public void run() {
                        listView.setAdapter(authorAdapter);
                    }
                });
            }
        }
    }

    @Override
    public void fail(IOException e) {

    }

    boolean isHeNewAuthor(ArrayList<Author> authors, Author mAuthor) {
        for (Author author : authors) {
            if (mAuthor.getName().equalsIgnoreCase(author.getName())) {
                return false;
            }
        }
        return true;
    }
    ArrayList<Author> addQuoteToAuthor(ArrayList<Author> authors,Author mAuthor, Quote quote) {
        for (int i = 0; i <authors.size() ; i++) {

            if (mAuthor.getName().equalsIgnoreCase(authors.get(i).getName())) {
                authors.get(i).addQuotes(quote);
                return authors;
            }
        }
        return authors;

    }
}
