package com.esther.noteme;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;

import com.esther.noteme.db.Note;

public class CreateNote extends AppActivity {

    private EditText et_title;
    private EditText et_description;
    private RatingBar rb_priority;
    private Long id;
    private Note p;
    private boolean edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_note);
        setUpViews();
    }

    private void setUpViews(){
        et_title = (EditText)findViewById(R.id.et_title);
        et_description = (EditText)findViewById(R.id.et_description);
        rb_priority = (RatingBar)findViewById(R.id.ratingBar);

    }

    @Override
    public void onBackPressed(){
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        Float rb = rb_priority.getRating();
        Note p = new Note();
        p.setTitle(title);
        p.setDescription(description);
        p.setPriority(rb);
        app.add(p);
        finish();
    }
}
