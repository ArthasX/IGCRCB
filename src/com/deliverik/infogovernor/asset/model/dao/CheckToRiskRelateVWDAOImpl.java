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
import com.deliverik.infogovernor.asset.model.CheckToRiskRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckToRiskRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.CheckToRiskRelateVW;

/**
  * ����: �������յ��ϵģ��DAOʵ��
  * ��������: �������յ��ϵģ��DAOʵ��
  * ������¼: 2014/07/23
  * �޸ļ�¼: 
  */
public class CheckToRiskRelateVWDAOImpl extends
		BaseHibernateDAOImpl<CheckToRiskRelateVWInfo> implements CheckToRiskRelateVWDAO {

	/**
	 * ���캯��
	 */
	public CheckToRiskRelateVWDAOImpl(){
		super(CheckToRiskRelateVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckToRiskRelateVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckToRiskRelateVWInfo findByPK(Serializable pk) {
		CheckToRiskRelateVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CheckToRiskRelateVWSearchCond cond){
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
	public List<CheckToRiskRelateVWInfo> findByCond(final CheckToRiskRelateVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CheckToRiskRelateVWDAOImpl.CHECK_TO_RISK").getQueryString());
				query.append("  and cs.eid = '"+cond.getEiid()+"'");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("cs",CheckToRiskRelateVW.class);
				List<CheckToRiskRelateVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckToRiskRelateVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CheckToRiskRelateVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}