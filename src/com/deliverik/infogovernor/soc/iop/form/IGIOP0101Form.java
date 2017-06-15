package com.deliverik.infogovernor.soc.iop.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 设备影响分析画面FORM
 * 
 */
public class IGIOP0101Form extends BaseForm{

	private static final long serialVersionUID = 1L;
	
	private String subnet;
	
	private String ipFrom;
	
	private String ipTo;
	
	private String creatDate;
	
	private String desc;

	public String getSubnet() {
		return subnet;
	}

	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}

	public String getIpFrom() {
		return ipFrom;
	}

	public void setIpFrom(String ipFrom) {
		this.ipFrom = ipFrom;
	}

	public String getIpTo() {
		return ipTo;
	}

	public void setIpTo(String ipTo) {
		this.ipTo = ipTo;
	}

	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
	

}
