/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCond;

/**
 * 
 * ���̲����߱���Ȩ��DAO�ӿ�
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG881DAO extends BaseHibernateDAO<IG881Info>{
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG881Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG881Info findByPK(Serializable pipdid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG881SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG881Info> findByCond(final IG881SearchCond cond, final int start, final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG100Info> findByCond(final IG100SearchCond cond);
	
	/**
	 * PIPDID����ֵȡ��
	 * 
	 * @param ����״̬�����߶���ID
	 * @return PIPDID����ֵ
	 */
	public String getPipdidSequenceNextValue(String ppdid);
	
}
