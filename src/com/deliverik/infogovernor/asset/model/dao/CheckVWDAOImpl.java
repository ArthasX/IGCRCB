/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckVWCond;
import com.deliverik.infogovernor.asset.model.entity.CheckVW;

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
public class CheckVWDAOImpl extends
BaseHibernateDAOImpl<CheckVWInfo> implements CheckVWDAO {

	/**
	 * ���캯��
	 */
	public CheckVWDAOImpl(){
		super(CheckVW.class);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<CheckVWInfo> findByCond(final CheckVWCond cond) {
		HibernateCallback action = new HibernateCallback(){
			public Object doInHibernate(Session session)throws HibernateException, SQLException {
			
				session.flush();
				//��ȡquery
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("CheckVW.search").getQueryString());
				
				/**׷�� �������� ��ѯ����*/
				/**��������*/
				if(StringUtils.isNotEmpty(cond.getSyscoding())){
					query.append(" and t.syscoding in ("+cond.getSyscoding()+")");
				}
				//��ȡSQLQuery
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("t",CheckVW.class);
				setFetchPoint(q, 0, 0);
				List<CheckVWInfo> list=q.list();
				session.clear();
				session.close();
				return list;
			}
			
		};
		return (List<CheckVWInfo>)execute(action);
	}

}
