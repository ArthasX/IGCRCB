/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;


/**
 * ����: ���̲����趨��ϢDAO�ӿ�
 * �������������̲����趨��ϢDAO�ӿ�
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public interface IG105DAO extends BaseHibernateDAO<IG105Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG105Info> findAll();

	/**
	 * ���ܣ�������������
	 * @param pk ����
	 * @return �������
	 */
	public IG105Info findByPK(Serializable pk);
	

	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG105SearchCond cond);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG105Info> findByCond(final IG105SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ���ȡָ�����̶���ID��ǰ�������汾��
	 * @param pdid���̶���ID
	 * @return ��ǰ�������汾��
	 */
	public Integer getMaxgPsdversion(String pdid);

}
