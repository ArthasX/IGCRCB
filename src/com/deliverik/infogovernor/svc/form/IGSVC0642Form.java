/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程数量统计Form
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC0642Form extends BaseForm{

	/** 开始时间 */
	protected String propentime_from;
	
	/** 结束时间 */
	protected String propentime_to;

	/**
	 * 开始时间取得
	 * @return propentime_from 开始时间
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * 开始时间设定
	 * @param propentime_from 开始时间
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * 结束时间取得
	 * @return propentime_to 结束时间
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * 结束时间设定
	 * @param propentime_to 结束时间
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
}
