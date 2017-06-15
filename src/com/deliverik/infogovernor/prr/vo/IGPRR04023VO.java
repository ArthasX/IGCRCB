/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG380Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR04023VO extends BaseVO{

	/** 流程信息 */
	protected IG380Info pdinfo;
	
	/** 是否可发起 （1：可发起 0：不可发起） */
	protected String isapprove;

	/**
	 * 流程信息取得
	 * @return pdinfo 流程信息
	 */
	public IG380Info getPdinfo() {
		return pdinfo;
	}

	/**
	 * 流程信息设定
	 * @param pdinfo 流程信息
	 */
	public void setPdinfo(IG380Info pdinfo) {
		this.pdinfo = pdinfo;
	}

	/**
	 * 是否可发起取得
	 * @return isapprove 是否可发起
	 */
	public String getIsapprove() {
		return isapprove;
	}

	/**
	 * 是否可发起设定
	 * @param isapprove 是否可发起
	 */
	public void setIsapprove(String isapprove) {
		this.isapprove = isapprove;
	}
}
