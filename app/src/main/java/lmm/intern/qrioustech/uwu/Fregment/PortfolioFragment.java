package lmm.intern.qrioustech.uwu.Fregment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.jaredrummler.materialspinner.MaterialSpinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lmm.intern.qrioustech.uwu.Adapter.CategoryAdapter;
import lmm.intern.qrioustech.uwu.Adapter.CustomPortAdapter;
import lmm.intern.qrioustech.uwu.Adapter.PortfolioAdapter;
import lmm.intern.qrioustech.uwu.Avtivity.MainActivity;
import lmm.intern.qrioustech.uwu.Model.CategoryModel;
import lmm.intern.qrioustech.uwu.Model.PortfolioModel;
import lmm.intern.qrioustech.uwu.PagerAdapter.MyAdapter;
import lmm.intern.qrioustech.uwu.PagerAdapter.PortPagerAdapter;
import lmm.intern.qrioustech.uwu.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link PortfolioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PortfolioFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public View view;
    public ViewPager mViewPager;
//    private NavigationTabStrip mBottomNavigationTabStrip;
//    public PortPagerAdapter mAdapter;
    List<PortfolioModel> list;
    List<CategoryModel> cat_list;
//    RecyclerView recycler_view;
    ListView listView;
    RecyclerView cat_listView;
    RecyclerView.LayoutManager LayoutManager,layoutManager2;
//    Spinner dynamicSpinner;
    CategoryAdapter categoryAdapter;
    RequestQueue mRequestQueue;

    public PortfolioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PortfolioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PortfolioFragment newInstance(String param1, String param2) {
        PortfolioFragment fragment = new PortfolioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_portfolio, container, false);

        list= new ArrayList<>();
        cat_list= new ArrayList<>();

        cat_listView = view.findViewById(R.id.category_list);
        listView = view.findViewById(R.id.listView);
//        recycler_view=view.findViewById(R.id.recycler);

        cat_listView.setHasFixedSize(true);
//        recycler_view.setHasFixedSize(true);

        layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
//        LayoutManager = new LinearLayoutManager(getContext());

        cat_listView.setLayoutManager(layoutManager2);
//        recycler_view.setLayoutManager(LayoutManager);
//        dynamicSpinner = view.findViewById(R.id.dynamic_spinner);

        //Applications

//        list.add(new PortfolioModel("app","Dj Durisimo created this App so you can have his mixes with you on the go at all times.! The App is absolutely free of charge and DJ Durisimo" +
//                " will be keeping you tuned in on all future events and will be making sure you obtain the hottest mixes he's put together at all times. Dj Durisimo" +
//                " comes Pre-loaded with an array of music like Merengue, Salsa, Bachatas, House, Dembow, Reggae, Reggaeton, Hip Hop, R&B, Freestyle and" +
//                " more. All new mixes and updates are created on a weekly or bi-monthly basis. Unlike other apps just based on Solely Music, Durisimo decided" +
//                " to implement modern tabs that enable you to take pictures directly from the app, leave voice messages, comments and even allows you to " +
//                "subscribe and obtain free coupons or tickets to future events.","Durisimo","https://play.google.com/store/apps/details?id=com.app_durisimo1.layout","https://itunes.apple.com/in/app/durisimo/id712453304?mt=8",new int[]{R.drawable.a1, R.drawable.a1_1}));
//
//        //Websites
//
//        list.add(new PortfolioModel("web","This website is used to book a taxi booking, with some entertainment feartures like : Listen Music, Local News, nightClub details, Resturants" +
//                " details, Socail Media Register and Social Media Login, User Location Tracking, Trip Selection, Trip Car Selection, Payment via Cash and " +
//                "Credit Card/Debit Card, User Profile Settings, Trip History, Interactive User Interface, Notifications, Music Player, Google News/Twitter News," +
//                " Events, News Marquee., Driver's Login, Feedback Feature.","My Taxi Apps","http://mytaxiapps.com/",new int[]{R.drawable.w1, R.drawable.w1_1, R.drawable.w1_2}));
//
//        //Applications
//
//        list.add(new PortfolioModel("app","Exit Vacancy is an application for Searching Nearby Hotels.User can get Hotel details can view ratings of hotel.","Exit Vacancy","","",new int[]{R.drawable.a2, R.drawable.a2_1, R.drawable.a2_2}));
//
//        //Websites
//
//        list.add(new PortfolioModel("web","This website is used to book a taxi booking, with some entertainment features like : Listen Music, Local News, nightClub details, Resturants" +
//                " details, Social Media Register and Social Media Login, User Location Tracking, Trip Selection, Trip Car Selection, Payment via Cash and " +
//                "Credit Card/Debit Card, User Profile Settings, Trip History, Interactive User Interface, Notifications, Music Player, Google News/Twitter News, " +
//                "Events, News Marquee., Driver's Login, Feedback Feature.","The Venue","http://thevenueapps.com/",new int[]{R.drawable.w2, R.drawable.w2_1}));
//
//        //Applications
//
//        list.add(new PortfolioModel("app","Wilforth is application for play group school childrens. In this application childrens can play games,quiz and mentor or gaurdian can see child " +
//                "activities and its progress.","Wilforth","","",new int[]{R.drawable.a3, R.drawable.a3_1}));
//
//        //Websites
//
//        list.add(new PortfolioModel("web","A website that portrays the mobile app in a eye-catching design and puts the visitor into the creators perspective. It also displays all the " +
//                "information regarding the mobile apps, listing all the features and why it is far better than any other app in competition. The website is fully " +
//                "integrated into one page and the data is lazy loaded so the visitor has a fast, responsive and unforgettable experience.","Believe in Millz","http://believeinmillz.com",new int[]{R.drawable.w3}));

        //Applications

//        list.add(new PortfolioModel("app","Dj Styles created his very own app so everyone can hear the hottest music on the go. It is simple to use. This app contains an amazing amount" +
//                " of features as they decided to implement modern tabs that allow you Powerful Sound effects, Easy navigation, Favorite Support and a good" +
//                " user interface view. Dj Styles 'S mobile updates are done on a weekly basis.","DJ Styles 2.0","https://play.google.com/store/apps/details?id=com.stegowl.dj_styles","https://itunes.apple.com/us/app/dj-styles-2-0/id1241314182?mt=8",new int[]{R.drawable.a4, R.drawable.a4_1, R.drawable.a4_2}));
//
//        list.add(new PortfolioModel("app","Rumba Radio Boston created his very own app so you can hear the hottest music on the go!The official app of Rumba Radio Boston will keep" +
//                " you on the loop of all new singles, mix tapes, re-mixes, exclusive events and more.Rumba Radio Boston's mobile updates are done on a " +
//                "weekly basis.","Rumba Radio Boston","","https://itunes.apple.com/in/app/rumba-radio-boston/id1291380252?mt=8",new int[]{R.drawable.a5, R.drawable.a5_1}));

        //Websites

//        list.add(new PortfolioModel("web","This website is used for preschool student admission in talent sprouts school. Here we can see fees for academic year for different age. " +
//                "Activities going on in school can be visited from here. Here children's different Art are presented like Dance, Tumbling, Theater, Music, etc. " +
//                "Academics details are displayed here like Science, Reading, Writing, Geography, Sign language, etc.","Talent Sprouts","http://talentsprouts.com/",new int[]{R.drawable.w4, R.drawable.w4_1}));
//
//        list.add(new PortfolioModel("web","A wonderful WordPress website for a great Thai food restaurant. EnjoyMint Serves freshly made and customizable food bowls of your choice." +
//                " So that website has eye-catching moving food bowls also the brand colors used to made it more unique and presentable.","Enjoymint","https://enjoymintkitchen.com/",new int[]{R.drawable.w5, R.drawable.w5_1, R.drawable.w5_2}));

//        CustomPortAdapter adapter=new CustomPortAdapter(list,getContext());
//        adapter.notifyDataSetChanged();
//        recycler_view.setAdapter(adapter);

        getCategory();
//        getAllData();

//        PortfolioAdapter adapter = new PortfolioAdapter(getContext(),0,list);
//        listView.setAdapter(adapter);

//        cat_list.add(new CategoryModel(R.drawable.all,"All"));
//        cat_list.add(new CategoryModel(R.drawable.shopping,"Shopping"));
//        cat_list.add(new CategoryModel(R.drawable.musical,"Music"));
//        cat_list.add(new CategoryModel(R.drawable.social,"Social Media"));
//
//
//        categoryAdapter = new CategoryAdapter(getContext(),cat_list,0);
//        categoryAdapter.notifyDataSetChanged();
//        cat_listView.setAdapter(categoryAdapter);

//        cat =new String[] {"All","Shopping","Education","Music","Social Media"};
//
//        MaterialSpinner spinner = view.findViewById(R.id.spinner);
//        spinner.setItems(cat);
//        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
//
//            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
//                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
//            }
//        });

//        arrayAdapter = new ArrayAdapter<String>(getContext(),R.layout.row_text_spinner,R.id.cust_view,cat);
//        dynamicSpinner.setAdapter(arrayAdapter);
//
//        dynamicSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
////                Log.v("item", (String) parent.getItemAtPosition(position));
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // TODO Auto-generated method stub
//            }
//        });

        cat_listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = cat_listView.getChildAdapterPosition(v);
                getAllData(position);
            }
        });


//        initUI();
//        setUI();

        return view;
    }



    public void getAllData(final int position){
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        String URL = "http://192.168.1.38/uwu/public/api/applications";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray =  jsonObject.getJSONArray("data");
                    for (int i=0;i<=jsonArray.length();i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String prj_logo = jsonObject.getString("logo");
                        String name = jsonObject1.getString("title");
//                        list.add(new PortfolioModel(R.drawable.all,name));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VOLLEY", error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams(){
                Map<String,String> map = new HashMap<String, String>();
                map.put("name", String.valueOf(position));
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }



    public void getCategory(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.1.38/uwu/public/api/categories", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Response",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray =  jsonObject.getJSONArray("data");
                    for (int i=0;i<=jsonArray.length();i++) {
                        JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                        String name = jsonObject1.getString("name");
                        String id = jsonObject1.getString("id");
                        cat_list.add(new CategoryModel(R.drawable.all,name));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                categoryAdapter = new CategoryAdapter(getContext(),cat_list,0);
                categoryAdapter.notifyDataSetChanged();
                cat_listView.setAdapter(categoryAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", String.valueOf(error));
            }
        });

        getRequestQueue().add(stringRequest);
    }

    public RequestQueue getRequestQueue(){
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getContext());
        }
        return mRequestQueue;
    }

//    private void initUI() {

//        mBottomNavigationTabStrip = view.findViewById(R.id.nts_bottom);
//        mViewPager = view.findViewById(R.id.frameLayoutPort);
//    }
//    private void setUI() {

//        mAdapter = new PortPagerAdapter(getChildFragmentManager());
//
//        mViewPager.setAdapter(mAdapter);
//
//        mBottomNavigationTabStrip.setViewPager(mViewPager,0);

//        mBottomNavigationTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int i, float v, int i1) {
//
//            }
//
//            @Override
//            public void onPageSelected(int i) {
//                mViewPager.setCurrentItem(i);
//                switch (i){
//                    case 0 :
//                        new AppsFragment();
//                        break;
//                    case 1:
//                        new WebFragment();
//                        break;
//                }
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int i) {
//
//            }
//        });

//        mBottomNavigationTabStrip.setOnTabStripSelectedIndexListener(new NavigationTabStrip.OnTabStripSelectedIndexListener() {
//            @Override
//            public void onStartTabSelected(String title, int index) {
////                mViewPager.setCurrentItem(index);
//
////                switch (index){
////                    case 0 :
////                        new AppsFragment();
////                        break;
////                    case 1:
////                        new WebFragment();
////                        break;
////                }
//
//            }
//
//            @Override
//            public void onEndTabSelected(String title, int index) {
//
//            }
//        });

//        navigationTabStrip.setTitles("Nav", "Tab", "Strip");
//        navigationTabStrip.setTitleSize(15);
//        navigationTabStrip.setStripColor(Color.RED);
//        navigationTabStrip.setStripWeight(6);
//        navigationTabStrip.setStripFactor(2);
//        navigationTabStrip.setStripType(NavigationTabStrip.StripType.LINE);
//        navigationTabStrip.setStripGravity(NavigationTabStrip.StripGravity.BOTTOM);
//        navigationTabStrip.setTypeface("fonts/typeface.ttf");
//        navigationTabStrip.setCornersRadius(3);
//        navigationTabStrip.setAnimationDuration(300);
//        navigationTabStrip.setInactiveColor(Color.GRAY);
//        navigationTabStrip.setActiveColor(Color.WHITE);
//        mBottomNavigationTabStrip.setOnPageChangeListener(...);
//        navigationTabStrip.setOnTabStripSelectedIndexListener(...);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
