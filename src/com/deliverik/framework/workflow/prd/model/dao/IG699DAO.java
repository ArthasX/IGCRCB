/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;

/**
 * 
 * ����ȱʡ�����߱���Ȩ��DAO�ӿ�
 *
 */
public interface IG699DAO extends BaseHibernateDAO<IG699Info>{
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG699Info> findAll();

	/**
	 * ������������
	 * @param psdid ����
	 * @return �������
	 */
	public IG699Info findByPK(Serializable pdvid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG699SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG699Info> findByCond(final IG699SearchCond cond, final int start, final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG909Info> searchIG909Info(final IG909SearchCond cond);
	
	/**
	 * PDVID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PDVID����ֵ
	 */
	public String getPdvidSequenceNextValue(String psdid);
	
}
