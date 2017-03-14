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
import com.deliverik.infogovernor.asset.model.RiskIndexShowVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexShowVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexShowVW;

/**
  * ����: ����ָ��չʾ��ѯDAOʵ��
  * ��������: ����ָ��չʾ��ѯDAOʵ��
  * ������¼: 2014/07/25
  * �޸ļ�¼: 
  */
public class RiskIndexShowVWDAOImpl extends
		BaseHibernateDAOImpl<RiskIndexShowVWInfo> implements RiskIndexShowVWDAO {

	/**
	 * ���캯��
	 */
	public RiskIndexShowVWDAOImpl(){
		super(RiskIndexShowVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskIndexShowVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskIndexShowVWInfo findByPK(Serializable pk) {
		RiskIndexShowVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskIndexShowVWSearchCond cond){
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
	public List<RiskIndexShowVWInfo> findByCond(final RiskIndexShowVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskIndexShowVWDAOImpl.SEARCH").getQueryString());
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("riskshow",RiskIndexShowVW.class);
				List<RiskIndexShowVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskIndexShowVWInfo>)execute(action);
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskIndexShowVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}