/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0602SearchCond;

/**
 * �豸��ͼDAO�ӿ�
 * 
 * @author 
 */
public interface SOC0602DAO extends BaseHibernateDAO<SOC0602Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0602SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0602Info> findByCond(final SOC0602SearchCond cond, final int start, final int count);
	
	/**
     * ������������ģ����ѯ�豸���������豸���ڻ��񣬻���
     * 
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<Object[]> findZhiJiLocation(final SOC0602SearchCond cond);
}
