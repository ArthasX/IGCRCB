/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiWaitTaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: ����̨��ʾVO
 * ��������: ����̨��ʾVO
 * ������¼: 2011/04/29
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM20011VO extends BaseVO implements Serializable{
	
	/** ���õ��������б� */
	protected List<EiWaitTaskInfo> eiWaitTaskList;
	
	/**
	 * ���캯��
	 * @param eiWaitTaskList ���õ��������б�
	 */
	public IGASM20011VO(List<EiWaitTaskInfo> eiWaitTaskList) {
		this.eiWaitTaskList = eiWaitTaskList;
	}

	/**
	 * ���õ��������б�ȡ��
	 * @return ���õ��������б�
	 */
	public List<EiWaitTaskInfo> getEiWaitTaskList() {
		return eiWaitTaskList;
	}
}


