/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sta.form;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseForm;


/**
 * 合同统计查询Form
 *
 */
@SuppressWarnings("serial")
public class IGSTA0103Form extends BaseForm {
	
    /** 统计年 */
    protected String curYear;
    
    /** 服务商 */
    protected String facilitator;
    
    protected String einame;

    /** 合同类型码 */
    protected String esyscoding;
    
    /** 合同类型*/
    protected String contractType;

    /**  合同模型  */
    protected List<LabelValueBean> contractLabel;
    
    /**
     * 统计年取得
     *
     * @return curYear 统计年
     */
    public String getCurYear() {
        return curYear;
    }

    /**
     * 服务商取得
     *
     * @return facilitator 服务商
     */
    public String getFacilitator() {
        return facilitator;
    }

    /**
     * 合同类型取得
     *
     * @return contractType 合同类型
     */
    public String getContractType() {
        return contractType;
    }

    /**
     * 统计年设定
     *
     * @param curYear 统计年
     */
    public void setCurYear(String curYear) {
        this.curYear = curYear;
    }

    /**
     * 服务商设定
     *
     * @param facilitator 服务商
     */
    public void setFacilitator(String facilitator) {
        this.facilitator = facilitator;
    }

    /**
     * 合同类型设定
     *
     * @param contractType 合同类型
     */
    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    /**
     * 合同模型取得
     *
     * @return contractLabel 合同模型
     */
    public List<LabelValueBean> getContractLabel() {
        return contractLabel;
    }

    /**
     * 合同模型设定
     *
     * @param contractLabel 合同模型
     */
    public void setContractLabel(List<LabelValueBean> contractLabel) {
        this.contractLabel = contractLabel;
    }

    /**
     * 合同类型码取得
     *
     * @return esyscoding 合同类型码
     */
    public String getEsyscoding() {
        return esyscoding;
    }

    /**
     * 合同类型码设定
     *
     * @param esyscoding 合同类型码
     */
    public void setEsyscoding(String esyscoding) {
        this.esyscoding = esyscoding;
    }

    /**
     * einame取得
     *
     * @return einame einame
     */
    public String getEiname() {
        return einame;
    }

    /**
     * einame设定
     *
     * @param einame einame
     */
    public void setEiname(String einame) {
        this.einame = einame;
    }
	
}
