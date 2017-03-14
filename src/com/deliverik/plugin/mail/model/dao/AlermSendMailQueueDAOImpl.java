/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.mail.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;
import com.deliverik.plugin.mail.model.condition.AlermSendMailQueueSearchCond;
import com.deliverik.plugin.mail.model.entity.AlermSendMailQueueTB;

/**
  * ����: �ʼ����б�DAOʵ��
  * ��������: �ʼ����б�DAOʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public class AlermSendMailQueueDAOImpl extends
		BaseHibernateDAOImpl<AlermSendMailQueueInfo> implements AlermSendMailQueueDAO {

	/**
	 * ���캯��
	 */
	public AlermSendMailQueueDAOImpl(){
		super(AlermSendMailQueueTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AlermSendMailQueueInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("inserttime"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AlermSendMailQueueInfo findByPK(Serializable pk) {
		AlermSendMailQueueInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AlermSendMailQueueSearchCond cond){
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
	public List<AlermSendMailQueueInfo> findByCond(final AlermSendMailQueueSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(AlermSendMailQueueSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond==null){return c;}
		if(Character.isDigit( cond.getSentstatus_eq() )){
			c.add(Expression.eq("sentstatus", cond.getSentstatus_eq()));
		}
		return c;
	}

}