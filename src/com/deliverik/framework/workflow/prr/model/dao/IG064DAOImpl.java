/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

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
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG064VW;

/**
  * ����: ���̼�¼�ڵ�������ͼDAOʵ��
  * ��������: ���̼�¼�ڵ�������ͼDAOʵ��
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public class IG064DAOImpl extends
		BaseHibernateDAOImpl<IG064Info> implements IG064DAO {

	/**
	 * ���캯��
	 */
	public IG064DAOImpl(){
		super(IG064VW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG064Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG064Info findByPK(Serializable pk) {
		IG064Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG064SearchCond cond){
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
	public List<IG064Info> findByCond(final IG064SearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG064DAO.Query").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("pd",IG064VW.class);
				setFetchPoint(q, 0, 0);
				List<IG221Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG064Info>) execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG064SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}