package lmm.intern.qrioustech.uwu.Fregment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lmm.intern.qrioustech.uwu.Adapter.CustomPortAdapter;
import lmm.intern.qrioustech.uwu.Model.PortfolioModel;
import lmm.intern.qrioustech.uwu.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link WebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    List<PortfolioModel> list;
    RecyclerView recycler_view;
    RecyclerView.LayoutManager LayoutManager;

    public WebFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WebFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WebFragment newInstance(String param1, String param2) {
        WebFragment fragment = new WebFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    View view;

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
        view = inflater.inflate(R.layout.fragment_web, container, false);

        list= new ArrayList<>();

        recycler_view=view.findViewById(R.id.web_recycler);

        recycler_view.setHasFixedSize(true);

        String prj_des= "An application can be self-contained or a group of programs. The program is a set of operations that runs the application for the user. Examples of applications include word processors, database programs, web browsers, development tools, image editors and communication platforms.";

        LayoutManager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(LayoutManager);

//        list.add(new PortfolioModel("This website is used to book a taxi booking, with some entertainment feartures like : Listen Music, Local News, nightClub details, Resturants" +
//                " details, Socail Media Register and Social Media Login, User Location Tracking, Trip Selection, Trip Car Selection, Payment via Cash and " +
//                "Credit Card/Debit Card, User Profile Settings, Trip History, Interactive User Interface, Notifications, Music Player, Google News/Twitter News," +
//                " Events, News Marquee., Driver's Login, Feedback Feature.","My Taxi Apps","http://mytaxiapps.com/",new int[]{R.drawable.w1, R.drawable.w1_1, R.drawable.w1_2}));
//
//        list.add(new PortfolioModel("This website is used to book a taxi booking, with some entertainment features like : Listen Music, Local News, nightClub details, Resturants" +
//                " details, Social Media Register and Social Media Login, User Location Tracking, Trip Selection, Trip Car Selection, Payment via Cash and " +
//                "Credit Card/Debit Card, User Profile Settings, Trip History, Interactive User Interface, Notifications, Music Player, Google News/Twitter News, " +
//                "Events, News Marquee., Driver's Login, Feedback Feature.","The Venue","http://thevenueapps.com/",new int[]{R.drawable.w2, R.drawable.w2_1}));
//
//        list.add(new PortfolioModel("A website that portrays the mobile app in a eye-catching design and puts the visitor into the creators perspective. It also displays all the " +
//                "information regarding the mobile apps, listing all the features and why it is far better than any other app in competition. The website is fully " +
//                "integrated into one page and the data is lazy loaded so the visitor has a fast, responsive and unforgettable experience.","Believe in Millz","http://believeinmillz.com",new int[]{R.drawable.w3}));
//
//        list.add(new PortfolioModel("This website is used for preschool student admission in talent sprouts school. Here we can see fees for academic year for different age. " +
//                "Activities going on in school can be visited from here. Here children's different Art are presented like Dance, Tumbling, Theater, Music, etc. " +
//                "Academics details are displayed here like Science, Reading, Writing, Geography, Sign language, etc.","Talent Sprouts","http://talentsprouts.com/",new int[]{R.drawable.w4, R.drawable.w4_1}));
//
//        list.add(new PortfolioModel("A wonderful WordPress website for a great Thai food restaurant. EnjoyMint Serves freshly made and customizable food bowls of your choice." +
//                " So that website has eye-catching moving food bowls also the brand colors used to made it more unique and presentable.","Enjoymint","https://enjoymintkitchen.com/",new int[]{R.drawable.w5, R.drawable.w5_1, R.drawable.w5_2}));


//        CustomPortAdapter adapter=new CustomPortAdapter(list,getContext(),0);
//        adapter.notifyDataSetChanged();
//        recycler_view.setAdapter(adapter);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
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
