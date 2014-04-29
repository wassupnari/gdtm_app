package com.nari.somnium.adapter;

import java.util.ArrayList;

import com.nari.toastmate.R;
import com.nari.somnium.DrawerItem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 
 * @author Nari Kim Shin (wassupnari@gmail.com)
 * 
 */

public class DrawerAdapter extends BaseAdapter {

	private final Context mContext;
	private final ArrayList<DrawerItem> mDrawerItem;

	public DrawerAdapter(Context context, ArrayList<DrawerItem> itemList) {

		this.mContext = context;
		this.mDrawerItem = itemList;
	}

	@Override
	public int getCount() {
		return mDrawerItem.size();
	}

	@Override
	public Object getItem(int position) {
		return mDrawerItem.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.control_drawer_item, null);
		}

		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.item_icon);
		TextView titleView = (TextView) convertView.findViewById(R.id.item_title);

		imgIcon.setImageResource(mDrawerItem.get(position).getIcon());
		titleView.setText(mDrawerItem.get(position).getTitle());

		// displaying count
		// check whether it set visible or not
		/*
		 * if(mDrawerItem.get(position).getCounterVisibility()){
		 * titleView.setText(mDrawerItem.get(position).getCount());
		 * }else{
		 * // hide the counter view
		 * titleView.setVisibility(View.GONE);
		 * }
		 */
		// View rowView = null;
		// if(!mDrawerItem.get(position).isGroupHeader()){
		// rowView = inflater.inflate(R.layout.control_drawer_item, parent,
		// false);
		//
		// ImageView imgView = (ImageView) rowView.findViewById(R.id.item_icon);
		//
		//
		//
		// imgView.setImageResource(mDrawerItem.get(position).getIcon());
		// titleView.setText(mDrawerItem.get(position).getTitle());
		//
		//
		// }
		// else{
		// //rowView = inflater.inflate(R.layout.group_header_item, parent,
		// false);
		// /*TextView titleView = (TextView) rowView.findViewById(R.id.header);
		// titleView.setText(modelsArrayList.get(position).getTitle());*/
		//
		// }

		return convertView;
	}

}