/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.TOPOXMLTB;

/**
  * ����: TOPOXMLҵ���߼��ӿ�
  * ��������: TOPOXMLҵ���߼��ӿ�
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public interface TOPOXMLBL extends BaseBL {

	/**
	 * TOPOXMLʵ��ȡ��
	 *
	 * @return TOPOXMLʵ��
	 */
	public TOPOXMLTB getTOPOXMLTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TOPOXMLInfo> searchTOPOXML();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TOPOXMLInfo searchTOPOXMLByPK(Serializable pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TOPOXMLSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TOPOXMLInfo> searchTOPOXML(
			TOPOXMLSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<TOPOXMLInfo> searchTOPOXML(
			TOPOXMLSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TOPOXMLInfo registTOPOXML(TOPOXMLInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TOPOXMLInfo updateTOPOXML(TOPOXMLInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTOPOXMLByPK(Serializable pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTOPOXML(TOPOXMLInfo instance)
		throws BLException;
	
	/**�����û�ɾ������*/
	public boolean deleteTOPOXMLByUserid(String userid) throws BLException;

}