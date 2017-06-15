/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SynchronizationAlarmSystemVWInfo;
import com.deliverik.framework.soc.asset.model.condition.SynchronizationAlarmSystemVWSearchCond;

/**
 * ����:ͬ���澯ϵͳ��ͼDAO�ӿ�
 * ��������: ͬ���澯ϵͳ��ͼDAO�ӿ�
 * �����ˣ�����
 * ������¼: 2014/04/03
 * �޸ļ�¼: 
 */

public interface SynchronizationAlarmSystemVWDAO extends BaseHibernateDAO<SynchronizationAlarmSystemVWInfo> {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SynchronizationAlarmSystemVWInfo> findByCond(final SynchronizationAlarmSystemVWSearchCond cond);
}
