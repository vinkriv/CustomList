package com.example.a10017404.customlist;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView1;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView)findViewById(R.id.listView1);
        arrayList=new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.add("e");
        arrayList.add("f");

        CustomAdapter adapter = new CustomAdapter(this,R.layout.list_item,arrayList);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrayList.get(position).toUpperCase(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public class CustomAdapter extends ArrayAdapter<String>{

        Context mainActivityContext;
        int resourceId;
        List list;

        public CustomAdapter(Context context, int resource, List<String>objects) {
            super(context, resource, objects);
            mainActivityContext=context;
            resourceId=resource;
            list=objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)mainActivityContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            View adapterLayout = layoutInflater.inflate(resourceId,null);
            ImageView imageView = (ImageView)adapterLayout.findViewById(R.id.imageView);
            imageView.setImageResource(R.mipmap.ic_launcher);
            TextView textView=(TextView)adapterLayout.findViewById(R.id.textView);
            textView.setText(list.get(position).toString());
            return adapterLayout;
        }
    }
}
