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

import com.deliverik.framework.asset.model.CIResultInfo;
import com.deliverik.framework.asset.model.condition.CIResultSearchCond;
import com.deliverik.framework.asset.model.entity.CIResultTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: CI����ԱȽ����Ϣ��DAOʵ��
  * ��������: CI����ԱȽ����Ϣ��DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CIResultDAOImpl extends
		BaseHibernateDAOImpl<CIResultInfo> implements CIResultDAO {

	/**
	 * ���캯��
	 */
	public CIResultDAOImpl(){
		super(CIResultTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CIResultInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CIResultInfo findByPK(Serializable pk) {
		CIResultInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CIResultSearchCond cond){
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
	public List<CIResultInfo> findByCond(final CIResultSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateCIResultWithout(final CIResultSearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				
				query.append( session.getNamedQuery("CIResultDAO.updateCIResultWithout").getQueryString());
				
				getSQL(cond, query);
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity("ar",CIResultTB.class);

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
	protected DetachedCriteria getCriteria(CIResultSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// CI�����ʼʱ��
		if (StringUtils.isNotEmpty(cond.getCitime_from())) {
			c.add(Expression.ge("autime", cond.getCitime_from()));
		}
		
		// CI�������ʱ��
		if (StringUtils.isNotEmpty(cond.getCitime_to())) {
			c.add(Expression.le("autime", cond.getCitime_to()));
		}
		
		// �ʲ�ģ��
		if (StringUtils.isNotEmpty(cond.getEsyscoding())) {
			c.add(Expression.like("esyscoding", cond.getEsyscoding() + '%'));
		}
		
		// CI�������
		if (StringUtils.isNotEmpty(cond.getCitdesc())) {
			String sql = "exists (select 1 from audittask at where at.autid = this_.autid and at.autdesc like '%" + cond.getCitdesc() + "%') ";
			c.add(Expression.sql(sql));
		}
		
		return c;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(CIResultSearchCond cond, StringBuffer query){
		
		// CI�����ʼʱ��
		if( !StringUtils.isEmpty(cond.getCitime_from())){
			query.append(" AND ar.autime >= :autime_from");
		}
		
		// CI�������ʱ��
		if( !StringUtils.isEmpty(cond.getCitime_to())){
			query.append(" AND ar.autime <= :autime_to");
		}
		
		// �ʲ�ģ��
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			query.append(" AND ar.esyscoding like (:esyscoding || '%')");
		}
		
		// CI�������
		if (StringUtils.isNotEmpty(cond.getCitdesc())) {
			query.append(" AND exists (select 1 from audittask at where at.autid = ar.autid and at.autdesc like '%' || :autdesc || '%') ");
		}
		
	}
		

}