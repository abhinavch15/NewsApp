package com.example.abhinavchinta.blogbeta;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by Abhinav Chinta on 9/22/2017.
 */

public class JsomParser {
    private String str="";
    private String str1="";
    private String s1="";
    private String s2="";
    private String s3="";
    private ArrayList<FeedEntry> applications;
    public FeedEntry currentRecord=null;
    final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public JsomParser() {
        this.applications=new ArrayList<>();
    }

    public ArrayList<FeedEntry> getApplications() {
        return applications;
    }



    public void Parser(String jsonStr) {

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

            }

        }

        else {
            Log.e(TAG, "Couldn't get json from server.");}

//return s1+s2;
    }
    void finishparse(JSONObject d) throws JSONException {

        currentRecord= new FeedEntry();

        JSONObject f= d.getJSONObject("fields");
        JSONObject g=f.getJSONObject("title");
        str = g.getString("en-US");
        currentRecord.setTitle(str);
        JSONObject h = f.getJSONObject("content");
        str1 = h.getString("en-US");
        JSONObject i = f.getJSONObject("author");
        s3 =i.getString("en-US");

        //NewActivity.class
        currentRecord.setContent(str1);
        currentRecord.setAuthor(s3);

        //NewActivity newActivity= new NewActivity();
        //newActivity.setText(s3);

        applications.add(currentRecord);
        //JSONObject f = e.getJSONObject("fields");
        //textview.setText(str);
        //Log.e("Contentfuljjjjjjjjjjjj", str);
        //textview.setText(st);
        //return d.toString();
        //return  str+"\n"+str1+"\n"+"\n";
        //return null;

    }
    /*String getString(){
        return s3;
    }*/
}

