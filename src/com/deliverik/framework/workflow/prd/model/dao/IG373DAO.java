/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;

/**
  * ����: ���̱���ʼ���¼������DAO�ӿ�
  * ��������: ���̱���ʼ���¼������DAO�ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 
  */
public interface IG373DAO extends BaseHibernateDAO<IG373Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG373Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG373Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG373SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG373Info> findByCond(
			final IG373SearchCond cond, final int start,
			final int count);
	
	/**
	 * PIIDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PIIDID����ֵ
	 */
	public String getPiididSequenceNextValue(String psdid);

}