/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;
import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0600SearchCond;

/**
  * 概述: 资产相关流程查询
  * 功能描述: 资产相关流程查询
  * 创建记录: 2014/03/13
  * 修改记录: 
  */
public interface SOC0600BL extends BaseBL {

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public List<SOC0600Info> findByCond(SOC0600SearchCond cond);
}