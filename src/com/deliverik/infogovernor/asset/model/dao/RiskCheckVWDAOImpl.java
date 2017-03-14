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
import com.deliverik.infogovernor.asset.model.RiskCheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskCheckVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskCheckVW;

/**
  * ����: ��鹤��ͳ�Ʊ���DAOʵ��
  * ��������: ��鹤��ͳ�Ʊ���DAOʵ��
  * ������¼: 2014/07/22
  * �޸ļ�¼: 
  */
public class RiskCheckVWDAOImpl extends
		BaseHibernateDAOImpl<RiskCheckVWInfo> implements RiskCheckVWDAO {

	/**
	 * ���캯��
	 */
	public RiskCheckVWDAOImpl(){
		super(RiskCheckVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskCheckVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskCheckVWInfo findByPK(Serializable pk) {
		RiskCheckVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskCheckVWSearchCond cond){
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
	public List<RiskCheckVWInfo> findByCond(final RiskCheckVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RISKCHECKVWDAOImpl.RISK_TO_CHECK").getQueryString());
				query.append(" and riskcheck.eid = '"+cond.getEiid()+"'");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("riskcheck",RiskCheckVW.class);
				List<RiskPointVMInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskCheckVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskCheckVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}