/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.ItemsCodesSt;
import com.csebank.lom.model.condition.LunchCardSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ϳ���ϢDAO�ӿ�
 *
 */
public interface LunchCardDAO extends BaseHibernateDAO<ItemsCodesSt> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<ItemsCodesSt> findAll();

	/**
	 * ������������
	 * @param icid ����
	 * @return �������
	 */
	public ItemsCodesSt findByPK(Serializable icid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final LunchCardSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ItemsCodesSt> findByCond(final LunchCardSearchCond cond, final int start, final int count);
	
	


}
