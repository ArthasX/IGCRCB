/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0423TB;

/**
  * ����: ���������DAOʵ��
  * ��������: ���������DAOʵ��
  * ������¼: 2012/07/17
  * �޸ļ�¼: 2012/08/09 ��CapacityObjectListDAOImpl������ΪSOC0423DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0423DAOImpl extends
		BaseHibernateDAOImpl<SOC0423Info> implements SOC0423DAO {

	/**
	 * ���캯��
	 */
	public SOC0423DAOImpl(){
		super(SOC0423TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0423Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0423Info findByPK(Serializable pk) {
		SOC0423Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0423SearchCond cond){
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
	public List<SOC0423Info> findByCond(final SOC0423SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("name"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0423SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (!StringUtils.isEmpty(cond.getName_like())) {
			c.add(Expression.like("name", cond.getName_like()+"_%"));
		}
		if (!StringUtils.isEmpty(cond.getName())) {
			c.add(Expression.eq("name", cond.getName()));
		}
		if (!StringUtils.isEmpty(cond.getObjectType())) {
			c.add(Expression.eq("objectType", cond.getObjectType()));
		}
		if(cond.getStatus()!=null){
			c.add(Expression.eq("status", cond.getStatus()));
		}
		if(!StringUtils.isEmpty(cond.getObjectName())){
			c.add(Expression.eq("objectName", cond.getObjectName()));
		}
		return c;
	}

}