/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG221VW;

/**
  * ����: �����߰�ť������Ϣ����ͼDAOʵ��
  * ��������: �����߰�ť������Ϣ����ͼDAOʵ��
  * ������¼: 2012/04/19
  * �޸ļ�¼: 
  */
public class IG221DAOImpl extends
		BaseHibernateDAOImpl<IG221Info> implements IG221DAO {

	/**
	 * ���캯��
	 */
	public IG221DAOImpl(){
		super(IG221VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG221Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG221Info findByPK(Serializable pk) {
		IG221Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG221SearchCond cond){
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
	@SuppressWarnings("unchecked")
	public List<IG221Info> findByCond(final IG221SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG132DAO.ButtonQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("ppdid", cond.getPpdid());
				q.addEntity("pd",IG221VW.class);
				setFetchPoint(q, 0, 0);
				List<IG221Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG221Info>) execute(action);
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
	public List<IG221Info> findDefaultByCond(final IG221SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG132DAO.DefaultButtonQuery").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("psdid", cond.getPsdid());
				q.addEntity("pd",IG221VW.class);
				setFetchPoint(q, 0, 0);
				List<IG221Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG221Info>) execute(action);
	}
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG221SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}