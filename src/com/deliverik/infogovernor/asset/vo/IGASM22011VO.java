/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: CI�������̨��ʾVO
 * ��������: CI�������̨��ʾVO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM22011VO extends BaseVO implements Serializable{
	
	/** ���õ��������б� */
	protected List<CIWaitTaskInfo> ciWaitTaskList;
	
	/** �������� */
	protected CITaskInfo ciTask;
	
	/**
	 * ���캯��
	 * @param ciWaitTaskList ���õ��������б�
	 * @param ciTask ��������
	 */
	public IGASM22011VO(List<CIWaitTaskInfo> ciWaitTaskList, CITaskInfo ciTask) {
		this.ciWaitTaskList = ciWaitTaskList;
		this.ciTask = ciTask;
	}

	/**
	 * ���õ��������б�ȡ��
	 * @return ���õ��������б�
	 */
	public List<CIWaitTaskInfo> getCiWaitTaskList() {
		return ciWaitTaskList;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public CITaskInfo getCiTask() {
		return ciTask;
	}
	
	
}


