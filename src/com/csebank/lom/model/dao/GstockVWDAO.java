/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.condition.GstockVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ���Ԥ����Ϣ��ͼDAO�ӿ�
 *
 */
public interface GstockVWDAO extends BaseHibernateDAO<GstockVWInfo> {

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GstockVWInfo> findByCond(final GstockVWSearchCond cond, final int start, final int count);
	
}
