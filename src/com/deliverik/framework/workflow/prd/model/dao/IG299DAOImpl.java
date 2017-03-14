/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG299TB;

/**
  * 概述: 状态可分派机构定义表DAO实现
  * 功能描述: 状态可分派机构定义表DAO实现
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG299DAOImpl extends
		BaseHibernateDAOImpl<IG299Info> implements IG299DAO {

	/**
	 * 构造函数
	 */
	public IG299DAOImpl(){
		super(IG299TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG299Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG299Info findByPK(Serializable pk) {
		IG299Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG299SearchCond cond){
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
	public List<IG299Info> findByCond(final IG299SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG299SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		// 状态节点
		if(StringUtils.isNotEmpty(cond.getPsdid_eq())){
			c.add(Expression.eq("psdid", cond.getPsdid_eq()));
		}
		// 流程状态节点指定可分派机构主键模糊查询
		if(StringUtils.isNotEmpty(cond.getPsodid_like())){
			c.add(Expression.eq("psodid", cond.getPsodid_like()));
		}
		// 流程状态节点指定可分派机构码精确查询
		if(StringUtils.isNotEmpty(cond.getOrgsyscoding_eq())){
			c.add(Expression.eq("orgsyscoding", cond.getOrgsyscoding_eq()));
		}
		if(StringUtils.isNotEmpty(cond.getPsdid_like())){
			c.add(Expression.like("psdid", cond.getPsdid_like()+"%"));
		}
		return c;
	}

	/**
	 * PSODID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSODID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPsrdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(psod.psodid) FROM IG299TB psod WHERE psod.psodid LIKE :psdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("psdid", psdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return psdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return psdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(psdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}
	
	/**
	 * 可被分派的角色检索处理
	 * @param pdid 流程类型ID
	 * @param levellen 机构的当前级数
	 * @param psdid 流程状态节点ID
	 * @return 可被分派的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<Organization> searchToBeAssignOrg(final String pdid, final int levellen, final String psdid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG299DAO.searchToBeAssignOrg").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", pdid);
				q.setInteger("levellen", levellen);
				q.setString("psdid", psdid);
				q.addEntity("org",OrganizationTB.class);
				setFetchPoint(q, 0, 0);
				List<Organization> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Organization>) execute(action);
	}
	
}