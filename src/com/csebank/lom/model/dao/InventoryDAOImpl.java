/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.csebank.lom.model.entity.InventoryTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * ÿ���̵�DAO�ӿ�ʵ��
 *
 */
@SuppressWarnings("deprecation")
public class InventoryDAOImpl extends BaseHibernateDAOImpl<Inventory> implements InventoryDAO {

	/**
	 * ���캯��
	 */
	public InventoryDAOImpl(){
		super(InventoryTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Inventory> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("goodscategory"));
		List<Inventory> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param lpdid ����
	 * @return �������
	 */
	public Inventory findByPK(Serializable lpdid) {

		Inventory result = super.findByPK(lpdid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InventorySearchCond cond){
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
	public List<Inventory> findByCond(final InventorySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("goodscategory"));
		List<Inventory> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(InventorySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��ѯ����
		if(StringUtils.isNotEmpty(cond.getYear())){
			c.add(Expression.eq("inventorydate", cond.getYear() + "/" + cond.getMonth()));
		}
		
		return c;
	}

}
