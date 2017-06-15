package com.csebank.lom.model.dao;


/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */


import java.util.List;

import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.condition.DealVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ����Ͳ͹���DAO�ӿ�
 *
 */
public interface DealVWDAO extends BaseHibernateDAO<DealVWInfo> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DealVWInfo> findByCond(final DealVWSearchCond cond, final int start, final int count);
	

}
