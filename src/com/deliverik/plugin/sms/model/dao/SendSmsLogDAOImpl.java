/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.sms.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.plugin.sms.model.SendSmsLogInfo;
import com.deliverik.plugin.sms.model.condition.SendSmsLogSearchCond;
import com.deliverik.plugin.sms.model.entity.SendSmsLogTB;

/**
  * ����: ���Ŷ��б�DAOʵ��
  * ��������: ���Ŷ��б�DAOʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SendSmsLogDAOImpl extends
		BaseHibernateDAOImpl<SendSmsLogInfo> implements SendSmsLogDAO {

	/**
	 * ���캯��
	 */
	public SendSmsLogDAOImpl(){
		super(SendSmsLogTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SendSmsLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SendSmsLogInfo findByPK(Serializable pk) {
		SendSmsLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SendSmsLogSearchCond cond){
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
	public List<SendSmsLogInfo> findByCond(final SendSmsLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SendSmsLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}