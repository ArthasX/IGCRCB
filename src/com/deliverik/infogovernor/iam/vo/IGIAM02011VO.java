/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.iam.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0203Form;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;

/**
 * @author Administrator
 *
 */
/**
 * 概述: 
 * 功能描述：
 * 创建人：赵敏
 * 创建记录： 2012-7-26
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGIAM02011VO extends BaseVO implements Serializable {

	/**
     * 内审工作详细信息显示bean
     */
	private IGIAM0203Form igiam0203form;

    /**
     * 内审工作条件查询结果list
     */
	protected List<InternalauditJobInfo> internalauditJobList;
	 
	protected List<Attachment> attkeyList;
	
	/**
	 * 获取attkeyList
	 * @return fattkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}

	/**
	 * 设置attkeyList
	 * @param attkeyList  attkeyList
	 */
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}

	/**
	 * 获取igiam0203form
	 * @return figiam0203form igiam0203form
	 */
	public IGIAM0203Form getIgiam0203form() {
		return igiam0203form;
	}

	/**
	 * 设置igiam0203form
	 * @param igiam0203form  igiam0203form
	 */
	public void setIgiam0203form(IGIAM0203Form igiam0203form) {
		this.igiam0203form = igiam0203form;
	}

	/**
	 * 获取internalauditJobList
	 * @return finternalauditJobList internalauditJobList
	 */
	public List<InternalauditJobInfo> getInternalauditJobList() {
		return internalauditJobList;
	}

	/**
	 * 设置internalauditJobList
	 * @param internalauditJobList  internalauditJobList
	 */
	public void setInternalauditJobList(
			List<InternalauditJobInfo> internalauditJobList) {
		this.internalauditJobList = internalauditJobList;
	}
	
}
