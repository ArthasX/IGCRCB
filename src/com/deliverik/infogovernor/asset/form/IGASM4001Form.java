/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ��Form
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGASM4001Form extends BaseForm{
	/** ��������*/
	protected String riskly;

	/**
	 * ��������ȡ��
	 * @return riskly ��������
	 */
	public String getRiskly() {
		return riskly;
	}

	/**
	 * ���������趨
	 * @param riskly ��������
	 */
	public void setRiskly(String riskly) {
		this.riskly = riskly;
	}
}
