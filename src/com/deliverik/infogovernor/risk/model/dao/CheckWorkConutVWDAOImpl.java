/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.CheckWorkConutVWInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckWorkConutVWSearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckWorkConutVW;

/**
  * 概述: 检查工作统计报表DAO实现
  * 功能描述: 检查工作统计报表DAO实现
  * 创建记录: 2014/07/09
  * 修改记录: 
  */
public class CheckWorkConutVWDAOImpl extends
		BaseHibernateDAOImpl<CheckWorkConutVWInfo> implements CheckWorkConutVWDAO {

	/**
	 * 构造函数
	 */
	public CheckWorkConutVWDAOImpl(){
		super(CheckWorkConutVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<CheckWorkConutVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public CheckWorkConutVWInfo findByPK(Serializable pk) {
		CheckWorkConutVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final CheckWorkConutVWSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<CheckWorkConutVWInfo> findByCond(final CheckWorkConutVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CheckWorkDAo.ResultQuery").getQueryString());
				
				if(StringUtils.isNotBlank(cond.getRcrtestmode())){
					query.append(" and rcrtestmode = '"+cond.getRcrtestmode()+"'");
				}
				if(StringUtils.isNotBlank(cond.getHalfyear())){
					query.append(cond.getHalfyear());
				}
				if(StringUtils.isNotBlank(cond.getQuart())){
					query.append(cond.getQuart());
				}
				if(StringUtils.isNotBlank(cond.getYear())){
					query.append(cond.getYear());
				}
				if(StringUtils.isNotBlank(cond.getCg())){
					query.append(cond.getCg());
				}
				query.append(" order by t.rccategoryname");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("t",CheckWorkConutVW.class);
				List<CheckWorkConutVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckWorkConutVWInfo>)execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(CheckWorkConutVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}