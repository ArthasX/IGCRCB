/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��form��Ϣ
 * </p>
 * 2014-7-24
 * 
 * @author wangyaowen@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK0301Form extends BaseForm {
	
    /**�ƻ����*/
    protected String risknum_l;
    
    /**�ƻ�����*/
    protected String risktype_q;
    
    /**�ƻ�����*/
    protected String  title_l;
    
    /**�ƻ�������*/
    protected String  prusername_l;
    
    /**�ƻ�״̬*/
    protected String  riskstatus_q;
    
    /**�ƻ���ʼʱ��С��*/
    protected String  riskstart_le;
    
    /**�ƻ���ʼʱ�����*/
    protected String  riskstart_ge;

	/**
	 * �ƻ����ȡ��
	 * @return risknum_l �ƻ����
	 */
	public String getRisknum_l() {
		return risknum_l;
	}

	/**
	 * �ƻ�����趨
	 * @param risknum_l �ƻ����
	 */
	public void setRisknum_l(String risknum_l) {
		this.risknum_l = risknum_l;
	}

	/**
	 * �ƻ�����ȡ��
	 * @return risktype_q �ƻ�����
	 */
	public String getRisktype_q() {
		return risktype_q;
	}

	/**
	 * �ƻ������趨
	 * @param risktype_q �ƻ�����
	 */
	public void setRisktype_q(String risktype_q) {
		this.risktype_q = risktype_q;
	}

	/**
	 * �ƻ�����ȡ��
	 * @return title_l �ƻ�����
	 */
	public String getTitle_l() {
		return title_l;
	}

	/**
	 * �ƻ������趨
	 * @param title_l �ƻ�����
	 */
	public void setTitle_l(String title_l) {
		this.title_l = title_l;
	}

	/**
	 * �ƻ�������ȡ��
	 * @return prusername_l �ƻ�������
	 */
	public String getPrusername_l() {
		return prusername_l;
	}

	/**
	 * �ƻ��������趨
	 * @param prusername_l �ƻ�������
	 */
	public void setPrusername_l(String prusername_l) {
		this.prusername_l = prusername_l;
	}

	/**
	 * �ƻ�״̬ȡ��
	 * @return riskstatus_q �ƻ�״̬
	 */
	public String getRiskstatus_q() {
		return riskstatus_q;
	}

	/**
	 * �ƻ�״̬�趨
	 * @param riskstatus_q �ƻ�״̬
	 */
	public void setRiskstatus_q(String riskstatus_q) {
		this.riskstatus_q = riskstatus_q;
	}

	/**
	 * �ƻ���ʼʱ��С��ȡ��
	 * @return riskstart_le �ƻ���ʼʱ��С��
	 */
	public String getRiskstart_le() {
		return riskstart_le;
	}

	/**
	 * �ƻ���ʼʱ��С���趨
	 * @param riskstart_le �ƻ���ʼʱ��С��
	 */
	public void setRiskstart_le(String riskstart_le) {
		this.riskstart_le = riskstart_le;
	}

	/**
	 * �ƻ���ʼʱ�����ȡ��
	 * @return riskstart_ge �ƻ���ʼʱ�����
	 */
	public String getRiskstart_ge() {
		return riskstart_ge;
	}

	/**
	 * �ƻ���ʼʱ������趨
	 * @param riskstart_ge �ƻ���ʼʱ�����
	 */
	public void setRiskstart_ge(String riskstart_ge) {
		this.riskstart_ge = riskstart_ge;
	}
}

