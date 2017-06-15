/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;
import com.deliverik.infogovernor.rdp.model.condition.AutoTaskSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.AutoTaskTB;

/**
  * ����: AutoTaskDAOʵ��
  * ��������: AutoTaskDAOʵ��
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class AutoTaskDAOImpl extends
		BaseHibernateDAOImpl<AutoTaskInfo> implements AutoTaskDAO {

	/**
	 * ���캯��
	 */
	public AutoTaskDAOImpl(){
		super(AutoTaskTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AutoTaskInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AutoTaskInfo findByPK(Serializable pk) {
		AutoTaskInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AutoTaskSearchCond cond){
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
	public List<AutoTaskInfo> findByCond(final AutoTaskSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("id"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AutoTaskSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getTaskName_like())){
			c.add(Expression.like("taskName", "%" + cond.getTaskName_like() + "%"));
		}
		if(StringUtils.isNotEmpty(cond.getTime_from())){
			c.add(Expression.ge("excutetime", cond.getTime_from()));
		}
		if(StringUtils.isNotEmpty(cond.getTime_to())){
			c.add(Expression.le("excutetime", cond.getTime_to()));
		}
		if(cond.getSystemid_eq() != null){
			c.add(Expression.eq("businessSystemid", cond.getSystemid_eq()));
		}
		return c;
	}

}