package com.example.chopda.a247companion;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Chopda on 4/16/2017.
 */
public class BackgroundTask extends AsyncTask<String, Void, String> {
    Context ctx;

    @Override
    protected String doInBackground(String... params) {
        String method=params[0];

        String strUrl="https://app-1494488866.000webhostapp.com/Register.php";
        if(method.equals("Register")){
            String first=params[1];
            String last= params[2];
            String mail=params[3];
            String contact= params[4];
            String password= params[5];
            Log.v("method", method);

            try {
                URL url= new URL(strUrl);
                HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setDoOutput(true);

                OutputStream os= urlConnection.getOutputStream();
                BufferedWriter out= new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("first","UTF-8")+"="+URLEncoder.encode(first,"UTF-8")+"&"+
                        URLEncoder.encode("last","UTF-8")+"="+URLEncoder.encode(last,"UTF-8")+"&"+
                        URLEncoder.encode("mail","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&"+
                        URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&"+
                        URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");

                Log.v("first", first);
                Log.v("last", last);
                Log.v("mail", mail);
                Log.v("contact", contact);
                Log.v("password", password);
                Log.v("data",data);


                out.write(data);
                out.flush();
                out.close();
                os.close();

                InputStream is= urlConnection.getInputStream();
                is.close();

                return "Register successfully";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    BackgroundTask(Context ctx) {
        this.ctx= ctx;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if(result!=null && result.equals("Register successfully"))
        Toast.makeText(ctx,result,Toast.LENGTH_LONG).show();

        else
            Toast.makeText(ctx,"something went wrong",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
