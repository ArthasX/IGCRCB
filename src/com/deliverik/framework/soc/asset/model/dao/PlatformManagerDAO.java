package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.PlatformManagerInfo;
import com.deliverik.framework.soc.asset.model.condition.PlatformManagerVWSearchCond;



/**
 * �ʲ����ϵ��ϢDAO�ӿ�
 * 
 */
public interface PlatformManagerDAO extends BaseHibernateDAO<PlatformManagerInfo> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<PlatformManagerInfo> findAll();

	/**
	 * ������������
	 * @param eirid ����
	 * @return �������
	 */
	public PlatformManagerInfo findByPK(Serializable eirid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final PlatformManagerVWSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PlatformManagerInfo> findByCond(final PlatformManagerVWSearchCond cond, final int start, final int count);
	
	
}
