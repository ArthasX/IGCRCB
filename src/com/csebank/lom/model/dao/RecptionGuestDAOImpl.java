/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.RecptionGuest;
import com.csebank.lom.model.condition.RecptionGuestSearchCond;
import com.csebank.lom.model.entity.RecptionGuestTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * �Ӵ�����DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class RecptionGuestDAOImpl extends BaseHibernateDAOImpl<RecptionGuest> implements RecptionGuestDAO {

	/**
	 * ���캯��
	 */
	public RecptionGuestDAOImpl(){
		super(RecptionGuestTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<RecptionGuest> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("rgid"));
		List<RecptionGuest> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rgid ����
	 * @return �������
	 */
	public RecptionGuest findByPK(Serializable rgid) {

		RecptionGuest result = super.findByPK(rgid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final RecptionGuestSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionGuest> findByCond(final RecptionGuestSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("rgid"));
		List<RecptionGuest> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(RecptionGuestSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�Ӵ�����ID
		if(cond.getRid()!=null && cond.getRid()!=0){
			c.add(Expression.eq("rid", cond.getRid()));
		}

		return c;
	}

}
