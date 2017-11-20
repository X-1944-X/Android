package com.example.android.myapplication;

import android.graphics.Color;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
    private int lastClick=0;
    private GridView gview;
    private List<HashMap<String, Object>> data_list;
    private SimpleAdapter sim_adapter;
    private int[] icon = { R.drawable.air, R.drawable.calendar,
            R.drawable.camera, R.drawable.clock, R.drawable.android,
            R.drawable.battery, R.drawable.behance, R.drawable.behance,
            R.drawable.bowlingball, R.drawable.busticketmachine, R.drawable.bus,
            R.drawable.cd };
    private String[] iconName = { "通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声",
            "设置", "语音", "天气", "浏览器", "视频" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gview = (GridView) findViewById(R.id.gview);
        data_list = new ArrayList<HashMap<String, Object>>();
        getData();
        String [] from ={"image","text"};
        int [] to = {R.id.image,R.id.text};
        sim_adapter = new SimpleAdapter(this, data_list, R.layout.show, from, to);
        gview.setAdapter(sim_adapter);
        gview.setOnItemClickListener(new ItemClickListener());
    }

    class ItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            HashMap<String, Object> item=
                    (HashMap<String, Object>) parent.getItemAtPosition(position);
            setTitle((String)item.get("ItemText"));
            parent.getChildAt(lastClick).setBackgroundColor(0);
            view.setBackgroundColor(Color.parseColor("#FF4081"));
            lastClick=position;
            Toast.makeText(MainActivity.this,"Click"+position,Toast.LENGTH_SHORT).show();
        }
    }


    public List<HashMap<String, Object>> getData(){
        for(int i=0;i<icon.length;i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            data_list.add(map);
        }

        return data_list;
    }


}
