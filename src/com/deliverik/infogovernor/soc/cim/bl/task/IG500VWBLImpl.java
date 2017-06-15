/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCond;
import com.deliverik.infogovernor.soc.cim.model.dao.IG500VWDAO;


/**
 * 概述: 资产相关流程查询
 * 功能描述: 资产相关流程查询
 * 创建记录: 2014/03/13
 * 修改记录: 
 */
public class IG500VWBLImpl extends BaseBLImpl implements
	IG500VWBL {

	protected IG500VWDAO ig500VWDAO;
	
	/**
	 * ig500VWDAO设定
	 * @param ig500VWDAO ig500VWDAO
	 */
	public void setIg500VWDAO(IG500VWDAO ig500vwdao) {
		ig500VWDAO = ig500vwdao;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public List<IG500VWInfo> findByCond(IG500VWSearchCond cond) {
		return ig500VWDAO.findByCond(cond);
	}
}