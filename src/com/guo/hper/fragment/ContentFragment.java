package com.guo.hper.fragment;

import java.util.List;

import com.guo.hper.R;
import com.guo.hper.adapter.ContentAdapter;
import com.guo.hper.config.BlockEnum;
import com.guo.hper.control.ContentFragmentControl;
import com.guo.hper.control.IndexControl;
import com.guo.hper.entity.ThreadEntity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 
 * @author <a href="mailto:kris@krislq.com">Kris.lee</a>
 * @since Mar 12, 2013
 * @version 1.0.0
 */
@SuppressLint("ValidFragment")
public class ContentFragment extends Fragment {
	BlockEnum blockEnum = null;
	private ListView listView;

	private Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 0:
				List<ThreadEntity> jsoupThread = (List<ThreadEntity>) msg.obj;
				ContentAdapter adapter  =new ContentAdapter(getActivity(), jsoupThread);
				listView.setAdapter(adapter);
				break;

			default:
				break;
			}

		}
	};

	public ContentFragment() {
	}

	public ContentFragment(BlockEnum blockEnum) {
		Log.e("Krislq", blockEnum.name());
		this.blockEnum = blockEnum;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
		Log.e("Krislq", "onCreate:" + blockEnum.name());
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("Krislq", "onCreateView:" + blockEnum.name());
		View view = inflater.inflate(R.layout.fragment_text, null);
		listView = (ListView) view.findViewById(R.id.content_list);
		new ContentFragmentControl(handler, 0, blockEnum);
		return view;
	}

	@Override
	public void onDestroy() {
		Log.e("Krislq", "onDestroy:" + blockEnum.name());
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		Log.e("Krislq", "onDetach:" + blockEnum.name());
		super.onDetach();
	}

	@Override
	public void onPause() {
		Log.e("Krislq", "onPause:" + blockEnum.name());
		super.onPause();
	}

	@Override
	public void onResume() {
		Log.e("Krislq", "onResume:" + blockEnum.name());
		super.onResume();
	}

	@Override
	public void onStart() {
		Log.e("Krislq", "onStart:" + blockEnum.name());
		super.onStart();
	}

	@Override
	public void onStop() {
		Log.e("Krislq", "onStop:" + blockEnum.name());
		super.onStop();
	}

}
