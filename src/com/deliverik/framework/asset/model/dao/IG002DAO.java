package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * 资产项配置信息视图DAO接口
 * 
 */
public interface IG002DAO extends BaseHibernateDAO<IG002Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG002SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG002Info> findByCond(final IG002SearchCond cond, final int start, final int count);
	
	public  List<IG002Info> findByCond(final IG002SearchCond cond);
	
	public  List<IG002Info> initFindByCond(final IG002SearchCond cond) ;
}
