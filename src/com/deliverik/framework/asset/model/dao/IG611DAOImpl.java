/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCond;
import com.deliverik.framework.asset.model.entity.IG611TB;
import com.deliverik.framework.asset.model.entity.IG612VW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: �ʲ�ģ������ȱʡֵDAOʵ��
  * ��������: �ʲ�ģ������ȱʡֵDAOʵ��
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
public class IG611DAOImpl extends
		BaseHibernateDAOImpl<IG611Info> implements IG611DAO {

	/**
	 * ���캯��
	 */
	public IG611DAOImpl(){
		super(IG611TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG611Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG611Info findByPK(Serializable pk) {
		IG611Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG611SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG611Info> findByCond(final IG611SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG611SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
	
	/**
	 * �ʲ�����Ĭ��ֵȡ��
	 * 
	 * @param cond ��������
	 * @return �ʲ�����Ĭ��ֵ
	 */
	@SuppressWarnings("unchecked")
	public  List<IG612Info> searchDefaultValue(final IG611SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("IG611DAO.searchDefaultValue").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ci",IG612VW.class);
				q.setProperties(cond);
				List<IG611Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<IG612Info>) execute(action);
	}
	
	/**
	 * �ʲ����Գ��ڻ���ѯ
	 * 
	 * @param cond ��������
	 * @return �ʲ�����
	 */
	@SuppressWarnings("unchecked")
	public  List<IG612Info> searchDefaultLabel(final IG611SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("IG611DAO.searchDefaultLabel").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("ci",IG612VW.class);
				q.setProperties(cond);
				List<IG611Info> list = q.list();
				session.clear();
				session.close();
				return list;
			}
				
		};
		return (List<IG612Info>) execute(action);
	}

}