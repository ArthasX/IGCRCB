/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD02SearchCond;

/**
  * ����: ������Դ��Ŀ��ϢDAO�ӿ�
  * ��������: ������Դ��Ŀ��ϢDAO�ӿ�
  * ������¼: 2014/02/25
  * �޸ļ�¼: 
  */
public interface VCD02DAO extends BaseHibernateDAO<VCD02Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<VCD02Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public VCD02Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final VCD02SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<VCD02Info> findByCond(
			final VCD02SearchCond cond, final int start,
			final int count);

}