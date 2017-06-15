package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.condition.IG313SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;



/**
 * �ʲ����ϵ��ϢDAO�ӿ�
 * 
 */
public interface IG313DAO extends BaseHibernateDAO<IG313Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG313Info> findAll();

	/**
	 * ������������
	 * @param eirid ����
	 * @return �������
	 */
	public IG313Info findByPK(Serializable eirid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG313SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG313Info> findByCond(final IG313SearchCond cond, final int start, final int count);
	
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG313Info> searchMaxIG313Info(final IG313SearchCond cond);
	
}
