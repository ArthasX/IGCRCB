/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:�걨�б��ѯ 
 * �����������걨�б��ѯ 
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0704Form extends BaseForm {
	
	/** ʵ��ID */
	private	Integer instanceID;
	
	/** ������������ */
	private Integer[] prids;
	
   /** ���̶���ID���� */
    private String[] prpdids;
	
	/** �������ر�ʶ   1������  2������ */
	private String type;

	/**
	 * ʵ��IDȡ��
	 * 
	 * @return ʵ��ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * ʵ��ID�趨
	 * 
	 * @param instanceID ʵ��ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}
	
	/**
	 * ������������ȡ��
	 * 
	 * @return ������������
	 */
	public Integer[] getPrids() {
		return prids;
	}
	
	/**
	 * �������������趨
	 * 
	 * @param prids ������������
	 */
	public void setPrids(Integer[] prids) {
		this.prids = prids;
	}
	/**
	 * �������ر�ʶȡ��
	 * 
	 * @return �������ر�ʶ
	 */
	public String getType() {
		return type;
	}
	/**
	 * �������ر�ʶ�趨
	 * 
	 * @param type �������ر�ʶ
	 */
	public void setType(String type) {
		this.type = type;
	}
	
    /**
     * @return the ���̶���ID����
     */
    public String[] getPrpdids() {
        return prpdids;
    }

    /**
     * @param ���̶���ID���� the prpdids to set
     */
    public void setPrpdids(String[] prpdids) {
        this.prpdids = prpdids;
    }
	
}
