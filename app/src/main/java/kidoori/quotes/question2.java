package kidoori.quotes;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class question2 extends Activity implements ApiFinish, OnFragmentInteractionListener, AdapterView.OnItemClickListener {
    private Context context;
    private AuthorAdapter authorAdapter;
    private ArrayList<Author> authors;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        this.context = this;
        new QuotesِِAsyncTask(this).execute();
          button1=(Button)findViewById(R.id.button1);
          button2=(Button)findViewById(R.id.button2);
          button3=(Button)findViewById(R.id.button3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AuthorsFragment();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuoteFragment();
            }
        });


    }
    public void AuthorsFragment() {
        AuthorsFragment fr;
            fr =   AuthorsFragment.newInstance("   "," ");


        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place2, fr);
        fragmentTransaction.commit();

    }

    public void QuoteFragment() {
        QuoteFragment fr;
        fr = QuoteFragment.newInstance("   ", " ");

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_place, fr);
        fragmentTransaction.commit();

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
                            authors = addQuoteToAuthor(authors, mAuthor, data.getQuotes().get(i));
                            Shared.setAuthors(authors);
                            Shared.setAuthor(authors.get(0));
                            button1.post(new Runnable() {
                                @Override
                                public void run() {
                                    button1.setEnabled(true);
                                    button2.setEnabled(true);
                                    button3.setEnabled(true);
                                    AuthorsFragment();
                                    QuoteFragment();
                                }
                            });



                        }
                    }

                }

            }
        }
    }

    @Override
    public void fail(IOException e) {
        question2.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // your stuff to update the UI
                Toast.makeText(question2.this,"الرجاء التأكد من الانترنت",Toast.LENGTH_SHORT).show();
            }
        });
    }

    boolean isHeNewAuthor(ArrayList<Author> authors, Author mAuthor) {
        for (Author author : authors) {
            if (mAuthor.getName().equalsIgnoreCase(author.getName())) {
                return false;
            }
        }
        return true;
    }

    ArrayList<Author> addQuoteToAuthor(ArrayList<Author> authors, Author mAuthor, Quote quote) {
        for (int i = 0; i < authors.size(); i++) {

            if (mAuthor.getName().equalsIgnoreCase(authors.get(i).getName())) {
                authors.get(i).addQuotes(quote);
                return authors;
            }
        }
        return authors;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Shared.setAuthor(authors.get(i));
        QuoteFragment();

    }
}
