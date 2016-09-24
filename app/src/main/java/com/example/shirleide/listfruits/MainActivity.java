package com.example.shirleide.listfruits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    EditText search;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search = (EditText) findViewById(R.id.search);
        list = (ListView) findViewById(R.id.list);




        String[] values = new String[] {
                "Abacate",
                "Acerola",
                "Açaí",
                "Acumã",
                "Amêndoa",
                "Banana",
                "Beringela",
                "Cacau",
                "Cajá",
                "Cajú",
                "Coco",
                "Damasco",
                "Graviola",
                "Guaraná",
                "Goiaba",
                "Ingá",
                "Jabuticaba",
                "Jaca",
                "Jaci",
                "Kiwi",
                "Laranja",
                "Limão",
                "Jambo",
                "Mamão",
                "Manga",
                "Maçã",
                "Melancia",
                "Pintanga",
                "Pêra",
                "Tangerina",
                "Uva"

        };

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                int itemPosition     = position;


                String  itemValue    = (String) list.getItemAtPosition(position);


                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();

            }
        });

        search.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
            }
        });

    }

}
