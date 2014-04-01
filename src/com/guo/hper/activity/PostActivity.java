package com.guo.hper.activity;

import java.util.List;

import com.guo.hper.R;
import com.guo.hper.adapter.PostAdatper;
import com.guo.hper.control.PostControl;
import com.guo.hper.entity.PostEntity;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;

public class PostActivity extends BaseActivity{
	private ListView listView;
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 0:
				List<PostEntity> jsoupPost = (List<PostEntity>) msg.obj;
				PostAdatper adatper = new PostAdatper(PostActivity.this, jsoupPost);
				listView.setAdapter(adatper);
				break;

			default:
				break;
			}
		}
		
	};
	private String pid;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_post);
		doString();
	}
	private void doString(){
		initIntent();
		initView();
		getData();
	}
	
	private void initIntent(){
		pid = getIntent().getStringExtra("pid");
	}
	private void initView(){
		 listView = (ListView) findViewById(R.id.activity_post_list);
		
	}
	private void getData(){
		new PostControl(handler, 0, pid);
	}
}
