/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.risk.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.condition.RiskCheckSearchCond;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckTB;

/**
 * 风险检查DAO实现
 * @author lipeng@deliverik.com
 */
@SuppressWarnings("unchecked")
public class RiskCheckDAOImpl extends BaseHibernateDAOImpl<RiskCheck> implements RiskCheckDAO {

	/**
	 * 构造函数
	 */
	public RiskCheckDAOImpl(){
		super(RiskCheckTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<RiskCheck> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rcid"));
		List<RiskCheck> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rcid 主键
	 * @return 检索结果
	 */
	public RiskCheck findByPK(Serializable rcid) {

		RiskCheck result = super.findByPK(rcid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskCheckSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheck> findByCond(final RiskCheckSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("rcstatus"));
		c.addOrder(Order.desc("rccreatetime"));
		c.addOrder(Order.desc("rccategory"));
		c.addOrder(Order.desc("rcid"));
		List<RiskCheck> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(RiskCheckSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//风险检查名id
		if(cond.getRcasset() != null){
			c.add(Restrictions.eq("rcasset", cond.getRcasset()));
		}
		//风险检查名
		if( !StringUtils.isEmpty(cond.getRcname_q())){
			c.add(Restrictions.like("rcname","%" + cond.getRcname_q() + "%"));
		}
		//风险检查名
		if( !StringUtils.isEmpty(cond.getRcname())){
			c.add(Restrictions.eq("rcname", cond.getRcname()));
		}
		//风险检查项说明
		if( !StringUtils.isEmpty(cond.getRcdesc())){
			c.add(Restrictions.eq("rcdesc", cond.getRcdesc()));
		}
		//责任人ID
		if(StringUtils.isNotEmpty(cond.getRcuserid())){
			c.add(Restrictions.eq("rcuserid", cond.getRcuserid()));
		}
		//检查项类别
		if( StringUtils.isNotEmpty(cond.getRccategory())){
			c.add(Restrictions.eq("rccategory", cond.getRccategory()));
		}
		//检查项状态
		if(StringUtils.isNotEmpty(cond.getRcstatus())){
			c.add(Restrictions.eq("rcstatus", cond.getRcstatus()));
		}
		//责任组名称
		if(StringUtils.isNotEmpty(cond.getRcrolename())){
			c.add(Restrictions.like("rcrolename", "%"+cond.getRcrolename()+"%"));
		}
		
		//责任人姓名
		if(StringUtils.isNotEmpty(cond.getRcusername())){
			c.add(Restrictions.like("rcusername", "%"+cond.getRcusername()+"%"));
		}
		
		//类型
		if(StringUtils.isNotEmpty(cond.getRcclass())){
			c.add(Restrictions.eq("rcclass", cond.getRcclass()));
		}
		if(cond.getRcid_in()!=null &&  cond.getRcid_in().length>0){
			c.add(Restrictions.in("rcid", cond.getRcid_in()));
		}
		
		
		//频率
		if(StringUtils.isNotEmpty(cond.getRcfrequency())){
			c.add(Restrictions.eq("rcfrequency", cond.getRcfrequency()));
		}
		if(StringUtils.isNotEmpty(cond.getRcCreateTime_like())){
			c.add(Restrictions.like("rccreatetime", cond.getRcCreateTime_like() + "%"));
		}
		return c;
	}
	public List<RiskCheck> dbmselByrcclass() {
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append(session.getNamedQuery("RiskCheckResultDAOImpl.dbmselByrcclass").getQueryString());
					SQLQuery q = session.createSQLQuery(query.toString());
					setFetchPoint(q, 0, 0);
					q.addEntity("t",RiskCheckTB.class);
					List<RiskCheck> list = q.list();
					session.clear();
					return list;
				}
			};
			return (List<RiskCheck>) execute(action);
	}
	public List<RiskCheck> getRcclassByMonth(final RiskCheckSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskCheckResultDAOImpl.getrcclassbymonth").getQueryString());
				if(StringUtils.isNotEmpty(cond.getYearMonth())){
					query.append(" and  rccreatetime like '"+cond.getYearMonth()+"%' ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				setFetchPoint(q, 0, 0);
				q.addEntity("t",RiskCheckTB.class);
				List<RiskCheck> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RiskCheck>) execute(action);
	}

	public List<RiskCheck> getRcTestMode(final RiskCheckSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("RiskCheckResultDAOImpl.getrcclassbymonth").getQueryString());
				if(StringUtils.isNotEmpty(cond.getStartDate()) && StringUtils.isNotEmpty(cond.getEndDate())){
					query.append(" and  rccreatetime<= '"+cond.getEndDate()+"' and '"+cond.getStartDate()+"' <=rccreatetime ");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				setFetchPoint(q, 0, 0);
				q.addEntity("t",RiskCheckTB.class);
				List<RiskCheck> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<RiskCheck>) execute(action);
	}


}
