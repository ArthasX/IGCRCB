/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.scheduling.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoEntitySearchCond;

/**
 * 
 * �����ʲ���ϵDAO�ӿ�
 *
 */
public interface QuartzProcessInfoEntityDAO extends BaseHibernateDAO<QuartzProcessInfoEntity> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<QuartzProcessInfoEntity> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public QuartzProcessInfoEntity findByPK(Serializable psidid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final QuartzProcessInfoEntitySearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<QuartzProcessInfoEntity> findByCond(final QuartzProcessInfoEntitySearchCond cond, final int start, final int count);
	
}
