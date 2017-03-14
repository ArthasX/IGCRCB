package com.deliverik.framework.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 资产属性业务逻辑
 * </p>
 */
public interface IG800BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产属性信息对象实例取得
	 * <p>
	 * 
	 * @return 资产属性信息对象实例
	 */

	public IG800TB getIG800TBInstance();

	/**
	 * 根据资产属性信息主键取得资产属性信息
	 * 
	 * @param ciid 资产属性信息主键
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	public IG800Info searchIG800InfoByKey(Integer ciid) throws BLException;

	/**
	 * 根据检索条件取得资产属性信息条数
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息条数
	 */
	public int getIG002InfoSearchCount(IG002SearchCond cond);

	/**
	 * 根据检索条件取得资产属性信息列表
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息列表
	 */
	public List<IG002Info> searchIG002Info(IG002SearchCond cond);
	
	/**
	 * 根据检索条件取得资产属性信息列表(分页查询用)
	 * 
	 * @param cond 资产属性信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性信息列表
	 */
	public List<IG002Info> searchIG002Info(IG002SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性历史纪录信息列表
	 * 
	 * @param eiid 资产ID
	 * @param civersion 资产属性版本号 
	 * 		  -1:检索最新版本
	 *        其他值:检索指定版本
	 *        空白:检索所有版本
	 * @param cismallversion 资产属性小版本号
	 * @param cname 资产属性名称(模糊查询条件)
	 * @return 资产属性历史纪录信息列表
	 */
	public List<IG800Info> searchIG800InfoHistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException;
	
	/**
	 * 保存资产属性信息处理(单个属性处理)
	 * 
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param ig800Info 资产属性信息
	 * @return 
	 */
	public void saveIG800Info(int currentEiversion, IG800Info ig800Info) throws BLException;
	
	/**
	 * 保存资产属性信息处理(多个属性处理)
	 * 
	 * @param eiid 资产ID
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param ig800InfoList 资产属性信息数据列表
	 * @return 
	 */
		public void saveIG800Info(Integer eiid, int currentEiversion, List<IG800Info> ig800InfoList) throws BLException;

	/**
	 * 根据检索条件取得资产属性信息结果条数（平台保留，请使用getIG002InfoSearchCount方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息结果条数
	 */
	public int getIG800InfoSearchCount(IG800SearchCond cond);

	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchIG002Info方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性信息检索结果列表
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchIG002Info方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息检索结果列表
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond);
	
	/**
	 * 新增资产属性信息处理（平台保留）
	 * 
	 * @param ig800Info 资产属性信息
	 * @return 资产属性信息
	 * @throws BLException
	 */
	public IG800Info registIG800Info(IG800Info ig800Info) throws BLException;
	
	/**
	 * 变更资产属性信息处理（平台保留）
	 * 
	 * @param ig800Info 资产属性信息
	 * @return 资产属性信息
	 * @throws BLException
	 */
	public IG800Info updateIG800Info(IG800Info ig800Info) throws BLException;
	
	/**
	 * 登记初始化时根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
	public List<IG002Info> initSearchIG002Info(IG002SearchCond cond, int start, int count);
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);
	
	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException;
	
}
