/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.SOC0114VWInfo;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCond;
import com.deliverik.infogovernor.soc.model.condition.SOC0114VW_FXSearchCondImpl;

/**
 * SOC0114VW_FX业务逻辑接口
 */
public interface SOC0114VW_FXBL extends BaseBL{

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public String searchSOC0114VW_FXByCond(SOC0114VW_FXSearchCond cond);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public String searchSOC0114VW_BJByCond(SOC0114VW_FXSearchCond cond);

	public List<SOC0114VWInfo> findByCondForBJ(
			SOC0114VW_FXSearchCondImpl soc0114Cond);

	/**
	 * 应用维护拓扑查询
	 * @param cond
	 * @return
	 */
	public String searchSOC0114VW_FXAPPByCond(SOC0114VW_FXSearchCond cond,String FLEXID);
}
