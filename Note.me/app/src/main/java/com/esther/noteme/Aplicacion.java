package com.esther.noteme;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.esther.noteme.db.Note;
import com.esther.noteme.db.NoteSqliteHelper;

import static com.esther.noteme.db.NoteSqliteHelper.*;
import java.util.ArrayList;
import java.util.List;


@SuppressLint("DefaultLocale")
public class Aplicacion extends Application {
	private SQLiteDatabase db;
	private List<Note> listado;

	@Override
	public void onCreate() {
		super.onCreate();
		NoteSqliteHelper helper = new NoteSqliteHelper(this);
		db = helper.getWritableDatabase();
		listado=new ArrayList<Note>();
		this.loadList();
	}
	
	public List<Note> getPersons(){
		return listado;
	}

	private void loadList() {
		listado = new ArrayList<Note>();
		Cursor personCursor = db.query(table_notes,
									new String[] {note_ID,
											note_TITLE,
											note_DESCRIPTION,
											note_STATE,
											note_DATE,
											note_PRIORITY},
									null, null, null, null, null);
		personCursor.moveToFirst();
		Note p;
		if (! personCursor.isAfterLast()) {
			do {
				Long id = personCursor.getLong(0);
				String title  = personCursor.getString(1);
				String description = personCursor.getString(2);
				String state = personCursor.getString(3);
				String date  = personCursor.getString(4);
				Float priority = personCursor.getFloat(5);
				p = new Note(id, title, description, state, date, priority);
				listado.add(p);
			} while (personCursor.moveToNext());
		}
		
		personCursor.close();
		
	}

	public void add(Note p){
		assert(null != p);
		
		ContentValues values = new ContentValues();
		values.put(note_TITLE, p.getTitle());
		values.put(note_DESCRIPTION, p.getDescription());
		values.put(note_STATE, p.getState());
		values.put(note_DATE, p.getDate());
		values.put(note_PRIORITY, p.getPriority());

		p.setId(db.insert(table_notes, null, values));
		Log.d("ADD", "Ha entrado en el metodo ADD");
		listado.add(p);
	}

	@SuppressLint("DefaultLocale")
	public void set(Note p) {
		assert(null != p);
		ContentValues values = new ContentValues();
		values.put(note_TITLE, p.getTitle());
		values.put(note_DESCRIPTION, p.getDescription());
		values.put(note_STATE, p.getState());
		values.put(note_DATE, p.getDate());
		values.put(note_PRIORITY, p.getPriority());
		long id = p.getId();
		Log.d("id", ""+id);
		String where = String.format("%s = %d",
				note_ID, id);

		db.update(table_notes, values, where, null);
		int tam=listado.size();
		for(int i=0;i<tam;i++){
			Note p2 = listado.get(i);
			if(p.getId()==p2.getId()){
				listado.set(i,p);
				break;
			}
		}
	}

	public void remove(Note p) {
		String where = String.format("%s = %s", note_ID, p.getId());
		db.delete(table_notes, where, null);
		listado.remove(p);
	}
	
	public Note get(Long id){
		int count =listado.size();
		for(int i=0;i<count;i++){
			Note p = listado.get(i);
			if(p.getId()==id){
				return p; 
			}
		}
		return new Note();
	}

}