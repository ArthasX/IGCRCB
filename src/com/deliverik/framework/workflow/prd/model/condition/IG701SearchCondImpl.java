/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * ����: ���̲鿴��ɫ��Ȩ�����������ʵ��
  * ��������: ���̲鿴��ɫ��Ȩ�����������ʵ��
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
public class IG701SearchCondImpl implements
		IG701SearchCond {
	
	/** ���̶���ID */
	protected String pdid;

	/** ��ɫID */
	protected Integer roleid;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	

}