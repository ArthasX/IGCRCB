/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseVO;

/**
 * ����: CI���������Ϣ��Ӻ���ϢVO
 * ��������: CI���������Ϣ��Ӻ���ϢVO
 * ������¼: 2011/05/019
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IGASM22051VO extends BaseVO implements Serializable {
	
	/**CI���������Ӻ���Ϣ*/
	protected CITaskInfo ciTaskInfo;
	
	
	
	/**
	 * ���캯��
	 * @param ciTaskInfoCI���������Ӻ���Ϣ
	 */
	public IGASM22051VO(CITaskInfo ciTaskInfo) {
		super();
		this.ciTaskInfo = ciTaskInfo;
	}

	/**
	 * CI���������Ӻ���Ϣȡ��
	 * @return CI���������Ӻ���Ϣ
	 */
	public CITaskInfo getCiTaskInfo() {
		return ciTaskInfo;
	}

	/**
	 * CI���������Ӻ���Ϣ�趨
	 * @param ciTaskInfoCI���������Ӻ���Ϣ
	 */
	public void setCITaskInfo(CITaskInfo ciTaskInfo) {
		this.ciTaskInfo = ciTaskInfo;
	}
	
	

}
