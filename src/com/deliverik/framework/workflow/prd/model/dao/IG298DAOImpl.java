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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;

/**
  * 概述: 流程状态可分派角色定义信息DAO实现
  * 功能描述: 流程状态可分派角色定义信息DAO实现
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class IG298DAOImpl extends
		BaseHibernateDAOImpl<IG298Info> implements IG298DAO {

	/**
	 * 构造函数
	 */
	public IG298DAOImpl(){
		super(IG298TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG298Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG298Info findByPK(Serializable pk) {
		IG298Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG298SearchCond cond){
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
	public List<IG298Info> findByCond(final IG298SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG298SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPsdid())){
			c.add(Expression.eq("psdid", cond.getPsdid()));
		}
		if(cond.getRoleid() != null && cond.getRoleid() > 0){
			c.add(Expression.eq("roleid", cond.getRoleid()));
		}
		if(StringUtils.isNotEmpty(cond.getPsrdid_like())){
			c.add(Expression.like("psrdid", cond.getPsrdid_like() + "%"));
		}
		return c;
	}
	
	/**
	 * PSRDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSRDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPsrdidSequenceNextValue(String psdid) {
		String sql =  "SELECT MAX(psrd.psrdid) FROM IG298TB psrd WHERE psrd.psrdid LIKE :psdid";
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
	 * @param pdid 流程定义ID
	 * @param psdid 流程状态ID
	 * @return 可被分派的角色列表
	 */
	@SuppressWarnings("unchecked")
	public List<Role> searchToBeAssignRole(final String pdid, final String psdid){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG298DAO.searchToBeAssignRole").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", pdid);
				q.setString("psdid", psdid);
				q.addEntity("role",RoleTB.class);
				setFetchPoint(q, 0, 0);
				List<Role> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<Role>) execute(action);
	}

}