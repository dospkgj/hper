package com.guo.hper.activity;

import com.guo.hper.R;
import com.guo.hper.control.IndexControl;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;

public class IndexActivity extends BaseActionBarActivity {

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
		SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        menu.setShadowWidthRes(200);
//        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
//        menu.setMenu(R.layout.menu);
        ActionBar supportActionBar = getSupportActionBar();
        System.out.println(supportActionBar);
        menu.showMenu();
	}

	private void getData() {
		IndexControl control = new IndexControl();
		control.getData(handler, REDATA_HAN);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.index_activity, menu);
	    return super.onCreateOptionsMenu(menu);
	}
}
