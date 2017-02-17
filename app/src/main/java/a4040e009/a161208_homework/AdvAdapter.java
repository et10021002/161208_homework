package a4040e009.a161208_homework;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

/**
 * Created by wanyun on 2016/12/8.
 */

public class AdvAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> list;
    private LayoutInflater inflater;
    public AdvAdapter(Context context,List<Integer> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }
    @Override
    public Object instantiateItem(ViewGroup viewGroup, int position){
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = inflater.inflate(R.layout.adv_item,viewGroup,false);
        ImageView imageView = (ImageView)itemview.findViewById(R.id.cell_imageview);
        imageView.setImageResource(list.get(position));
        (viewGroup).addView(itemview);
        return itemview;
    }
    @Override
    public void destroyItem(ViewGroup viewGroup, int position, Object object){
        viewGroup.removeView((LinearLayout)object);
    }
}
