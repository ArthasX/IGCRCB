/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM09Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM09SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM09DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM09TB;

/**
  * ����: CRM09ҵ���߼�ʵ��
  * ��������: CRM09ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM09BLImpl extends BaseBLImpl implements
		CRM09BL {

	/** CRM09DAO�ӿ� */
	protected CRM09DAO crm09DAO;
	
	/**
	 * crm09DAO�ӿ��趨
	 *
	 * @param crm09DAO crm09DAO�ӿ�
	 */
	public void setCrm09DAO(CRM09DAO crm09DAO) {
		this.crm09DAO = crm09DAO;
	}

	/**
	 * CRM09ʵ��ȡ��
	 *
	 * @return CRM09ʵ��
	 */
	public CRM09TB getCRM09TBInstance() {
		return new CRM09TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM09Info> searchCRM09() {
		return crm09DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM09Info searchCRM09ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM09SearchCond cond) {
		return crm09DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM09Info> searchCRM09(
			CRM09SearchCond cond) {
		return crm09DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM09Info> searchCRM09(
			CRM09SearchCond cond, int start,
			int count) {
		return crm09DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM09Info registCRM09(CRM09Info instance)
		throws BLException {
		return crm09DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM09Info updateCRM09(CRM09Info instance)
		throws BLException {
		checkExistInstance(instance.getRelationid());
		return crm09DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM09ByPK(Integer pk)
		throws BLException {
		crm09DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM09(CRM09Info instance)
		throws BLException {
		crm09DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CRM09Info checkExistInstance(Integer pk)
		throws BLException {
		CRM09Info instance = crm09DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}