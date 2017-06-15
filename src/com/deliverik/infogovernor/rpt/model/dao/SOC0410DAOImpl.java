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
import com.deliverik.infogovernor.rpt.model.SOC0410Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0410SearchCond;
import com.deliverik.infogovernor.rpt.model.entity.SOC0410TB;

/**
  * ����: �洢lunʵʱ��DAOʵ��
  * ��������: �洢lunʵʱ��DAOʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVStorageRealTimeDAOImpl������ΪSOC0410DAOImpl
  */
@SuppressWarnings("deprecation")
public class SOC0410DAOImpl extends
		BaseHibernateDAOImpl<SOC0410Info> implements SOC0410DAO {

	/**
	 * ���캯��
	 */
	public SOC0410DAOImpl(){
		super(SOC0410TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0410Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0410Info findByPK(Serializable pk) {
		SOC0410Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0410SearchCond cond){
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
	public List<SOC0410Info> findByCond(final SOC0410SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0410SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getSName_eq())){
			c.add(Expression.eq("sName", cond.getSName_eq()));
		}
		if(!StringUtils.isEmpty(cond.getIsUsed_eq())){
			c.add(Expression.eq("isUsed", cond.getIsUsed_eq()));
		}
		c.addOrder(Order.asc("lunid"));
		return c;
	}

}