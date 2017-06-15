/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;

/**
 * 机柜信息业务逻辑
 * 
 */
public interface SOC0603BL extends BaseBL{

	/**
	 * 根据机柜信息主键取得机柜信息
	 * 
	 * @param eiid 机柜ID
	 * @return 机柜信息
	 */
	public SOC0603Info searchSOC0603InfoByKey(String eiid);

	/**
	 * 根据检索条件取得机柜信息条数
	 * 
	 * @param cond 机柜信息检索条件
	 * @return 机柜信息条数
	 */
	public int getSOC0603InfoSearchCount(SOC0603SearchCond cond);


	/**
	 * 根据检索条件取得机柜信息列表
	 * 
	 * @param cond 机柜信息检索条件
	 * @return 机柜信息列表
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond);
	
	/**
	 * 根据检索条件取得机柜信息列表(分页查询用)
	 * 
	 * @param cond 机柜信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机柜信息列表
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond, int start, int count);
	
	/**
	 * 新建机柜信息处理
	 * 
	 * @param SOC0603Info 机柜信息
	 * @return 机柜ID
	 * @throws BLException
	 */
	public Integer registSOC0603Info(SOC0603Info SOC0603Info) throws BLException;

	/**
	 * 删除机柜信息处理
	 * 
	 * @param SOC0603Info 删除的机柜信息
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603Info(SOC0603Info SOC0603Info) throws BLException;

	/**
	 * 根据机柜主键删除机柜信息处理
	 * 
	 * @param eiid 删除机柜信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603InfoByKey(Integer eiid) throws BLException;

	/**
	 * 变更机柜信息处理
	 * 
	 * @param SOC0603Info 变更前的机柜信息
	 * @throws BLException
	 */
	public void updateSOC0603Info(SOC0603Info SOC0603Info) throws BLException;

	/**
	 * 条件检索处理：检索空调和UPS
	 * 
	 * @param cond
	 * @return
	 */
	public List<SOC0603Info> searchUpsAndAirSOC0603Info(SOC0603SearchCond cond);
}
