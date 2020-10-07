package com.example.lkoepplinger_eigene_aufgabe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Film> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CustomListAdapter(this, image_details));

        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Film film = (Film) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + film, Toast.LENGTH_LONG).show();
            }
        });
    }

    private  List<Film> getListData() {
        List<Film> list = new ArrayList<Film>();

        Film noes = new Film("A Nightmare on Elm Street", "noes_image", 1984, "Freddy Krueger");
        Film friday = new Film("Friday the 13th", "friday_image", 1980, "Jason Voorhees");
        Film halloween = new Film("Halloween", "halloween_image", 1978, "Michael Myers");
        Film texas = new Film("The Texas Chain Saw Massacre", "texas_image", 1974, "Leatherface");
        Film childsplay = new Film("Child's Play", "childsplay_image", 1988, "Chucky");
        Film scream = new Film("Scream", "scream_image", 1996, "Ghostface");
        Film candyman = new Film("Candyman", "candyman_image", 1992, "Candyman");

        list.add(noes);
        list.add(friday);
        list.add(halloween);
        list.add(texas);
        list.add(childsplay);
        list.add(scream);
        list.add(candyman);

        return list;
    }
}
