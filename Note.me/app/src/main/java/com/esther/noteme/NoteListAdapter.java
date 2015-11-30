package com.esther.noteme;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.esther.noteme.db.Note;

import java.util.List;

public class NoteListAdapter extends BaseAdapter {

	private List<Note> listado;
	private Context context;
	private int vista;

	public NoteListAdapter(Context context, int vista, List<Note> datos) {
		this.listado = datos;
		this.vista = vista;
		this.context = context;
	}

	public int getCount() {
		return listado.size();
	}

	public Note getItem(int position) {
		if(null == listado){
			return null;
		}else{
			return listado.get(position);
		}
	}

	public long getItemId(int position) {
		return this.getItem(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		RelativeLayout rl;
		if (null == convertView) {
            rl = (RelativeLayout)View.inflate(context, vista, null);
		} else {
            rl = (RelativeLayout)convertView;
		}
        TextView title = (TextView) rl.findViewById(R.id.LblTitulo);
        TextView description = (TextView) rl.findViewById(R.id.LblSubTitulo);
        RatingBar rb = (RatingBar) rl.findViewById(R.id.rb_item);
        TextView date = (TextView)rl.findViewById(R.id.tv_date);

        title.setText(listado.get(position).getTitle());
        description.setText(listado.get(position).getTitle());
        rb.setRating(listado.get(position).getPriority());
        date.setText(listado.get(position).getDate());
		return rl;
	}

	public void forceReload() {
		notifyDataSetChanged();
	}

}
