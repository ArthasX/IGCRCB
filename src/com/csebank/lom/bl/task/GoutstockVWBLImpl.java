/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.csebank.lom.model.dao.GoutstockVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 物品领用信息视图业务逻辑接口实现
 */
public class GoutstockVWBLImpl extends BaseBLImpl implements GoutstockVWBL {
	
	/**  DAO */
	protected GoutstockVWDAO goutstockVWDAO;

	

	/**
	 * @param goutstockVWDAO the goutstockVWDAO to set
	 */
	public void setGoutstockVWDAO(GoutstockVWDAO goutstockVWDAO) {
		this.goutstockVWDAO = goutstockVWDAO;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GoutstockVWSearchCond cond){
		
		return goutstockVWDAO.getSearchCount(cond);
	}

	

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GoutstockVWInfo> searchGoutstockVW(GoutstockVWSearchCond cond, int start, int count){
		
		return goutstockVWDAO.findByCond(cond,start,count);
	}


}
