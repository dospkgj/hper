package com.guo.hper.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 版块实体类
 * @author gj
 *
 */
public class Block implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4210513456958250397L;
	
	/**
	 * 版块名称
	 */
	public String blockName;
	
	public List<ChildBlock> childBlocks;

	

}
