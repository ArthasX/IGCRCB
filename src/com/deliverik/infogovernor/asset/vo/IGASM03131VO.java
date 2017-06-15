package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;

/**
 * ���Ͻ��豸��Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM03131VO extends BaseVO implements Serializable{
	
	/** �豸��������id */
	protected String orgid;
	
	/** �豸��������name */
	protected String orgname;
	
	/** �豸�·�ʱ�� */
	protected String issuetime;
	
	/** �豸������ */
	protected String recivename;

	/**
	 * ���캯��
	 */
	public IGASM03131VO() {
	}

	

	public String getRecivename() {
		return recivename;
	}



	public void setRecivename(String recivename) {
		this.recivename = recivename;
	}



	public String getOrgid() {
		return orgid;
	}



	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}



	public String getOrgname() {
		return orgname;
	}



	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}



	public String getIssuetime() {
		return issuetime;
	}



	public void setIssuetime(String issuetime) {
		this.issuetime = issuetime;
	}


	
	
}


