/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程通用查询Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGPRR0601Form extends BaseForm{

	/** 流程定义ID */
	protected String pdid;
	
	/** 查询条件标识 */
	protected String[] queryKey;
	
	/** 查询条件值 */
	protected String[] queryValue;

	/**
	 * 流程记录紧急程度
	 */
	protected String prurgency;

	/**
	 * 流程定义ID取得
	 * @return pdid 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 查询条件标识取得
	 * @return queryKey 查询条件标识
	 */
	public String[] getQueryKey() {
		return queryKey;
	}

	/**
	 * 查询条件标识设定
	 * @param queryKey 查询条件标识
	 */
	public void setQueryKey(String[] queryKey) {
		this.queryKey = queryKey;
	}

	/**
	 * 查询条件值取得
	 * @return queryValue 查询条件值
	 */
	public String[] getQueryValue() {
		return queryValue;
	}

	/**
	 * 查询条件值设定
	 * @param queryValue 查询条件值
	 */
	public void setQueryValue(String[] queryValue) {
		this.queryValue = queryValue;
	}

	public String getPrurgency() {
		return prurgency;
	}

	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
}

