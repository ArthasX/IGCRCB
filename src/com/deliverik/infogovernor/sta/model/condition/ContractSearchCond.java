/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * ��ͬͳ�Ʋ�ѯ�����ӿ�
 */
public interface ContractSearchCond {
    
    /**
     * ͳ����ȡ��
     *
     * @return curYear ͳ����
     */
    public String getCurYear();

    /**
     * ������ȡ��
     *
     * @return facilitator ������
     */
    public String getFacilitator();

    /**
     * ��ͬ����ȡ��
     *
     * @return contractType ��ͬ����
     */
    public String getContractType();
    
}
