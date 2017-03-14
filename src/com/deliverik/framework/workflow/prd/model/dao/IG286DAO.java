/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;

/**
 * <p>����:���̼���������DAO�ӿ�</p>
 * <p>����������1.������������</p>
 *        
 * <p>������¼��</p>
 */
public interface IG286DAO extends BaseHibernateDAO<IG286Info> {
	
	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG286Info> findByCond(final IG286SearchCond cond, final int start, final int count);
	
	/**
	 * PLID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PLID����ֵ
	 */
	public String getPlidSequenceNextValue(String pdid);
}
