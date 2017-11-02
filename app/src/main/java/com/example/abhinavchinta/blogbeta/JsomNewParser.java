package com.example.abhinavchinta.blogbeta;

/**
 * Created by Abhinav Chinta on 9/23/2017.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

/**
 * Created by Abhinav Chinta on 9/22/2017.
 */

public class JsomNewParser {
    private String str="";
    private String str1="";
    private String s1="";
    private String s2="";
    private String s3="";
    private String ssss="";
    private String imageurl="";
    private String jsonstr1="";
    private String content="";
    private ArrayList<FeedEntry> applications;
    public FeedEntry currentRecord=null;
    public Bitmap bitmap;
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public JsomNewParser() {
        this.applications=new ArrayList<>();
    }

    public ArrayList<FeedEntry> getApplications() {
        return applications;
    }



    public void Parser(String jsonStr, String sssss) {
        ssss=sssss;jsonstr1=jsonStr;
        Log.e(TAG, "Parser: "+ jsonStr );

        if (jsonStr != null) {
            try {
                int i;
                JSONObject obj = new JSONObject(jsonStr);
                String strrr=obj.getString("total");
                i =Integer.parseInt(strrr);

                JSONObject emp=(new JSONObject(jsonStr)).getJSONObject("entries");
                //String empname=emp.getString("name");
                //for (int j=0;j<i;j++){}

                //JSONObject d = emp.getJSONObject("3aJG4dywRyGOUgaAGkSoeC");finishparse(d);
                //JSONObject e = emp.getJSONObject("UTNqzUA7cWOiMc0KmIo6S");finishparse(e);
                //JSONObject f = emp.getJSONObject("12B9BuQps8EwikC8226us2");finishparse(f);
                //JSONObject g = emp.getJSONObject("4nAYMQAIFac6EcOSG2iuMU");finishparse(g);
                JSONObject h = emp.getJSONObject("1CJKZSN09CoAW4AOyqa0AM");finishparse(h);
                //JSONObject i1 = emp.getJSONObject("3aJG4dywRyGOUgaAGkSoeC");finishparse(i1);
                //JSONObject j= emp.getJSONObject("UTNqzUA7cWOiMc0KmIo6S");finishparse(j);
                //JSONObject k = emp.getJSONObject("12B9BuQps8EwikC8226us2");finishparse(k);
                //JSONObject l = emp.getJSONObject("4nAYMQAIFac6EcOSG2iuMU");finishparse(l);
                //JSONObject m = emp.getJSONObject("1CJKZSN09CoAW4AOyqa0AM");finishparse(m);


            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        }

        else {
            Log.e(TAG, "Couldn't get json from server.");}

//return s1+s2;
    }
    void finishparse(JSONObject d) throws JSONException, ExecutionException, InterruptedException {


        currentRecord= new FeedEntry();

        JSONObject f= d.getJSONObject("fields");
        JSONObject g=f.getJSONObject("title");
        str = g.getString("en-US");
        JSONObject h = f.getJSONObject("content");
        str1 = h.getString("en-US");
        JSONObject i=f.getJSONObject("photourl");
        JSONObject j=i.getJSONObject("en-US");
        JSONObject k=j.getJSONObject("fields");
        JSONObject l=k.getJSONObject("file");
        JSONObject m=l.getJSONObject("en-US");
        String url =m.getString("url");

        //currentRecord.setTitle(str);
        if (str.equals(ssss)){
            s3=url;
            content=str1;
            Download newdownload = new Download();

            setBitmap(newdownload.execute(s3).get());

        }
        //else {s3="DFGHJKLKJHGDFGHJK";}


    }
    String getString(){
        return content;
        //return jsonstr1;
    }
    private class Download extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            try{
                //FeedEntry r = new FeedEntry();
                //String src =r.getImageURL();
                //String src = "http://is3.mzstatic.com/image/thumb/Purple118/v4/51/42/5d/51425d9a-8150-93ce-c6b5-5c1de26ef3e7/mzl.elloeqsq.png/75x75bb-85.png";
                URL url = new URL("http:"+s3);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);

                return bitmap;
            }catch (IOException e){
                Log.e(TAG, "doInBackground: ERRRRRRROR" );
                return null;

            }
            //return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            //final ImageView imageview = (ImageView) View.findViewById(R.id.imageView);
            //imageview.setImageBitmap(bitmap);
            //final ImageView imageview = (ImageView)view.findViewById(R.id.imageView);
            //Download newdownload = new Download();
            //newdownload.execute("http://is3.mzstatic.com/image/thumb/Purple118/v4/51/42/5d/51425d9a-8150-93ce-c6b5-5c1de26ef3e7/mzl.elloeqsq.png/75x75bb-85.png");
            //imageview.setImageBitmap(bitmap);





        }
    }
}