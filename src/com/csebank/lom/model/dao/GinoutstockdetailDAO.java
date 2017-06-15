/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.condition.GinoutstockdetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�����DAO�ӿ�
 *
 */
public interface GinoutstockdetailDAO extends BaseHibernateDAO<Ginoutstockdetail> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Ginoutstockdetail> findAll();

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public Ginoutstockdetail findByPK(Serializable dadid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GinoutstockdetailSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Ginoutstockdetail> findByCond(final GinoutstockdetailSearchCond cond, final int start, final int count);
	
	


}
