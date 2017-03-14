/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG809Info;
import com.deliverik.framework.asset.model.condition.IG809SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * �ʲ���ϵͼ�ļ���ϢDAO�ӿ�
 *
 */
public interface IG809DAO extends BaseHibernateDAO<IG809Info>{
	
	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG809Info> findAll();

	/**
	 * ������������
	 * @param eirfid ����
	 * @return �������
	 */
	public IG809Info findByPK(Serializable eirfid);
	

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG809SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG809Info> findByCond(final IG809SearchCond cond, final int start, final int count);

}
