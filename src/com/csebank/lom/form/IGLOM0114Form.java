/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * �Ӵ����˲�ѯForm
 *
 */
public class IGLOM0114Form extends BaseForm implements RecptionGuestInfoCond {
	
	
	private static final long serialVersionUID = 1L;

	/**
	 * ������λ
	 */
	protected String rgunit;
	
	/**
	 * ��������
	 */
	protected String rgname;
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
    public String getRgname() {
		
		return rgname;
	}
    
	/**
	 * ���������趨
	 * @param rgname ��������
	 */
    public void setRgname(String rgname){
    	this.rgname=rgname;
    }
    
    /**
	 * ������λȡ��
	 * @return ������λ
	 */
	public String getRgunit() {
		
		return rgunit;
	}
	
	/**
	 * ������λ�趨
	 * @param rgname ������λ
	 */
	public void setRgunit(String rgunit){
		this.rgunit=rgunit;
	}

	
	
}
