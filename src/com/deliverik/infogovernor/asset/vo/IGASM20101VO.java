/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ����̨����鿴VO
 * ��������: ����̨����鿴VO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20101VO extends BaseVO implements Serializable{
	
	/** ����̨�����б� */
	protected EiWaitTaskInfo eiWaitTask;
	
	/**
	 * ���캯��
	 * @param eiWaitTask ����̨�����б�
	 */
	public IGASM20101VO(EiWaitTaskInfo eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}

	/**
	 * ����̨����ȡ��
	 * @return ����̨����
	 */
	public EiWaitTaskInfo getEiWaitTask() {
		return eiWaitTask;
	}
}


