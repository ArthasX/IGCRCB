/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.condition;

/**
 * ����:����� 
 * ��������������� 
 * �����ˣ�����͢
 * ������¼�� 2013-08-30
 * �޸ļ�¼��
 */
public class FillInQualityAssessSearchCondImpl implements FillInQualityAssessSearchCond{

	/** ���˿�ʼ���� */
	protected String assessstartdate;
	
	/** ���˽������� */
	protected String assessoverdate;
	
	/** �û�ID */
	protected String userid;
	
	/** ����ID */
	protected String orgid;

	public String getAssessstartdate() {
		return assessstartdate;
	}
	public void setAssessstartdate(String assessstartdate) {
		this.assessstartdate = assessstartdate;
	}

	public String getAssessoverdate() {
		return assessoverdate;
	}

	public void setAssessoverdate(String assessoverdate) {
		this.assessoverdate = assessoverdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrgid() {
		return orgid;
	}
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}
	
	
	
	
	
}
