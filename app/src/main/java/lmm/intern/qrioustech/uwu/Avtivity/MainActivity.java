package lmm.intern.qrioustech.uwu.Avtivity;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import devlight.io.library.ntb.NavigationTabBar;
import lmm.intern.qrioustech.uwu.Fregment.AboutUsFragment;
import lmm.intern.qrioustech.uwu.Fregment.ContactUsFragment;
import lmm.intern.qrioustech.uwu.Fregment.LiveChatFragment;
import lmm.intern.qrioustech.uwu.Fregment.PortfolioFragment;
import lmm.intern.qrioustech.uwu.PagerAdapter.MyAdapter;
import lmm.intern.qrioustech.uwu.R;

public class MainActivity extends AppCompatActivity {

//    LinearLayout navigationTabBar,portfolio,live_chat,about_us,contect_us;
    NavigationTabBar navigationTabBar;
//    FrameLayout frameLayout;
    public static Fragment selected=null;
    boolean first=true;

    ViewPager viewPager;
    View view;
//    boolean start=false;
    MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        navigationTabBar = findViewById(R.id.ntb);
        viewPager = findViewById(R.id.viewPager);

//        if(start==false){
//            getSupportFragmentManager().beginTransaction().replace(R.id.vp_horizontal_ntb, new PortfolioFragment()).commit();
//            start=true;
//        }

        mAdapter = new MyAdapter(getSupportFragmentManager());
        mAdapter.notifyDataSetChanged();
        viewPager.setAdapter(mAdapter);

//        viewPager.setAdapter(new PagerAdapter() {
//            @Override
//            public int getCount() {
//                return 4;
//            }
//
//            @Override
//            public boolean isViewFromObject(final View view, final Object object) {
//                return view.equals(object);
//            }
//
//            @Override
//            public void destroyItem(final View container, final int position, final Object object) {
//                ((ViewPager) container).removeView((View) object);
//            }
//
//            @Override
//            public Object instantiateItem(final ViewGroup container, final int position) {
//
//                switch (position){
//                    case 0 :
//                        view = LayoutInflater.from(getBaseContext()).inflate(R.layout.fragment_portfolio, null, false);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.vp_horizontal_ntb, new PortfolioFragment()).commit();
//                        break;
//                    case 1 :
//                        view = LayoutInflater.from(getBaseContext()).inflate(R.layout.fragment_live_chat, null, false);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.vp_horizontal_ntb, new LiveChatFragment()).commit();
//                        break;
//                    case 2 :
//                        view = LayoutInflater.from(getBaseContext()).inflate(R.layout.fragment_contact_us, null, false);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.vp_horizontal_ntb, new ContactUsFragment()).commit();
//                        break;
//                    case 3 :
//                        view = LayoutInflater.from(getBaseContext()).inflate(R.layout.fragment_about_us, null, false);
//                        getSupportFragmentManager().beginTransaction().replace(R.id.vp_horizontal_ntb, new AboutUsFragment()).commit();
//                        break;
//                }
//                container.addView(view);
//                return view;
//            }
//        });

        final int colour = getResources().getColor(R.color.header);
//        final String[] colors = getResources().getStringArray(R.array.default_preview);

        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.portfolio),colour)
                        .selectedIcon(getResources().getDrawable(R.drawable.portfolio_fill))
                        .title("Portfolio")
//                        .badgeTitle("NTB")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.chat),colour)
                        .selectedIcon(getResources().getDrawable(R.drawable.chat_fill))
                        .title("Live Chat")
                        .badgeTitle("0")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.contact),colour)
                        .selectedIcon(getResources().getDrawable(R.drawable.contact_fill))
                        .title("Contact Us")
//                        .badgeTitle("state")
                        .build()
        );
        models.add(
                new NavigationTabBar.Model.Builder(getResources().getDrawable(R.drawable.about),colour)
                        .selectedIcon(getResources().getDrawable(R.drawable.about_fill))
                        .title("About Us")
//                        .badgeTitle("icon")
                        .build()
        );

        navigationTabBar.setBehaviorEnabled(true);

        navigationTabBar.setModels(models);
        navigationTabBar.setViewPager(viewPager, 0);

        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
                navigationTabBar.getModels().get(position).hideBadge();
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

        navigationTabBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < navigationTabBar.getModels().size(); i++) {
                    final NavigationTabBar.Model model = navigationTabBar.getModels().get(1);
                    navigationTabBar.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            model.showBadge();
                        }
                    }, i * 100);
                }
            }
        }, 500);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}



//        navigationTabBar = findViewById(R.id.ntb_horizontal);
//                portfolio = findViewById(R.id.portfolio);
//                live_chat= findViewById(R.id.live_chat);
//                contect_us = findViewById(R.id.contact_us);
//                about_us = findViewById(R.id.about_us);
//
//                frameLayout = findViewById(R.id.main_frameLayout);
//
//                portfolio.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//
//        selected=new PortfolioFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,selected).addToBackStack("Portfolio").commit();
//        }
//        });
//        live_chat.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//
//        selected=new LiveChatFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,selected).addToBackStack("Portfolio").commit();
//        }
//        });
//        contect_us.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//
//        selected=new ContactUsFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,selected).addToBackStack("Portfolio").commit();
//        }
//        });
//        about_us.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//
//        selected=new ContactUsFragment();
//        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,selected).addToBackStack("Portfolio").commit();
//        }
//        });



