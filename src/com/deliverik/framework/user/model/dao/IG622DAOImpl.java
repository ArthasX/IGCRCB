/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.condition.IG622SearchCond;
import com.deliverik.framework.user.model.entity.IG622TB;

/**
  * ����: ��ҳ��תURL����DAOʵ��
  * ��������: ��ҳ��תURL����DAOʵ��
  * ������¼: 2012/07/18
  * �޸ļ�¼: 
  */
public class IG622DAOImpl extends
		BaseHibernateDAOImpl<IG622Info> implements IG622DAO {

	/**
	 * ���캯��
	 */
	public IG622DAOImpl(){
		super(IG622TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG622Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("hpid"));
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG622Info findByPK(Serializable pk) {
		IG622Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG622SearchCond cond){
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
	public List<IG622Info> findByCond(final IG622SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("hpid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG622SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}

}