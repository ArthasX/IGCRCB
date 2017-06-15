/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0605SearchCond;

/**
 * �ʲ�����ͼDAO�ӿ�
 * 
 * @author 
 */
public interface SOC0605DAO extends BaseHibernateDAO<SOC0605Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0605SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0605Info> findByCond(final SOC0605SearchCond cond, final int start, final int count);
	
}
