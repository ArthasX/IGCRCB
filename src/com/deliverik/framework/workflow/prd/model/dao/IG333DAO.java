/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;

/**
 * 
 * ����״̬����DAO�ӿ�
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG333DAO extends BaseHibernateDAO<IG333Info> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG333Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG333Info findByPK(Serializable psdid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG333SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG333Info> findByCond(final IG333SearchCond cond, final int start, final int count);
	
	/**
	 * PSDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PSDID����ֵ
	 */
	public String getPsdidSequenceNextValue(String pdid);
	
	/**
	 * ָ��״̬�����Ŀɵ��������ߵ�״̬����ȡ��
	 *
	 * @param psdid ״̬ID
	 * @return ״̬����
	 */
	public List<IG333Info> searchAdjustStatus(final String psdid);
	
	/**
	 * ���ݷ���״̬�ͷ��ɰ�ť��ѯ�����ɽڵ㼯��
	 */
	public List<IG333Info> findByAssign(final IG333SearchCond cond);
	
}
