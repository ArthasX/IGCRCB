/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ��Ʒ������Ϣ��ͼDAO�ӿ�
 *
 */
public interface GoutstockVWDAO extends BaseHibernateDAO<GoutstockVWInfo> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GoutstockVWSearchCond cond);
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoutstockVWInfo> findByCond(final GoutstockVWSearchCond cond, final int start, final int count);
	
}
