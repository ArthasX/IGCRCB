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
import com.deliverik.infogovernor.asset.model.RiskToZhRelateVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskToZhRelateVWSearchCond;
import com.deliverik.infogovernor.asset.model.entity.RiskToZhRelateVW;

/**
  * ����: ���յ�ָ���ϵDAOʵ��
  * ��������: ���յ�ָ���ϵDAOʵ��
  * ������¼: 2014/07/24
  * �޸ļ�¼: 
  */
public class RiskToZhRelateVWDAOImpl extends
		BaseHibernateDAOImpl<RiskToZhRelateVWInfo> implements RiskToZhRelateVWDAO {

	/**
	 * ���캯��
	 */
	public RiskToZhRelateVWDAOImpl(){
		super(RiskToZhRelateVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RiskToZhRelateVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RiskToZhRelateVWInfo findByPK(Serializable pk) {
		RiskToZhRelateVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RiskToZhRelateVWSearchCond cond){
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
	public List<RiskToZhRelateVWInfo> findByCond(final RiskToZhRelateVWSearchCond cond, final int start, final int count){
			HibernateCallback action = new HibernateCallback(){
			
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				if("1".equals(cond.getSign())){
					query.append( session.getNamedQuery("RiskToZhRelateVWDAOImpl.RISK_TO_ZB").getQueryString());
				}else{
					query.append( session.getNamedQuery("RiskToZhRelateVWDAOImpl.CHECK_TO_ZB").getQueryString());
				}
				query.append("  and riskzb.eid = '"+cond.getEiid()+"'");
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity("riskzb",RiskToZhRelateVW.class);
				List<RiskToZhRelateVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskToZhRelateVWInfo>)execute(action);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RiskToZhRelateVWSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}