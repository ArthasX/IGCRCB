/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG500Info;

/**
 * @Description: 流程处理VO
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01022VO extends BaseVO {
	
	/** 关联类型 */
	protected String type;
	
	/** 流程信息 */
	protected IG500Info info;

	/**
	 * 关联类型取得
	 * @return type 关联类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 关联类型设定
	 * @param type 关联类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 流程信息取得
	 * @return info 流程信息
	 */
	public IG500Info getInfo() {
		return info;
	}

	/**
	 * 流程信息设定
	 * @param info 流程信息
	 */
	public void setInfo(IG500Info info) {
		this.info = info;
	}
}
