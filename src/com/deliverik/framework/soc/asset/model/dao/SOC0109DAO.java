package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;



/**
 * �ʲ�������ϢDAO�ӿ�
 * 
 */
public interface SOC0109DAO extends BaseHibernateDAO<SOC0109Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SOC0109Info> findAll();

	/**
	 * ������������
	 * @param cid ����
	 * @return �������
	 */
	public SOC0109Info findByPK(Serializable cid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0109SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0109Info> findByCond(final SOC0109SearchCond cond, final int start, final int count);

	/**
	 * ��ȡ���CID��
	 * @param cond
	 * @return
	 */
	public List<SOC0109Info> findMaxCidByCond(final SOC0109SearchCond cond);
}
