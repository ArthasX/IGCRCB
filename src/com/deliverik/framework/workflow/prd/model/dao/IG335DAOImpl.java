/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG335TB;

/**
  * ����: �����Ա�DAOʵ��
  * ��������: �����Ա�DAOʵ��
  * ������¼: 2013/09/03
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG335DAOImpl extends
		BaseHibernateDAOImpl<IG335Info> implements IG335DAO {

	/**
	 * ���캯��
	 */
	public IG335DAOImpl(){
		super(IG335TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG335Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG335Info findByPK(Serializable pk) {
		IG335Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG335SearchCond cond){
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
	public List<IG335Info> findByCond(final IG335SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG335SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// ������Idȫ��
		if (StringUtils.isNotEmpty(cond.getPidid_eq())) {
			c.add(Expression.eq("pidid", cond.getPidid_eq()));
		}
		
		// ������IdLike
		if (StringUtils.isNotEmpty(cond.getPidid_like())) {
		    c.add(Expression.like("pidid", cond.getPidid_like() + "%"));
		}
		
		// ��״̬Idȫ��
		if (StringUtils.isNotEmpty(cond.getPsdid_eq())) {
			c.add(Expression.eq("psdid", cond.getPsdid_eq() ));
		}
		
		// ��״̬Id like
		if (StringUtils.isNotEmpty(cond.getPsdid_like())) {
			c.add(Expression.like("psdid", cond.getPsdid_like() + "%"));
		}
		
		// ��ֵȫ��
		if (StringUtils.isNotEmpty(cond.getPivalue_eq())) {
			c.add(Expression.eq("pivalue", cond.getPivalue_eq()));
		}

		// ���̶���ID(��ȫƥ��)
		if (StringUtils.isNotEmpty(cond.getPdid_eq())) {
			c.add(Expression.eq("pdid", cond.getPdid_eq()));
		}
		// ���̶���ID(ģ��ƥ��)_ֻ�ṩ��ģ��ƥ��
		if (StringUtils.isNotEmpty(cond.getPdid_like())) {
		    c.add(Expression.like("pdid", cond.getPdid_like() + "%"));
		}

		return c;
	}

	/**
	 * ��ʱ֪ͨ���Բ�ѯ
	 * 
	 * @param pdid ���̶���ID
	 * @param psdid ״̬����ID
	 * @param pidid ������ID
	 * @return  ��ʱ֪ͨ�����б�
	 */
	@SuppressWarnings("unchecked")
	public List<IG335Info> searchIG335Info(final String pdid, final  String psdid, final String pidid, final String psdconfirm){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG335DAO.searchIG335Info").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", pdid);
				q.setString("psdid", psdid);
				q.setString("pidid", pidid);
				q.setString("psdconfirm", psdconfirm);
				setFetchPoint(q, 0, 0);
				q.addEntity(IG335TB.class);
				List<IG238Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG335Info>) execute(action);
	}
}