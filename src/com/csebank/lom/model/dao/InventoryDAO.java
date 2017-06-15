/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.condition.InventorySearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ÿ���̵�DAO�ӿ�
 *
 */
public interface InventoryDAO extends BaseHibernateDAO<Inventory> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Inventory> findAll();

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public Inventory findByPK(Serializable lpdid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final InventorySearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Inventory> findByCond(final InventorySearchCond cond, final int start, final int count);
	

}
