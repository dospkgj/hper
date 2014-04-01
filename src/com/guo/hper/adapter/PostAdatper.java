package com.guo.hper.adapter;

import java.util.List;

import com.guo.hper.R;
import com.guo.hper.entity.PostEntity;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PostAdatper extends BaseAdapter{ 
	
	private Context context;
	private List<PostEntity> list;
	
	
	public PostAdatper(Context context, List<PostEntity> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View inflate = LayoutInflater.from(context).inflate(R.layout.adapter_post, null);
		TextView anthour = (TextView) inflate.findViewById(R.id.adapter_post_anthour);
		TextView floor = (TextView) inflate.findViewById(R.id.adapter_post_floor);
		TextView neiRong = (TextView) inflate.findViewById(R.id.adapter_post_neirong);
		anthour.setText(list.get(position).PostAnthour);
		floor.setText("#"+list.get(position).PostFloor);
		neiRong.setText(Html.fromHtml(list.get(position).PostContent));
		return inflate;
	}

}
