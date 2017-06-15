/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.SOC0137TB;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;

/**
  * ����: ��ƶԱȽ����Ϣ��DAOʵ��
  * ��������: ��ƶԱȽ����Ϣ��DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0103DAOImpl extends
		BaseHibernateDAOImpl<SOC0103Info> implements SOC0103DAO {

	/**
	 * ���캯��
	 */
	public SOC0103DAOImpl(){
		super(SOC0103TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0103Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0103Info findByPK(Serializable pk) {
		SOC0103Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0103SearchCond cond){
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
	public List<SOC0103Info> findByCond(final SOC0103SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateSOC0103Without(final SOC0103SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("AuditResultDAO.updateAuditResultWithout").getQueryString());
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ar",SOC0103TB.class);

				q.setProperties(cond);
				
				int i = q.executeUpdate();
				
				session.clear();
				
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0137Info> findByCondOne(final SOC0103SearchCond cond) {
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("AuditResultDAO.findByCondOne").getQueryString());
				
				getSQL(cond, query);
				
				query.append(" group by ar.autid,ar.eiid,ar.eiversion," +
						"ar.eismallversion,ar.einame,ar.aucmptype,ar.esyscoding,ar.auflag,ar.autime");
				query.append(" order by ar.eiid asc");
				SQLQuery q = session.createSQLQuery(query.toString());
				
				q.setProperties(cond);

				q.addEntity("ar",SOC0137TB.class);

				List<SOC0137TB> list = q.list();
				
				session.clear();
				
				return list;
			}
				
		};
		return  (List<SOC0137Info>) execute(action);
	}
	

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0103SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// �ʲ�ģ��
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + '%'));
		}
		
		// �������ID
		if (cond.getAutid() != null && cond.getAutid() != 0){
			c.add(Expression.eq("autid", cond.getAutid()));
		}
		
		//�ʲ�eiid
		if(cond.getEiid()!=null&&cond.getEiid()!=0){
			c.add(Expression.eq("eiid", cond.getEiid()));
		}
		
		return c;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(SOC0103SearchCond cond, StringBuffer query){
		
		// �ʲ�ģ��
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			query.append(" AND ar.esyscoding like (:esyscoding || '%')");
		}
		
		// �������ID
		if (cond.getAutid() != null && cond.getAutid() != 0){
			query.append(" AND ar.autid = " + cond.getAutid());
		}
		
	}
		

}