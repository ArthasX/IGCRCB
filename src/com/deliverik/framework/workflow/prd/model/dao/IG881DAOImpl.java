/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

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

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG100VW;
import com.deliverik.framework.workflow.prd.model.entity.IG881TB;

/**
 * 
 * 流程参与者变量权限DAO实现
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("deprecation")
public class IG881DAOImpl extends BaseHibernateDAOImpl<IG881Info> implements IG881DAO{

	/**
	 * 构造函数
	 */
	public IG881DAOImpl(){
		super(IG881TB.class);
	}
	
	
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG881Info> findAll(){
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pipdid"));
		List<IG881Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 主键检索处理
	 * @param pipdid 主键
	 * @return 检索结果
	 */
	public IG881Info findByPK(Serializable pipdid){
		IG881Info processInfoParticipantDef = super.findByPK(pipdid);
		
		if(processInfoParticipantDef == null) return null;

		return processInfoParticipantDef;
	}
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG881SearchCond cond){
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
	public List<IG881Info> findByCond(final IG881SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		List<IG881Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG881SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();		
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPpdid())){
			c.add(Expression.eq("ppdid", cond.getPpdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPipdid_like())){
			c.add(Expression.like("pipdid", cond.getPipdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG100Info> findByCond(final IG100SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG881DAO.searchIG100").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("IG100VW", IG100VW.class);
				setFetchPoint(q, 0, 0);
				List<IG100Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG100Info>) execute(action);
	}
	
	/**
	 * PIPDID主键值取得
	 * 
	 * @param 流程状态参与者定义ID
	 * @return PIPDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPipdidSequenceNextValue(String ppdid) {
		String sql =  "SELECT MAX(pipd.pipdid) FROM IG881TB pipd WHERE pipd.pipdid LIKE :ppdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("ppdid", ppdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return ppdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return ppdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(ppdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
	
}
