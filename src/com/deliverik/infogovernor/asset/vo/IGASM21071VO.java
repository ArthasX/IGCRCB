/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.AuditTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ���������Ϣ��������֣�
 * ��������: ���������Ϣ��������֣�
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM21071VO extends BaseVO implements Serializable {
	
	/** ������������� */
	protected List<AuditTaskInfo> auditTaskInfoList;

	
	/**
	 * ���캯��
	 * @param auditTaskInfoList�������������
	 */
	public IGASM21071VO(List<AuditTaskInfo> auditTaskInfoList) {
		super();
		this.auditTaskInfoList = auditTaskInfoList;
	}

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public List<AuditTaskInfo> getAuditTaskInfoList() {
		return auditTaskInfoList;
	}

	/**
	 * ��������������趨
	 * @param auditTaskInfoList�������������
	 */
	public void setAuditTaskInfoList(List<AuditTaskInfo> auditTaskInfoList) {
		this.auditTaskInfoList = auditTaskInfoList;
	}
	
	
	
	
	
}
