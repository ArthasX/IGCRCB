package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.deliverik.framework.base.BaseDTO;

/**
 * portal页通知用DTO
 * 
 */
public class IGCOM05DTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = -664076405965041531L;

	private String filepath;//系统路径
	
	private ArrayList<String> contentList;//通知内容集合

	
	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public ArrayList<String> getContentList() {
		return contentList;
	}

	public void setContentList(ArrayList<String> contentList) {
		this.contentList = contentList;
	}
	
	
	
}


