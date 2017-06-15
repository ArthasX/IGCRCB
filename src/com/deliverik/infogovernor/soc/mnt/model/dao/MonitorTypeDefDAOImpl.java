/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.MonitorTypeDefInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.MonitorTypeDefSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.MonitorTypeDefTB;

/**
  * ����: ������ͷ�ֵ��ϢDAOʵ��
  * ��������: ������ͷ�ֵ��ϢDAOʵ��
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class MonitorTypeDefDAOImpl extends
		BaseHibernateDAOImpl<MonitorTypeDefInfo> implements MonitorTypeDefDAO {

	/**
	 * ���캯��
	 */
	public MonitorTypeDefDAOImpl(){
		super(MonitorTypeDefTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MonitorTypeDefInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MonitorTypeDefInfo findByPK(Serializable pk) {
		MonitorTypeDefInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MonitorTypeDefSearchCond cond){
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
	public List<MonitorTypeDefInfo> findByCond(final MonitorTypeDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("orderNumber"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(MonitorTypeDefSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getMtId()!=null){
			c.add(Expression.eq("mtId", Integer.valueOf(cond.getMtId())));
		}
		return c;
	}

}