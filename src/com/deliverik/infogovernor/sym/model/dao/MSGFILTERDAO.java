/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;

/**
  * ����: MSGFILTERDAO�ӿ�
  * ��������: MSGFILTERDAO�ӿ�
  * ������¼: 2013/08/21
  * �޸ļ�¼: 
  */
public interface MSGFILTERDAO extends BaseHibernateDAO<MSGFILTERInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MSGFILTERInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MSGFILTERInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final MSGFILTERSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MSGFILTERInfo> findByCond(
			final MSGFILTERSearchCond cond, final int start,
			final int count);

}