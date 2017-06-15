/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * ��ͬͳ�Ʋ�ѯ����ʵ��
 */
public class ContractSearchCondImpl implements ContractSearchCond{
	
	/** ͳ���� */
	protected String curYear;
	
	/** ������ */
	protected String facilitator;
	
	/** ��ͬ����*/
	protected String contractType;

    /**
     * ͳ����ȡ��
     *
     * @return curYear ͳ����
     */
    public String getCurYear() {
        return curYear;
    }

    /**
     * ������ȡ��
     *
     * @return facilitator ������
     */
    public String getFacilitator() {
        return facilitator;
    }

    /**
     * ��ͬ����ȡ��
     *
     * @return contractType ��ͬ����
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * ͳ�����趨
     *
     * @param curYear ͳ����
     */
    public void setCurYear(String curYear) {
        this.curYear = curYear;
    }

    /**
     * �������趨
     *
     * @param facilitator ������
     */
    public void setFacilitator(String facilitator) {
        this.facilitator = facilitator;
    }

    /**
     * ��ͬ�����趨
     *
     * @param contractType ��ͬ����
     */
    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
	
	
}
