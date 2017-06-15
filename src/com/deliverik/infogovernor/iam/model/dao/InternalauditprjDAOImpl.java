/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCond;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;
/**
  * 概述: 内审项目DAO实现
  * 功能描述: 内审项目DAO实现
  * 创建记录: 2012/07/19
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class InternalauditprjDAOImpl extends
		BaseHibernateDAOImpl<InternalauditprjInfo> implements InternalauditprjDAO {

	/**
	 * 构造函数
	 */
	public InternalauditprjDAOImpl(){
		super(InternalauditprjTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<InternalauditprjInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public InternalauditprjInfo findByPK(Serializable pk) {
		InternalauditprjInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final InternalauditprjSearchCond cond){
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
	public List<InternalauditprjInfo> findByCond(final InternalauditprjSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
	public List<InternalauditprjInfo> auditProjectHelpSearch(final InternalauditprjSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("InternalauditprjDAO.projectListInfo").getQueryString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					query.append(" and iapName like :name ");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					query.append(" and iapOpenTime >= :openTime_ge");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					query.append(" and iapOpenTime <= :openTime_le");
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					query.append(" and iapstatus = :status ");
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					query.append(" and iaptype = :type");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					q.setString("name", "%"+cond.getIapName_like()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					q.setString("openTime_le", cond.getIapOpenTimeTo_le());
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					q.setString("openTime_ge", cond.getIapOpenTimeFrom_ge());
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					q.setString("status", cond.getIapStatus_eq());
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					q.setString("type", cond.getIapType_eq());
				}
				q.setFirstResult(start);
				q.setMaxResults(count);
				q.addEntity("a",InternalauditprjTB.class);
				List queryList = q.list();
				Iterator it = queryList.iterator();
				List<InternalauditprjInfo> result = new ArrayList<InternalauditprjInfo>();
				while(it.hasNext()){
					Object obj = (Object)it.next();
					InternalauditprjTB info = (InternalauditprjTB)obj;
					result.add(info);
				}
				List<InternalauditprjInfo> list = result;
				session.clear();
				return list;
			}
		};
		return (List<InternalauditprjInfo>) execute(action);
	}
	
	public int auditProjectHelpSearchConut(final InternalauditprjSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("InternalauditprjDAO.projectListInfo").getQueryString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					query.append(" and iapName like :name ");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					query.append(" and iapOpenTime >= :openTime_ge");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					query.append(" and iapOpenTime <= :openTime_le");
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					query.append(" and iapstatus = :status ");
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					query.append(" and iaptype = :type");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				if(StringUtils.isNotEmpty(cond.getIapName_like())){
					q.setString("name", "%"+cond.getIapName_like()+"%");
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())){
					q.setString("openTime_le", cond.getIapOpenTimeTo_le());
				}
				if(StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())){
					q.setString("openTime_ge", cond.getIapOpenTimeFrom_ge());
				}
				if(StringUtils.isNotEmpty(cond.getIapStatus_eq())){
					q.setString("status", cond.getIapStatus_eq());
				}
				if(StringUtils.isNotEmpty(cond.getIapType_eq())){
					q.setString("type", cond.getIapType_eq());
				}
				q.addEntity("a",InternalauditprjTB.class);
				List queryList = q.list();
				return queryList.size();
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(InternalauditprjSearchCond cond){
		
		DetachedCriteria c = getDetachedCriteria();
		//判断审计项目名称是否为空
		if (StringUtils.isNotEmpty(cond.getIapName_like())) {
			//添加审计项目名称检索条件
			c.add(Expression.like("iapName", "%" + cond.getIapName_like() + "%"));
		}
		//判断年度是否为空
		if (StringUtils.isNotEmpty(cond.getIapYear_eq())) {
			//添加年度检索条件
			c.add(Expression.eq("iapYear", cond.getIapYear_eq()));
		}
		//判断状态是否为空
		if (StringUtils.isNotEmpty(cond.getIapStatus_eq())) {
			//当查询为内审确认时
			if (cond.getIapStatus_eq().equals("a")) {
				//添加状态检索条件
				c.add(Expression.ne("iapStatus", "0"));
			//其他情况
			} else {			
				//添加状态检索条件
				c.add(Expression.eq("iapStatus", cond.getIapStatus_eq()));
			}
		}
		//判断审计日期从是否为空
		if (StringUtils.isNotEmpty(cond.getIapOpenTimeFrom_ge())) {
			//添加审计日期从检索条件
			c.add(Expression.ge("iapOpenTime", cond.getIapOpenTimeFrom_ge()));
		}
		//判断审计日期到是否为空
		if (StringUtils.isNotEmpty(cond.getIapOpenTimeTo_le())) {
			//添加审计日期到检索条件
			c.add(Expression.le("iapOpenTime", cond.getIapOpenTimeTo_le()));
		}
		//判断审计状态是否为空
		if (StringUtils.isNotEmpty(cond.getIapType_eq())) {
			//添加审计状态到检索条件
			c.add(Expression.eq("iapType", cond.getIapType_eq()));
		}
		return c;
	}

}