/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.AdvanceDetail;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.model.condition.WorkmanagerSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerTB;
import com.deliverik.infogovernor.dbm.model.entity.WorkmanagerVW;

/**
  * 概述: 工作管理DAO实现
  * 功能描述: 工作管理DAO实现
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class WorkmanagerDAOImpl extends
		BaseHibernateDAOImpl<WorkmanagerInfo> implements WorkmanagerDAO {

	/**
	 * 构造函数
	 */
	public WorkmanagerDAOImpl(){
		super(WorkmanagerTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkmanagerInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkmanagerInfo findByPK(Serializable pk) {
		WorkmanagerInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkmanagerSearchCond cond){
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
	public List<WorkmanagerInfo> findByCond(final WorkmanagerSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("wmstartdate"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(WorkmanagerSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//工作名称
		if(StringUtils.isNotEmpty(cond.getWmname())){
			c.add(Expression.like("wmname", "%"+cond.getWmname()+"%"));
		}
		//工作描述
		if(StringUtils.isNotEmpty(cond.getWmdesc())){
			c.add(Expression.like("wmdesc", "%"+cond.getWmdesc()+"%"));
		}
		//工作状态
		if(StringUtils.isNotEmpty(cond.getWmstatus())){
			c.add(Expression.eq("wmstatus", cond.getWmstatus()));
		}
		//工作发起时间
		if(StringUtils.isNotEmpty(cond.getWmstartdate_from())){
			c.add(Expression.ge("wmstartdate", cond.getWmstartdate_from()));
		}
		if(StringUtils.isNotEmpty(cond.getWmstartdate_to())){
			c.add(Expression.le("wmstartdate", cond.getWmstartdate_to()));
		}
		//频率
		if(StringUtils.isNotEmpty(cond.getWmfrequency())){
			c.add(Expression.like("wmfrequency", "%"+cond.getWmfrequency()+"%"));
		}
		//发起人姓名
		if(StringUtils.isNotEmpty(cond.getWmusername())){
			c.add(Expression.like("wmusername", "%"+cond.getWmusername()+"%"));
		}
		//数据源id
		if(StringUtils.isNotEmpty(cond.getRewmid())){
			c.add(Expression.eq("wmid", cond.getWmusername()));
		}
		//发起日期
		if(StringUtils.isNotEmpty(cond.getWmstartdate())){
			c.add(Expression.like("wmstartdate", cond.getWmstartdate()+"%"));
		}
		//是否提醒
		if(StringUtils.isNotEmpty(cond.getWmremind())){
			c.add(Expression.eq("wmremind", cond.getWmremind()));
		}
		return c;
	}

	/**
	 * 统计待处理工作
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<WorkmanagerVW> searchSumByCond(final WorkmanagerSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer("select wmid,wmname,wmuserid,wmusername from workmanager where wmstatus=0 ");
				List<AdvanceDetail> list = null;
				//工作发起时间
				if(StringUtils.isNotEmpty(cond.getWmstartdate_from())){
					query.append(" and wmlimitdate > '"+cond.getWmstartdate_from()+"'");
				}
				//工作发起时间
				if(StringUtils.isNotEmpty(cond.getWmstartdate_to())){
					query.append(" and wmlimitdate <= '"+cond.getWmstartdate_to()+"'");
				}
				//是否提醒
				if(StringUtils.isNotEmpty(cond.getWmremind())){
					query.append(" and wmremind = "+cond.getWmremind());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("WorkmanagerVW", WorkmanagerVW.class);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<WorkmanagerVW>) execute(action);
	}
	
}