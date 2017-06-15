/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0604SearchCond;

/**
 * 设备信息业务逻辑
 * 
 */
public interface SOC0602BL extends BaseBL{

	/**
	 * 根据设备信息主键取得设备信息
	 * 
	 * @param eiid 设备ID
	 * @return 设备信息
	 */
	public SOC0602Info searchSOC0602InfoByKey(String eiid);

	/**
	 * 根据检索条件取得设备信息结果条数
	 * 
	 * @param cond 设备信息检索条件
	 * @return 设备信息结果条数
	 */
	public int getSOC0602InfoSearchCount(SOC0602SearchCond cond);
	
	/**
	 * 根据检索条件取得设备信息列表
	 * 
	 * @param cond 设备信息检索条件
	 * @return 设备信息检索结果列表
	 */
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond);


	/**
	 * 根据检索条件取得设备信息列表(分页查询用)
	 * 
	 * @param cond 设备信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 设备信息检索结果列表
	 */
	public List<SOC0602Info> searchSOC0602Info(SOC0602SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得机房设备信息列表
	 * 
	 * @param cond 机房机柜统计分析信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房设备信息检索结果列表
	 */
	public List<SOC0604Info> searchSOC0604Info(SOC0604SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * 根据检索条件取得机房设备信息结果条数
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息结果条数
	 */
	public int getSOC0604InfoSearchCount(SOC0604SearchCond cond) throws BLException;
	
	/**
     * 条件检索处理：模糊查询设备名，返回设备所在机柜，机房
     * 
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<Object[]> findZhiJiLocation(SOC0602SearchCond cond);

}
