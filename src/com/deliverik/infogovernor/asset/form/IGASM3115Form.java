/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: 
 * @Author       zhangqiang
 * @History      @2014-7-26�½� 
 * 			
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGASM3115Form extends BaseForm{
	
	/***/
	protected String esyscoding;

	/** ���� */
	protected String risknum;

	/** �������� */
	protected String risk;

	/** �������� */
	protected String riskly;

	/** �������� */
	protected String riskarea;

	/** ������ */
	protected String riskitem;

	/**
	 * ȡ��
	 * @return esyscoding 
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * �趨
	 * @param esyscoding 
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * ����ȡ��
	 * @return risknum ����
	 */
	public String getRisknum() {
		return risknum;
	}

	/**
	 * �����趨
	 * @param risknum ����
	 */
	public void setRisknum(String risknum) {
		this.risknum = risknum;
	}

	/**
	 * ��������ȡ��
	 * @return risk ��������
	 */
	public String getRisk() {
		return risk;
	}

	/**
	 * ���������趨
	 * @param risk ��������
	 */
	public void setRisk(String risk) {
		this.risk = risk;
	}

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

	/**
	 * ��������ȡ��
	 * @return riskarea ��������
	 */
	public String getRiskarea() {
		return riskarea;
	}

	/**
	 * ���������趨
	 * @param riskarea ��������
	 */
	public void setRiskarea(String riskarea) {
		this.riskarea = riskarea;
	}

	/**
	 * ������ȡ��
	 * @return riskitem ������
	 */
	public String getRiskitem() {
		return riskitem;
	}

	/**
	 * �������趨
	 * @param riskitem ������
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}
}
