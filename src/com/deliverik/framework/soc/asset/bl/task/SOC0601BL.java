/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCond;

/**
 * 机房信息业务逻辑
 * 
 */
public interface SOC0601BL extends BaseBL{

	/**
	 * 根据机房信息主键取得机房信息
	 * 
	 * @param eiid 机房信息主键
	 * @return 机房信息
	 */
	public SOC0601Info searchSOC0601InfoByKey(String eiid);

	/**
	 * 根据检索条件取得机房信息结果条数
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息结果条数
	 */
	public int getSOC0601InfoSearchCount(SOC0601SearchCond cond);

	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息检索结果列表
	 */
	public List<SOC0601Info> searchSOC0601Info(SOC0601SearchCond cond);
	
	/**
	 * 根据检索条件取得机房信息列表(分页查询用)
	 * 
	 * @param cond 机房信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房信息检索结果列表
	 */
	public List<SOC0601Info> searchSOC0601Info(SOC0601SearchCond cond, int start, int count);
	
	/**
	 * 新建机房信息处理
	 * 
	 * @param SOC0601Info 机房信息
	 * @return 机房ID
	 * @throws BLException
	 */
	public Integer registSOC0601Info(SOC0601Info SOC0601Info) throws BLException;

	/**
	 * 删除机房信息处理
	 * 
	 * @param SOC0601Info 删除的机房信息
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0601Info(SOC0601Info SOC0601Info) throws BLException;

	/**
	 * 根据机房主键删除机房信息处理
	 * 
	 * @param eiid 删除机房信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0601InfoByKey(Integer eiid) throws BLException;

	/**
	 * 变更机房信息处理
	 * 
	 * @param SOC0601Info 变更前的机房信息
	 * @throws BLException
	 */
	public void updateSOC0601Info(SOC0601Info SOC0601Info) throws BLException;


}
