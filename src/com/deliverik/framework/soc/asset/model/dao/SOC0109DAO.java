package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;



/**
 * 资产配置信息DAO接口
 * 
 */
public interface SOC0109DAO extends BaseHibernateDAO<SOC0109Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<SOC0109Info> findAll();

	/**
	 * 主键检索处理
	 * @param cid 主键
	 * @return 检索结果
	 */
	public SOC0109Info findByPK(Serializable cid);

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0109SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0109Info> findByCond(final SOC0109SearchCond cond, final int start, final int count);

	/**
	 * 获取最大CID用
	 * @param cond
	 * @return
	 */
	public List<SOC0109Info> findMaxCidByCond(final SOC0109SearchCond cond);
}
