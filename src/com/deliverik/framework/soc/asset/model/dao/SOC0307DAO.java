/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCond;

/**
  * ����: StorageEventVWDAO�ӿ�
  * ��������: StorageEventVWDAO�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0307DAO extends BaseHibernateDAO<SOC0307Info> {
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0305SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0307Info> findByCond(final SOC0305SearchCond cond, final int start, final int count);
}