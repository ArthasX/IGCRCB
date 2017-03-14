package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;


/**
 * ����ҳ�涨����ϢDAO�ӿ�
 * 
 */
public interface IG126DAO extends BaseHibernateDAO<IG126Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG126Info> findAll();

	/**
	 * ������������
	 * @param pedid ����
	 * @return �������
	 */
	public IG126Info findByPK(Serializable pedid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG126SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG126Info> findByCond(final IG126SearchCond cond, final int start, final int count);
	
	/**
	 * PJDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PJDID����ֵ
	 */
	public String getPjdidSequenceNextValue(String pdid);

}
