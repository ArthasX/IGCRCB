package com.deliverik.infogovernor.dto;

import java.io.Serializable;
import java.util.ArrayList;

import com.deliverik.framework.base.BaseDTO;

/**
 * portalҳ֪ͨ��DTO
 * 
 */
public class IGCOM05DTO extends BaseDTO implements Serializable{

	private static final long serialVersionUID = -664076405965041531L;

	private String filepath;//ϵͳ·��
	
	private ArrayList<String> contentList;//֪ͨ���ݼ���

	
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


