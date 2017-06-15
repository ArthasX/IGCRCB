package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCond;



/**
 * 资产配置信息DAO接口
 * 
 */
public interface SOC0109VWDAO extends BaseHibernateDAO<SOC0109VWInfo> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SOC0109VWInfo> findAll();

	/**
	 * 主键检索处理
	 * @param cid 主键
	 * @return 检索结果
	 */
	public SOC0109VWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0109VWSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0109VWInfo> findByCond(final SOC0109VWSearchCond cond, final int start, final int count);

	/**
	 * 获取最大CID用
	 * @param cond
	 * @return
	 */
	public List<SOC0109VWInfo> findMaxCidByCond(final SOC0109VWSearchCond cond);
}
