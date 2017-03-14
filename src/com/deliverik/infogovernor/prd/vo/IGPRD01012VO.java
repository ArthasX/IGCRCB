/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程导出操作校验错误信息vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRD01012VO extends BaseVO{

	/** 错误信息 */
	protected List<String> errorMessages;

	/**
	 * 错误信息取得
	 * @return errorMessages 错误信息
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * 错误信息设定
	 * @param errorMessages 错误信息
	 */
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}
