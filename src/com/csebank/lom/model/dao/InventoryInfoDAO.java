/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.InventoryInfo;
import com.csebank.lom.model.condition.InventoryInfoSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ÿ���̵�DAO�ӿ�
 *
 */
public interface InventoryInfoDAO extends BaseHibernateDAO<InventoryInfo> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InventoryInfo> findByCond(final InventoryInfoSearchCond cond, final int start, final int count);
	

}
