/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * <p>����:���̹�ͨ������ѯ����ʵ��</p>
 * <p>��������:</p>
 * <p>������¼��</p>
 */
public class IG202SearchCondImpl implements IG202SearchCond{
	
	protected String pdid;

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/** ���̱�����ʾ���� */
	protected String pidlabel;
	

	protected Integer pidid_notlike;

	public String getPidlabel() {
		return pidlabel;
	}

	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	public Integer getPidid_notlike() {
		return pidid_notlike;
	}

	public void setPidid_notlike(Integer pidid_notlike) {
		this.pidid_notlike = pidid_notlike;
	}
}
