/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM04Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM04SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM04DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM04TB;

/**
  * ����: CRM04ҵ���߼�ʵ��
  * ��������: CRM04ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM04BLImpl extends BaseBLImpl implements
		CRM04BL {

	/** CRM04DAO�ӿ� */
	protected CRM04DAO crm04DAO;
	
	/**
	 * CRM04DAO�ӿ��趨
	 *
	 * @param cRM04DAO CRM04DAO�ӿ�
	 */
	public void setCrm04DAO(CRM04DAO crm04DAO) {
		this.crm04DAO = crm04DAO;
	}

	/**
	 * CRM04ʵ��ȡ��
	 *
	 * @return CRM04ʵ��
	 */
	public CRM04TB getCRM04TBInstance() {
		return new CRM04TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM04Info> searchCRM04() {
		return crm04DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM04Info searchCRM04ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM04SearchCond cond) {
		return crm04DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM04Info> searchCRM04(
			CRM04SearchCond cond) {
		return crm04DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM04Info> searchCRM04(
			CRM04SearchCond cond, int start,
			int count) {
		return crm04DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM04Info registCRM04(CRM04Info instance)
		throws BLException {
		return crm04DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM04Info updateCRM04(CRM04Info instance)
		throws BLException {
		checkExistInstance(instance.getAlarmid());
		return crm04DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM04ByPK(Integer pk)
		throws BLException {
		crm04DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM04(CRM04Info instance)
		throws BLException {
		crm04DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CRM04Info checkExistInstance(Integer pk)
		throws BLException {
		CRM04Info instance = crm04DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}