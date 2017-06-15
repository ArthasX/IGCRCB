/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0101Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0101SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0101TB;

/**
  * ����: ����ʲ����Ա�DAOʵ��
  * ��������: ����ʲ����Ա�DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0101DAOImpl extends
		BaseHibernateDAOImpl<SOC0101Info> implements SOC0101DAO {

	/**
	 * ���캯��
	 */
	public SOC0101DAOImpl(){
		super(SOC0101TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0101Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0101Info findByPK(Serializable pk) {
		SOC0101Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0101SearchCond cond){
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
	public List<SOC0101Info> findByCond(final SOC0101SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0101SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0101Info> searchSOC0101ForAucmptype(final Integer eiid){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AuditConfigItemDAO.getConfigAucmptype").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("eiid", eiid);
				q.addEntity("ac", SOC0101TB.class);
				List<SOC0101Info> list = q.list();
				
				session.clear();
				
				return list;
			}
				
		};
		return  (List<SOC0101Info>) execute(action);
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0101(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AuditConfigItemDAO.deleteAuditConfigItem").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				int i = q.executeUpdate();
				
				session.clear();
				
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}

}