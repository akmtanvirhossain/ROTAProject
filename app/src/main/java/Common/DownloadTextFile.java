package Common;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by TanvirHossain on 04/09/2016.
 */
//Downloading updated system from the central server
public class DownloadTextFile extends AsyncTask<String,String,Void> {
    private Context context;
    public void setContext(Context contextf){
        context = contextf;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    protected void onProgressUpdate(String... progress) {
    }

    //@Override
    protected void onPostExecute(String unused) {
    }

    @Override
    protected Void doInBackground(String... arg0) {
        try {
            URL url = new URL(arg0[0]);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();
            c.setRequestMethod("GET");
            c.connect();
            int lenghtOfFile = c.getContentLength();

            File file= Environment.getExternalStorageDirectory();

            file.mkdirs();
            File outputFile = new File(file.getAbsolutePath() + File.separator + Global.DatabaseFolder + File.separator + arg0[1]);

            if(outputFile.exists()){
                outputFile.delete();
            }
            else
            {
                outputFile.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(outputFile);

            InputStream is = c.getInputStream();


            byte[] buffer = new byte[1024];
            int len1 = 0;
            long total = 0;
            while ((len1 = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len1);
            }
            fos.close();
            is.close();

            Connection.ExecuteSQLFromFile(arg0[1]);

        } catch (IOException e) {
            //Log.e("UpdateAPP", "Update error! " + e.getMessage());
        }
        return null;
    }
}