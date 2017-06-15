/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.plugin.sms.model.SmsQueueInfo;
import com.deliverik.plugin.sms.model.condition.SmsQueueSearchCond;
import com.deliverik.plugin.sms.model.entity.SmsQueueTB;

/**
  * ����: ���Ŷ��б�DAOʵ��
  * ��������: ���Ŷ��б�DAOʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public class SmsQueueDAOImpl extends
		BaseHibernateDAOImpl<SmsQueueInfo> implements SmsQueueDAO {

	/**
	 * ���캯��
	 */
	public SmsQueueDAOImpl(){
		super(SmsQueueTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SmsQueueInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("qid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SmsQueueInfo findByPK(Serializable pk) {
		SmsQueueInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SmsQueueSearchCond cond){
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
	public List<SmsQueueInfo> findByCond(final SmsQueueSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SmsQueueSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}