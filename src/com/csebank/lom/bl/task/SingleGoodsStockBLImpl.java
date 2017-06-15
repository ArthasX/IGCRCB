/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.csebank.lom.model.dao.SingleGoodsStockDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 食堂成本信息业务逻辑接口实现
 */
public class SingleGoodsStockBLImpl extends BaseBLImpl implements SingleGoodsStockBL {
	
	protected SingleGoodsStockDAO singleGoodsStockDAO;
	
	public void setSingleGoodsStockDAO(
			SingleGoodsStockDAO singleGoodsStockDAO) {
		this.singleGoodsStockDAO = singleGoodsStockDAO;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SingleGoodsStock> searchSingleGoodsStock(SingleGoodsStockSearchCond cond, int start, int count){
		
		return singleGoodsStockDAO.findByCond(cond,start,count);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SingleGoodsStock> getSearchCount(SingleGoodsStockSearchCond cond){
		
		return singleGoodsStockDAO.getSearchCount(cond);
	}

}
