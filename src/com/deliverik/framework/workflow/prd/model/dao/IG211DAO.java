/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;

/**
 * 
 * ����״̬����ǰ����DAO�ӿ�
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG211DAO extends BaseHibernateDAO<IG211Info> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG211Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG211Info findByPK(Serializable psidid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG211SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG211Info> findByCond(final IG211SearchCond cond, final int start, final int count);
	
	/**
	 * PSIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PSIDID����ֵ
	 */
	public String getPsididSequenceNextValue(String psdid);
	
}
