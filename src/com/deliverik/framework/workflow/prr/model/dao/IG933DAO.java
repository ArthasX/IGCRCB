/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG933SearchCond;

/**
 * ���񹤵�DAO�ӿ�
 */
public interface IG933DAO extends BaseHibernateDAO<IG933Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG933Info> findAll();

	/**
	 * ȫ������
	 * @return ���������ʱ������
	 */
	public List<IG933Info> findAllAsc();
	
	/**
	 * ������������
	 * @param sfid ����
	 * @return �������
	 */
	public IG933Info findByPK(Serializable sfid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG933SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG933Info> findByCond(final IG933SearchCond cond, final int start, final int count);
	

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�ʱ������
	 */
	public List<IG933Info> findByCondAsc(final IG933SearchCond cond, final int start, final int count);
	
	 /**
	 * ��ȡ���񹤵�������ֵ
	 * @param code ���񹤵���������
	 * @return ���񹤵�������ֵ
	 */
	public String searchMaxID(String code);
}
