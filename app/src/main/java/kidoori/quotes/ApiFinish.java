package kidoori.quotes;

import java.io.IOException;

/**
 * Created by hosam on 12/3/17.
 */

interface ApiFinish {
    void sucess(Data data);

    void fail(IOException e);
}
