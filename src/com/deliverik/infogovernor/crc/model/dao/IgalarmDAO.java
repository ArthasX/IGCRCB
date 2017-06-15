/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;

/**
  * ����: ���ɸ澯��DAO�ӿ�
  * ��������: ���ɸ澯��DAO�ӿ�
  * ������¼: 2014/06/21
  * �޸ļ�¼: 
  */
public interface IgalarmDAO extends BaseHibernateDAO<IgalarmInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgalarmInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgalarmInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IgalarmSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgalarmInfo> findByCond(
			final IgalarmSearchCond cond, final int start,
			final int count);
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IGCRC0208VWInfo> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count);

	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond);
	

	/**
	 * ������������(û��Ĭ������)
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgalarmInfo> findByCondNoSort(final IgalarmSearchCond cond, final int start, final int count);
}