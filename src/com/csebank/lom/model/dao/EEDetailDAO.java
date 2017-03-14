/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EESearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż�����ϸDAO�ӿ�
 * ���ߣ�������
 */
public interface EEDetailDAO extends BaseHibernateDAO<Eentertainment> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Eentertainment> findByCond(final EESearchCond cond, final int start, final int count);
	
	
	

}
