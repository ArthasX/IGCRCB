package com.deliverik.infogovernor.dbm.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

@SuppressWarnings("serial")
public class IGDBM1203VO extends BaseVO implements Serializable{
	String xml;

	public String getXml() {
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}
}
