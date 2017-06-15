/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCond;

/**
 * ���̹�ϵʵ��DAO�ӿ�
 * 
 */
public interface EmergencyRelationDAO extends BaseHibernateDAO<EmergencyRelationInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<EmergencyRelationInfo> findAll();

	/**
	 * ������������
	 * @param prrid ����
	 * @return �������
	 */
	public EmergencyRelationInfo findByPK(Serializable prrid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final EmergencyRelationSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EmergencyRelationInfo> findByCond(final EmergencyRelationSearchCond cond, final int start, final int count);

	
}
