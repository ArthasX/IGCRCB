/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCond;

/**
  * ����: ��Դ���������ϢDAO�ӿ�
  * ��������: ��Դ���������ϢDAO�ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD03DAO extends BaseHibernateDAO<VCD03Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD03Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD03Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VCD03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD03Info> findByCond(
			final VCD03SearchCond cond, final int start,
			final int count);

}