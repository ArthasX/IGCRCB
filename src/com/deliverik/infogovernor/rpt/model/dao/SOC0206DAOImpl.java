/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0206Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0206SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0206TB;

/**
  * ����: ģ��ӳ���DAOʵ��
  * ��������: ģ��ӳ���DAOʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateMappingDAOImpl�����޸�ΪSOC0206DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0206DAOImpl extends
		BaseHibernateDAOImpl<SOC0206Info> implements SOC0206DAO {

	/**
	 * ���캯��
	 */
	public SOC0206DAOImpl(){
		super(SOC0206TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0206Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0206Info findByPK(Serializable pk) {
		SOC0206Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0206SearchCond cond){
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
	public List<SOC0206Info> findByCond(final SOC0206SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0206SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (cond.getRtId_eq()!=null) {
			c.add(Expression.eq("rtId", cond.getRtId_eq()));
		}
		if (cond.getRtNumber_eq()!=null) {
			c.add(Expression.eq("rtNumber", cond.getRtNumber_eq()));
		}
		c.addOrder(Order.asc("rtNumber"));
		return c;
	}
	/**����IDɾ��*/
	public Integer deleteByRtId(final Integer rtId){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				Query query1=session.createSQLQuery("delete from reporttemplatemapping where rtid=:rtid");
				query1.setParameter("rtid", rtId);
				int tmp=query1.executeUpdate();
				session.clear();
				return tmp;
			}
		};
		
		return (Integer) execute(action);
	}

}