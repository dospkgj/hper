package com.guo.hper.entity;

import java.io.Serializable;

/**
 * @author gj 子版块实体类
 */
public class ChildBlock implements Serializable{
	/**
	 * 子版块名称
	 */
	public String childBlockName;

	/**
	 * 版块简介
	 */
	public String childBlockIntro;
	
	
	/**
	 * 今日条数
	 */
	public  String todayNum;
	
	/**
	 * 子版块url
	 */
	public String url;
}
