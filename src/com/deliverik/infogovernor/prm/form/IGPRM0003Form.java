/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * @Description: ��ݷ��𵯳����������б�Form
 * @Author
 * @History 
 * @Version
 */
@SuppressWarnings("serial")
public class IGPRM0003Form extends BaseForm {

	/** ����ID */
	protected Integer prid;
	
	/** �������� */
	protected String prtype;

	/** ���̷����������� */
    protected String parameters;
    
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

    /**
     * @return the ���̷�����������
     */
    public String getParameters() {
        return parameters;
    }

    /**
     * @param ���̷����������� the parameters to set
     */
    public void setParameters(String parameters) {
        this.parameters = parameters;
    }
	
}
