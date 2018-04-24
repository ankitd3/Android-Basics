package com.example.ankitd3.ageapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.Currency;
import java.util.List;
import java.util.Map;

public class Quiz extends AppCompatActivity {

    ListView con;
    Button t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        con=(ListView)findViewById(R.id.l);
        t=(Button)findViewById(R.id.show);

    }


    public void get(View V){
        Cursor c = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        startManagingCursor(c);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone._ID};

        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter s = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,c,from,to);
        con.setAdapter(s);
        con.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    }

}
