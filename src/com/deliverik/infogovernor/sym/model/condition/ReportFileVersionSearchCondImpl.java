/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
 * ����汾��Ϣ��ѯ����ʵ��
 * 
 */
public class ReportFileVersionSearchCondImpl implements ReportFileVersionSearchCond {
	
	/** �������� */
	protected Integer rfdid;
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getRfdid() {
		return rfdid;
	}
	
	/**
	 * �����趨
	 * @param rfdid ����
	 */
	public void setRfdid(Integer rfdid) {
		this.rfdid = rfdid;
	}
}
