package com.deliverik.framework.asset.bl.task;


import java.util.List;

import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.condition.IG445SearchCond;
import com.deliverik.framework.asset.model.condition.IG011SearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;


/**
 * <p>
 * 资产统计业务逻辑
 * </p>
 */
public interface IG189BL extends BaseBL{

	/**
	 * 根据检索条件检索指定资产模型下的资产结果列表
	 * @param cond 检索条件
	 * @return 资产结果列表
	 * @throws BLException
	 */
	public List<IG011Info> searchIG011InfoByEcatory(IG011SearchCond cond) throws BLException;
	
	/**
	 * 设备统计分析处理（平台保留）
	 * 
	 * @param cond 设备统计分析信息检索条件
	 * @return 设备统计分析结果
	 * @throws BLException
	 */
	public List<IG011Info> searchIG011Info(IG011SearchCond cond) throws BLException;

	/**
	 * 设备统计分析处理结果条数取得（平台保留）
	 * 
	 * @param cond 设备统计分析信息检索条件
	 * @return 处理结果条数
	 * @throws BLException
	 */
	public int getIG011InfoSearchCount(IG011SearchCond cond) throws BLException;
	
	/**
	 * 设备使用分布情况统计分析处理（平台保留）
	 * 
	 * @param cond 设备使用分布情况统计分析信息检索条件
	 * @return 设备使用分布情况统计分析结果
	 * @throws BLException
	 */
	public List<IG445Info> searchIG445Info(IG445SearchCond cond) throws BLException;
	
	/**
	 * 设备使用分布情况统计分析处理结果条数取得（平台保留）
	 * @param cond 设备使用分布情况统计分析信息检索条件
	 * @return 设备使用分布情况统计分析处理结果条数
	 * @throws BLException
	 */
	public int getIG445InfoSearchCount(IG445SearchCond cond) throws BLException;
}
