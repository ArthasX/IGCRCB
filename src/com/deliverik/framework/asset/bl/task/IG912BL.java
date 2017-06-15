package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG912Info;
import com.deliverik.framework.asset.model.IG790Info;
import com.deliverik.framework.asset.model.condition.IG912SearchCond;
import com.deliverik.framework.asset.model.condition.IG790SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 设备信息业务逻辑
 * 
 */
public interface IG912BL extends BaseBL{

	/**
	 * 根据设备信息主键取得设备信息
	 * 
	 * @param eiid 设备ID
	 * @return 设备信息
	 */
	public IG912Info searchIG912InfoByKey(String eiid);

	/**
	 * 根据检索条件取得设备信息结果条数
	 * 
	 * @param cond 设备信息检索条件
	 * @return 设备信息结果条数
	 */
	public int getIG912InfoSearchCount(IG912SearchCond cond);
	
	/**
	 * 根据检索条件取得设备信息列表
	 * 
	 * @param cond 设备信息检索条件
	 * @return 设备信息检索结果列表
	 */
	public List<IG912Info> searchIG912Info(IG912SearchCond cond);


	/**
	 * 根据检索条件取得设备信息列表(分页查询用)
	 * 
	 * @param cond 设备信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 设备信息检索结果列表
	 */
	public List<IG912Info> searchIG912Info(IG912SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得机房设备信息列表
	 * 
	 * @param cond 机房机柜统计分析信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房设备信息检索结果列表
	 */
	public List<IG790Info> searchIG790Info(IG790SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * 根据检索条件取得机房设备信息结果条数
	 * 
	 * @param cond 机房设备信息检索条件
	 * @return 机房设备信息结果条数
	 */
	public int getIG790InfoSearchCount(IG790SearchCond cond) throws BLException;

}
