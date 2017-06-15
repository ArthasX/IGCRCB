/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.entity.EiDomainDefTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 概述: 资产域定义表DAO实现 功能描述: 资产域定义表DAO实现 创建记录: 2011/04/20 修改记录:
 */
public class EiDomainDefDAOImpl extends BaseHibernateDAOImpl<EiDomainDefInfo>
		implements EiDomainDefDAO {
	static Log log = LogFactory.getLog(EiDomainDefDAOImpl.class);

	/**
	 * 构造函数
	 */
	public EiDomainDefDAOImpl() {
		super(EiDomainDefTB.class);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<EiDomainDefInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pk
	 *            主键
	 * @return 检索结果
	 */
	public EiDomainDefInfo findByPK(Serializable pk) {
		EiDomainDefInfo result = super.findByPK(pk);
		if (result == null)
			return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final EiDomainDefSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();

				query.append(session.getNamedQuery(
						"EiDomainDefDAO.getSearchCount").getQueryString());

				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				session.clear();
				session.close();
				return getCount(q.list());
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(EiDomainDefSearchCond cond, StringBuffer query) {

		// 资产预定义名称
		if (StringUtils.isNotEmpty(cond.getName_like())) {
			query.append(" AND ei.name like ('%'||:name_like||'%')");
		}
		// 开始日期
		if (StringUtils.isNotEmpty(cond.getCreatetime_from())) {
			query.append(" AND ei.createtime >= :createtime_from");
		}
		// 结束日期
		if (StringUtils.isNotEmpty(cond.getCreatetime_to())) {
			query.append(" AND ei.createtime <= :createtime_to");
		}
		
		//域定义ID
		if (StringUtils.isNotEmpty(cond.getEiddid_eq())) {
			query.append(" AND ei.eiddid = " + Integer.parseInt(cond.getEiddid_eq()));
		}
		
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<EiDomainDefInfo> findByCond(final EiDomainDefSearchCond cond,
			final int start, final int count) {
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();

				query.append(session.getNamedQuery(
								"EiDomainDefDAO.getSearchEiDomainDef").getQueryString());
				getSQL(cond, query);
				query.append(" group by ei.eiddid,ei.name,ei.version,ei.description,ei.createtime,ei.updatetime,ei.fingerprint order by ei.createtime desc");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ei", EiDomainDefTB.class);
				q.setProperties(cond);
				setFetchPoint(q, start, count);
				List<EiDomainDefTB> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<EiDomainDefInfo>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(EiDomainDefSearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

	/**
	 * 查询最大EiddId
	 * 
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public Integer findMaxEiddId() {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select max(eiddid) from eidomaindef");
				SQLQuery q = session.createSQLQuery(query.toString());
				List<Integer> list = q.list();
				session.clear();
				session.close();
				return list.size() > 0 && list.get(0) != null ? list.get(0)
						: null;
			}
		};
		return (Integer) execute(action);
	}

	/**
	 * 获取资产域定义版本
	 * @param eiddid
	 * @param version
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EiDomainDefInfo> searchEiDomainDefByPK(final Integer eiddid,final Integer version) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("EiDomainDefDAO.searchEiDomainDefByPK").getQueryString());
				getSQL(eiddid,version,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(eiddid);
				q.addEntity("ei", EiDomainDefTB.class);
				 List<EiDomainDefTB> list = q.list();
				session.clear();
				session.close();
				return list.size() > 0 ? list: null;
			}
		};
		return ( List<EiDomainDefInfo>) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(Integer eiddid,Integer version, StringBuffer query) {

			// 资产域定义ID
			if (eiddid!= null) {
				query.append(" AND ei.eiddid='" +eiddid+ "'");
			}
			// 资产域定义版本号
			if (version!= null) {
				query.append(" AND ei.version!=" +version);
			}

	}

}