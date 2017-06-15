package com.deliverik.framework.soc.asset.bl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;

/**
 * 资产信息业务逻辑
 * 
 */
public interface SOC0118VWBL extends BaseBL{
	
	/**
	 * <p>
	 * 资产信息对象实例取得
	 * <p>
	 * 
	 * @return 资产信息对象实例
	 */

	public SOC0118VW getEntityItemTBInstance();

	/**
	 * 根据检索条件取得资产信息件数
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息件数
	 */
	public int getEntityItemSearchCount(SOC0118VWSearchCond cond);

	/**
	 * 根据资产信息主键取得资产信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 资产信息
	 */
	public SOC0118VWInfo searchEntityItemByKey(SOC0118VWPK pk) throws BLException;
	
	/**
	 * 根据检索条件取得资产信息列表
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产信息列表
	 */
	public List<SOC0118VWInfo> searchEntityItem(SOC0118VWSearchCond cond);

	/**
	 * 根据检索条件取得资产信息列表(分页查询用)
	 * 
	 * @param cond 资产信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产信息列表
	 */
	public List<SOC0118VWInfo> searchEntityItem(SOC0118VWSearchCond cond, int start, int count);

	/**
	 * 新增资产信息处理
	 * 
	 * @param entityItem 资产信息
	 * @return 资产信息
	 * @throws BLException
	 */
	public SOC0118VWInfo registEntityItemAndConfigItem(SOC0118VWInfo entityItem) throws BLException;
	
	/**
	 * 风险事件登记
	 * 
	 * @param entityItem 保存的资产信息数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	public SOC0118VWInfo registRiskCase(SOC0118VWInfo entityItem) throws BLException;
	
	/**
	 * 删除资产信息处理
	 * 
	 * @param entityItem 资产信息
	 * @return
	 * @throws BLException
	 */
//	public void deleteEntityItem(SOC0118VWInfo entityItem) throws BLException;
	
	/**
	 * 根据资产信息主键删除资产信息处理
	 * 
	 * @param eiid 删除资产信息的主键
	 * @return
	 * @throws BLException
	 */
//	public void deleteEntityItemByKey(Integer eiid) throws BLException;

	/**
	 * 变更资产信息处理
	 * 
	 * @param entityItem 资产信息
	 * @return 资产信息
	 * @throws BLException
	 */
	public SOC0118VWInfo updateEntityItem(SOC0118VWInfo entityItem) throws BLException;
	
	/**
	 * 资产信息不存在检查
	 * 
	 * @param eilabel 资产编号
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistEntityItem(String eilabel) throws BLException;
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
//	public SOC0124Info searchEntityItemVWByKey(Integer eiid) throws BLException;

	/**
	 * 资产及其所属模型信息条件检索结果件数取得
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息件数
	 */
//	public int getEntityItemVWSearchCount(SOC0124SearchCond cond);
	
	/**
	 * 根据检索条件取得资产及其所属模型信息列表
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @return 资产及其所属模型信息列表
	 */
//	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond);


	/**
	 * 根据检索条件取得资产及其所属模型信息列表(分页查询用)
	 * 
	 * @param cond 资产及其所属模型信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产及其所属模型信息列表
	 */
//	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond, int start, int count);
	
	/**
	 * 判断登陆用户是否有查看该资产属性信息的权限
	 * 
	 * @param user 用户信息
	 * @param entityItemVWInfo 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
//	public boolean checkEntityItemDomain(User user,SOC0124Info entityItemVWInfo) throws BLException;
	
	/**
	 * 新增资产信息处理（平台保留）
	 * 
	 * @param entityItem 资产信息
	 * @return 资产信息
	 * @throws BLException
	 */
	public SOC0118VWInfo registEntityItem(SOC0118VWInfo entityItem) throws BLException;
	
	/**
	 * 获取当前可用资产编号 资产key+年+编号 （位数：4+2+6）
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号（平台保留）
	 */
	public String searchNextEntityItemLable(SOC0118VWSearchCond cond) throws BLException;

	/**
	 * 获取当前可用资产编号 资产key+设备类型code+编号 （位数：10+2+7）阜新银行专用
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号（平台保留）
	 */
	public String searchNextEntityItemLableFX(SOC0118VWSearchCond cond) throws BLException;

	/**
	 *  获取资产历史版本更新时间
	 * 
	 * @param eiid 资产ID
	 * @return 各版本更新时间
	 * @throws BLException 
	 */
//	public List<SOC0128Info> searchVersionUpdateTime(Integer eiid) throws BLException;
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0118VWInfo> searchDeviceService(final SOC0124SearchCond cond, final int start, final int count);
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
//	public SOC0123Info searchEntityItemEntityVWByKey(Integer eiid) throws BLException;
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
//	public List<SOC0139VW> searchSwitchService(final String eiid,final String version,final String smallversion);
	
	/**
	 * 查询CX
	 * @param strEilabel
	 * @return
	 */
	public String searchEntityESyscoding(String strEilabel);
	
	/**
	 * 条件检索处理sql
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<CodeDetailEntity> searchCodeDetailSQL(SOC0118VWSearchCond cond);

	public List<TableSpaceInfo> searchTableRelationInfo(
			SOC0118VWSearchCondImpl soc0118Cond, int start, int count);
	/**
	 * 表空间预警设定阀值
	 * @param cond
	 * @return
	 */
//	public void updateCutValue(IGCIM1001Form igcim1001Form);
	/**
	 * 表空间预警
	 * @param cond
	 * @return
	 */
//	public List<SOC0437Info> searchCutItem(SOC0437SearchCond cond, int start, int count);
	
	public Integer searchCutItemCount(SOC0437SearchCond cond);
	
	/**
	 * 清空资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(final SOC0118VWSearchCond cond) throws BLException;
	
	/**
	 * 批量插入
	 * @param soc0118List
	 * @throws Exception
	 */
//	public void saveEntityItems(List<SOC0118VW> soc0118List)throws Exception;
	
	/**
	 * 执行sql
	 * @param sql
	 * @return
	 */
	public Integer executeSQL(String sql)throws BLException;
	
	public int getNetDeviceInfoListCount(NetDeviceSearchCond Cond);
	
	public List<NetDeviceInfo> searchNetDeviceInfoList(NetDeviceSearchCond Cond, int start, int count);
	
	
	/**
	 * 清空指定eiid的资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118VWSearchCond cond)throws BLException;
	
	/**
	 * 删除eiid和eirootmark在 给定范围内的资产
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids)throws BLException;
	
	/**
	 * 根据资产信息主键取得资产及其所属模型信息
	 * 
	 * @param eiid 资产信息主键
	 * @return 根据资产信息主键取得资产及其所属模型信息
	 * @throws BLException 
	 */
//	public SOC0605Info searchSOC0605InfoByKey(Integer eiid) throws BLException;
	
	/**
	 * 判断登陆用户是否有查看该资产配置信息的权限
	 * 
	 * @param user 用户信息
	 * @param SOC0605Info 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkSOC0605InfoDomain(User user,SOC0605Info soc0605Info) throws BLException;
	
	/**
	 * 获取主机信息
	 * 配置一致性对比 中 根据业务系统 查询主机时 使用
	 * @param cond
	 * @return
	 */
	public List<Map<String,String>> searchHostList(SOC0118VWSearchCond cond)throws BLException;
	
	public void deleteEntityItemByEilabel(String eilabel)throws BLException;
	
	public int getEntityItemSearchCountByHost(SOC0118VWSearchCondImpl cond) throws BLException;

	public List<SOC0118VWInfo> searchEntityItemByHost(SOC0118VWSearchCondImpl cond,
			int fromCount, int pageDispCount)throws BLException;
	
	/**
	 * 风险领域缩写+X+二级分类序号+三级分类序号+风险检查项序号
	 * （两位或三位） X     （两位）         （两位）      （三位） IG-X0101-001
	 * @param cond 资产信息检索条件
	 * @return 资产编号（平台保留）
	 * 
	 */
	public String searchNewNextEntityItemLable(SOC0118VWSearchCond cond) throws BLException;
	
	/**
	 * 查询风险库分布情况
	 * @return map key:{riskcont:风险点数量,riskesyscoding:风险点层次码(6位),inspectcont:检查项,inspectesyscoding:检查项层次码(6位),名称}
	 */
	public List<Map> getRiskRepository()throws BLException;


	/**
	 *  获取 风险点+检查项  条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchAssessRisk(RehearseSearchCond cond, int start, int count) throws BLException;
	/**
	 * 获取 评估工作选择的本年度风险点+检查项  条件查询 分页
	 * @param cond
	 * @param start
	 * @param count
	 * @return  key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchRiskInfo(RehearseSearchCond cond, int start, int count) throws BLException;
	/**
	 * 主键检索处理
	 * @param pk主键
	 * @return 检索结果
	 */
	public List<SOC0118VWInfo> findByPKs(List<SOC0118VWPK> PKs);
	/**
	 * 查询应急资源关联的资产集合
	 * @return List<SOC0118VWInfo>
	 */
	public List<SOC0118VWInfo> getEmergencyRelationList(SOC0118VWSearchCond cond, final int start, final int count);
	/**
	 * 查询应急资源关联的资产集合
	 * @return List<SOC0118VWInfo>
	 */
	public Integer getEmergencyRelationCount(SOC0118VWSearchCond cond);

	/**
	 * 判断登陆用户是否有查看该资产配置信息的权限
	 * 
	 * @param user 用户信息
	 * @param entityItemVWInfo 资产及其所属模型信息
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkEntityItemDomain(User user,SOC0118VWInfo entityItemVWInfo) throws BLException;
}
