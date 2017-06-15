package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG778Info;
import com.deliverik.framework.asset.model.condition.IG778SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 机柜信息业务逻辑
 * 
 */
public interface IG778BL extends BaseBL{

	/**
	 * 根据机柜信息主键取得机柜信息
	 * 
	 * @param eiid 机柜ID
	 * @return 机柜信息
	 */
	public IG778Info searchIG778InfoByKey(Integer eiid);

	/**
	 * 根据检索条件取得机柜信息条数
	 * 
	 * @param cond 机柜信息检索条件
	 * @return 机柜信息条数
	 */
	public int getIG778InfoSearchCount(IG778SearchCond cond);


	/**
	 * 根据检索条件取得机柜信息列表
	 * 
	 * @param cond 机柜信息检索条件
	 * @return 机柜信息列表
	 */
	public List<IG778Info> searchIG778Info(IG778SearchCond cond);
	
	/**
	 * 根据检索条件取得机柜信息列表(分页查询用)
	 * 
	 * @param cond 机柜信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机柜信息列表
	 */
	public List<IG778Info> searchIG778Info(IG778SearchCond cond, int start, int count);
	
	/**
	 * 新建机柜信息处理
	 * 
	 * @param ig778Info 机柜信息
	 * @return 机柜ID
	 * @throws BLException
	 */
	public Integer registIG778Info(IG778Info ig778Info) throws BLException;

	/**
	 * 删除机柜信息处理
	 * 
	 * @param ig778Info 删除的机柜信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG778Info(IG778Info ig778Info) throws BLException;

	/**
	 * 根据机柜主键删除机柜信息处理
	 * 
	 * @param eiid 删除机柜信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG778InfoByKey(Integer eiid) throws BLException;

	/**
	 * 变更机柜信息处理
	 * 
	 * @param ig778Info 变更前的机柜信息
	 * @throws BLException
	 */
	public void updateIG778Info(IG778Info ig778Info) throws BLException;

	/**
	 * 条件检索处理：检索空调和UPS
	 * 
	 * @param cond
	 * @return
	 */
	public List<IG778Info> searchUpsAndAirIG778Info(IG778SearchCond cond);
}
