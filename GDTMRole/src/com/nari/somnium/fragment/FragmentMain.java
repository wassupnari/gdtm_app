package com.nari.somnium.fragment;

import java.util.ArrayList;

import com.nari.toastmate.R;
import com.nari.somnium.adapter.CLExpandableListAdapter;
import com.nari.somnium.helper.DatabaseHelper;
import com.nari.somnium.pojo.CCDataPojo;
import com.nari.somnium.pojo.CLDataPojo;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * This is the main page of role signup.
 * 
 * @author Nari Kim Shin (wassupnari@gmail.com)
 */
public class FragmentMain extends Fragment implements Runnable {

	private ProgressBar CCProgressBar;
	private ProgressBar CLProgressBar;
	
	private int mCurProgressCC;
	private int mCurProgressCL;
	
	private int ccPosition;
	private int clPosition;
	
	private DatabaseHelper mDB;
	
	TextView ccProgressText;
	TextView clProgressText;
	
	private TextView mCCmsg;
	private TextView mCLmsg;
	
	private Handler mHandler = new Handler();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_main, null);
		
		mDB = new DatabaseHelper(getActivity());
		
		ccProgressText = (TextView) view.findViewById(R.id.cc_progress_text);
		clProgressText = (TextView) view.findViewById(R.id.cl_progress_text);
		
		mCCmsg = (TextView) view.findViewById(R.id.cc_message);
		mCLmsg = (TextView) view.findViewById(R.id.cl_message);
		
		for(CCDataPojo cc : mDB.getAllCCData()) {
			if(cc.getComplete()) {
				mCurProgressCC += 10;
			}
		}
		
		for(CLDataPojo cl : mDB.getAllCLData()) {
			if(cl.getComplete()) {
				mCurProgressCL += 10;
			}
		}
		
		CCProgressBar = (ProgressBar) view.findViewById(R.id.cc_progress);
        CCProgressBar.setProgress(0);
        CCProgressBar.setMax(100);
        
        CLProgressBar = (ProgressBar) view.findViewById(R.id.cl_progress);
        CLProgressBar.setProgress(0);
        CLProgressBar.setMax(100);
		new Thread(this).start();
		
		

		return view;
	}

	@Override
    public void run() {
        ccPosition= 0;
        while (ccPosition<mCurProgressCC) {
            
                
            ccPosition+= 1;
            mHandler.post(new Runnable() {

				@Override
				public void run() {
					CCProgressBar.setProgress(ccPosition);
	                ccProgressText.setText(ccPosition + " %");
				}
            	
            });
            try {
                Thread.sleep(30);
                
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }            
        }
        
        //showCCMessage();
        
        clPosition = 0;
        while (clPosition<mCurProgressCL) {
            
            
            clPosition += 1;
            mHandler.post(new Runnable() {

				@Override
				public void run() {
					CLProgressBar.setProgress(clPosition);
	                clProgressText.setText(clPosition + " %");
				}
            	
            });
            try {
                Thread.sleep(30);
                
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }            
        }
        
        //showCLMessage();
    }
	
//	public void showCCMessage() {
//		mCCmsg.setVisibility(View.VISIBLE);
//		
//		if(mCurProgressCC == 10) {
//			mCCmsg.setText("Great start!");
//		} else if(mCurProgressCC == 50) {
//			mCCmsg.setText("You're half way done!");
//		} else if(mCurProgressCC == 90) {
//			mCCmsg.setText("Almost finished!");
//		} else if (mCurProgressCC == 100) {
//			mCCmsg.setText("Congratulations! You have finished CC manual!");
//		} else {
//			mCCmsg.setText("Let's keep working hard!");
//		}
//	}
//	
//	public void showCLMessage() {
//		
//	}
}