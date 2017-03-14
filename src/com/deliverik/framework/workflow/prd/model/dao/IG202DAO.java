/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;

/**
 * <p>����:���̹�ͨ����DAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.���������������ȡ��</p>
 * <p>          4.������������</p>
 * <p>          5.����������¼��</p>
 * <p>������¼��</p>
 */
public interface IG202DAO extends BaseHibernateDAO<IG202Info> {
	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG202Info> findAll();

	/**
	 * ���ܣ�������������
	 * @param pdaid ����
	 * @return �������
	 */
	public IG202Info findByPK(Serializable pdaid);
	

	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG202SearchCond cond);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG202Info> findByCond(final IG202SearchCond cond, final int start, final int count);
	

	/**
	 * ���ܣ�����������¼��
	 * @return ����������¼��
	 */
	public int searchIG202InfoCount(final IG202SearchCond cond);
	
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG202Info> searchIG202Info(final IG202SearchCond cond, final int start, final int count);
	
}
