package com.example.alexandre.list.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.alexandre.list.R;
import com.example.alexandre.list.adapters.TweetAdapter;
import com.example.alexandre.list.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnTweetListClickListener} interface
 * to handle interaction events.
 * Use the {@link TweetListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TweetListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private ListView maListView;

    private String[] prenoms = new String[]{
            "Alexandre", "Yoann", "Simon", "Bob", "Jean", "Yann", "Louis", "Christophe", "Gael", "Bamboula", "Gareth"
    };

    private OnTweetListClickListener mListener;

    public TweetListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TweetListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TweetListFragment newInstance(String param1, String param2) {
        TweetListFragment fragment = new TweetListFragment();
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
        View view = inflater.inflate(R.layout.fragment_tweet_list, container, false);

        bindViews(view);

        afficherListeTweets();

        maListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                onTweetListClick();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onTweetListClick() {
        if (mListener != null) {
            mListener.onTweetListClick();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnTweetListClickListener) {
            mListener = (OnTweetListClickListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTweetListClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void bindViews(View view) {
        maListView = (ListView) view.findViewById(R.id.list);
    }

    private void afficherListeTweets() {
        TweetAdapter adapter = new TweetAdapter(getContext(), genererTweets());
        maListView.setAdapter(adapter);
    }

    private List<Tweet> genererTweets() {
        List<Tweet> tweets = new ArrayList<Tweet>();
        tweets.add(new Tweet(Color.BLACK, "Bob", "Salut  !"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Tweet(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Tweet(Color.GRAY, "Willy", "On y est presque"));
        tweets.add(new Tweet(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Tweet(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Tweet(Color.GRAY, "Willy", "On y est presque"));
        tweets.add(new Tweet(Color.BLACK, "Florent", "Mon premier tweet !"));
        tweets.add(new Tweet(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        tweets.add(new Tweet(Color.GREEN, "Logan", "Que c'est beau..."));
        tweets.add(new Tweet(Color.RED, "Mathieu", "Il est quelle heure ??"));
        tweets.add(new Tweet(Color.GRAY, "Willy", "On y est presque"));
        return tweets;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnTweetListClickListener {
        void onTweetListClick();
    }

}
