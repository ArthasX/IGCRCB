/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.csebank.lom.model.entity.EworkingLunchTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ʳ�ù����͹���DAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class EworkingLunchDAOImpl extends BaseHibernateDAOImpl<EworkingLunch> implements EworkingLunchDAO {

	/**
	 * ���캯��
	 */
	public EworkingLunchDAOImpl(){
		super(EworkingLunchTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<EworkingLunch> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ewldate"));
		List<EworkingLunch> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param ewlid ����
	 * @return �������
	 */
	public EworkingLunch findByPK(Serializable ewlid) {

		EworkingLunch result = super.findByPK(ewlid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EworkingLunchSearchCond cond){
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
	public List<EworkingLunch> findByCond(final EworkingLunchSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ewldate"));
		List<EworkingLunch> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(EworkingLunchSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
	
		//ʳ�ù�������Ϣ��ʼʱ��
		if(StringUtils.isNotEmpty(cond.getEwltime_from())){
			c.add(Expression.ge("ewldate", cond.getEwltime_from()));
		}

		//ʳ�ù�������Ϣ����ʱ��
		if(StringUtils.isNotEmpty(cond.getEwltime_to())){
			c.add(Expression.le("ewldate", cond.getEwltime_to()));
		}

		return c;
	}

}
