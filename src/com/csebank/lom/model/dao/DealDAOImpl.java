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

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.condition.DealSearchCond;
import com.csebank.lom.model.condition.RecptionGuestInfoCond;
import com.csebank.lom.model.entity.DealTB;
import com.csebank.lom.model.entity.InvoiceVW;
import com.csebank.lom.model.entity.RecptionTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * �Ӵ�����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class DealDAOImpl extends BaseHibernateDAOImpl<Deal> implements DealDAO {

	/**
	 * ���캯��
	 */
	public DealDAOImpl(){
		super(DealTB.class);
	}
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Deal> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rid"));
		List<Deal> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Deal findByPK(Serializable rid) {

		Deal result = super.findByPK(rid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final DealSearchCond cond){
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
	public List<Deal> findByCond(final DealSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("dealTime"));
		List<Deal> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(DealSearchCond cond){
		

       DetachedCriteria c = getDetachedCriteria();
		

		
		//���벿��
		if(StringUtils.isNotEmpty(cond.getRapporgid())){
			c.add(Expression.eq("rapporgid", cond.getRapporgid()));
		}
		
		//���Ż��ܽӴ���ϸ����ID
		if(StringUtils.isNotEmpty(cond.getRapporgid_org())){
			c.add(Expression.eq("rapporgid", cond.getRapporgid_org()));
		}
		
		//״̬
		if(StringUtils.isNotEmpty(cond.getRstatus())){
			c.add(Expression.eq("rstatus", cond.getRstatus()));
		}
		
		//�Ӵ���ʼʱ��
		if(StringUtils.isNotEmpty(cond.getRtime_from())){
			c.add(Expression.ge("dealTime", cond.getRtime_from()));
		}

		//�Ӵ���ʼʱ��
		if(StringUtils.isNotEmpty(cond.getRtime_to())){
			c.add(Expression.le("dealTime", cond.getRtime_to()));
		}

		//����
		if(StringUtils.isNotEmpty(cond.getMonth())){
			c.add(Expression.ge("dealTime", cond.getYear() + "/" + cond.getMonth() + "/00"));
			c.add(Expression.le("dealTime", cond.getYear() + "/" + cond.getMonth() + "/31"));
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
	public List<Recption> findByGuestInfoCond(final RecptionGuestInfoCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback()
		{  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				List<InvoiceVW> list =null;
				query.append(session.getNamedQuery("RecptionDAO.RecptionInfo").getQueryString());
				if(!StringUtils.isEmpty(cond.getRgname())){
					query.append(" AND  RGNAME = :rgname ");
				}
				if(!StringUtils.isEmpty(cond.getRgunit())){
					query.append(" AND RGUNIT = :rgunit");
				}
				query.append(" ORDER BY R.RID ");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("Recption",RecptionTB.class);
				setFetchPoint(q, start, count);
				list = q.list();
				session.clear();
				session.close();
				return list;
			}
		};
		return (List<Recption>) execute(action);
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
					query.append(" AND  RGNAME = :rgname ");
				}
				if(!StringUtils.isEmpty(cond.getRgunit())){
					query.append(" AND RGUNIT = :rgunit");
				}
				
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(cond);
				q.addEntity("Recption",RecptionTB.class);
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
