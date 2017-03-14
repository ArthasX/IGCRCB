/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

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
import com.deliverik.infogovernor.asset.model.MaintenanceInfo;
import com.deliverik.infogovernor.asset.model.condition.MaintenanceSearchCond;
import com.deliverik.infogovernor.asset.model.entity.MaintenanceTB;

/**
  * ����: ����ָ��ά��DAOʵ��
  * ��������: ����ָ��ά��DAOʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class MaintenanceDAOImpl extends
		BaseHibernateDAOImpl<MaintenanceInfo> implements MaintenanceDAO {

	/**
	 * ���캯��
	 */
	public MaintenanceDAOImpl(){
		super(MaintenanceTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MaintenanceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MaintenanceInfo findByPK(Serializable pk) {
		MaintenanceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MaintenanceSearchCond cond){
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
	public List<MaintenanceInfo> findByCond(final MaintenanceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	@SuppressWarnings("deprecation")
	protected DetachedCriteria getCriteria(MaintenanceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//����ָ��ID
		if( cond.getRIID()!=null){
			c.add(Expression.eq("RIID", cond.getRIID()));
		}
		return c;
	}




	public List<Integer> saveOrUpdateMaintenance(final MaintenanceInfo instance) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append("select rimid from MAINTENANCE where riid = '");
                if(instance.getRIID()==null){
                	query.append("0'");
                }else{
                	query.append(instance.getRIID()+"'");
                }
                
                
                SQLQuery q = session.createSQLQuery(query.toString()); 
                List<Integer> list =(List<Integer>) q.list();
                
                session.clear();
                session.close();
                return list;
            }
        };
        return (List<Integer>)execute(action);
	}



	public MaintenanceInfo update(final MaintenanceInfo instance) {
		// TODO Auto-generated method stub
		HibernateCallback action = new HibernateCallback() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.flush();
                StringBuffer query = new StringBuffer();
                
                query.append("update MAINTENANCE set riid='");
                query.append(instance.getRIID()+"',rimtype='");
                query.append(instance.getRIMTYPE()+"',rimdesc='");
                query.append(instance.getRIMDESC()+"'");
                query.append(" where RIMID='"+instance.getRIMID()+"'");
                SQLQuery q = session.createSQLQuery(query.toString());
                q.executeUpdate();
                
                session.clear();
                session.close();
                return null;
            }
        };
        return (MaintenanceInfo)execute(action);
	}
	
	
	/**
	 * ������������
	 * ����sql��ѯ
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<Object> SearchBySQL(final MaintenanceSearchCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				String query =cond.getSearchSQL();
				SQLQuery q = session.createSQLQuery(query);
				q.setProperties(cond);
				List<Object> list = q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<Object>)execute(action);
	}

}