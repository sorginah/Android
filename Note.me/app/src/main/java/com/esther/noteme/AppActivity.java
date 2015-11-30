package com.esther.noteme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import com.esther.noteme.db.Note;

import java.util.List;

/**
 * Created by Esther on 30/11/2015.
 */
public class AppActivity extends AppCompatActivity {

    protected Aplicacion app;
    protected List<Note> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (Aplicacion)getApplication();
        datos = app.getPersons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

