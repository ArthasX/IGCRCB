/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCond;
import com.deliverik.infogovernor.asset.model.entity.RiskVW;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�Ʋ�ѯDAOʵ��
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class RiskVWDAOImpl extends
BaseHibernateDAOImpl<RiskVWInfo> implements RiskVWDAO {

	/**
	 * ���캯��
	 */
	public RiskVWDAOImpl(){
		super(RiskVW.class);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<RiskVWInfo> findByCond(final RiskVWCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("RiskVW.search").getQueryString());
				
				/**׷�� �������� ��ѯ����*/
				/**��������*/
				/*if(StringUtils.isNotEmpty(cond.getEiname())){
					query.append(" and risk.einame like '%"+cond.getEiname()+"%'");
				}*/
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				//q.setProperties(cond);
				q.addEntity("t",RiskVW.class);
				setFetchPoint(q, 0, 0);
				List<RiskVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<RiskVWInfo>)execute(action);
	}

}
