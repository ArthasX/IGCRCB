/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ���������Ϣ��Ӻ���ϢVO
 * ��������: ���������Ϣ��Ӻ���ϢVO
 * ������¼: 2011/05/019
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM21051VO extends BaseVO implements Serializable {
	
	/**���������Ӻ���Ϣ*/
	protected AuditTaskInfo auditTaskInfo;
	
	
	
	/**
	 * ���캯��
	 * @param auditTaskInfo���������Ӻ���Ϣ
	 */
	public IGASM21051VO(AuditTaskInfo auditTaskInfo) {
		super();
		this.auditTaskInfo = auditTaskInfo;
	}

	/**
	 * ���������Ӻ���Ϣȡ��
	 * @return ���������Ӻ���Ϣ
	 */
	public AuditTaskInfo getAuditTaskInfo() {
		return auditTaskInfo;
	}

	/**
	 * ���������Ӻ���Ϣ�趨
	 * @param auditTaskInfo���������Ӻ���Ϣ
	 */
	public void setAuditTaskInfo(AuditTaskInfo auditTaskInfo) {
		this.auditTaskInfo = auditTaskInfo;
	}
	
	

}
