package lmm.intern.qrioustech.uwu.Avtivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bluejamesbond.text.DocumentView;
import com.tmall.ultraviewpager.UltraViewPager;

import java.util.ArrayList;
import java.util.List;

import lmm.intern.qrioustech.uwu.Adapter.ImageAdapter;
import lmm.intern.qrioustech.uwu.Model.ImageModel;
import lmm.intern.qrioustech.uwu.PagerAdapter.UltraPagerAdapter;
import lmm.intern.qrioustech.uwu.R;

public class DetailsActivity extends AppCompatActivity {

    LinearLayout l_ios;
    TextView prj_name;
    TextView android,ios;
    DocumentView documentView;
    List<ImageModel> imageList;
    UltraViewPager ultraViewPager;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager LayoutManager;
    String palink,pilink,pwlink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        prj_name = findViewById(R.id.prj_name);
        android = findViewById(R.id.android);
        ios = findViewById(R.id.ios);
        documentView = findViewById(R.id.des);
        ultraViewPager = findViewById(R.id.ultra_viewpager);
        recyclerView = findViewById(R.id.recyclerView);
        l_ios = findViewById(R.id.linear_ios);

        Bundle bundle = getIntent().getExtras();

        final String ptype= bundle.getString("ptype");
        String pname= bundle.getString("pname");
        if(ptype.equalsIgnoreCase("app")){
            palink= bundle.getString("palink");
            pilink= bundle.getString("pilink");
        }else {
            pwlink = bundle.getString("pwlink");
        }
        String pdes = bundle.getString("pdes");
        int[] pimages = bundle.getIntArray("pimages");

        prj_name.setText(pname);
        documentView.setText(pdes);

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                if(ptype.equalsIgnoreCase("app")) {
                    if(palink.equalsIgnoreCase(""))
                        Toast.makeText(getApplicationContext(),"No Link", Toast.LENGTH_SHORT).show();
                    else {
                        intent.setData(Uri.parse(palink));
                        startActivity(intent);
                    }
                }else{
                    if(pwlink.equalsIgnoreCase(""))
                        Toast.makeText(getApplicationContext(),"No Link", Toast.LENGTH_SHORT).show();
                    else {
                        intent.setData(Uri.parse(pwlink));
                        startActivity(intent);
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
                if(pilink.equalsIgnoreCase(""))
                    Toast.makeText(getApplicationContext(),"No Link", Toast.LENGTH_SHORT).show();
                else {
                    intent.setData(Uri.parse(pilink));
                    startActivity(intent);
                }
            }
        });

        if(ptype.equalsIgnoreCase("web")){

            ultraViewPager.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
//           PageAdapterImage pageAdapterImage = new PageAdapterImage(context);
//           viewPager.setAdapter(pageAdapterImage);

            ultraViewPager.setScrollMode(UltraViewPager.ScrollMode.HORIZONTAL);
//initialize UltraPagerAdapter，and add child view to UltraViewPager
            PagerAdapter adapter = new UltraPagerAdapter(false,pimages);
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

            LayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(LayoutManager);

            imageList = new ArrayList<>();

            for (int j=0; j<pimages.length; j++){
                imageList.add(new ImageModel(pimages[j]));
            }

            ImageAdapter adapter=new ImageAdapter(imageList,this);
            adapter.notifyDataSetChanged();
            recyclerView.setAdapter(adapter);
        }

        if(ptype.equalsIgnoreCase("web")){
//            viewHolder.ultraViewPager.setMultiScreen(0.85f);
            l_ios.setVisibility(View.GONE);
            android.setText("Website");
//            viewHolder.ios_head.setText("Website : ");
        }
        else if(ptype.equalsIgnoreCase("app")) {
//            viewHolder.ultraViewPager.setMultiScreen(0.3f);
            l_ios.setVisibility(View.VISIBLE);
            android.setText("Android");
        }

    }
}
