/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.EworkingLunch;
import com.csebank.lom.model.condition.EworkingLunchSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * ʳ�ù�������ϢDAO�ӿ�
 *
 */
public interface EworkingLunchDAO extends BaseHibernateDAO<EworkingLunch> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<EworkingLunch> findAll();

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public EworkingLunch findByPK(Serializable ewlid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EworkingLunchSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EworkingLunch> findByCond(final EworkingLunchSearchCond cond, final int start, final int count);
	
	


}
