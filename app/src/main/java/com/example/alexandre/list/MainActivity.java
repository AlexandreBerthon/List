package com.example.alexandre.list;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.alexandre.list.fragments.MapFragment;
import com.example.alexandre.list.fragments.TweetListFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TweetListFragment.OnTweetListClickListener, MapFragment.OnMapClickListener {

    private static final String TAG = "MainActivity";

    private Button mBtMap;
    private Button mBtTweetList;
    private Fragment mMapFragment;
    private Fragment mTweetFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        mBtMap.setOnClickListener(this);
        mBtTweetList.setOnClickListener(this);

        mMapFragment = MapFragment.newInstance("arg1", "arg2");
        mTweetFragment = TweetListFragment.newInstance("arg1", "arg2");
        loadFragment(mTweetFragment);
    }


    private void bindViews() {
        mBtMap = (Button) findViewById(R.id.btMap);
        mBtTweetList = (Button) findViewById(R.id.btTweet);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btMap:
                loadFragment(mMapFragment);
                break;

            case R.id.btTweet:
                loadFragment(mTweetFragment);
                break;
        }
    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }

    @Override
    public void onTweetListClick() {
        Log.e(TAG, "onTweetListClick: click !");
    }

    @Override
    public void onMapClick() {
        Log.e(TAG, "onMapClick: click !");
    }
}
