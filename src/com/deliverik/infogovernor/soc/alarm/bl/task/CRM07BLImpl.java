/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM07Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM07SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM07DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM07TB;

/**
  * ����: CRM07ҵ���߼�ʵ��
  * ��������: CRM07ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM07BLImpl extends BaseBLImpl implements
		CRM07BL {

	/** CRM07DAO�ӿ� */
	protected CRM07DAO crm07DAO;
	
	/**
	 * CRM07DAO�ӿ��趨
	 *
	 * @param crm07DAO CRM07DAO�ӿ�
	 */
	public void setCrm07DAO(CRM07DAO crm07DAO) {
		this.crm07DAO = crm07DAO;
	}

	/**
	 * CRM07ʵ��ȡ��
	 *
	 * @return CRM07ʵ��
	 */
	public CRM07TB getCRM07TBInstance() {
		return new CRM07TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM07Info> searchCRM07() {
		return crm07DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM07Info searchCRM07ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM07SearchCond cond) {
		return crm07DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM07Info> searchCRM07(
			CRM07SearchCond cond) {
		return crm07DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM07Info> searchCRM07(
			CRM07SearchCond cond, int start,
			int count) {
		return crm07DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM07Info registCRM07(CRM07Info instance)
		throws BLException {
		return crm07DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM07Info updateCRM07(CRM07Info instance)
		throws BLException {
		checkExistInstance(instance.getRuleconditionid());
		return crm07DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM07ByPK(Integer pk)
		throws BLException {
		crm07DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM07(CRM07Info instance)
		throws BLException {
		crm07DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CRM07Info checkExistInstance(Integer pk)
		throws BLException {
		CRM07Info instance = crm07DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}