/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prd.model.IG007Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 表格类表单预览vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01731VO extends BaseVO{

	/** 表格类表单定义信息 */
	protected IG007Info pidInfo;

	/**
	 * 表格类表单定义信息取得
	 * @return pidInfo 表格类表单定义信息
	 */
	public IG007Info getPidInfo() {
		return pidInfo;
	}

	/**
	 * 表格类表单定义信息设定
	 * @param pidInfo 表格类表单定义信息
	 */
	public void setPidInfo(IG007Info pidInfo) {
		this.pidInfo = pidInfo;
	}
	
}
