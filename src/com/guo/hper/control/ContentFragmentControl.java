package com.guo.hper.control;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;

import com.guo.hper.config.BlockEnum;
import com.guo.hper.config.WebConfig;
import com.guo.hper.entity.ThreadEntity;
import com.guo.hper.jsoup.JsoupTools;
import com.guo.hper.web.HttpClientStart;

import android.os.Handler;

public class ContentFragmentControl implements WebCallBack{

	
	public ContentFragmentControl(Handler handler,int what,BlockEnum blockEnum){
		switch (blockEnum) {
		case DSECOVERY:
			HttpClientStart.exc(handler, what, WebConfig.DISCOVERY_URL, null, this);
			break;
		case BS:
			HttpClientStart.exc(handler, what, WebConfig.BS_URL, null, this);
			break;
		default:
			break;
		}
	}
	
	
	
	@Override
	public Object webService(HttpEntity object) throws ParseException,
			IOException {
		String dom = EntityUtils.toString(object, "GBK");
		List<ThreadEntity> jsoupThread = JsoupTools.jsoupThread(dom);
		return jsoupThread;
	}

}
