/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.parameter;

/**
 * ������ֹ��Ϣ
 */
public class SuspendProcess implements SuspendProcessInfo {
	
	/** ��־������Ϣ */
	private WorkFlowLogInfo logInfo;
	
	/**
	 * ���캯��
	 * 
	 * @param logInfo ��־������Ϣ
	 */
	public SuspendProcess(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * ��־������Ϣȡ��
	 * 
	 * @return ��־������Ϣ
	 */
	public WorkFlowLogInfo getLogInfo() {
		return logInfo;
	}

	/**
	 * ��־������Ϣ�趨
	 * 
	 * @param logInfo ��־������Ϣ
	 */
	public void setLogInfo(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}
}
