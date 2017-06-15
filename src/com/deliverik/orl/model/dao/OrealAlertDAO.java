/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.orl.model.OrealAlertInfo;
import com.deliverik.orl.model.condition.OrealAlertSearchCond;

/**
 * ������ŷ���Ÿ澯��DAO�ӿ�
 * ����������ŷ���Ÿ澯��DAO�ӿ�
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public interface OrealAlertDAO extends BaseHibernateDAO<OrealAlertInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OrealAlertInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public OrealAlertInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws Exception 
	 */
	public int getSearchCount(final OrealAlertSearchCond cond) throws BLException;

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws Exception 
	 */
	public List<OrealAlertInfo> findByCond(final OrealAlertSearchCond cond, final int start, final int count) throws BLException;
}