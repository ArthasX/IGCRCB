package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * �ʲ���ϢDAO�ӿ�
 * 
 */
public interface IG117DAO extends BaseHibernateDAO<IG117Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG117Info> findAll();

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public IG117Info findByPK(Serializable eid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG117SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG117Info> findByCond(final IG117SearchCond cond, final int start, final int count);
	
	public List<IG117Info> findByCond(final IG117SearchCond cond,final String id);
	public List<IG117Info> findByCondCoding(final IG117SearchCond cond);
}
