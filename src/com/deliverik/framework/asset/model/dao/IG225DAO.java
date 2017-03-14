package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * �ʲ�������ϢDAO�ӿ�
 * 
 */
public interface IG225DAO extends BaseHibernateDAO<IG225Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG225Info> findAll();

	/**
	 * ������������
	 * @param cid ����
	 * @return �������
	 */
	public IG225Info findByPK(Serializable cid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG225SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG225Info> findByCond(final IG225SearchCond cond, final int start, final int count);
}
