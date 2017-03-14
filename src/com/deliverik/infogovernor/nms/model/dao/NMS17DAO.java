/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.nms.model.NMS17Info;
import com.deliverik.infogovernor.nms.model.condition.NMS17SearchCond;

/**
  * ����: ����������ϢDAO�ӿ�
  * ��������: ����������ϢDAO�ӿ�
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
public interface NMS17DAO extends BaseHibernateDAO<NMS17Info> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<NMS17Info> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS17Info findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final NMS17SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS17Info> findByCond(
			final NMS17SearchCond cond, final int start,
			final int count);

}