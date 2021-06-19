package lmm.intern.qrioustech.uwu.PagerAdapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lmm.intern.qrioustech.uwu.Model.FeedbackModel;
import lmm.intern.qrioustech.uwu.R;

public class UltraFeedbackAdapter extends PagerAdapter {
    private boolean isMultiScr;
    int[] prj_images;
    ArrayList<FeedbackModel> list;
    Context context;

    public UltraFeedbackAdapter(boolean isMultiScr, ArrayList<FeedbackModel> list, Context context) {
        this.isMultiScr = isMultiScr;
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(container.getContext()).inflate(R.layout.row_feedback_model, null);
        CircularImageView circularImageView = linearLayout.findViewById(R.id.pimage);


//        Animation animation = AnimationUtils.loadAnimation(context,R.anim.slide_left);
//
//        linearLayout.setAnimation(animation);

        circularImageView.setImageResource(list.get(position).getPimage());

        container.addView(linearLayout);

        return linearLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        LinearLayout view = (LinearLayout) object;
        container.removeView(view);
    }
}