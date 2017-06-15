/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.SmsMessageLogInfo;
import com.deliverik.infogovernor.sym.model.condition.SmsMessageLogSearchCond;
import com.deliverik.infogovernor.sym.model.entity.SmsMessageLogTB;

/**
  * ����: ������־��Ϣ��DAOʵ��
  * ��������: ������־��Ϣ��DAOʵ��
  * ������¼: 2012/02/20
  * �޸ļ�¼: 
  */
public class SmsMessageLogDAOImpl extends
		BaseHibernateDAOImpl<SmsMessageLogInfo> implements SmsMessageLogDAO {

	/**
	 * ���캯��
	 */
	public SmsMessageLogDAOImpl(){
		super(SmsMessageLogTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SmsMessageLogInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SmsMessageLogInfo findByPK(Serializable pk) {
		SmsMessageLogInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SmsMessageLogSearchCond cond){
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
	public List<SmsMessageLogInfo> findByCond(final SmsMessageLogSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SmsMessageLogSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}