/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0502SearchCond;

/**
  * ����: StorageEventVWDAO�ӿ�
  * ��������: StorageEventVWDAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0502DAO extends BaseHibernateDAO<SOC0502Info> {
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0502SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0502Info> findByCond(final SOC0502SearchCond cond, final int start, final int count);
	
	
	public void deleteByRids(Integer[] rids);
	
}