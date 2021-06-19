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
 * Use the {@link AppsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;
    List<PortfolioModel> list;
    RecyclerView recycler_view;
    RecyclerView.LayoutManager LayoutManager;

    public AppsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AppsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppsFragment newInstance(String param1, String param2) {
        AppsFragment fragment = new AppsFragment();
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
        view = inflater.inflate(R.layout.fragment_apps, container, false);

        list= new ArrayList<>();

        recycler_view=view.findViewById(R.id.apps_recycler);

        recycler_view.setHasFixedSize(true);

        String prj_des= "An application can be self-contained or a group of programs. The program is a set of operations that runs the application for the user. Examples of applications include word processors, database programs, web browsers, development tools, image editors and communication platforms.";

        LayoutManager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(LayoutManager);

        list.add(new PortfolioModel("Dj Durisimo created this App so you can have his mixes with you on the go at all times.! The App is absolutely free of charge and DJ Durisimo" +
                " will be keeping you tuned in on all future events and will be making sure you obtain the hottest mixes he's put together at all times. Dj Durisimo" +
                " comes Pre-loaded with an array of music like Merengue, Salsa, Bachatas, House, Dembow, Reggae, Reggaeton, Hip Hop, R&B, Freestyle and" +
                " more. All new mixes and updates are created on a weekly or bi-monthly basis. Unlike other apps just based on Solely Music, Durisimo decided" +
                " to implement modern tabs that enable you to take pictures directly from the app, leave voice messages, comments and even allows you to " +
                "subscribe and obtain free coupons or tickets to future events.","Durisimo","https://play.google.com/store/apps/details?id=com.app_durisimo1.layout","https://itunes.apple.com/in/app/durisimo/id712453304?mt=8",new int[]{R.drawable.a1, R.drawable.a1_1}));

        list.add(new PortfolioModel("Exit Vacancy is an application for Searching Nearby Hotels.User can get Hotel details can view ratings of hotel.","Exit Vacancy","","",new int[]{R.drawable.a2, R.drawable.a2_1, R.drawable.a2_2}));

        list.add(new PortfolioModel("Wilforth is application for play group school childrens. In this application childrens can play games,quiz and mentor or gaurdian can see child " +
                "activities and its progress.","Wilforth","","",new int[]{R.drawable.a3, R.drawable.a3_1}));

        list.add(new PortfolioModel("Dj Styles created his very own app so everyone can hear the hottest music on the go. It is simple to use. This app contains an amazing amount" +
                " of features as they decided to implement modern tabs that allow you Powerful Sound effects, Easy navigation, Favorite Support and a good" +
                " user interface view. Dj Styles 'S mobile updates are done on a weekly basis.","DJ Styles 2.0","https://play.google.com/store/apps/details?id=com.stegowl.dj_styles","https://itunes.apple.com/us/app/dj-styles-2-0/id1241314182?mt=8",new int[]{R.drawable.a4, R.drawable.a4_1, R.drawable.a4_2}));

        list.add(new PortfolioModel("Rumba Radio Boston created his very own app so you can hear the hottest music on the go!The official app of Rumba Radio Boston will keep" +
                " you on the loop of all new singles, mix tapes, re-mixes, exclusive events and more.Rumba Radio Boston's mobile updates are done on a " +
                "weekly basis.","Rumba Radio Boston","","https://itunes.apple.com/in/app/rumba-radio-boston/id1291380252?mt=8",new int[]{R.drawable.a5, R.drawable.a5_1}));

//        CustomPortAdapter adapter=new CustomPortAdapter(list,getContext(),1);
//        adapter.notifyDataSetChanged();
//        recycler_view.setAdapter(adapter);

        return view;
    }
//
//    // TODO: Rename method, update argument and hook method into UI event
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
