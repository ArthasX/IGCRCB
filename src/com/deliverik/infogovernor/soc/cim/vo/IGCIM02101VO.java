/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0115Info;

/**
 * ����: ����̨����鿴VO
 * ��������: ����̨����鿴VO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGCIM02101VO extends BaseVO implements Serializable{
	
	/** ����̨�����б� */
	protected SOC0115Info eiWaitTask;
	
	/**
	 * ���캯��
	 * @param eiWaitTask ����̨�����б�
	 */
	public IGCIM02101VO(SOC0115Info eiWaitTask) {
		this.eiWaitTask = eiWaitTask;
	}

	/**
	 * ����̨����ȡ��
	 * @return ����̨����
	 */
	public SOC0115Info getEiWaitTask() {
		return eiWaitTask;
	}
}


