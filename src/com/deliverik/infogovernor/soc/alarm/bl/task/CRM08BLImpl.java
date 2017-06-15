/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM08Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM08SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM08DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM08TB;

/**
  * ����: CRM08ҵ���߼�ʵ��
  * ��������: CRM08ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM08BLImpl extends BaseBLImpl implements
		CRM08BL {

	/** CRM08DAO�ӿ� */
	protected CRM08DAO crm08DAO;
	
	/**
	 * CRM08DAO�ӿ��趨
	 *
	 * @param crm08DAO CRM08DAO�ӿ�
	 */
	public void setCrm08DAO(CRM08DAO crm08DAO) {
		this.crm08DAO = crm08DAO;
	}

	/**
	 * CRM08ʵ��ȡ��
	 *
	 * @return CRM08ʵ��
	 */
	public CRM08TB getCRM08TBInstance() {
		return new CRM08TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM08Info> searchCRM08() {
		return crm08DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM08Info searchCRM08ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM08SearchCond cond) {
		return crm08DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM08Info> searchCRM08(
			CRM08SearchCond cond) {
		return crm08DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM08Info> searchCRM08(
			CRM08SearchCond cond, int start,
			int count) {
		return crm08DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM08Info registCRM08(CRM08Info instance)
		throws BLException {
		return crm08DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM08Info updateCRM08(CRM08Info instance)
		throws BLException {
		checkExistInstance(instance.getRuletempid());
		return crm08DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM08ByPK(Integer pk)
		throws BLException {
		crm08DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM08(CRM08Info instance)
		throws BLException {
		crm08DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CRM08Info checkExistInstance(Integer pk)
		throws BLException {
		CRM08Info instance = crm08DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}