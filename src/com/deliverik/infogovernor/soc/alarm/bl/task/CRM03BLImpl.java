/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM03Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM03SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM03DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM03TB;

/**
  * ����: CRM03ҵ���߼�ʵ��
  * ��������: CRM03ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM03BLImpl extends BaseBLImpl implements
		CRM03BL {

	/** CRM03DAO�ӿ� */
	protected CRM03DAO crm03DAO;
	
	/**
	 * CRM03DAO�ӿ��趨
	 *
	 * @param cRM03DAO CRM03DAO�ӿ�
	 */
	public void setCrm03DAO(CRM03DAO crm03DAO) {
		this.crm03DAO = crm03DAO;
	}

	/**
	 * CRM03ʵ��ȡ��
	 *
	 * @return CRM03ʵ��
	 */
	public CRM03TB getCRM03TBInstance() {
		return new CRM03TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM03Info> searchCRM03() {
		return crm03DAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM03SearchCond cond) {
		return crm03DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM03Info> searchCRM03(
			CRM03SearchCond cond) {
		return crm03DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM03Info> searchCRM03(
			CRM03SearchCond cond, int start,
			int count) {
		return crm03DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM03Info registCRM03(CRM03Info instance)
		throws BLException {
		return crm03DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM03Info updateCRM03(CRM03Info instance)
		throws BLException {
		return crm03DAO.save(instance);
	}


	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM03(CRM03Info instance)
		throws BLException {
		crm03DAO.delete(instance);
	}


}