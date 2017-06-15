/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM05Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM05SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM05DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM05TB;

/**
  * ����: CRM05ҵ���߼�ʵ��
  * ��������: CRM05ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM05BLImpl extends BaseBLImpl implements
		CRM05BL {

	/** CRM05DAO�ӿ� */
	protected CRM05DAO crm05DAO;
	
	
	public CRM05DAO getCrm05DAO() {
		return crm05DAO;
	}

	public void setCrm05DAO(CRM05DAO crm05DAO) {
		this.crm05DAO = crm05DAO;
	}

	/**
	 * CRM05ʵ��ȡ��
	 *
	 * @return CRM05ʵ��
	 */
	public CRM05TB getCRM05TBInstance() {
		return new CRM05TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM05Info> searchCRM05() {
		return crm05DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM05Info searchCRM05ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM05SearchCond cond) {
		return crm05DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM05Info> searchCRM05(
			CRM05SearchCond cond) {
		return crm05DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM05Info> searchCRM05(
			CRM05SearchCond cond, int start,
			int count) {
		return crm05DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM05Info registCRM05(CRM05Info instance)
		throws BLException {
		return crm05DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM05Info updateCRM05(CRM05Info instance)
		throws BLException {
		checkExistInstance(instance.getFileid());
		return crm05DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM05ByPK(Integer pk)
		throws BLException {
		crm05DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM05(CRM05Info instance)
		throws BLException {
		crm05DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CRM05Info checkExistInstance(Integer pk)
		throws BLException {
		CRM05Info instance = crm05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}