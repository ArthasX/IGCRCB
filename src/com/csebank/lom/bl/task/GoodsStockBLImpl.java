/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.csebank.lom.model.dao.GoodsStockDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 食堂成本信息业务逻辑接口实现
 */
public class GoodsStockBLImpl extends BaseBLImpl implements GoodsStockBL {
	
	/** WorkLunchEatery DAO */
	protected GoodsStockDAO goodsStockDAO;
	
	public void setGoodsStockDAO(
			GoodsStockDAO goodsStockDAO) {
		this.goodsStockDAO = goodsStockDAO;
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GoodsStock> searchGoodsStock(GoodsStockSearchCond cond, int start, int count){
		
		return goodsStockDAO.findByCond(cond,start,count);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GoodsStock> getSearchCount(GoodsStockSearchCond cond){
		
		return goodsStockDAO.getSearchCount(cond);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GoodsStock> searchGoodsStockDetail(GoodsStockSearchCond cond, int start, int count){
		
		return goodsStockDAO.findByCond(cond,start,count);
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GoodsStock> getDetailSearchCount(GoodsStockSearchCond cond){
		
		return goodsStockDAO.getSearchCount(cond);
	}

}
