package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.IG778Info;
import com.deliverik.framework.asset.model.condition.IG778SearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ������ͼDAO�ӿ�
 * 
 * @author 
 */
public interface IG778DAO extends BaseHibernateDAO<IG778Info> {

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG778SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG778Info> findByCond(final IG778SearchCond cond, final int start, final int count);
	
	/**
	 * �����������������յ���UPS
	 * 
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG778Info> findByIG778Info(final IG778SearchCond cond);
}
