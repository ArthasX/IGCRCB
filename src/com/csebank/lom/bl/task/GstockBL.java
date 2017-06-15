/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.condition.GstockSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 物品信息业务逻辑接口
 */
public interface GstockBL extends BaseBL {
 
	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(GstockSearchCond cond);

	/**
	 * 主键检索处理
	 * 
	 * @param gsid 检查项ID
	 * @return 检查项ID
	 */
	public Gstock searchGstockByKey(Integer gsid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部物品信息
	 */
	public List<Gstock> searchGstockAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Gstock> searchGstock(GstockSearchCond cond, int start, int count);

	/**
	 * 登录处理
	 * 
	 * @param Goods 登录数据
	 * @return 值班检查项信息
	 */
	public Gstock registGstock(Gstock gStock) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param rid 检查项ID
	 * @throws BLException
	 */
	public void deleteGstock(Integer gsid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param auditCheckRelation 变更数据
	 * @return 值班检查项信息
	 */
	public Gstock updateGstock(Gstock gStock) throws BLException;

}
