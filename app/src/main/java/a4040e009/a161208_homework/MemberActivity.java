package a4040e009.a161208_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class MemberActivity extends AppCompatActivity {
    private String member_id[] = {"A010111","A010112","A010113","A010114","A010115"};
    private String member_data[][] = {
            {"詹朝淵","0973-291128","臺中市東區三賢街123號"},
            {"陳重均","0979-354923","臺北市中正區重慶南路二段112號9樓之2"},
            {"劉姵妏","0976-561528","臺南市永康區龍潭里龍潭街123巷14號"},
            {"謝侑儒","0988-991913","臺中市太平區光明里長安11街15號"},
            {"林聖鈞","0935-290795","台南市安南區同安路456號"}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        setAdapter();
    }
    private void setAdapter(){
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
                this,                                                         //Context
                setgroupData(),                                              //grout List data
                android.R.layout.simple_expandable_list_item_1,                //group Layout
                new String[]{"id"},                                          //group Key
                new int[]{android.R.id.text1},                                //group TextView
                setchildData(),                                              //child List data
                android.R.layout.simple_expandable_list_item_1,               //child Layout
                new String[]{"name"},                                       //child Key
                new int[]{android.R.id.text1});                              //child TextView
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.exlistview);
        expandableListView.setAdapter(adapter);
    }
    private ArrayList<HashMap<String,String>> setgroupData(){
        ArrayList<HashMap<String,String>> groupData = new ArrayList<HashMap<String, String>>();             //父清單
        for(int i=0;i<member_id.length;i++){
            HashMap<String,String> group = new HashMap<String,String>();                          //父清單內容
            group.put("id",member_id[i]);
            groupData.add(group);
        }
        return groupData;
    }
    private ArrayList<ArrayList<HashMap<String,String>>> setchildData(){
        ArrayList<ArrayList<HashMap<String,String>>> childData = new ArrayList<ArrayList<HashMap<String,String>>>();    //子清單

        for(int i=0;i<member_data.length;i++){
            ArrayList<HashMap<String,String>> childlist = new ArrayList<HashMap<String, String>>();           //子清單容器
            for(int j=0;j<member_data[i].length;j++){
                HashMap<String,String> child = new HashMap<String,String>();                        //子清單內容
                child.put("name",member_data[i][j]);
                childlist.add(child);
            }
            childData.add(childlist);
        }
        return childData;
    }
}
