package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCondImpl;



/**
 * 资产配置项信息DAO接口
 * 
 */
public interface SOC0107VWDAO extends BaseHibernateDAO<SOC0107VWInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0107VWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0107VWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0107VWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0107VWInfo> findByCond(
			final SOC0107VWSearchCond cond, final int start,
			final int count);
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);

	public String getHostEiid(SOC0107VWSearchCondImpl cond);
	
	/**
	 * 根据资产模型ID获取属性信息
	 * @param eiid 资产ID
	 * @return List<SOC0107VWInfo>
	 */
	public List<SOC0107VWInfo> getConfigItemByEid(final SOC0107VWSearchCondImpl cond);
	
	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException;
}
