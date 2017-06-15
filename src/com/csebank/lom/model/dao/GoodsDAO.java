/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Goods;
import com.csebank.lom.model.condition.GoodsSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * �Ӵ�����DAO�ӿ�
 *
 */
public interface GoodsDAO extends BaseHibernateDAO<Goods> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Goods> findAll();

	/**
	 * ������������
	 * @param dadid ����
	 * @return �������
	 */
	public Goods findByPK(Serializable dadid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GoodsSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Goods> findByCond(final GoodsSearchCond cond, final int start, final int count);
	
	public List<Goods> findByCond(final String gcategory);


}
