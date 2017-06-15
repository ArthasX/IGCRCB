/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;

/**
 * 
 * ����״̬ԾǨ����DAO�ӿ�
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG273DAO extends BaseHibernateDAO<IG273Info> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG273Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG273Info findByPK(Serializable ptdid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG273SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG273Info> findByCond(final IG273SearchCond cond, final int start, final int count);
	
	/**
	 * PTDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PTDID����ֵ
	 */
	public String getPtdidSequenceNextValue(String psdid);
	
}
