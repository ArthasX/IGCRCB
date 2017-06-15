/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.RiskIndexContextVWInfo;
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexContextVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexContextVW;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexShowVW;

/**
  * ����: ����ָ��չʾ���ݲ�ѯDAOʵ��
  * ��������: ����ָ��չʾ���ݲ�ѯDAOʵ��
  * ������¼: 2014/07/26
  * �޸ļ�¼: 
  */
public class RiskIndexContextVWDAOImpl extends
		BaseHibernateDAOImpl<RiskIndexContextVWInfo> implements RiskIndexContextVWDAO {

	/**
	 * ���캯��
	 */
	public RiskIndexContextVWDAOImpl(){
		super(RiskIndexContextVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexContextVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexContextVWInfo findByPK(Serializable pk) {
		RiskIndexContextVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskIndexContextVWSearchCond cond){
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
	public List<RiskIndexContextVWInfo> findByCond(final RiskIndexContextVWSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskIndexContextVWDAOImpl.SEARCH").getQueryString());
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("riskshow",RiskIndexContextVW.class);
				List<RiskIndexContextVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskIndexContextVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskIndexContextVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}