/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 餐卡信息业务逻辑接口
 */
public interface LunchCardBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(LunchCardSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param typecode 餐卡ID
	 * @return 餐卡ID
	 */
	public ItemsCodesSt searchLunchCardByKey(Integer icid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部食堂成本信息
	 */
	public List<ItemsCodesSt> searchLunchCardAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ItemsCodesSt> searchLunchCard(LunchCardSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param Eatery 登录数据
	 * @return 餐卡信息
	 */
	public ItemsCodesSt registLunchCard(ItemsCodesSt eatery) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param Eatery 变更数据
	 * @return 餐卡信息
	 */
	public ItemsCodesSt updateLunchCard(ItemsCodesSt eatery) throws BLException;

}
