/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.condition.RecptionVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�����DAO�ӿ�
 *
 */
public interface RecptionVWDAO extends BaseHibernateDAO<RecptionVWInfo> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RecptionVWInfo> findByCond(final RecptionVWSearchCond cond, final int start, final int count);
	

}
