/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.condition.AssessmentScoreVWSearchCond;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
  * 概述: 评分历史查询DAO实现
  * 功能描述: 评分历史查询DAO实现
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class AssessmentScoreVWDAOImpl extends
		BaseHibernateDAOImpl<AssessmentScoreVWInfo> implements AssessmentScoreVWDAO {

	/**
	 * 构造函数
	 */
	public AssessmentScoreVWDAOImpl(){
		super(AssessmentScoreVW.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<AssessmentScoreVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public AssessmentScoreVWInfo findByPK(Serializable pk) {
		AssessmentScoreVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final AssessmentScoreVWSearchCond cond){
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
	public List<AssessmentScoreVWInfo> findByCond(final AssessmentScoreVWSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	/**
	 * 年度评估报表检索处理
	 * @return 评估年度报表
	 */
	public List<Object[]> assessmentYearReport(final AssessmentScoreVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(session.getNamedQuery("AssessmentScoreDAO.AssessmentOfYearReportVW").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				if(!StringUtils.isEmpty(cond.getCurrentyear())){
					q.setString("currentyear", cond.getCurrentyear()+"%");				
				}
				
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Object[]>)execute(action);
	}
	/**
	 * 部门评估报表检索处理
	 * @return 评估年度报表
	 */
	public List<Object[]> assessmentOrganizationReport(final AssessmentScoreVWSearchCond cond){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append(session.getNamedQuery("AssessmentScoreDAO.AssessmentOfOrganizationReportVW").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				
				if(!StringUtils.isEmpty(cond.getBegintime())&&!StringUtils.isEmpty(cond.getEndtime())){
					q.setString("pdid1", cond.getList().get(0).substring(0, 5)+"%");
					q.setString("pdid2", cond.getList().get(1).substring(0, 5)+"%");
					q.setString("pdid3", cond.getList().get(2).substring(0, 5)+"%");
					q.setString("pdid4", cond.getList().get(3).substring(0, 5)+"%");
					q.setString("BEGINTIME", cond.getBegintime());
					q.setString("ENDTIME", cond.getEndtime());
					q.setString("toporgid", cond.getTopOrgid());
				}
				
				setFetchPoint(q, 0, 0);
				List<Object[]> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Object[]>)execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(AssessmentScoreVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid()!=null){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(cond.getUserid()!= null){
			c.add(Expression.eq("userid", cond.getUserid()));
		}
		return c;
	}

}