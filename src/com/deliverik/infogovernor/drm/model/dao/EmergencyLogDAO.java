/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.EmergencyLogInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyLogSearchCond;

/**
 * ������Ӧ����־��Ϣ��DAO�ӿ�
 * ����������Ӧ����־��Ϣ��DAO�ӿ�
 * ������¼��2014/05/19
 * (1)�����뽵������������EmergencyLogTB�е��ֶ���Ϊ��������ֻ�Ǽ�����û�漰���ӹ�ϵ
 * �޸ļ�¼��
 */
public interface EmergencyLogDAO extends BaseHibernateDAO<EmergencyLogInfo> {
	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EmergencyLogInfo> findAll();
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EmergencyLogInfo findByPK(Serializable pk);
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmergencyLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmergencyLogInfo> findByCond(final EmergencyLogSearchCond cond, final int start, final int count);
}