/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�����DAO�ӿ�
 *
 */
public interface GinoutStockDetailVWDAO extends BaseHibernateDAO<GinoutStockDetailVW> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GinoutstockdetailSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GinoutStockDetailVW> findByCond(final GinoutstockdetailSearchCond cond, final int start, final int count);
	
	


}
