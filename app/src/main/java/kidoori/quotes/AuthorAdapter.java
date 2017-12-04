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

public class AuthorAdapter extends ArrayAdapter<Author> {
    private final ArrayList<Author> authors;

    public AuthorAdapter(Context context, ArrayList<Author> authorArrayList) {
        super(context, 0, authorArrayList);
        this.authors=authorArrayList;
    }

    @Nullable
    @Override
    public Author getItem(int position) {
        return authors.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Author author = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.author, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(author.getName());
        tvHome.setText(""+author.getQuotes().size());
        // Return the completed view to render on screen
        convertView.setTag(author);
        return convertView;
    }
}
