/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ���񹤵���ݷ��𵯳����������б�Form
 * @Author masai
 * @History 
 * @Version 1.0
 */
@SuppressWarnings("serial")
public class IGPRM0004Form extends BaseForm {

	/** ����ID */
	protected Integer prid;
	
	/** �������� */
	protected String prtype;

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * 
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * 
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	
}
