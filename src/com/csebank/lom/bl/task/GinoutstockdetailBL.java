/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 物品入出库明细信息业务逻辑接口
 */
public interface GinoutstockdetailBL extends BaseBL {

	/**
	 * 主键检索处理
	 * 
	 * @param giodid 物品入出库明细信息ID
	 * @return 物品入出库明细信息ID
	 */
	public Ginoutstockdetail searchGinoutstockdetailByKey(Integer giodid) throws BLException;
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部物品入出库明细信息
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetailAll();

	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Ginoutstockdetail> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count);
	public List<GinoutStockDetailVW> searchGinoutstockdetail(GinoutstockdetailSearchCond cond, int start, int count, String temp);
	/**
	 * 登录处理
	 * 
	 * @param Ginoutstockdetail 登录数据
	 * @return 物品入出库明细信息
	 */
	public Ginoutstockdetail registGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException;

	/**
	 * 删除处理
	 * 
	 * @param giodid 物品入出库明细信息ID
	 * @return
	 */
	public void deleteGinoutstockdetail(Integer giodid) throws BLException;

	/**
	 * 变更处理
	 * 
	 * @param Ginoutstockdetail 变更数据
	 * @return 物品入出库明细信息
	 */
	public Ginoutstockdetail updateGinoutstockdetail(Ginoutstockdetail Ginoutstockdetail) throws BLException;
	/**
	 * 食堂物品消耗明细
	 * 
	 * @param Ginoutstockdetail 变更数据
	 * @return 物品入出库明细信息
	 */
	
	public List<GoutDetailInfo> getGoutDetailInfo(GoutDetailSearchCond cond, int start, int count)throws BLException;
	


}
