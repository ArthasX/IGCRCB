/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.mnt.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0305Info;

/**
 * 概述: 错误日志检索ＶＯ
 * 功能描述: 错误日志检索ＶＯ
 * 创建记录: 2011/06/09
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGMNT02081VO extends BaseVO implements Serializable{
	
	/**错误日志 */
    protected SOC0305Info soc0305Info;

	/**
	 * 错误日志取得
	 *
	 * @return soc0305Info 错误日志
	 */
	public SOC0305Info getSoc0305Info() {
		return soc0305Info;
	}

	/**
	 * 错误日志设定
	 *
	 * @param soc0305Info 错误日志
	 */
	public void setSoc0305Info(SOC0305Info soc0305Info) {
		this.soc0305Info = soc0305Info;
	}

}
