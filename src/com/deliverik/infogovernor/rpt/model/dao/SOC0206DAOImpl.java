/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0206SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0206TB;

/**
  * 概述: 模板映射表DAO实现
  * 功能描述: 模板映射表DAO实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateMappingDAOImpl表名修改为SOC0206DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0206DAOImpl extends
		BaseHibernateDAOImpl<SOC0206Info> implements SOC0206DAO {

	/**
	 * 构造函数
	 */
	public SOC0206DAOImpl(){
		super(SOC0206TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0206Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0206Info findByPK(Serializable pk) {
		SOC0206Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0206SearchCond cond){
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
	public List<SOC0206Info> findByCond(final SOC0206SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SOC0206SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getRtId_eq()!=null) {
			c.add(Expression.eq("rtId", cond.getRtId_eq()));
		}
		if (cond.getRtNumber_eq()!=null) {
			c.add(Expression.eq("rtNumber", cond.getRtNumber_eq()));
		}
		c.addOrder(Order.asc("rtNumber"));
		return c;
	}
	/**根据ID删除*/
	public Integer deleteByRtId(final Integer rtId){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				Query query1=session.createSQLQuery("delete from reporttemplatemapping where rtid=:rtid");
				query1.setParameter("rtid", rtId);
				int tmp=query1.executeUpdate();
				session.clear();
				return tmp;
			}
		};
		
		return (Integer) execute(action);
	}

}