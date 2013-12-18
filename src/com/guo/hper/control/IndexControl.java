package com.guo.hper.control;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.guo.hper.config.WebConfig;
import com.guo.hper.web.HttpClientStart;

import android.os.Handler;

public class IndexControl implements WebCallBack {

	public void getData(Handler handler, int what) {
		HttpClientStart.exc(handler, what, WebConfig.BBS_URL, null, this);
	}

	@Override
	public Object webService(HttpEntity object) throws ParseException,
			IOException {
		String string = EntityUtils.toString(object, "GBK");
		System.out.println( string);
		return null;
	}

}
