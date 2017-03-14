/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;

/**
 * 
 * ���̽�ɫ���Ͷ���DAO�ӿ�
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG213DAO extends BaseHibernateDAO<IG213Info> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG213Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG213Info findByPK(Serializable prtdid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG213SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG213Info> findByCond(final IG213SearchCond cond, final int start, final int count);
	
	/**
	 * PRTDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PRTDID����ֵ
	 */
	public String getPrtdidSequenceNextValue(String pdid);
	
}
