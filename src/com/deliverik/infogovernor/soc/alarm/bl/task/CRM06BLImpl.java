/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM06Info;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM06SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM06DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM06TB;

/**
  * ����: CRM06ҵ���߼�ʵ��
  * ��������: CRM06ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM06BLImpl extends BaseBLImpl implements
		CRM06BL {

	/** CRM06DAO�ӿ� */
	protected CRM06DAO crm06DAO;
	
	
	public CRM06DAO getCrm06DAO() {
		return crm06DAO;
	}

	public void setCrm06DAO(CRM06DAO crm06DAO) {
		this.crm06DAO = crm06DAO;
	}

	/**
	 * CRM06ʵ��ȡ��
	 *
	 * @return CRM06ʵ��
	 */
	public CRM06TB getCRM06TBInstance() {
		return new CRM06TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM06Info> searchCRM06() {
		return crm06DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM06Info searchCRM06ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM06SearchCond cond) {
		return crm06DAO.getSearchCount(cond);
	}
	
	/**
	 * ��ͼ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchVWCount(CRM06SearchCond cond) {
		return crm06DAO.getSearchVWCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM06Info> searchCRM06(
			CRM06SearchCond cond) {
		return crm06DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM06Info> searchCRM06(
			CRM06SearchCond cond, int start,
			int count) {
		return crm06DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM06Info registCRM06(CRM06Info instance)
		throws BLException {
		return crm06DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM06Info updateCRM06(CRM06Info instance)
		throws BLException {
		checkExistInstance(instance.getServerid());
		return crm06DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM06ByPK(Integer pk)
		throws BLException {
		crm06DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM06(CRM06Info instance)
		throws BLException {
		crm06DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CRM06Info checkExistInstance(Integer pk)
		throws BLException {
		CRM06Info instance = crm06DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	public List<CRM06VWInfo> searchCRM06VW(final CRM06SearchCond cond, final int start, final int count){
		return crm06DAO.findVWByCond(cond, start, count);
	}
	
	public List<String> getSearchVWByInstance(final CRM06SearchCond cond){
		return crm06DAO.getSearchVWByInstance(cond);
	}

}