/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * ����汾��Ϣ��ѯ����ʵ��
 * 
 */
public class RoleReportSearchCondImpl implements RoleReportSearchCond {
	
	/** ������ */
	protected Integer rfdid;
	/** ��ɫ��� */
	protected Integer roleid;
	
	/**
	 * ���ȡ��
	 * @return ���
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * ��������趨
	 * @param rfdid ���
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	
}
