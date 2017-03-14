/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.sym.model.QueueInfo;
import com.deliverik.infogovernor.sym.model.condition.QueueSearchCond;
import com.deliverik.infogovernor.sym.model.entity.QueueTB;

/**
  * ����: ���Ŷ��б�DAOʵ��
  * ��������: ���Ŷ��б�DAOʵ��
  * ������¼: 2012/11/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class QueueDAOImpl extends
		BaseHibernateDAOImpl<QueueInfo> implements QueueDAO {

	/**
	 * ���캯��
	 */
	public QueueDAOImpl(){
		super(QueueTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<QueueInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public QueueInfo findByPK(Serializable pk) {
		QueueInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final QueueSearchCond cond){
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
	public List<QueueInfo> findByCond(final QueueSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(QueueSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}