/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;

/**
 * 
 * �����ʲ���ϵDAO�ӿ�
 *
 */
public interface IG731DAO extends BaseHibernateDAO<IG731Info> {
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG731Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG731Info findByPK(Serializable psidid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG731SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG731Info> findByCond(final IG731SearchCond cond, final int start, final int count);
	
	
	/**
	 * ͨ������prid��ѯ��ص�ҵ��ϵͳ�ʲ�
	 * @param prid
	 * @return ��������б�
	 */
	public List<IG731Info> searchIG731InfoBySePrid(final Integer prid,final String flowType);
	
	/**
	 * ��������prid��ѯ������eiid
	 * @param prid ����id
	 * @param flowType ��������
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid(final Integer prid,final String flowType);
}
