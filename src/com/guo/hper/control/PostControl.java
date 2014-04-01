package com.guo.hper.control;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.guo.hper.config.WebConfig;
import com.guo.hper.entity.PostEntity;
import com.guo.hper.jsoup.JsoupTools;
import com.guo.hper.web.HttpClientStart;

import android.os.Handler;

public class PostControl implements WebCallBack{

	public PostControl(Handler handler,int what,String pid){
		HttpClientStart.exc(handler, what, WebConfig.BBS_URL+pid, null, this);
	}
	@Override
	public Object webService(HttpEntity object) throws ParseException,
			IOException {
		String string = EntityUtils.toString(object,"GBK");
		List<PostEntity> jsoupPost = JsoupTools.jsoupPost(string);
		return jsoupPost;
	}
}
