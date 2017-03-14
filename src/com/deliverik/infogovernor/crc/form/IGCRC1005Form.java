/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 程序开发
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC1005Form extends BaseForm{

	/** 主流程ID */
	protected Integer parprid;

	/**
	 * 主流程ID取得
	 * @return parprid 主流程ID
	 */
	public Integer getParprid() {
		return parprid;
	}

	/**
	 * 主流程ID设定
	 * @param parprid 主流程ID
	 */
	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}
}
