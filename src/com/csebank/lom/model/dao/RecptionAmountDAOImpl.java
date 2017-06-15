/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.csebank.lom.model.RecptionAmount;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.csebank.lom.model.entity.RecptionAmountVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * �Ӵ�����DAOʵ��
 *
 */
public class RecptionAmountDAOImpl extends BaseHibernateDAOImpl<RecptionAmount> implements RecptionAmountDAO {

	/**
	 * ���캯��
	 */
	public RecptionAmountDAOImpl(){
		super(RecptionAmountVW.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<RecptionAmount> findByCond(final RecptionSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<RecptionAmount> list =null;
				
				query.append(session.getNamedQuery("RecptionAmountDAO.recptionAmount").getQueryString());
				getSQL(cond, query);
				query.append(" ORDER BY RP.RSTIME DESC");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity(RecptionAmountVW.class);
				setFetchPoint(q, start, count);
				 list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<RecptionAmount>) execute(action);
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected void getSQL(RecptionSearchCond cond, StringBuffer query){
		
		//���벿��
		if(StringUtils.isNotEmpty(cond.getRapporgid_q())){
			query.append(" AND RP.rapporgid = :rapporgid_q");
		}
		
		//״̬
		if(StringUtils.isNotEmpty(cond.getRstatus_q())){
			query.append(" AND RP.rstatus = :rstatus_q");
		}
		
		//�Ӵ���ʼʱ��
		if(StringUtils.isNotEmpty(cond.getRtime_from())){
			query.append(" AND RP.rstime >= (:rtime_from||' 00:00')");
		}

		//�Ӵ���ʼʱ��
		if(StringUtils.isNotEmpty(cond.getRtime_to())){
			query.append(" AND RP.rstime <= (:rtime_to||' 23:59')");
		}
		
		//�Ӵ�����ʱ��
		if(StringUtils.isNotEmpty(cond.getRetime_from())){
			query.append(" AND RP.retime >= (:retime_from||' 00:00')");
		}

		//�Ӵ�����ʱ��
		if(StringUtils.isNotEmpty(cond.getRetime_to())){
			query.append(" AND RP.retime <= (:retime_to||' 23:59')");
		}
	}
	

}
