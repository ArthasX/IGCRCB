/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ��ƿ���̨����鿴VO
 * ��������: ��ƿ���̨����鿴VO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM21031VO extends BaseVO implements Serializable{
	
	/** ��ƿ���̨�����б� */
	protected AuditWaitTaskInfo auditWaitTask;
	
	/**
	 * ���캯��
	 * @param auditWaitTask ��ƿ���̨�����б�
	 */
	public IGASM21031VO(AuditWaitTaskInfo auditWaitTask) {
		this.auditWaitTask = auditWaitTask;
	}

	/**
	 * ��ƿ���̨����ȡ��
	 * @return ��ƿ���̨����
	 */
	public AuditWaitTaskInfo getAuditWaitTask() {
		return auditWaitTask;
	}
}


