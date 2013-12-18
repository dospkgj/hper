package com.guo.hper.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.os.Handler;

import com.guo.hper.config.WebConfig;
import com.guo.hper.entity.ReslutEntity;
import com.guo.hper.web.HttpClientStart;

public class LoginControl  implements WebCallBack{
	public void login(Handler handler,int what,String user, String passwd) {
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("username", user));
		nameValuePairs.add(new BasicNameValuePair("password", passwd));
		HttpClientStart.exc(handler, what, WebConfig.LONGIN_URL, nameValuePairs, this);
	}
	@Override
	public Object webService(HttpEntity object) throws ParseException, IOException {
		String string = EntityUtils.toString(object, "GBK");
		boolean contains = string.contains("欢迎您回来");
		ReslutEntity reslutEntity = new ReslutEntity();
		reslutEntity.isOK = contains;
		return reslutEntity;
	}
}
