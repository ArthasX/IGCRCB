/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCond;
import com.deliverik.infogovernor.dbm.model.dao.TOPOXMLDAO;
import com.deliverik.infogovernor.dbm.model.entity.TOPOXMLTB;

/**
  * ����: TOPOXMLҵ���߼�ʵ��
  * ��������: TOPOXMLҵ���߼�ʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public class TOPOXMLBLImpl extends BaseBLImpl implements
		TOPOXMLBL {

	/** TOPOXMLDAO�ӿ� */
	protected TOPOXMLDAO tOPOXMLDAO;
	


	/**
	 * TOPOXMLʵ��ȡ��
	 *
	 * @return TOPOXMLʵ��
	 */
	public TOPOXMLTB getTOPOXMLTBInstance() {
		return new TOPOXMLTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TOPOXMLInfo> searchTOPOXML() {
		return tOPOXMLDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TOPOXMLInfo searchTOPOXMLByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(TOPOXMLSearchCond cond) {
		return tOPOXMLDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<TOPOXMLInfo> searchTOPOXML(
			TOPOXMLSearchCond cond) {
		return tOPOXMLDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return tOPOXMLDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public TOPOXMLInfo registTOPOXML(TOPOXMLInfo instance)
		throws BLException {
		return tOPOXMLDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public TOPOXMLInfo updateTOPOXML(TOPOXMLInfo instance)
		throws BLException {
		checkExistInstance(instance.getMyid());
		return tOPOXMLDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteTOPOXMLByPK(Serializable pk)
		throws BLException {
		tOPOXMLDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteTOPOXML(TOPOXMLInfo instance)
		throws BLException {
		tOPOXMLDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public TOPOXMLInfo checkExistInstance(Serializable pk)
		throws BLException {
		TOPOXMLInfo instance = tOPOXMLDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * tOPOXMLDAO�趨
	 *
	 * @param tOPOXMLDAO tOPOXMLDAO
	 */
	public void settOPOXMLDAO(TOPOXMLDAO tOPOXMLDAO) {
		this.tOPOXMLDAO = tOPOXMLDAO;
	}
	/**�����û�ɾ������*/
	public boolean deleteTOPOXMLByUserid(String userid) throws BLException{
		return tOPOXMLDAO.deleteTOPOXMLByUserid(userid);
	}

}