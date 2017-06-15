/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.condition.SingleGoodsStockSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ��һ��Ʒ���ͳ��DAO�ӿ�
 *
 */
public interface SingleGoodsStockDAO extends BaseHibernateDAO<SingleGoodsStock> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SingleGoodsStock> findByCond(final SingleGoodsStockSearchCond cond, final int start, final int count);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public List<SingleGoodsStock> getSearchCount(final SingleGoodsStockSearchCond cond);
}
