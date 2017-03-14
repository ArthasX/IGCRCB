/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.condition.DealSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 接待管理业务逻辑接口
 */
public interface DealBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(DealSearchCond cond);
	
	

	/**
	 * 主键检索处理
	 * 
	 * @param rid 接待ID
	 * @return 接待ID
	 */
	public Deal searchDealByKey(Integer rid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班接待信息
	 */
	public List<Deal> searchDealAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Deal> searchDeal(DealSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param Recption 登录数据
	 * @return 值班接待信息
	 */
	public Deal insertDealInfo(Deal deal) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rid 接待ID
	 * @throws BLException
	 */
	public void deleteDeal(Integer rid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param recption 变更数据
	 * @return 值班接待信息
	 */
	public Deal updateDeal(Deal recption) throws BLException;

	/**
 	 * 根据客户姓名，客户单位查询接待工作信息
 	 *
 	 * @param cond 检索条件
 	 * @param start 检索记录起始行号
 	 * @param count 检索记录件数
 	 * @return 接待工作信息
 	 * @throws BLException
 	 */

}
