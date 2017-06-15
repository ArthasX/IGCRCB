/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;

/**
 * 审计版本信息检索结果ＶＯ
 * 
 * @author
 */
@SuppressWarnings("serial")
public class IGIAM01011VO extends BaseVO implements Serializable{
	
	/** 审计版本信息检索结果 */
	protected List<IGIAM0101Form> internalauditprjInfoList;
	/** 年份检索结果 */
	protected List<String> iamYearList;
	/** 邮寄信息实体 */
    protected InternalauditprjInfo internalauditprjInfo;
	
    /** 内审工作登记页内审项目弹出页List*/
    protected List<InternalauditprjInfo> helpSearchList;
    
    /** 附件List */
    protected List<Attachment> attkeyList;

	/**
	 * internalauditprjInfo取得
	 *
	 * @return internalauditprjInfo internalauditprjInfo
	 */
	public InternalauditprjInfo getInternalauditprjInfo() {
		return internalauditprjInfo;
	}

	/**
	 * internalauditprjInfo设定
	 *
	 * @param internalauditprjInfo internalauditprjInfo
	 */
	public void setInternalauditprjInfo(InternalauditprjInfo internalauditprjInfo) {
		this.internalauditprjInfo = internalauditprjInfo;
	}

	/**
	 * 构造函数
	 * @param riskAudit　审计版本信息检索结果
	 */
	public void setInternalauditprjInfoList(List<IGIAM0101Form> internalauditprjInfoList) {
		this.internalauditprjInfoList = internalauditprjInfoList;
	}
	
	/**
	 * 审计版本信息检索结果取得
	 * @return 审计版本信息检索结果
	 */
	public List<IGIAM0101Form> getInternalauditprjInfoList() {
		return internalauditprjInfoList;
	}
	
	/**
	 * iamYearList取得
	 *
	 * @return iamYearList iamYearList
	 */
	public List<String> getIamYearList() {
		return iamYearList;
	}

	/**
	 * iamYearList设定
	 *
	 * @param iamYearList iamYearList
	 */
	public void setIamYearList(List<String> iamYearList) {
		this.iamYearList = iamYearList;
	}

	/**
	 * 获取helpSearchList
	 * @return fhelpSearchList helpSearchList
	 */
	public List<InternalauditprjInfo> getHelpSearchList() {
		return helpSearchList;
	}

	/**
	 * 设置helpSearchList
	 * @param helpSearchList  helpSearchList
	 */
	public void setHelpSearchList(List<InternalauditprjInfo> helpSearchList) {
		this.helpSearchList = helpSearchList;
	}

	/**
	 * attkeyList取得
	 *
	 * @return attkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}

	/**
	 * attkeyList设定
	 *
	 * @param attkeyList attkeyList
	 */
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}

}


