/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;

/**
 * ����:��ظ澯ip��ͼDAO�ӿ�
 * ��������: ��ظ澯ip��ͼDAO�ӿ�
 * �����ˣ�����
 * ������¼: 2014/04/01
 * �޸ļ�¼: 
 */

public interface MonitoringAlarmIPVWDAO extends BaseHibernateDAO<SOC0107Info> {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0107Info> findByCond(final SOC0107SearchCond cond);
}
