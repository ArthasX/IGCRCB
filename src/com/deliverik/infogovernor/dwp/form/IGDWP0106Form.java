/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划流程分派页面
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDWP0106Form extends BaseForm{

	/** 计划ID */
	protected Integer planid;
	
	/** 流程信息ID */
	protected Integer prid;
	
	/** 分派信息集合 */
	protected String[] participants;

	/**
	 * 计划ID取得
	 * @return planid 计划ID
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * 计划ID设定
	 * @param planid 计划ID
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	/**
	 * 流程信息ID取得
	 * @return prid 流程信息ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程信息ID设定
	 * @param prid 流程信息ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 分派信息集合取得
	 * @return participants 分派信息集合
	 */
	public String[] getParticipants() {
		return participants;
	}

	/**
	 * 分派信息集合设定
	 * @param participants 分派信息集合
	 */
	public void setParticipants(String[] participants) {
		this.participants = participants;
	}
}
