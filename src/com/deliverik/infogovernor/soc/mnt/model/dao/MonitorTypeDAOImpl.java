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
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeTB;

/**
  * ����: ������ͱ�DAOʵ��
  * ��������: ������ͱ�DAOʵ��
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class MonitorTypeDAOImpl extends
		BaseHibernateDAOImpl<MonitorTypeInfo> implements MonitorTypeDAO {

	/**
	 * ���캯��
	 */
	public MonitorTypeDAOImpl(){
		super(MonitorTypeTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeInfo findByPK(Serializable pk) {
		MonitorTypeInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorTypeSearchCond cond){
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
	public List<MonitorTypeInfo> findByCond(final MonitorTypeSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("mtSyscoding"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(MonitorTypeSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getMtSyscoding())){
			c.add(Expression.eq("mtSyscoding", cond.getMtSyscoding()));
		}
		return c;
	}

}