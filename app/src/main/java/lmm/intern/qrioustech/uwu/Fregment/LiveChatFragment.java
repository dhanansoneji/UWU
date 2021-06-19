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

import lmm.intern.qrioustech.uwu.Adapter.ChatAdapter;
import lmm.intern.qrioustech.uwu.Adapter.CustomPortAdapter;
import lmm.intern.qrioustech.uwu.Model.ChatModel;
import lmm.intern.qrioustech.uwu.Model.PortfolioModel;
import lmm.intern.qrioustech.uwu.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link LiveChatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LiveChatFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public View view;
    List<ChatModel> list;
    RecyclerView recycler_view;
    RecyclerView.LayoutManager LayoutManager;

    public LiveChatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LiveChatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LiveChatFragment newInstance(String param1, String param2) {
        LiveChatFragment fragment = new LiveChatFragment();
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
        view = inflater.inflate(R.layout.fragment_live_chat, container, false);

        list= new ArrayList<>();

        recycler_view=view.findViewById(R.id.chat_recycler);

        recycler_view.setHasFixedSize(true);

        LayoutManager = new LinearLayoutManager(getContext());
        recycler_view.setLayoutManager(LayoutManager);

        list.add(new ChatModel("You","Hey",1));
        list.add(new ChatModel("Michale","Hello",0));
        list.add(new ChatModel("Michale","How Can I Help You?",0));
        list.add(new ChatModel("You","I Want to Join Your Office.",1));
        list.add(new ChatModel("Michale","Come Tomorrow at 11:00 PM For Interview.",0));
        list.add(new ChatModel("You","Okay! Thank You",1));
        list.add(new ChatModel("You","An application can be self-contained or a group of programs. The program is a set of operations that runs the application for the user.",1));


        ChatAdapter adapter=new ChatAdapter(list,getContext());
        recycler_view.setAdapter(adapter);

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
