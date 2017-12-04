package kidoori.quotes;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class quotesActivity extends FragmentActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);
        listView = (ListView) findViewById(R.id.qqlist);
        QuotesAdapter quotesAdapter =  new QuotesAdapter(this,Shared.getAuthor().getQuotes());
        listView.setAdapter(quotesAdapter);

    }
}
