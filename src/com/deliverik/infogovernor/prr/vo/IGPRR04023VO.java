/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04023VO extends BaseVO{

	/** ������Ϣ */
	protected IG380Info pdinfo;
	
	/** �Ƿ�ɷ��� ��1���ɷ��� 0�����ɷ��� */
	protected String isapprove;

	/**
	 * ������Ϣȡ��
	 * @return pdinfo ������Ϣ
	 */
	public IG380Info getPdinfo() {
		return pdinfo;
	}

	/**
	 * ������Ϣ�趨
	 * @param pdinfo ������Ϣ
	 */
	public void setPdinfo(IG380Info pdinfo) {
		this.pdinfo = pdinfo;
	}

	/**
	 * �Ƿ�ɷ���ȡ��
	 * @return isapprove �Ƿ�ɷ���
	 */
	public String getIsapprove() {
		return isapprove;
	}

	/**
	 * �Ƿ�ɷ����趨
	 * @param isapprove �Ƿ�ɷ���
	 */
	public void setIsapprove(String isapprove) {
		this.isapprove = isapprove;
	}
}
