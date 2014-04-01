package com.guo.hper.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

public class BaseActionActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题栏
	}
	
}
