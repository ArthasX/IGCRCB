package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;



/**
 * 资产配置项信息DAO接口
 * 
 */
public interface SOC0107DAO extends BaseHibernateDAO<SOC0107Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SOC0107Info> findAll();

	/**
	 * 主键检索处理
	 * @param ciid 主键
	 * @return 检索结果
	 */
	public SOC0107Info findByPK(Serializable ciid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0107SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond, final int start, final int count);
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);

	public String getHostEiid(SOC0107SearchCondImpl cond);
	
	/**
	 * 根据资产模型ID获取属性信息
	 * @param eiid 资产ID
	 * @return List<SOC0107Info>
	 */
	public List<SOC0107Info> getConfigItemByEid(final SOC0107SearchCondImpl cond);
	
	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException;
	

	/**
	 * 根据资产id和config id 查询场景定义流程节点与节点参与人信息
	 * @param cid config id
	 * @param eiid 资产id
	 * @return
	 * @throws BLException
	 */
	public List<Map<String,Object>> searchProcessDefineUserByEiidInfo(String cid,Integer eiid)throws BLException;
}
