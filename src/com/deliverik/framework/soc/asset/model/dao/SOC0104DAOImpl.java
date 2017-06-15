/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.soc.asset.model.SOC0104Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0104SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0104TB;

/**
  * ����: ��������DAOʵ��
  * ��������: ��������DAOʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0104DAOImpl extends
		BaseHibernateDAOImpl<SOC0104Info> implements SOC0104DAO {

	/**
	 * ���캯��
	 */
	public SOC0104DAOImpl(){
		super(SOC0104TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0104Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0104Info findByPK(Serializable pk) {
		SOC0104Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0104SearchCond cond){
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
	public List<SOC0104Info> findByCond(final SOC0104SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("autid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0104SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�����������
		if (StringUtils.isNotEmpty(cond.getAutdesc_like())) {
			c.add(Expression.like("autdesc", "%" + cond.getAutdesc_like() + "%"));
		}
		//״̬
		if (StringUtils.isNotEmpty(cond.getAutstatus_eq())) {
			c.add(Expression.eq("autstatus", cond.getAutstatus_eq()));
		}
		//ʱ��
		if(StringUtils.isNotEmpty(cond.getAuttime_from())){
			c.add(Expression.ge("auttime", cond.getAuttime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getAuttime_to())){
			c.add(Expression.le("auttime", cond.getAuttime_to()+" 23:59"));
		}
		return c;
	}

}