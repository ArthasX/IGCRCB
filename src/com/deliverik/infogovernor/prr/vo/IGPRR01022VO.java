/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * @Description: ���̴���VO
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01022VO extends BaseVO {
	
	/** �������� */
	protected String type;
	
	/** ������Ϣ */
	protected IG500Info info;

	/**
	 * ��������ȡ��
	 * @return type ��������
	 */
	public String getType() {
		return type;
	}

	/**
	 * ���������趨
	 * @param type ��������
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ������Ϣȡ��
	 * @return info ������Ϣ
	 */
	public IG500Info getInfo() {
		return info;
	}

	/**
	 * ������Ϣ�趨
	 * @param info ������Ϣ
	 */
	public void setInfo(IG500Info info) {
		this.info = info;
	}
}
