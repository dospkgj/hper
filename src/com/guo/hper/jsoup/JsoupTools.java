package com.guo.hper.jsoup;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.guo.hper.entity.PostEntity;
import com.guo.hper.entity.ThreadEntity;

public class JsoupTools {

	public static List<ThreadEntity> jsoupThread(String dom) {
		Document parse = Jsoup.parse(dom);
		Elements tbody = parse.select("[id^=normalthread_]");
		List<ThreadEntity> threadList = new ArrayList<ThreadEntity>();
		for (Element element : tbody) {
			Element span = element.select("[id^=thread_]").first();
			Element as = span.getElementsByTag("a").first();
			String attr = as.attr("href");
			String text = as.text();
			ThreadEntity threadEntity = new ThreadEntity();
			threadEntity.ThreadName = text;
			threadEntity.ThreadURL = attr;
			threadList.add(threadEntity);
		}
		return  threadList;
	}
	
	public static List<PostEntity> jsoupPost(String dom){
		Document parse = Jsoup.parse(dom);
		Elements select = parse.select("table[id^=pid]");
		List<PostEntity> entities = new ArrayList<PostEntity>();
		for(Element element:select){
			PostEntity entity = new PostEntity();
			Element  elementsByClass = element.getElementsByClass("postinfo").first();
			String anthour = elementsByClass.text();
			entity.PostAnthour = anthour;
			Elements elementsByClass2 = element.getElementsByClass("t_msgfont");
			entity.PostContent = elementsByClass2.html();
			entities.add(entity);
		}
		return entities;
	}
}
