/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCond;

/**
  * ����: TOPOXMLDAO�ӿ�
  * ��������: TOPOXMLDAO�ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface TOPOXMLDAO extends BaseHibernateDAO<TOPOXMLInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TOPOXMLInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TOPOXMLInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TOPOXMLSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TOPOXMLInfo> findByCond(
			final TOPOXMLSearchCond cond, final int start,
			final int count);
	
	/**
	 * �����û�ɾ������
	 * @param userid �û�ID
	 * */
	public boolean deleteTOPOXMLByUserid(String userid);
}