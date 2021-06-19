package lmm.intern.qrioustech.uwu.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import lmm.intern.qrioustech.uwu.Avtivity.DetailsActivity;
import lmm.intern.qrioustech.uwu.Model.CategoryModel;
import lmm.intern.qrioustech.uwu.Model.ImageModel;
import lmm.intern.qrioustech.uwu.Model.PortfolioModel;
import lmm.intern.qrioustech.uwu.PagerAdapter.UltraPagerAdapter;
import lmm.intern.qrioustech.uwu.R;


public class PortfolioAdapter extends ArrayAdapter<PortfolioModel> {

    UltraViewPager ultraViewPager;
    //        LinearLayout android_linear;
//        TextView a_link,i_link,ios_head;
    RecyclerView recyclerView;
    TextView prj_name,more_less;
    ImageView android,ios;
    DocumentView des;
    RecyclerView.LayoutManager LayoutManager;
    List<PortfolioModel> list;
    List<ImageModel> imageList;
    Context context;

    public PortfolioAdapter(@androidx.annotation.NonNull @NonNull Context context, int resource, @androidx.annotation.NonNull @NonNull List<PortfolioModel> objects) {
        super(context, resource, objects);
        this.list = objects;
        this.context = context;
    }

    @androidx.annotation.NonNull
    @NonNull
    @Override
    public View getView(final int position, @Nullable @android.support.annotation.Nullable View convertView, @androidx.annotation.NonNull @NonNull ViewGroup parent) {

        View new_view=LayoutInflater.from(getContext()).inflate(R.layout.row_portfolio_model,parent,false);

        ultraViewPager = new_view.findViewById(R.id.ultra_viewpager);

        more_less = new_view.findViewById(R.id.more_less);
        des = new_view.findViewById(R.id.des);
        android = new_view.findViewById(R.id.android);
        ios = new_view.findViewById(R.id.ios);
        recyclerView = new_view.findViewById(R.id.recyclerView);
        prj_name = new_view.findViewById(R.id.prj_name);




        more_less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(context, DetailsActivity.class);
                intent.putExtra("pname",list.get(position).getPrj_name());
                intent.putExtra("ptype",list.get(position).getType());
                if(list.get(position).getType().equalsIgnoreCase("app")) {
                    intent.putExtra("palink", list.get(position).getPrj_androd());
                    intent.putExtra("pilink", list.get(position).getPrj_ios());
                }else {
                    intent.putExtra("pwlink", list.get(position).getPrj_website());
                }
                intent.putExtra("pdes",list.get(position).getPrj_des());
                intent.putExtra("pimages",list.get(position).getPrj_images());
                context.startActivity(intent);
            }
        });




        if(list.get(position).getType().equalsIgnoreCase("web")){

            ultraViewPager.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
//           PageAdapterImage pageAdapterImage = new PageAdapterImage(context);
//           viewPager.setAdapter(pageAdapterImage);

            ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
            PagerAdapter adapter = new UltraPagerAdapter(false,list.get(position).getPrj_images());
            ultraViewPager.setAdapter(adapter);

//initialize built-in indicator
            ultraViewPager.initIndicator();
//set style of indicators
            ultraViewPager.getIndicator()
                    .setOrientation(UltraViewPager.Orientation.HORIZONTAL)
//                .setFocusColor(Color.WHITE)
//                .setNormalColor(Color.WHITE)
                    .setIndicatorPadding(10)
                    .setMargin(0,0,0,17)
                    .setFocusResId(R.mipmap.focused)
                    .setNormalResId(R.mipmap.normal);
//                .setRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5,context.getResources().getDisplayMetrics()));

//set the alignment
            ultraViewPager.getIndicator().setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
//construct built-in indicator, and add it to  UltraViewPager
            ultraViewPager.getIndicator().build();
        }else{

            ultraViewPager.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);

            recyclerView.setHasFixedSize(true);

            LayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(LayoutManager);

            imageList = new ArrayList<>();

            for (int j=0; j<list.get(position).getPrj_images().length; j++){
                imageList.add(new ImageModel(list.get(position).getPrj_images()[j]));
            }

            ImageAdapter adapter=new ImageAdapter(imageList,context);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        }

        prj_name.setText(list.get(position).getPrj_name());

        des.setText(list.get(position).getPrj_des());

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                if(list.get(position).getType().equalsIgnoreCase("app")) {
                    if(list.get(position).getPrj_androd().equalsIgnoreCase(""))
                        Toast.makeText(context,"No Link", Toast.LENGTH_SHORT).show();
                    else {
                        intent.setData(Uri.parse(list.get(position).getPrj_androd()));
                        context.startActivity(intent);
                    }
                }else{
                    if(list.get(position).getPrj_website().equalsIgnoreCase(""))
                        Toast.makeText(context,"No Link", Toast.LENGTH_SHORT).show();
                    else {
                        intent.setData(Uri.parse(list.get(position).getPrj_website()));
                        context.startActivity(intent);
                    }
                }
            }
        });

        ios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                if(list.get(position).getPrj_ios().equalsIgnoreCase(""))
                    Toast.makeText(context,"No Link", Toast.LENGTH_SHORT).show();
                else {
                    intent.setData(Uri.parse(list.get(position).getPrj_ios()));
                    context.startActivity(intent);
                }
            }
        });

        if(list.get(position).getType().equalsIgnoreCase("web")){
            ios.setVisibility(View.GONE);
            android.setImageResource(R.drawable.website);
        }else if(list.get(position).getType().equalsIgnoreCase("app")) {
            ios.setVisibility(View.VISIBLE);
            android.setImageResource(R.drawable.android);
        }

        return new_view;
    }
}


