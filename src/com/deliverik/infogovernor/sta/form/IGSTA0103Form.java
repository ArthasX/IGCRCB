/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sta.form;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;


/**
 * ��ͬͳ�Ʋ�ѯForm
 *
 */
@SuppressWarnings("serial")
public class IGSTA0103Form extends BaseForm {
	
    /** ͳ���� */
    protected String curYear;
    
    /** ������ */
    protected String facilitator;
    
    protected String einame;

    /** ��ͬ������ */
    protected String esyscoding;
    
    /** ��ͬ����*/
    protected String contractType;

    /**  ��ͬģ��  */
    protected List<LabelValueBean> contractLabel;
    
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

    /**
     * ��ͬģ��ȡ��
     *
     * @return contractLabel ��ͬģ��
     */
    public List<LabelValueBean> getContractLabel() {
        return contractLabel;
    }

    /**
     * ��ͬģ���趨
     *
     * @param contractLabel ��ͬģ��
     */
    public void setContractLabel(List<LabelValueBean> contractLabel) {
        this.contractLabel = contractLabel;
    }

    /**
     * ��ͬ������ȡ��
     *
     * @return esyscoding ��ͬ������
     */
    public String getEsyscoding() {
        return esyscoding;
    }

    /**
     * ��ͬ�������趨
     *
     * @param esyscoding ��ͬ������
     */
    public void setEsyscoding(String esyscoding) {
        this.esyscoding = esyscoding;
    }

    /**
     * einameȡ��
     *
     * @return einame einame
     */
    public String getEiname() {
        return einame;
    }

    /**
     * einame�趨
     *
     * @param einame einame
     */
    public void setEiname(String einame) {
        this.einame = einame;
    }
	
}
