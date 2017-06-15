/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

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

import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.condition.RecptionSearchCond;
import com.csebank.lom.model.entity.GuestRecptionVW;
import com.csebank.lom.model.entity.InvoiceVW;
import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * �Ӵ�����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class RecptionDAOImpl extends BaseHibernateDAOImpl<Recption> implements RecptionDAO {

	/**
	 * ���캯��
	 */
	public RecptionDAOImpl(){
		super(RecptionTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Recption> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rid"));
		List<Recption> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Recption findByPK(Serializable rid) {

		Recption result = super.findByPK(rid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Recption> findByCond(final RecptionSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rid"));
		List<Recption> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RecptionSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		

		
		//���벿��
		if(StringUtils.isNotEmpty(cond.getRapporgid_q())){
			c.add(Expression.eq("rapporgid", cond.getRapporgid_q()));
		}
		
		//���Ż��ܽӴ���ϸ����ID
		if(StringUtils.isNotEmpty(cond.getRapporgid_org())){
			c.add(Expression.eq("rapporgid", cond.getRapporgid_org()));
		}
		
		//״̬
		if(StringUtils.isNotEmpty(cond.getRstatus_q())){
			c.add(Expression.eq("rstatus", cond.getRstatus_q()));
		}
		
		//�Ӵ���ʼʱ��
		if(StringUtils.isNotEmpty(cond.getRtime_from())){
			c.add(Expression.ge("rstime", cond.getRtime_from()+ " 00:00"));
		}

		//�Ӵ���ʼʱ��
		if(StringUtils.isNotEmpty(cond.getRtime_to())){
			c.add(Expression.le("rstime", cond.getRtime_to()+ " 23:59"));
		}
		
		//�Ӵ�����ʱ��
		if(StringUtils.isNotEmpty(cond.getRetime_from())){
			c.add(Expression.ge("retime", cond.getRetime_from()+ " 00:00"));
		}

		//�Ӵ�����ʱ��
		if(StringUtils.isNotEmpty(cond.getRetime_to())){
			c.add(Expression.le("retime", cond.getRetime_to() +" 23:59"));
		}

		//����
		if(StringUtils.isNotEmpty(cond.getMonth())){
			c.add(Expression.ge("rstime", cond.getYear() + "/" + cond.getMonth() + "/00 00:00"));
			c.add(Expression.le("rstime", cond.getYear() + "/" + cond.getMonth() + "/31 23:59"));
		}
		
		
		return c;
	}
	/**
	 * ���ݿͻ��������ͻ���λ��ѯ�Ӵ�������Ϣ
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �Ӵ�������Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<GuestRecption> findByGuestInfoCond(final RecptionGuestInfoCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<InvoiceVW> list =null;
				query.append(session.getNamedQuery("RecptionDAO.RecptionInfo").getQueryString());
				if(!StringUtils.isEmpty(cond.getRgname())){
					query.append(" AND  RGNAME LIKE '%'||:rgname||'%' ");
				}
				if(!StringUtils.isEmpty(cond.getRgunit())){
					query.append(" AND RGUNIT LIKE '%'||:rgunit||'%'");
				}
				query.append(" ORDER BY RG.RGNAME ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
//				q.addEntity("Recption",RecptionTB.class);
				q.addEntity("GuestRecption",GuestRecptionVW.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<GuestRecption>) execute(action);
	}

	/**
	 * ���ݿͻ��������ͻ���λ�����������ȡ��
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �����������
	 */
	@SuppressWarnings("unchecked")
	public int getRecptionSearchCount(final RecptionGuestInfoCond cond){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<InvoiceVW> list =null;
				query.append(session.getNamedQuery("RecptionDAO.RecptionInfo").getQueryString());
				if(!StringUtils.isEmpty(cond.getRgname())){
					query.append(" AND  RGNAME LIKE '%'||:rgname||'%' ");
				}
				if(!StringUtils.isEmpty(cond.getRgunit())){
					query.append(" AND RGUNIT LIKE '%'||:rgunit||'%'");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("GuestRecption",GuestRecptionVW.class);
//				q.addEntity("Recption",RecptionTB.class);
//				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list.size();
			}
		};
		return (Integer) execute(action);
	}
}
