package com.example.abhinavchinta.blogbeta;

import android.util.Log;

/**
 * Created by Abhinav Chinta on 9/22/2017.
 */

public class FeedEntry {
    private String title;
    private String content;
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        Log.e("toString: ",title );
        return  "\n"+title+"\n"+author+"\n";
       // Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();

    }
}
