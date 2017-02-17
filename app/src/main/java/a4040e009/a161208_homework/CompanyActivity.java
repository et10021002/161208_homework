package a4040e009.a161208_homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompanyActivity extends AppCompatActivity {
    private GridView gridView;
    private int companyImage[] = {R.drawable.companyimage,R.drawable.companyimage1,R.drawable.companyimage2,R.drawable.companyimage3,
            R.drawable.companyimage4,R.drawable.companyimage5,R.drawable.companyimage6,R.drawable.companyimage7,
            R.drawable.companyimage8,R.drawable.companyimage9,R.drawable.companyimage10,R.drawable.companyimage11,
            R.drawable.companyimage12,R.drawable.companyimage13,R.drawable.companyimage14};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        setGridView();
        setAdapter();
    }
    private void setGridView(){
        gridView = (GridView) findViewById(R.id.gridview);
        gridView.setNumColumns(3);
    }
    private void setAdapter(){
        ArrayList<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<companyImage.length;i++){
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("image",companyImage[i]);
            list.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,list,R.layout.company_item,new String[]{"image"},
                                                            new int[]{R.id.company_image});
        gridView.setAdapter(simpleAdapter);
    }

}
