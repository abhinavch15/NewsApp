package com.example.abhinavchinta.blogbeta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.contentful.java.cda.CDAArray;
import com.contentful.java.cda.CDAClient;
import com.contentful.java.cda.CDAEntry;
import com.contentful.java.cda.CDAResource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    //private TextView textview;
    private int count=0;
    private ListView ListApps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListApps = (ListView) findViewById(R.id.listview);
        //final TextView textview = (TextView)findViewById(R.id.textView);
        //textview.setMovementMethod(new ScrollingMovementMethod());
        //textview.setMaxLines(10000);
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        CDAClient client = CDAClient.builder()
                .setSpace("y2mv6eklzz6u")
                .setToken("b3921c24e664003727a4771b082f892fb383093aec408f61c7de22352e09af9d")
                .build();

        //CDAEntry entry = client.observe(CDAEntry.class).one("4LgMotpNF6W20YKmuemW0a");
        /*client.observe(CDAEntry.class)
                .one("4LgMotpNF6W20YKmuemW0a")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CDAEntry>() {
                    CDAEntry result;

                    @Override public void onCompleted() {
                        Log.i("Contentful", gson.toJson(result));
                        textview.setText(gson.toJson(result));
                    }

                    @Override public void onError(Throwable error) {
                        Log.e("Contentful", "could not request entry", error);
                    }

                    @Override public void onNext(CDAEntry cdaEntry) {
                        result = cdaEntry;
                    }
                });*/



        //Gson gson = new GsonBuilder().setPrettyPrinting().create();



        client.observe(CDAEntry.class)
                //.where("include", "1")
                .all()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CDAArray>() {
                    CDAArray result;

                    @Override
                    public void onCompleted() {
                        for (CDAResource resource : result.items()) {
                            CDAEntry entry = (CDAEntry) resource;
                            try{
                                // Log.i("Contentful************", entry.getAttribute("description").toString());
                            }catch (Exception e){
                                Log.i("nothing found********", e.toString());
                            }

                            //textview.setText(gson.toJson(result));

                            //JsomParser jsomparser = new JsomParser();----------
                            //textview.setText(jsomparser.Parser(gson.toJson(result)));---------

                            //jsomparser.Parser(gson.toJson(result));
                            JsomParser parse = new JsomParser();
                            parse.Parser(gson.toJson(result));

                            //final ArrayAdapter<FeedEntry> arrayadapter =  new ArrayAdapter<FeedEntry>(
                            //                MainActivity.this, R.layout.list, parse.getApplications());
                            //         ListApps.setAdapter(arrayadapter);

                            final FeedAdapter feedadapter = new FeedAdapter(MainActivity.this, R.layout.tilenames,
                                    parse.getApplications());
                            ListApps.setAdapter(feedadapter);
                            ListApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3){

                                    Intent appInfo = new Intent(MainActivity.this, NewActivity.class);
                                    appInfo.putExtra("sss", gson.toJson(result));
                                    TextView textViewItem = ((TextView) arg1.findViewById(R.id.textView4));
                                    appInfo.putExtra("ss",textViewItem.getText());
                                    TextView authorname = ((TextView) arg1.findViewById(R.id.bleee));
                                    appInfo.putExtra("authorname",authorname.getText());


                                    //appInfo.putExtra("s",);
                                    //NewActivity newActivity= new NewActivity();
                                    //newActivity.setText("hhhhhhhhh");
                                    startActivity(appInfo);


                                    //FeedEntry feedentry = new FeedEntry();
                                    //String s =feedentry.getAuthor();
                                    //feedadapter.g
                                    //feedadapter.getView()
                                    //Toast.makeText(MainActivity.this, "New Activity" + arg3, Toast.LENGTH_SHORT).show();

                                }
                            });



                        }
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.e("Contentful", "could not request entry", error);
                    }

                    @Override
                    public void onNext(CDAArray cdaArray) {
                        result = cdaArray;
                    }
                });
        /*client.observe(CDAEntry.class)
                //.where("Brand","JrePkDVYomE8AwcuCUyMi")
                .all()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<CDAArray>() {
                    CDAArray result;
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();

                    @Override
                    public void onCompleted() {count++;Toast.makeText(getApplicationContext(),"count" +count,Toast.LENGTH_LONG).show();
                        //for (CDAResource resource : result.items()) {
                          //  CDAEntry entry = (CDAEntry) resource;
                            //Log.i("Contentful", entry.getField("fileName").toString());
                            Log.i("Contentful ssss", gson.toJson(result));
                            textview.setText(gson.toJson(result));


                        //}
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.e("Contentful", "could not request entry", error);
                    }

                    @Override
                    public void onNext(CDAArray cdaArray) {
                        result = cdaArray;


                        //textview.append("\n*****************************\n");
                    }
                });*/



        //CDAEntry entry = client.fetch(CDAEntry.class).one("sFzTZbSuM8coEwygeUYes");


        //Toast.makeText(getApplicationContext(),)



    }
}

