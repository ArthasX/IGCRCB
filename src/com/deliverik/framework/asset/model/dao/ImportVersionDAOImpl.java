/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.dao;

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

import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.asset.model.entity.ImportVersionTB;
import com.deliverik.framework.asset.model.entity.ImportVersionVW;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * 概述: 导入数据版本管理表DAO实现
  * 功能描述: 导入数据版本管理表DAO实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class ImportVersionDAOImpl extends
		BaseHibernateDAOImpl<ImportVersionInfo> implements ImportVersionDAO {

	/**
	 * 构造函数
	 */
	public ImportVersionDAOImpl(){
		super(ImportVersionTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<ImportVersionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public ImportVersionInfo findByPK(Serializable pk) {
		ImportVersionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ImportVersionSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery(
						"ImportVersionDAO.getSearchCount").getQueryString());
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
	protected void getSQL(ImportVersionSearchCond cond, StringBuffer query) {
		
		// 导入对象实体名称
		if(StringUtils.isNotEmpty(cond.getImpeiname_like())){
			query.append(" AND im.impeiname like ('%'||:impeiname_like||'%')");
			}
		// 导入对象实体名称
		if(StringUtils.isNotEmpty(cond.getImpeiname())){
			query.append(" AND im.impeiname = :impeiname");
		}
		//
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			query.append(" AND im.deleteflag =:deleteflag_eq");
		}
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<ImportVersionInfo> findByCond(final ImportVersionSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
//				query.append(session.getNamedQuery(
//								"ImportVersionDAO.getSearchImportVersion").getQueryString());
				query.append("select impeiname,impversion,impeiid,impcitype,impfilename,");
				query.append("impcreatetime,deleteflag,esyscoding,impip,impuserid,");
				query.append("imppassword,impstatus,eircount,belongcount from importversionvw im where 1=1 ");
				getSQL(cond, query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("im", ImportVersionVW.class);
				setFetchPoint(q, start, count);
				List<ImportVersionVW> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<ImportVersionInfo>) execute(action);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(ImportVersionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//删除标志
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		
		return c;
	}
	
	/**
	 * 导入对象版本检索
	 */
	@SuppressWarnings("unchecked")
	public List<ImportVersionInfo> searchImportVersionByImpname(final String impeiname,final Integer impversion) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("ImportVersionDAO.searchImportVersionByImpname").getQueryString());
				getSQL(impeiname,impversion,query);
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(impeiname);
				q.addEntity("im", ImportVersionTB.class);
				 List<ImportVersionTB> list = q.list();
				session.clear();
				session.close();
				return list.size() > 0 ? list: null;
			}
		};
		return ( List<ImportVersionInfo>) execute(action);
	}
	/**
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(String impeiname,Integer impversion, StringBuffer query) {

			// 导入对象实体名称
			if (impeiname!= null && impeiname != "") {
				query.append(" AND im.impeiname='" +impeiname+ "'");
			}
			// 导入对象版本号
			if (impversion!= null) {
				query.append(" AND im.impversion!=" +impversion);
			}

	}

	/**
	 * 导入对象不存在检查
	 * 
	 * @param impeiname实体名
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public List<ImportVersionInfo> findByImpeiname(final ImportVersionSearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select * from importversion where impeiname='"+cond.getImpeiname()+"'");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("im", ImportVersionTB.class);
				 List<ImportVersionTB> list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return ( List<ImportVersionInfo>) execute(action);
	}
	
}