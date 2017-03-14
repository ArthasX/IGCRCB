package com.deliverik.framework.user.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.condition.ActionSearchCond;

/**
 * �˵���ϢDAO�ӿ�
 * 
 */
public interface ActionTBDAO extends BaseHibernateDAO<Action> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Action> findAll();

	/**
	 * ������������
	 * @param actname ����
	 * @return �������
	 */
	public Action findByPK(Serializable actname);
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ActionSearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Action> findByCond(final ActionSearchCond cond, final int start, final int count);
	
	/**
	 * ��ѯ�û��˵�Ȩ��
	 * @param userid �û�ID
	 * @return ��������б�
	 */
	public List<Action> findUserAction(final String userid);
	
	/**
     * �Ӳ˵�������ֵȡ��
     * 
     * @param ���˵�������
     * @return �Ӳ˵�������ֵ
     */
    public String getActnameNextValue(String parActname);
}
