/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 物品出库信息业务逻辑接口
 */
public interface GoutstockBL extends BaseBL {

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GoutstockSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param goid 物品出库信息ID
	 * @return 物品出库信息ID
	 */
	public Goutstock searchGoutstockByKey(Integer goid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部物品入出库明细信息
	 */
	public List<Goutstock> searchGoodsAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Goutstock> searchGoutstock(GoutstockSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param Goutstock 登录数据
	 * @return 物品出库信息
	 */
	public Goutstock registGoutstock(Goutstock Goutstock) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param goid 物品出库信息ID
	 * @return
	 */
	public void deleteGoutstock(Integer giodid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param Goutstock 变更数据
	 * @return 物品出库信息
	 */
	public Goutstock updateGoods(Goutstock Goutstock) throws BLException;

	

}
