package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;



/**
 * 资产信息DAO接口
 * 
 */
public interface SOC0118DAO extends BaseHibernateDAO<SOC0118Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SOC0118Info> findAll();

	/**
	 * 主键检索处理
	 * @param eiid 主键
	 * @return 检索结果
	 */
	public SOC0118Info findByPK(Serializable eiid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0118SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0118Info> findByCond(final SOC0118SearchCond cond, final int start, final int count);
	
	/**
	 * 获取资产编号最大值 资产key+年+编号 （位数：4+2+6）
	 * 
	 * @param cond 资产信息检索条件
	 * @return 资产编号最大值（平台保留）
	 */
	
	public String searchMaxEntityItemLable(final SOC0118SearchCond cond);
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0118Info> searchDeviceService(final SOC0124SearchCond cond, final int start, final int count);
	
	/**
	 * 设备相关服务记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0139VW> searchSwitchService(final String eiid,final String version,final String smallversion);
/**
 * cx记录查询
 * @param strEilabel
 * @return
 */
	public String searchEntityESyscoding(final String strEilabel);
	
	/**自己写的查询*/
	public List<CodeDetailEntity> findByCondSQL(final SOC0118SearchCond cond, final int start, final int count);

	public List<TableSpaceInfo> searchTableRelationInfo(final 
			SOC0118SearchCondImpl soc0118Cond,final int start,final int count);
	
	public Integer updateCutValue(IGCIM1001Form igcim1001Form);
	
	public List<SOC0437Info> searchCutItem(SOC0437SearchCond cond, int start, int count);
	
	public Integer searchCutItemCount(SOC0437SearchCond cond);
	
	/**
	 * 清空资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(final SOC0118SearchCond cond);
	
	/**
	 * 批量插入
	 * @param soc0118List
	 * @throws Exception
	 */
	public void saveEntityItems(List<SOC0118TB> soc0118List)throws Exception;
	
	/**
	 * 执行sql
	 * @param sql
	 * @return
	 */
	public Integer executeSQL(String sql);
	/**
	 * 查询网络设备记录检索
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int getNetDeviceCount(final NetDeviceSearchCond cond);
	
	public List<NetDeviceInfo> searchNetDeviceListByCond(final NetDeviceSearchCond cond, final int start, final int count);
	
	/**
	 * 清空指定eiid的资产的说明
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118SearchCond cond);
	
	/**
	 * 删除eiid和eirootmark在 给定范围内的资产
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids);
	
	/**
	 * 获取主机信息
	 * 配置一致性对比 中 根据业务系统 查询主机时 使用
	 * @param cond
	 * @return
	 */
	public List<Map<String,String>> searchHostList(SOC0118SearchCond cond);
	
	public void deleteEntityItemByEilabel(String eilabel);
	
	public int getEntityItemSearchCountByHost(SOC0118SearchCondImpl cond);

	public List<SOC0118Info> searchEntityItemByHost(SOC0118SearchCondImpl cond,
			int fromCount, int pageDispCount);
	/**
	 * 查询风险库分布情况
	 * @return map key:{riskcont:风险点数量,riskesyscoding:风险点层次码(6位),inspectcont:检查项,inspectesyscoding:检查项层次码(6位),名称}
	 */
	public List<Map> getRiskRepository();
	
}
