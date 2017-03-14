/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0125Info;

/**
 * 概述: 最新版域信息视图业务逻辑接口
 * 功能描述: 最新版域信息视图业务逻辑接口
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface SOC0125BL extends BaseBL {
	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0125Info> searchEiDomainDefVW() throws BLException;

	/**
	 * 根据eiddid查询
	 * @param eiddid
	 * @return
	 */
	public SOC0125Info searchEiDomainDefVW(String eiddid) throws BLException;
	
}
