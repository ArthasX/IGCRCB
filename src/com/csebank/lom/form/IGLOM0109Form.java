package com.csebank.lom.form;


import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0109Form extends BaseForm implements RecptionGuestInfoCond {
 
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 来宾单位
	 */
	protected String rgunit;
	
	/**
	 * 来宾姓名
	 */
	protected String rgname;
	
	/**
	 * 接待工作名称
	 */
	protected String rname;
	
	/**
	 * 主要申请部门 
	 */
	protected String rapporgid;
	
	/** 接待开始日期 */
	protected String rstime;
	
	/** 接待结束日期*/
	protected String retime;

	public String getRapporgid() {
		return rapporgid;
	}

	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	public String getRstime() {
		return rstime;
	}

	public void setRstime(String rstime) {
		this.rstime = rstime;
	}

	public String getRetime() {
		return retime;
	}

	public void setRetime(String retime) {
		this.retime = retime;
	}

	public String getRpporg() {
		return rpporg;
	}

	public void setRpporg(String rpporg) {
		this.rpporg = rpporg;
	}

	public String getRdescription() {
		return rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	/** 其他参与部门 */
	protected String rpporg;
	
	/** 接待内容描述 */
	protected String rdescription;
	
	
	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRgname() {
		
		return rgname;
	}
	
    public void setRgname(String rgname){
    	this.rgname=rgname;
    }
	
	public String getRgunit() {
		
		return rgunit;
	}
	
	public void setRgunit(String rgunit){
		this.rgunit=rgunit;
	}

}
