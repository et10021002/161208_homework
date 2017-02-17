package a4040e009.a161208_homework;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class AdvertisingActivity extends AppCompatActivity {
    private int companyImage[] = {R.drawable.companyimage,R.drawable.companyimage1,R.drawable.companyimage2,R.drawable.companyimage3,
            R.drawable.companyimage4,R.drawable.companyimage5,R.drawable.companyimage6,R.drawable.companyimage7,
            R.drawable.companyimage8,R.drawable.companyimage9,R.drawable.companyimage10,R.drawable.companyimage11,
            R.drawable.companyimage12,R.drawable.companyimage13,R.drawable.companyimage14};
    private ViewPager viewPager;
    private AdvAdapter advAdapter;
    private LinearLayout linear_horizontal_scrollview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advertising);
        setdata();
    }
    private void setdata(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        linear_horizontal_scrollview = (LinearLayout) findViewById(R.id.linear_horizontal_scrollview);
        List list = new ArrayList<Integer>();
        for(int i:companyImage){
            list.add(i);
        }
        pagerView(list);
        for(int i:companyImage){
            linear_horizontal_scrollview.addView(insertImage(i));
        }
    }
    /**
     * ViewPager
     * @param list
     */
    private void pagerView(List<Integer> list){
        advAdapter = new AdvAdapter(this,list);
        viewPager.setAdapter(advAdapter);
    }
    /**
     * @param path
     * @return
     */
    private View insertImage(int path){
        LinearLayout linearLayout = new LinearLayout(getApplicationContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setGravity(Gravity.CENTER);
        linearLayout.setPadding(10,0,10,0);

        View child = getLayoutInflater().inflate(R.layout.adv_item,null);
        ImageView imageView = (ImageView)child.findViewById(R.id.cell_imageview);
        imageView.setImageResource(path);
        linearLayout.addView(child);

        return linearLayout;
    }
}
