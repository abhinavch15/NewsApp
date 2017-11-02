package com.example.abhinavchinta.blogbeta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);
        Toast.makeText(NewActivity.this, "New Activity" , Toast.LENGTH_SHORT).show();
        String s = getIntent().getStringExtra("ss");
        String result = getIntent().getStringExtra("sss");
        String author = getIntent().getStringExtra("authorname");

        JsomNewParser parse = new JsomNewParser();
        parse.Parser(result,s);




        ImageView im = (ImageView)findViewById(R.id.imageView2);

        im.setImageBitmap(parse.getBitmap());
        //startActivity(this.getIntent());
        TextView textview = (TextView)findViewById(R.id.textView4);
        TextView textview1 = (TextView)findViewById(R.id.textView5);
        TextView authorr = (TextView)findViewById(R.id.author);
        authorr.setText(author);

       // final TextView textview = (TextView)findViewById(R.id.textView);
        //textview.setMovementMethod(new ScrollingMovementMethod());
        //textview.setMaxLines(10000);
        textview.setText( parse.getString());
        textview1.setText(s);
        //textview.setText(result);

    }

}
