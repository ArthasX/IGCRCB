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
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;

/**
  * 概述: 流程组成员表DAO实现
  * 功能描述: 流程组成员表DAO实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("unchecked")
public class IG481DAOImpl extends
		BaseHibernateDAOImpl<IG481Info> implements IG481DAO {

	/**
	 * 构造函数
	 */
	public IG481DAOImpl(){
		super(IG481TB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<IG481Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public IG481Info findByPK(Serializable pk) {
		IG481Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG481SearchCond cond){
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
	public List<IG481Info> findByCond(final IG481SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
	
		return findByCriteria(c, start, count);
	}
	
	/**
	 * 根据条件删除
	 * @param cond
	 */
	public void deleteByCond(final IG481SearchCond cond){
		
		delete(this.findByCond(cond, 0, 0));
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG481SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getCreateType())){
			c.add(Restrictions.eq("createType", cond.getCreateType()));
		}
		if(StringUtils.isNotEmpty(cond.getPgdid())){
			c.add(Restrictions.eq("pgdid", cond.getPgdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Restrictions.eq("pdid", cond.getPdid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdid_like())){
			c.add(Restrictions.like("pdid", cond.getPdid_like()+"%"));
		}
		if(cond.getPdids_in()!=null&& cond.getPdids_in().length>0){
			c.add(Restrictions.in("pdid",cond.getPdids_in()));
		}
		return c;
	}
	
	/**
	 * 根据流程定义ID查询组定义列表
	 * @param pdid 流程定义ID
	 * @return 组定义列表
	 */
	public List<IG480Info> searchIG480(final String pdid) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				//获取query
				StringBuffer query = new StringBuffer();
				query.append("select a.* from ig480 a ");
				query.append("inner join ig481 b on (a.pgdid = b.pgdid) ");
				query.append("where b.pdid = :pdid");
				//获取SQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", pdid);
				q.addEntity(IG480TB.class);
				List<IG480Info> lst = q.list();
				session.clear();
				session.close();
				return lst;
			}
		};
		return (List<IG480Info>)execute(action);
	}

}