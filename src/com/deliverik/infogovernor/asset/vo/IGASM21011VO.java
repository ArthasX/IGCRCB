/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.asset.model.AuditWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ��ƿ���̨��ʾVO
 * ��������: ��ƿ���̨��ʾVO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM21011VO extends BaseVO implements Serializable{
	
	/** ���õ��������б� */
	protected List<AuditWaitTaskInfo> auditWaitTaskList;
	
	/** ������� */
	protected AuditTaskInfo auditTask;
	
	/**
	 * ���캯��
	 * @param auditWaitTaskList ���õ��������б�
	 * @param auditTask �������
	 */
	public IGASM21011VO(List<AuditWaitTaskInfo> auditWaitTaskList,
			AuditTaskInfo auditTask) {
		this.auditWaitTaskList = auditWaitTaskList;
		this.auditTask = auditTask;
	}

	/**
	 * ���õ��������б�ȡ��
	 * @return ���õ��������б�
	 */
	public List<AuditWaitTaskInfo> getAuditWaitTaskList() {
		return auditWaitTaskList;
	}

	/**
	 * �������
	 * @return �������
	 */
	public AuditTaskInfo getAuditTask() {
		return auditTask;
	}
	
}


