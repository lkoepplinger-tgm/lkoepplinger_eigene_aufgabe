package com.example.lkoepplinger_eigene_aufgabe;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Film> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext, List<Film> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.iconView = (ImageView) convertView.findViewById(R.id.imageView);
            holder.filmnameView = (TextView) convertView.findViewById(R.id.textView_filmname);
            holder.jahrView = (TextView) convertView.findViewById(R.id.textView_anfang);
            holder.antagonistView = (TextView) convertView.findViewById(R.id.textView_mainantagonist);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Film Filme = this.listData.get(position);
        holder.filmnameView.setText(Filme.getFilmName());
        holder.jahrView.setText("Anfang: " + Filme.getAnfang());
        holder.antagonistView.setText("Main Antagonist: " + Filme.getMainAntagonist());

        int imageId = this.getMipmapResIdByName(Filme.getIconName());

        holder.iconView.setImageResource(imageId);

        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView iconView;
        TextView filmnameView;
        TextView jahrView;
        TextView antagonistView;
    }

}