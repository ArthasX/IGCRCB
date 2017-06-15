/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;

/**
 * ������ͼDAO�ӿ�
 * 
 * @author 
 */
public interface SOC0603DAO extends BaseHibernateDAO<SOC0603Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0603SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0603Info> findByCond(final SOC0603SearchCond cond, final int start, final int count);
	
	/**
	 * �����������������յ���UPS
	 * 
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<SOC0603Info> findBySOC0603Info(final SOC0603SearchCond cond);
}
