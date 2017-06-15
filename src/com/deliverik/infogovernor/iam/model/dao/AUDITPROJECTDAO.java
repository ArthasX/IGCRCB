/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.condition.AUDITPROJECTSearchCond;

/**
  * ����: ��Ʊ����DAO�ӿ�
  * ��������: ��Ʊ����DAO�ӿ�
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
public interface AUDITPROJECTDAO extends BaseHibernateDAO<AUDITPROJECTInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AUDITPROJECTInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AUDITPROJECTInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final AUDITPROJECTSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AUDITPROJECTInfo> findByCond(
			final AUDITPROJECTSearchCond cond, final int start,
			final int count);

}