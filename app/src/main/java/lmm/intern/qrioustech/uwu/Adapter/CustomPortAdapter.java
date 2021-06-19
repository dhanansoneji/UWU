package lmm.intern.qrioustech.uwu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.IDocumentLayout;
import com.tmall.ultraviewpager.UltraViewPager;
import com.tmall.ultraviewpager.transformer.UltraScaleTransformer;

import java.util.ArrayList;
import java.util.List;

import lmm.intern.qrioustech.uwu.Avtivity.DetailsActivity;
import lmm.intern.qrioustech.uwu.Avtivity.MainActivity;
import lmm.intern.qrioustech.uwu.Model.ImageModel;
import lmm.intern.qrioustech.uwu.Model.PortfolioModel;
import lmm.intern.qrioustech.uwu.PagerAdapter.PageAdapterImage;
import lmm.intern.qrioustech.uwu.PagerAdapter.UltraPagerAdapter;
import lmm.intern.qrioustech.uwu.R;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;


public class CustomPortAdapter extends RecyclerView.Adapter<CustomPortAdapter.ViewHolder> {

    List<PortfolioModel> list;
    List<ImageModel> imageList;
    Context context;
//    int page;

    public CustomPortAdapter(List<PortfolioModel> list, Context context/*,int page*/) {
        this.list = list;
        this.context = context;
//        this.page=page;
    }

    @NonNull
    @Override
    public CustomPortAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View new_layout= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_portfolio_model,viewGroup,false);

        CustomPortAdapter.ViewHolder n_l = new CustomPortAdapter.ViewHolder(new_layout);

        return n_l;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        viewHolder.more_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, DetailsActivity.class);
                intent.putExtra("pname",list.get(i).getPrj_name());
                intent.putExtra("ptype",list.get(i).getType());
                if(list.get(i).getType().equalsIgnoreCase("app")) {
                    intent.putExtra("palink", list.get(i).getPrj_androd());
                    intent.putExtra("pilink", list.get(i).getPrj_ios());
                }else {
                    intent.putExtra("pwlink", list.get(i).getPrj_website());
                }
                intent.putExtra("pdes",list.get(i).getPrj_des());
                intent.putExtra("pimages",list.get(i).getPrj_images());
                context.startActivity(intent);

//                if(viewHolder.more_less.getText().equals("Read More")){
//                    viewHolder.more_less.setText("Read Less");
//                    viewHolder.des.getLayout().getLayoutParams().setMaxLines(100);
////                    viewHolder.des.getDocumentLayoutParams().setMaxLines(10);
//
//                }else{
//                    viewHolder.more_less.setText("Read More");
//                    viewHolder.des.getLayout().getLayoutParams().setMaxLines(2);
////                    viewHolder.des.getDocumentLayoutParams().setMaxLines(2);
//                }
//                notifyDataSetChanged();
            }
        });

       if(list.get(i).getType().equalsIgnoreCase("web")){

           viewHolder.ultraViewPager.setVisibility(View.VISIBLE);
           viewHolder.recyclerView.setVisibility(View.INVISIBLE);
//           PageAdapterImage pageAdapterImage = new PageAdapterImage(context);
//           viewHolder.viewPager.setAdapter(pageAdapterImage);

           viewHolder.ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
           PagerAdapter adapter = new UltraPagerAdapter(false,list.get(i).getPrj_images());
           viewHolder.ultraViewPager.setAdapter(adapter);

//initialize built-in indicator
           viewHolder.ultraViewPager.initIndicator();
//set style of indicators
           viewHolder.ultraViewPager.getIndicator()
                   .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
//                .setFocusColor(Color.WHITE)
//                .setNormalColor(Color.WHITE)
                   .setIndicatorPadding(10)
                   .setMargin(0,0,0,17)
                   .setFocusResId(R.mipmap.focused)
                   .setNormalResId(R.mipmap.normal);
//                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5,context.getResources().getDisplayMetrics()));

//set the alignment
           viewHolder.ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//construct built-in indicator, and add it to  UltraViewPager
           viewHolder.ultraViewPager.getIndicator().build();
       }else{

            viewHolder.ultraViewPager.setVisibility(View.INVISIBLE);
            viewHolder.recyclerView.setVisibility(View.VISIBLE);

            viewHolder.recyclerView.setHasFixedSize(true);

            viewHolder.LayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            viewHolder.recyclerView.setLayoutManager(viewHolder.LayoutManager);

            imageList = new ArrayList<>();

            for (int j=0; j<list.get(i).getPrj_images().length; j++){
                imageList.add(new ImageModel(list.get(i).getPrj_images()[j]));
            }

            ImageAdapter adapter=new ImageAdapter(imageList,context);
            adapter.notifyDataSetChanged();
            viewHolder.recyclerView.setAdapter(adapter);
        }

        viewHolder.prj_name.setText(list.get(i).getPrj_name());

        viewHolder.des.setText(list.get(i).getPrj_des());

        viewHolder.android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                if(list.get(i).getType().equalsIgnoreCase("app")) {
                    if(list.get(i).getPrj_androd().equalsIgnoreCase(""))
                        Toast.makeText(context,"No Link", Toast.LENGTH_SHORT).show();
                    else {
                        intent.setData(Uri.parse(list.get(i).getPrj_androd()));
                        context.startActivity(intent);
                    }
                }else{
                    if(list.get(i).getPrj_website().equalsIgnoreCase(""))
                        Toast.makeText(context,"No Link", Toast.LENGTH_SHORT).show();
                    else {
                        intent.setData(Uri.parse(list.get(i).getPrj_website()));
                        context.startActivity(intent);
                    }
                }
            }
        });

        viewHolder.ios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                if(list.get(i).getPrj_ios().equalsIgnoreCase(""))
                    Toast.makeText(context,"No Link", Toast.LENGTH_SHORT).show();
                else {
                    intent.setData(Uri.parse(list.get(i).getPrj_ios()));
                    context.startActivity(intent);
                }
            }
        });

//        viewHolder.ultraViewPager.setItemRatio(1.0f);
//        viewHolder.ultraViewPager.setRatio(2.0f);
//        viewHolder.ultraViewPager.setMaxHeight(500);
//        viewHolder.ultraViewPager.setAutoMeasureHeight(true);
//        viewHolder.ultraViewPager.setPageTransformer(false, new UltraScaleTransformer());
//
//        ultraViewPager.setPageTransformer(false, new UltraDepthScaleTransformer());
//
////set an infinite loop
//        ultraViewPager.setInfiniteLoop(true);
////enable auto-scroll mode
//        ultraViewPager.setAutoScroll(2000);
//
        if(list.get(i).getType().equalsIgnoreCase("web")){
//            viewHolder.ultraViewPager.setMultiScreen(0.85f);
            viewHolder.ios.setVisibility(View.GONE);
            viewHolder.android.setImageResource(R.drawable.website);
//            viewHolder.ios_head.setText("Website : ");
        }
        else if(list.get(i).getType().equalsIgnoreCase("app")) {
//            viewHolder.ultraViewPager.setMultiScreen(0.3f);
            viewHolder.ios.setVisibility(View.VISIBLE);
            viewHolder.android.setImageResource(R.drawable.android);
        }

//
//        SpannableString content1 = new SpannableString(viewHolder.a_link.getText());
//        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
//        viewHolder.a_link.setText(content);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            viewHolder.des.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
//        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ViewPager viewPager;
        UltraViewPager ultraViewPager;
//        LinearLayout android_linear;
//        TextView a_link,i_link,ios_head;
        RecyclerView recyclerView;
        TextView prj_name,more_less;
        ImageView android,ios;
        DocumentView des;
        RecyclerView.LayoutManager LayoutManager;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ultraViewPager = itemView.findViewById(R.id.ultra_viewpager);

            more_less = itemView.findViewById(R.id.more_less);
            des = itemView.findViewById(R.id.des);
            android = itemView.findViewById(R.id.android);
            ios = itemView.findViewById(R.id.ios);
            recyclerView = itemView.findViewById(R.id.recyclerView);
            prj_name = itemView.findViewById(R.id.prj_name);

//            viewPager= itemView.findViewById(R.id.viewPagerImage);
//            a_link = itemView.findViewById(R.id.android_link);
//            i_link = itemView.findViewById(R.id.ios_link);
//            android_linear = itemView.findViewById(R.id.android_linear);
//            ios_head = itemView.findViewById(R.id.ios_head);
        }
    }
}


