package kidoori.quotes;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Created by hosam on 12/3/17.
 */

public class QuotesِِAsyncTask extends AsyncTask {
    private  ApiFinish apiFinish;

    public QuotesِِAsyncTask(ApiFinish apiFinish) {
        this.apiFinish=apiFinish;
    }

    public    static  String  getPageDate(int page) throws IOException {
         String url="http://quotes.toscrape.com/api/quotes?page="+page;
         HttpClient httpclient = new DefaultHttpClient();

         HttpResponse response = httpclient.execute(new HttpGet(url));
         StatusLine statusLine = response.getStatusLine();
         if(statusLine.getStatusCode() == HttpStatus.SC_OK){
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             response.getEntity().writeTo(out);
             String responseString = out.toString();
             out.close();
             return responseString;
         } else{
             //Closes the connection.
             response.getEntity().getContent().close();
             throw new IOException(statusLine.getReasonPhrase());
         }
     }

    @Override
    protected Object doInBackground(Object[] objects) {

        Gson gson=new Gson();
        try {

            Data data = gson.fromJson(getPageDate(1), Data.class);
            for (int i = 2; i < 11; i++) {
                data.getQuotes().addAll(gson.fromJson(getPageDate(1), Data.class).getQuotes()) ;
            }
            apiFinish.sucess(data);
            Log.d("data",""+data.getQuotes().size());
        } catch (IOException e) {
            apiFinish.fail(e);

        }

        return null;
    }
}
