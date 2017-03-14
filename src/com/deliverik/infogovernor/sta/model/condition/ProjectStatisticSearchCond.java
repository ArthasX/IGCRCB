/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * ��Ŀͳ�Ʋ�ѯ�����ӿ�
 */
public interface ProjectStatisticSearchCond {
    /**
     * IDȡ��
     *
     * @return prid ID
     */
    public Integer getPrid();

    /**
     * ��Ŀ����ȡ��
     *
     * @return prTitle ��Ŀ����
     */
    public String getPrTitle();

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjLevel ��Ŀ����
     */
    public String getPrjLevel();

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjCategory ��Ŀ����
     */
    public String getPrjCategory();

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjProperty ��Ŀ����
     */
    public String getPrjProperty();

    /**
     * ��Ŀ�׶�ȡ��
     *
     * @return prjStage ��Ŀ�׶�
     */
    public String getPrjStage();

    /**
     * ��Ŀ�����ȡ��
     *
     * @return prjOutsourcers ��Ŀ�����
     */
    public String getPrjOutsourcers() ;

    /**
     * �Ƿ��ϱ���ܻ���ȡ��
     *
     * @return prjReport �Ƿ��ϱ���ܻ���
     */
    public String getPrjReport();
    
    /**
     * Ԥ�ƿ�ʼʱ��ȡ��
     *
     * @return planStartTime_from Ԥ�ƿ�ʼʱ��
     */
    public String getPlanStartTime_from();

    /**
     * planStartTime_toȡ��
     *
     * @return planStartTime_to planStartTime_to
     */
    public String getPlanStartTime_to();

    /**
     * Ԥ�����ʱ��ȡ��
     *
     * @return planFinishTime_from Ԥ�����ʱ��
     */
    public String getPlanFinishTime_from();

    /**
     * planFinishTime_toȡ��
     *
     * @return planFinishTime_to planFinishTime_to
     */
    public String getPlanFinishTime_to();
    
}
