/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.CIWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: CI�������̨����鿴VO
 * ��������: CI�������̨����鿴VO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM22031VO extends BaseVO implements Serializable{
	
	/** CI�������̨�����б� */
	protected CIWaitTaskInfo ciWaitTask;
	
	/**
	 * ���캯��
	 * @param ciWaitTask CI�������̨�����б�
	 */
	public IGASM22031VO(CIWaitTaskInfo ciWaitTask) {
		this.ciWaitTask = ciWaitTask;
	}

	/**
	 * CI�������̨����ȡ��
	 * @return CI�������̨����
	 */
	public CIWaitTaskInfo getCiWaitTask() {
		return ciWaitTask;
	}
}


