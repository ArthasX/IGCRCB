/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.prj.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.prj.model.condition.ProjectSearchCond;

public class IGPRJ0101Form extends BaseForm implements ProjectSearchCond {
	
	private static final long serialVersionUID = 1L;

	/** ��Ŀ���� */
	private String pname;

	/** ��Ŀ��ʼʱ�� */
	private String popentime;
	
	/** ��Ŀ����ʱ�� */
	private String pclosetime;
	
	/** ��Ŀ״̬ */
	private String pstatus;

	/** Ԥ������ID*/
	protected Integer pbid_q;
	
	/** ��ĿId */
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
	 * ��ĿIdȡ��
	 * @return ��ĿId
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��ĿId�趨
	 * @param pid ��ĿId
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
}
