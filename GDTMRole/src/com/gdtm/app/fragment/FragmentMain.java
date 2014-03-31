package com.gdtm.app.fragment;

import java.util.ArrayList;

import com.gdtm.app.R;
import com.gdtm.app.adapter.CLExpandableListAdapter;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ProgressBar;

/**
 * This is the main page of role signup.
 * 
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */
public class FragmentMain extends Fragment implements Runnable {

	private static final int NUM_OF_ROLE = 18;

	private CLExpandableListAdapter mAdapter;

	private ArrayList<String> mGroupItem = new ArrayList<String>();
	private ArrayList<Object> mChildItem = new ArrayList<Object>();
	
	private ProgressBar CCProgressBar;
	private ProgressBar CLProgressBar;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_main, null);
		
		CCProgressBar = (ProgressBar) view.findViewById(R.id.cc_progress);
		CCProgressBar.setVisibility(ProgressBar.VISIBLE);
        CCProgressBar.setProgress(0);
        CCProgressBar.setMax(50);
		new Thread(this).start();

		return view;
	}

	@Override
    public void run() {
        int currentPosition= 0;
        while (currentPosition<100) {
            try {
                Thread.sleep(100);
                currentPosition+= 1;
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }            
            CCProgressBar.setProgress(currentPosition);
        }
    }
}
