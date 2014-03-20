package com.guo.hper.adapter;

import java.util.List;

import com.guo.hper.entity.Block;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;

public class IndexAdatper extends BaseExpandableListAdapter{
	
	private Context context;
	private List<Block> list;

	public IndexAdatper(Context context, List<Block> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public Object getChild(int arg0, int arg1) {
		return list.get(arg0).childBlocks.get(arg1);
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		return arg1;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		
		
		
		
		return null;
	}

	@Override
	public int getChildrenCount(int arg0) {
		return list.get(arg0).childBlocks.size();
	}

	@Override
	public Object getGroup(int arg0) {
		return list.get(arg0);
	}

	@Override
	public int getGroupCount() {
		return list.size();
	}

	@Override
	public long getGroupId(int arg0) {
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		return null;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		return false;
	}

}
