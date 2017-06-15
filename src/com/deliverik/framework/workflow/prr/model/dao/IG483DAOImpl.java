/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
  * 概述: 流程组实例表DAO实现
  * 功能描述: 流程组实例表DAO实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("unchecked")
public class IG483DAOImpl extends
		BaseHibernateDAOImpl<IG483Info> implements IG483DAO {

	/**
	 * 构造函数
	 */
	public IG483DAOImpl(){
		super(IG483TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG483Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG483Info findByPK(Serializable pk) {
		IG483Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG483SearchCond cond){
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
	public List<IG483Info> findByCond(final IG483SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getOrder())){
			if("ASC".equals(cond.getSing())){
				c.addOrder(Order.asc(cond.getOrder()));
			}else{
				c.addOrder(Order.desc(cond.getOrder()));	
			}
		}else{
			c.addOrder(Order.desc("pgrclosetime"));
			c.addOrder(Order.asc("pgropentime"));
			c.addOrder(Order.asc("pgrserialnum"));
		}
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG483SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//流程组发起时间开始
		if(StringUtils.isNotEmpty(cond.getPgropentime_begin())){
			c.add(Restrictions.ge("pgropentime", cond.getPgropentime_begin()));
		}
		//流程组发起时间开始
		if(StringUtils.isNotEmpty(cond.getPgropentime_end())){
			c.add(Restrictions.le("pgropentime", cond.getPgropentime_end() + " 23:59"));
		}
		// 流程组序列号
		if(StringUtils.isNotEmpty(cond.getPgrserialnum_like())){
			c.add(Restrictions.like("pgrserialnum", "%" + cond.getPgrserialnum_like() + "%"));
		}
		// 流程组发起人名称
		if(StringUtils.isNotEmpty(cond.getPgrusername_like())){
			c.add(Restrictions.like("pgrusername", "%" + cond.getPgrusername_like() + "%"));
		}
		// 流程组标题
		if(StringUtils.isNotEmpty(cond.getPgrtitle_like())){
			c.add(Restrictions.like("pgrtitle", "%" + cond.getPgrtitle_like() + "%"));
		}
		// 流程模版类型
		if(StringUtils.isNotEmpty(cond.getPttype())){
			c.add(Restrictions.eq("pttype", cond.getPttype()));
		}
		// 是否测试数据
		if(StringUtils.isNotEmpty(cond.getIstest())){
			c.add(Restrictions.eq("istest", cond.getIstest()));
		}
		// 流程组定义ID
		if(StringUtils.isNotEmpty(cond.getPgdid())){
			c.add(Restrictions.eq("pgdid", cond.getPgdid()));
		}
		// 是否关闭
		if(cond.isActive()){
			c.add(Restrictions.isNull("pgrclosetime"));
		}
		return c;
	}
	
	/**
	 * 查询当前默认最大流水号（WG+2位年+6位流水）
	 * @param pgrserialnum 流水号
	 * @return 最大流水号
	 */
	@SuppressWarnings("rawtypes")
	public String getMaxPgrserialnum(String pgrserialnum){
		
		String sql =  "select max(prg.pgrserialnum) from IG483TB prg where prg.pgrserialnum like :pgrserialnum";
		NamedParamMap p = getNamedParamMap();
		p.setString("pgrserialnum", pgrserialnum+"%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
	}
	
	/**
	 * 查询流程组成员列表
	 * @param pgrid 流程组ID
	 * @return 流程组成员列表
	 */
	public List<IG500Info> searchProcess(final Integer pgrid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select a.* from ig500 a ");
				query.append("inner join ig484 b on (a.prid = b.prid) ");
				query.append("where b.pgrid = :pgrid order by a.prclosetime desc, a.propentime asc, a.prserialnum");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("pgrid", pgrid);
				q.addEntity(IG500TB.class);
				List<IG485VW> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG500Info>)execute(action);
	}
	
	/**
	 * 查询流程组外发起的流程prid
	 * @param pgrid 检索条件-流程组实例ID
	 */
	public List<Map<String,Object>> searchProcessInfoByCond(final int pgrid) {
		
		Session session = getSession();
		
		StringBuffer sql = new StringBuffer();
		sql.append("select a.prid as prid from ig484 a ");
		sql.append("inner join ig483 b on  b.pgrid = a.pgrid ");
		sql.append("inner join ig481 c on  c.pgdid = b.pgdid and c.pdid= a.pdid and c.createtype = '0' ");
		sql.append("where a.pgrid=:pgrid ");
		SQLQuery q = session.createSQLQuery(sql.toString());
		q.setInteger("pgrid", pgrid);
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("PRID", Hibernate.STRING);
		return q.list();
	  }
}