package com.guo.hper.activity;

import com.guo.hper.R;
import com.guo.hper.control.IndexControl;

import android.os.Bundle;
import android.os.Handler;

public class IndexActivity extends BaseActivity {

	private final int REDATA_HAN = 0x01;
	private Handler handler = new Handler() {

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		doString();
	}

	private void doString() {
		initView();
		getData();
	}

	private void initView() {
	}

	private void getData() {
		IndexControl control = new IndexControl();
		control.getData(handler, REDATA_HAN);
	}
}
