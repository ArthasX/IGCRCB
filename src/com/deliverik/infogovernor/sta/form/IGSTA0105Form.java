/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sta.form;

import com.deliverik.framework.base.BaseForm;


/**
 * ��Ŀͳ�Ʋ�ѯForm
 *
 */
@SuppressWarnings("serial")
public class IGSTA0105Form extends BaseForm {
    
    /** ID */
    protected Integer prid;
    
    /** ��Ŀ���� */
    protected String prTitle;
    
    /** ��Ŀ���� */
    protected String prjLevel;
    
    /** ��Ŀ���� */
    protected String prjCategory;
    
    /** ��Ŀ���� */
    protected String prjProperty;
    
    /** Ԥ�ƿ�ʼʱ�� */
    protected String planStartTime_from;
    
    protected String planStartTime_to;
    
    /** Ԥ�����ʱ��  */
    protected String planFinishTime_from;

    protected String planFinishTime_to;

    /** ��Ŀ�׶�  */
    protected String prjStage;

    /** ��Ŀ�����  */
    protected String prjOutsourcers;
    
    /** �Ƿ��ϱ���ܻ���  */
    protected String prjReport;

    /**
     * IDȡ��
     *
     * @return prid ID
     */
    public Integer getPrid() {
        return prid;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prTitle ��Ŀ����
     */
    public String getPrTitle() {
        return prTitle;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjLevel ��Ŀ����
     */
    public String getPrjLevel() {
        return prjLevel;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjCategory ��Ŀ����
     */
    public String getPrjCategory() {
        return prjCategory;
    }

    /**
     * ��Ŀ����ȡ��
     *
     * @return prjProperty ��Ŀ����
     */
    public String getPrjProperty() {
        return prjProperty;
    }

   

    /**
     * ��Ŀ�׶�ȡ��
     *
     * @return prjStage ��Ŀ�׶�
     */
    public String getPrjStage() {
        return prjStage;
    }

    /**
     * ��Ŀ�����ȡ��
     *
     * @return prjOutsourcers ��Ŀ�����
     */
    public String getPrjOutsourcers() {
        return prjOutsourcers;
    }

    /**
     * �Ƿ��ϱ���ܻ���ȡ��
     *
     * @return prjReport �Ƿ��ϱ���ܻ���
     */
    public String getPrjReport() {
        return prjReport;
    }

    /**
     * ID�趨
     *
     * @param prid ID
     */
    public void setPrid(Integer prid) {
        this.prid = prid;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prTitle ��Ŀ����
     */
    public void setPrTitle(String prTitle) {
        this.prTitle = prTitle;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prjLevel ��Ŀ����
     */
    public void setPrjLevel(String prjLevel) {
        this.prjLevel = prjLevel;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prjCategory ��Ŀ����
     */
    public void setPrjCategory(String prjCategory) {
        this.prjCategory = prjCategory;
    }

    /**
     * ��Ŀ�����趨
     *
     * @param prjProperty ��Ŀ����
     */
    public void setPrjProperty(String prjProperty) {
        this.prjProperty = prjProperty;
    }

  

    /**
     * ��Ŀ�׶��趨
     *
     * @param prjStage ��Ŀ�׶�
     */
    public void setPrjStage(String prjStage) {
        this.prjStage = prjStage;
    }

    /**
     * ��Ŀ������趨
     *
     * @param prjOutsourcers ��Ŀ�����
     */
    public void setPrjOutsourcers(String prjOutsourcers) {
        this.prjOutsourcers = prjOutsourcers;
    }

    /**
     * �Ƿ��ϱ���ܻ����趨
     *
     * @param prjReport �Ƿ��ϱ���ܻ���
     */
    public void setPrjReport(String prjReport) {
        this.prjReport = prjReport;
    }

    /**
     * Ԥ�ƿ�ʼʱ��ȡ��
     *
     * @return planStartTime_from Ԥ�ƿ�ʼʱ��
     */
    public String getPlanStartTime_from() {
        return planStartTime_from;
    }

    /**
     * planStartTime_toȡ��
     *
     * @return planStartTime_to planStartTime_to
     */
    public String getPlanStartTime_to() {
        return planStartTime_to;
    }

    /**
     * Ԥ�����ʱ��ȡ��
     *
     * @return planFinishTime_from Ԥ�����ʱ��
     */
    public String getPlanFinishTime_from() {
        return planFinishTime_from;
    }

    /**
     * planFinishTime_toȡ��
     *
     * @return planFinishTime_to planFinishTime_to
     */
    public String getPlanFinishTime_to() {
        return planFinishTime_to;
    }

    /**
     * Ԥ�ƿ�ʼʱ���趨
     *
     * @param planStartTime_from Ԥ�ƿ�ʼʱ��
     */
    public void setPlanStartTime_from(String planStartTime_from) {
        this.planStartTime_from = planStartTime_from;
    }

    /**
     * planStartTime_to�趨
     *
     * @param planStartTime_to planStartTime_to
     */
    public void setPlanStartTime_to(String planStartTime_to) {
        this.planStartTime_to = planStartTime_to;
    }

    /**
     * Ԥ�����ʱ���趨
     *
     * @param planFinishTime_from Ԥ�����ʱ��
     */
    public void setPlanFinishTime_from(String planFinishTime_from) {
        this.planFinishTime_from = planFinishTime_from;
    }

    /**
     * planFinishTime_to�趨
     *
     * @param planFinishTime_to planFinishTime_to
     */
    public void setPlanFinishTime_to(String planFinishTime_to) {
        this.planFinishTime_to = planFinishTime_to;
    }
    
    
}
