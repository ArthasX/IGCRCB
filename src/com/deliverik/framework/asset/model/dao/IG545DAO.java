/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * �ʲ���������DAO�ӿ�
 * 
 */
public interface IG545DAO extends BaseHibernateDAO<IG545Info> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG545Info> findByCond(final IG545SearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡȡֵ��Χ��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG545Bean> findIG545Bean(final IG545SearchCond cond);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG545SearchCond cond);
}
