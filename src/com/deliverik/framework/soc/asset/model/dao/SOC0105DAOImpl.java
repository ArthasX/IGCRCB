/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

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

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.bl.task.CMDBConstants;
import com.deliverik.framework.soc.asset.model.SOC0105Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0105SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0105TB;

/**
  * ����: ��ƴ���������DAOʵ��
  * ��������: ��ƴ���������DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0105DAOImpl extends
		BaseHibernateDAOImpl<SOC0105Info> implements SOC0105DAO {

	/**
	 * ���캯��
	 */
	public SOC0105DAOImpl(){
		super(SOC0105TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0105Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("auwtid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0105Info findByPK(Serializable pk) {
		SOC0105Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0105SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("auwtid"));
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
	public List<SOC0105Info> findByCond(final SOC0105SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0105SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//�����Ƿ�������
		if(cond.isTaskError()) {
			c.add(Expression.gt("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//�����
		} else {
			//����״̬�Ƿ����
			if(cond.isTaskDone()) {
				c.add(Expression.eq("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//�����
			} else {
				c.add(Expression.lt("auwtstatus", CMDBConstants.TASK_STATUS_DONE));//δ���
			}
		}
		
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		return c;
	}
	
	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteAll(){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AuditWaitTaskDAO.deleteAll").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				int i = q.executeUpdate();
				session.clear();
				return Integer.valueOf(i);
			}
		};
		return  (Integer) execute(action);
	}

}