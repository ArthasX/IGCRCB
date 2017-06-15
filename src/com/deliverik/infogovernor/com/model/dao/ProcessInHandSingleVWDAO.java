/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.com.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCond;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCondImpl;

/**
 * 
 * Ԥ֧��Աͳ��DAO
 * 
 */
public interface ProcessInHandSingleVWDAO extends BaseHibernateDAO<ProcessInHandVWInfo> {
	
	/**
	 * �ҵĹ�����������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessInHandVWInfo> searchProcessInhand(
			final ProcessInHandVWInfoSearchCond cond,final int start, final int count, final boolean desc) ;
	
	/**
	 * ��ع�����������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessInHandVWInfo> searchProcessInhandGroup(
			final ProcessInHandVWInfoSearchCond cond,final int start,final int count, final boolean desc); 

	/**
	 * ��ֹ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessInHandVWInfo> searchProcessInhandDiscontinue(final ProcessInHandVWInfoSearchCondImpl cond,final boolean desc);
}
