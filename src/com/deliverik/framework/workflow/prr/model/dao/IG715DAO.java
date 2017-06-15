/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;

/**
 * ���񹤵���������DAO�ӿ�
 */
public interface IG715DAO extends BaseHibernateDAO<IG715Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG715Info> findAll();

	/**
	 * ������������
	 * @param raid ����
	 * @return �������
	 */
	public IG715Info findByPK(Serializable raid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG715SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG715Info> findByCond(final IG715SearchCond cond, final int start, final int count);

	/**
	 * ��ȡ���񹤵���������ʵ��
	 * @return ���񹤵���������ʵ��
	 */
	public IG715TB getIG715TBInstance();

}
