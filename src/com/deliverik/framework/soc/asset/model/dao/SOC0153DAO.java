/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0153Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0153SearchCond;

/**
  * ����: ��־��Ϣ�ӿ�
  * ��������: ��־��Ϣ�ӿ�
  * ������¼: 2013/12/05
  * �޸ļ�¼: 
  */
public interface SOC0153DAO extends BaseHibernateDAO<SOC0153Info> {
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0153SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0153Info> findByCond(final SOC0153SearchCond cond, final int start, final int count);
}