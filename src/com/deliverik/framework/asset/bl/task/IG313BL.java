package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.condition.IG313SearchCond;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 资产关系业务逻辑
 * </p>
 */

public interface IG313BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产关系信息对象实例取得
	 * <p>
	 * 
	 * @return 资产关系信息对象实例
	 */
	public IG313TB getIG313TBInstance();

	/**
	 * 根据检索条件取得资产关系信息条数
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息条数
	 */
	public int getIG313InfoSearchCount(IG313SearchCond cond);

	/**
	 * 根据资产关系信息主键取得资产关系信息
	 * 
	 * @param eid 资产关系信息主键
	 * @return 资产关系信息
	 */
	public IG313Info searchIG313InfoByKey(Integer eirid) throws BLException;
	
	/**
	 * 根据检索条件取得资产关系信息列表
	 * 
	 * @param cond 资产关系信息检索条件
	 * @return 资产关系信息列表
	 */
	public List<IG313Info> searchIG313Info(IG313SearchCond cond);//必须有
	
	/**
	 * 根据检索条件取得资产关系信息列表(分页查询用)
	 * 
	 * @param cond 资产关系信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产关系信息列表
	 */
	public List<IG313Info> searchIG313Info(IG313SearchCond cond, int start, int count);
	
	/**
	 * 新增资产关系信息处理
	 * 
	 * @param ig313Info 资产关系信息
	 * @return 资产关系信息
	 * @throws BLException
	 */
	public IG313Info registIG313Info(IG313Info ig313Info) throws BLException;
	
	/**
	 * 删除资产关系信息处理
	 * 
	 * @param ig313Info 资产关系信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG313Info(IG313Info ig313Info) throws BLException;
	
	/**
	 * 根据资产关系信息主键删除资产模型信息处理
	 * 
	 * @param eid 资产关系信息主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG313InfoByKey(Integer eid) throws BLException;//必须有


	/**
	 * 变更资产关系信息处理（平台保留）
	 * 
	 * @param ig313Info 资产关系信息
	 * @return 资产关系信息
	 * @throws BLException
	 */
	public IG313Info updateIG313Info(IG313Info ig313Info) throws BLException;
	
	/**
	 * 资产关系信息版本升级处理
	 * 
	 * @param eiid 变更资产ID
	 * @param eiversion 关系表中资产最新大版本
	 * @param eismallversion 关系表中资产最新小版本
	 * @param neweiversion 资产最新大版本
	 * @param neweismallversion 资产最新小版本
	 * @throws BLException 
	 */
	public void upgradeIG313Info(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException;
	
	/**
	 * 资产关系最大版本检索
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG313Info> searchMaxIG313Info(IG313SearchCond cond);

	/**
	 * 合同-服务关系更新
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int version, int i, String[] cldeiids) throws BLException;
	
	/**
	 * 更新无模式关系
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException;
	
}
