package kidoori.quotes;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hosam on 12/3/17.
 */

public class QuotesAdapter extends ArrayAdapter<Quote> {
    private final ArrayList<Quote> quotes;

    public QuotesAdapter(Context context, ArrayList<Quote> quotes) {
        super(context, 0, quotes);
        this.quotes=quotes;
    }

    @Nullable
    @Override
    public Quote getItem(int position) {
        return quotes.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Quote quote = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.quote, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        // Populate the data into the template view using the data object
        tvName.setText(quote.getText());

        return convertView;
    }
}
