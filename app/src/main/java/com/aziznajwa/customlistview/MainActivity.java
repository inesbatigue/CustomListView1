package com.aziznajwa.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.listView);
        final ArrayList<HashMap<String,String>> listitems =new ArrayList<>();
        HashMap<String,String> map =new HashMap<>();
        map.put("titre","Word");
        map.put("description","Editeur de Text");
        map.put("img",String.valueOf(R.drawable.word));
        listitems.add(map);

        map =new HashMap<>();
        map.put("titre","Excel");
        map.put("description","Tableur");
        map.put("img",String.valueOf(R.drawable.excel));
        listitems.add(map);

        map =new HashMap<>();
        map.put("titre","Power Point");
        map.put("description","Logiciel de Presentation");
        map.put("img",String.valueOf(R.drawable.powerpoint));
        listitems.add(map);

        map =new HashMap<>();
        map.put("titre","Outlook");
        map.put("description","Client de courrir electronique");
        map.put("img",String.valueOf(R.drawable.outlook));
        listitems.add(map);

        final SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                listitems,
                R.layout.items,
                new String[]{"img","titre","description"},
                new int[]{R.id.image_view,R.id.text_view1,R.id.textView2}
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,String> map = (HashMap<String,String>) listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, map.get("titre"), Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,String> map = (HashMap<String,String>) listView.getItemAtPosition(position);
                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Sélection item");
                builder.setMessage("Votre choix : "+map.get("titre"));
                builder.setPositiveButton("ok",null);
                builder.show();
                return true;
            }
        });


    }
}
