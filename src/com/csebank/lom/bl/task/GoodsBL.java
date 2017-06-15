/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goods;
import com.csebank.lom.model.condition.GoodsSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 物品信息业务逻辑接口
 */
public interface GoodsBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GoodsSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param rid 检查项ID
	 * @return 检查项ID
	 */
	public Goods searchGoodsByKey(Integer gid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部值班检查项信息
	 */
	public List<Goods> searchGoodsAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Goods> searchGoods(GoodsSearchCond cond, int start, int count);
	public List<Goods> searchGoods(String gcategory);
	/**
	 * 登录处理
	 * 
	 * @param Goods 登录数据
	 * @return 值班检查项信息
	 */
	public Goods registGoods(Goods goods) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rid 检查项ID
	 * @throws BLException
	 */
	public void deleteGoods(Integer gid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param auditCheckRelation 变更数据
	 * @return 值班检查项信息
	 */
	public Goods updateGoods(Goods goods) throws BLException;

}
