/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: CI���������Ϣ��������֣�
 * ��������: CI���������Ϣ��������֣�
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM22071VO extends BaseVO implements Serializable {
	
	/** CI������������� */
	protected List<CITaskInfo> ciTaskInfoList;

	
	/**
	 * ���캯��
	 * @param ciTaskInfoListCI�������������
	 */
	public IGASM22071VO(List<CITaskInfo> ciTaskInfoList) {
		super();
		this.ciTaskInfoList = ciTaskInfoList;
	}

	/**
	 * CI�������������ȡ��
	 * @return CI�������������
	 */
	public List<CITaskInfo> getCiTaskInfoList() {
		return ciTaskInfoList;
	}

	/**
	 * CI��������������趨
	 * @param ciTaskInfoListCI�������������
	 */
	public void setCITaskInfoList(List<CITaskInfo> ciTaskInfoList) {
		this.ciTaskInfoList = ciTaskInfoList;
	}
	
	
	
	
	
}
