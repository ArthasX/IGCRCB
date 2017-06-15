package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;

/**
 * <p>
 * 资产属性业务逻辑
 * </p>
 */
public interface SOC0107BL extends BaseBL{
	
	/**
	 * <p>
	 * 资产属性信息对象实例取得
	 * <p>
	 * 
	 * @return 资产属性信息对象实例
	 */

	public SOC0107TB getSOC0107Instance();
	

	
	/**
	 * 根据检索条件取得资产属性信息列表
	 * 
	 * @param eiid 资产ID
	 * @param civersion 资产属性大版本号 
	 * 			<br>civersion:null检索资产属性所有版本的属性信息。
	 * 			<br>civersion:-1检索资产属性最新版本的属性信息。
	 * 			<br>civersion:其他值检索资产属性对应版本的属性信息。
	 * @param cismallversion 资产属性小版本号
	 * @param cname 资产属性名称(模糊查询条件)
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, 
			Integer civersion, Integer cismallversion, String cname) throws BLException;

	/**
	 * 根据资产属性信息主键取得资产属性信息
	 * 
	 * @param ciid 资产属性信息主键
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	public SOC0107Info searchSOC0107ByKey(Integer ciid) throws BLException;

	/**
	 * 根据检索条件取得资产属性信息条数
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息条数
	 */
	public int getConfigItemVWSearchCount(SOC0129SearchCond cond);

	/**
	 * 根据检索条件取得资产属性信息列表
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息列表
	 */
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond);
	
	/**
	 * 根据检索条件取得资产属性信息列表(分页查询用)
	 * 
	 * @param cond 资产属性信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性信息列表
	 */
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性历史纪录信息列表
	 * 
	 * @param eiid 资产ID
	 * @param civersion 资产属性版本号 
	 * 		  -1:检索最新版本
	 *        其他值:检索指定版本
	 *        空白:检索所有版本
	 * @param cname 资产属性名称(模糊查询条件)
	 * @return 资产属性历史纪录信息列表
	 */
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, Integer civersion, String cname) throws BLException;
	
	/**
	 * 保存资产属性信息处理(单个属性处理)
	 * 
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param configItem 资产属性信息
	 * @return 
	 */
	public void saveSOC0107(int currentEiversion, SOC0107Info soc0107Info) throws BLException;
	
	/**
	 * 保存资产属性信息处理(多个属性处理)
	 * 
	 * @param eiid 资产ID
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param configItemList 资产属性信息数据列表
	 * @return 
	 */
		public void saveSOC0107(Integer eiid, int currentEiversion, List<SOC0107Info> soc0107InfoList) throws BLException;

	/**
	 * 根据检索条件取得资产属性信息结果条数（平台保留，请使用getConfigItemVWSearchCount方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息结果条数
	 */
	public int getSOC0107SearchCount(SOC0107SearchCond cond);

	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond, int start, int count);
	
	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond);
	
	/**
	 * 新增资产属性信息处理（平台保留）
	 * 
	 * @param configItem 资产属性信息
	 * @return 资产属性信息
	 * @throws BLException
	 */
	public SOC0107Info registSOC0107(SOC0107Info soc0107Info) throws BLException;
	
	/**
	 * 变更资产属性信息处理（平台保留）
	 * 
	 * @param configItem 资产属性信息
	 * @return 资产属性信息
	 * @throws BLException
	 */
	public SOC0107Info updateSOC0107(SOC0107Info soc0107Info) throws BLException;
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);

	public String getHostEiid(SOC0107SearchCondImpl cond) throws BLException;
	
	/**
	 * 根据资产模型ID获取属性信息
	 * @param eiid 资产ID
	 * @return List<SOC0107Info>
	 */
	public List<SOC0107Info> getConfigItemByEid(SOC0107SearchCondImpl cond);
	
	/**
	 * 根据检索条件取得资产配置信息结果条数
	 * 
	 * @param cond 资产配置信息检索条件
	 * @return 资产配置信息结果条数
	 */
	public int getSOC0606InfoSearchCount(SOC0606SearchCond cond);
	
	/**
	 * 根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
	public List<SOC0606Info> searchSOC0606Info(SOC0606SearchCond cond, int start, int count);
	
	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException;
	public List<SOC0129Info> searchConfigItemSoc0109VW(SOC0129SearchCond cond, int start, int count)throws BLException;
	
	/**
	 * 根据资产id和config id 查询场景定义流程节点与节点参与人信息
	 * @param cid config id
	 * @param eiid 资产id
	 * @return
	 * @throws BLException
	 */
	public List<Map<String,Object>> searchProcessDefineUserByEiidInfo(String cid,Integer eiid)throws BLException;
}
