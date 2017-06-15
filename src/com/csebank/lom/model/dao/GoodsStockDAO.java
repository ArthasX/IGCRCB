/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.condition.GoodsStockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ���ͳ��DAO�ӿ�
 *
 */
public interface GoodsStockDAO extends BaseHibernateDAO<GoodsStock> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoodsStock> findByCond(final GoodsStockSearchCond cond, final int start, final int count);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public List<GoodsStock> getSearchCount(final GoodsStockSearchCond cond);
}
