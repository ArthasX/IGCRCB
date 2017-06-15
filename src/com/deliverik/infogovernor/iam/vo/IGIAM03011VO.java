/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.iam.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0301Form;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;

/**
 * 概述: 
 * 功能描述：
 * 创建人：惠涌智
 * 创建记录： 2012-8-9
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGIAM03011VO extends BaseVO implements Serializable {
	/**
	 * 审计报告查询Form
	 */
	private IGIAM0301Form igiam0301Form ;
	/**
     * 审计报告查询结果list
     */
	protected List<AUDITPROJECTInfo> auditProjectInfoList;
	/**
	 * 附件KEYlist
	 */
	protected List<Attachment> attkeyList;
	
	public IGIAM0301Form getIgiam0301Form() {
		return igiam0301Form;
	}
	public void setIgiam0301Form(IGIAM0301Form igiam0301Form) {
		this.igiam0301Form = igiam0301Form;
	}
	public List<AUDITPROJECTInfo> getAuditProjectInfoList() {
		return auditProjectInfoList;
	}
	public void setAuditProjectInfoList(List<AUDITPROJECTInfo> auditProjectInfoList) {
		this.auditProjectInfoList = auditProjectInfoList;
	}
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}
}
