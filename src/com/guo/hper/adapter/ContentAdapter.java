package com.guo.hper.adapter;

import java.util.List;

import com.guo.hper.R;
import com.guo.hper.activity.PostActivity;
import com.guo.hper.entity.ThreadEntity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContentAdapter extends BaseAdapter {
	private Context context;
	private List<ThreadEntity> list;

	public ContentAdapter(Context context, List<ThreadEntity> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int arg0) {
		return list.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		View inflate = LayoutInflater.from(context).inflate(
				R.layout.adapter_thread, null);
		final int a = arg0;
		TextView name = (TextView) inflate
				.findViewById(R.id.adapter_thread_name);
		name.setText(list.get(arg0).ThreadName);
		name.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.putExtra("pid", list.get(a).ThreadURL);
				intent.setClass(context, PostActivity.class);
				context.startActivity(intent);
			}
		});
		
		
		return inflate;
	}
}
