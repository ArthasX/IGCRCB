/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond;

public class IGPRJ0101Form extends BaseForm implements ProjectSearchCond {
	
	private static final long serialVersionUID = 1L;

	/** 项目名称 */
	private String pname;

	/** 项目开始时间 */
	private String popentime;
	
	/** 项目结束时间 */
	private String pclosetime;
	
	/** 项目状态 */
	private String pstatus;

	/** 预算主表ID*/
	protected Integer pbid_q;
	
	/** 项目Id */
	protected Integer pid;
	
	
	public Integer getPbid_q() {
		return pbid_q;
	}

	public void setPbid_q(Integer pbid_q) {
		this.pbid_q = pbid_q;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPopentime() {
		return popentime;
	}

	public void setPopentime(String popentime) {
		this.popentime = popentime;
	}

	public String getPclosetime() {
		return pclosetime;
	}

	public void setPclosetime(String pclosetime) {
		this.pclosetime = pclosetime;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getPcode() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPtype() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 项目Id取得
	 * @return 项目Id
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 项目Id设定
	 * @param pid 项目Id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
