/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.model;


/**
 * 
 * ��Ŀͳ��
 * 
 */
public interface ProjectStatistic{

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
     * Ԥ�ƿ�ʼʱ��ȡ��
     *
     * @return planStartTime Ԥ�ƿ�ʼʱ��
     */
    public String getPlanStartTime();

    /**
     * Ԥ�����ʱ��ȡ��
     *
     * @return planFinishTime Ԥ�����ʱ��
     */
    public String getPlanFinishTime();

    /**
     * ��Ŀ�׶�ȡ��
     *
     * @return prjStage ��Ŀ�׶�
     */
    public String getPrjStage();

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjManager ��Ŀ����
     */
    public String getPrjManager();

    /**
     * ��Ŀ�����ȡ��
     *
     * @return prjOutsourcers ��Ŀ�����
     */
    public String getPrjOutsourcers();

    /**
     * �Ƿ��ϱ���ܻ���ȡ��
     *
     * @return prjReport �Ƿ��ϱ���ܻ���
     */
    public String getPrjReport();

}
