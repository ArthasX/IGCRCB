package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;


/**
 * �����¼�������ϢDAO�ӿ�
 * 
 */
public interface IG413DAO extends BaseHibernateDAO<IG413Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG413Info> findAll();

	/**
	 * ������������
	 * @param pedid ����
	 * @return �������
	 */
	public IG413Info findByPK(Serializable pedid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG413SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG413Info> findByCond(final IG413SearchCond cond, final int start, final int count);
	
	/**
	 * PEDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getPedidSequenceNextValue(String psdid);

}
