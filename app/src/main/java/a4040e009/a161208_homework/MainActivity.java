package a4040e009.a161208_homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SimpleAdapter simpleAdapter;
    private List<HashMap<String,Object>> hashMapList;
    private HashMap<String,Object> map;
    private String keyname[] = {"image","text"};
    private int resid[] = {R.id.ivmain,R.id.tvmain};
    private int main_image[] = {R.drawable.icon_member,R.drawable.icon_product,R.drawable.icon_company,R.drawable.icon_advertising};
    private String main_text[] = {"會員管理系統","產品管理系統","廠商聯絡系統","廣告廠商系統"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setadapter();
        listView.setOnItemClickListener(listener);
    }
    //Listview
    private void setadapter(){
        listView = (ListView) findViewById(R.id.lvmain);
        simpleAdapter = new SimpleAdapter(this, getmapdata(), R.layout.main_item, keyname,resid);
        listView.setAdapter(simpleAdapter);
    }
    private List<HashMap<String,Object>> getmapdata(){
        hashMapList = new ArrayList<HashMap<String, Object>>();
        for(int i = 0;i<main_image.length;i++){
            map = new HashMap<String, Object>();
            map.put("image",main_image[i]);
            map.put("text",main_text[i]);
            hashMapList.add(map);
        }
        return hashMapList;
    }
//Listview點擊事件
    private OnItemClickListener listener = new OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,//parent就是ListView，view表示Item视图，position表示数据索引
                                long id) {
            ListView lv = (ListView)parent;
            HashMap<String,Object> person = (HashMap<String,Object>)lv.getItemAtPosition(position);//SimpleAdapter返回Map
            //Toast.makeText(getApplicationContext(), person.toString(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent();
            Bundle bundle = new Bundle();
            switch(position){
                case 0:
                    bundle.putString("text", "會員管理系統");
                    i.setClass(MainActivity.this, MemberActivity.class);
                    break;
                case 1:
                    bundle.putString("text", "產品管理系統");
                    //i.setClass(MainActivity.this, ProductActivity.class);
                    break;
                case 2:
                    bundle.putString("text", "廠商聯絡系統");
                    i.setClass(MainActivity.this, CompanyActivity.class);
                    break;
                case 3:
                    bundle.putString("text", "廣告廠商系統");
                    i.setClass(MainActivity.this, AdvertisingActivity.class);
                    break;
            }
             i.putExtras(bundle);
            startActivity(i);  //重點在這一行
        }
    };

}