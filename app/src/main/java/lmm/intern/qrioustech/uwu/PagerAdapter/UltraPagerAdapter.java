package lmm.intern.qrioustech.uwu.PagerAdapter;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import lmm.intern.qrioustech.uwu.R;

public class UltraPagerAdapter extends PagerAdapter {
    private boolean isMultiScr;
    int[] prj_images;

    public UltraPagerAdapter(boolean isMultiScr, int[] prj_images) {
        this.isMultiScr = isMultiScr;
        this.prj_images = prj_images;
    }

    @Override
    public int getCount() {
        return prj_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView linearLayout = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.layout_child, null);
        //new LinearLayout(container.getContext());
        ImageView imageView = linearLayout.findViewById(R.id.image);
//        TextView textView = (TextView) linearLayout.findViewById(R.id.pager_textview);
//        textView.setText(position + "");
//        linearLayout.setId(R.id.item_id);
        switch (position) {
            case 0:
                imageView.setImageResource(prj_images[0]);
//                linearLayout.setBackgroundResource(prj_images[0]);
                break;
            case 1:
                imageView.setImageResource(prj_images[1]);
//                linearLayout.setBackgroundResource(prj_images[1]);
                break;
            case 2:
                imageView.setImageResource(prj_images[2]);
//                linearLayout.setBackgroundResource(prj_images[2]);
                break;
            case 3:
                imageView.setImageResource(prj_images[3]);
//                linearLayout.setBackgroundResource(prj_images[3]);
                break;
            case 4:
                imageView.setImageResource(prj_images[4]);
//                linearLayout.setBackgroundResource(prj_images[4]);
                break;
        }
        container.addView(linearLayout);
//        linearLayout.getLayoutParams().width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180, container.getContext().getResources().getDisplayMetrics());
//        linearLayout.getLayoutParams().height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, container.getContext().getResources().getDisplayMetrics());
        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ImageView view = (ImageView) object;
        container.removeView(view);
    }
}