/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;

/**
  * ����: �����������DAOʵ��
  * ��������: �����������DAOʵ��
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0304DAOImpl extends
		BaseHibernateDAOImpl<SOC0304Info> implements SOC0304DAO {

	/**
	 * ���캯��
	 */
	public SOC0304DAOImpl(){
		super(SOC0304TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0304Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0304Info findByPK(Serializable pk) {
		SOC0304Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0304SearchCond cond){
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
	public List<SOC0304Info> findByCond(final SOC0304SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0304SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//״̬
		if(StringUtils.isNotEmpty(cond.getMtStatus())){
			c.add(Expression.eq("mtStatus", cond.getMtStatus()));
		}
		//�������к�
		if(StringUtils.isNotEmpty(cond.getMtSsn())){
			c.add(Expression.eq("mtSsn", cond.getMtSsn()));
		}
		c.addOrder(Order.asc("mtId"));
		return c;
	}

}