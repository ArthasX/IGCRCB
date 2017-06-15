package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;



/**
 * 资产项配置信息视图DAO接口
 * 
 */
public interface SOC0129DAO extends BaseHibernateDAO<SOC0129Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0129SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0129Info> findByCond(final SOC0129SearchCond cond, final int start, final int count);
	
	
	public  List<SOC0129Info> findByCond(final SOC0129SearchCond cond);
	
	/**
	 * 常熟新资产查询
	 * @param cond
	 * @return
	 */
	public List<SOC0129Info> findSoc0129ByCond(final SOC0129SearchCond cond);
	
	/**
	 * 条件检索处理  常熟资产专用
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0129Info> findByCondSoc0109(final SOC0129SearchCond cond, final int start, final int count);
}
