/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
  * ����: �������ݰ汾�����DAOʵ��
  * ��������: �������ݰ汾�����DAOʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ImportVersionDAOImpl extends
		BaseHibernateDAOImpl<ImportVersionInfo> implements ImportVersionDAO {

	/**
	 * ���캯��
	 */
	public ImportVersionDAOImpl(){
		super(ImportVersionTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ImportVersionInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ImportVersionInfo findByPK(Serializable pk) {
		ImportVersionInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
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
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(ImportVersionSearchCond cond, StringBuffer query) {
		
		// �������ʵ������
		if(StringUtils.isNotEmpty(cond.getImpeiname_like())){
			query.append(" AND im.impeiname like ('%'||:impeiname_like||'%')");
			}
		// �������ʵ������
		if(StringUtils.isNotEmpty(cond.getImpeiname())){
			query.append(" AND im.impeiname = :impeiname");
		}
		//
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			query.append(" AND im.deleteflag =:deleteflag_eq");
		}
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
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
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ImportVersionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		
		return c;
	}
	
	/**
	 * �������汾����
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
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(String impeiname,Integer impversion, StringBuffer query) {

			// �������ʵ������
			if (impeiname!= null && impeiname != "") {
				query.append(" AND im.impeiname='" +impeiname+ "'");
			}
			// �������汾��
			if (impversion!= null) {
				query.append(" AND im.impversion!=" +impversion);
			}

	}

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param impeinameʵ����
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