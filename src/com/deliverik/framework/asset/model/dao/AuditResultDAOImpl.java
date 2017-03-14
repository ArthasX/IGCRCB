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
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.asset.model.entity.AuditResultTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ��ƶԱȽ����Ϣ��DAOʵ��
  * ��������: ��ƶԱȽ����Ϣ��DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class AuditResultDAOImpl extends
		BaseHibernateDAOImpl<AuditResultInfo> implements AuditResultDAO {

	/**
	 * ���캯��
	 */
	public AuditResultDAOImpl(){
		super(AuditResultTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditResultInfo findByPK(Serializable pk) {
		AuditResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AuditResultSearchCond cond){
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
	public List<AuditResultInfo> findByCond(final AuditResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateAuditResultWithout(final AuditResultSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("AuditResultDAO.updateAuditResultWithout").getQueryString());
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ar",AuditResultTB.class);

				q.setProperties(cond);
				
				int i = q.executeUpdate();
				
				session.clear();
				session.close();
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}
	

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AuditResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// �ʲ�ģ��
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + '%'));
		}
		
		// �������ID
		if (cond.getAutid() != null && cond.getAutid() != 0){
			c.add(Expression.eq("autid", cond.getAutid()));
		}
		
		return c;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(AuditResultSearchCond cond, StringBuffer query){
		
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