/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;



/**
 * 资产项配置信息视图DAO接口
 * 
 */
public interface SOC0606DAO extends BaseHibernateDAO<SOC0606Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0606SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0606Info> findByCond(final SOC0606SearchCond cond, final int start, final int count);
	
	public  List<SOC0606Info> findByCond(final SOC0606SearchCond cond);
	
	public  List<SOC0606Info> initFindByCond(final SOC0606SearchCond cond) ;
}
