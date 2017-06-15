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
import com.deliverik.framework.soc.asset.model.SOC0102Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0102SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0102TB;

/**
  * ����: ����ʲ���DAOʵ��
  * ��������: ����ʲ���DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0102DAOImpl extends
		BaseHibernateDAOImpl<SOC0102Info> implements SOC0102DAO {

	/**
	 * ���캯��
	 */
	public SOC0102DAOImpl(){
		super(SOC0102TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0102Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eiid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0102Info findByPK(Serializable pk) {
		SOC0102Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0102SearchCond cond){
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
	public List<SOC0102Info> findByCond(final SOC0102SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0102SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// ����ʲ�����
		if(StringUtils.isNotEmpty(cond.getAucmptype())){
			// ����
			if("1".equals(cond.getAucmptype())){
				c.add(Expression.sql(" not exists (select 1 from SOC0118 ei where ei.eiid = this_.eiid)"));
			}
			// �޸�
			if("2".equals(cond.getAucmptype())){
				c.add(Expression.sql(" exists (select 1 from SOC0118 ei where ei.eiid = this_.eiid)"));
			}
		}
		
		//����CI��ʶ
		if(cond.getTopCIList()!=null && cond.getTopCIList().size()>0){
			c.add(Expression.in("einame", cond.getTopCIList()));
		}
		
		
		
		return c;
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0102(){
		HibernateCallback action = new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				
				StringBuffer query = new StringBuffer();
				query.append( session.getNamedQuery("AuditEntityItemDAO.deleteAuditEntityItem").getQueryString());
				
				SQLQuery q = session.createSQLQuery(query.toString());
				int i = q.executeUpdate();
				
				session.clear();
				
				return Integer.valueOf(i);
			}
				
		};
		return  (Integer) execute(action);
	}

}