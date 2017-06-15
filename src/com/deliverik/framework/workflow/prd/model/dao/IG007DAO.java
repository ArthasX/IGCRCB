/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;


/**
 * <p>����:���̱���������ϢDAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.����������¼��</p>
 * <p>          3.������������</p>
 * <p>          4.������������</p>
 * <p>������¼��</p>
 */
public interface IG007DAO extends BaseHibernateDAO<IG007Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG007Info> findAll();
	
	/**
	 * ���ܣ�����������¼��
	 * @return ����������¼��
	 */
	public int getSearchCount(final IG007SearchCond cond);

	/**
	 * ���ܣ�������������
	 * @param prid ����
	 * @return �������
	 */
	public IG007Info findByPK(Serializable prid);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG007Info> findByCond(final IG007SearchCond cond, final int start, final int count);
	
	/**
	 * PIDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PSDID����ֵ
	 */
	public String getPididSequenceNextValue(String pdid);

	public List<IG007Info> findByCondRun(final IG007SearchCond cond);
}
