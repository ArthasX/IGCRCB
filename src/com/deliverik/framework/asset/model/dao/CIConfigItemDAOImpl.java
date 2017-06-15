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

import com.deliverik.framework.asset.model.CIConfigItemInfo;
import com.deliverik.framework.asset.model.condition.CIConfigItemSearchCond;
import com.deliverik.framework.asset.model.entity.CIConfigItemTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: CI����ʲ����Ա�DAOʵ��
  * ��������: CI����ʲ����Ա�DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class CIConfigItemDAOImpl extends
		BaseHibernateDAOImpl<CIConfigItemInfo> implements CIConfigItemDAO {

	/**
	 * ���캯��
	 */
	public CIConfigItemDAOImpl(){
		super(CIConfigItemTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIConfigItemInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIConfigItemInfo findByPK(Serializable pk) {
		CIConfigItemInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CIConfigItemSearchCond cond){
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
	public List<CIConfigItemInfo> findByCond(final CIConfigItemSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CIConfigItemSearchCond cond){
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
	public List<CIConfigItemInfo> searchCIConfigItemForAucmptype(final Integer eiid){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CIConfigItemDAO.getConfigAucmptype").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setInteger("eiid", eiid);
				q.addEntity("ac", CIConfigItemTB.class);
				List<CIConfigItemInfo> list = q.list();
				
				session.clear();
				session.close();
				return list;
			}
				
		};
		return  (List<CIConfigItemInfo>) execute(action);
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteCIConfigItem(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CIConfigItemDAO.deleteCIConfigItem").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				int i = q.executeUpdate();
				
				session.clear();
				session.close();
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}

}