/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCond;

/**
  * 概述: 资产相关流程查询
  * 功能描述: 资产相关流程查询
  * 创建记录: 2014/03/13
  * 修改记录: 
  */
public interface IG500VWBL extends BaseBL {

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public List<IG500VWInfo> findByCond(IG500VWSearchCond cond);
}