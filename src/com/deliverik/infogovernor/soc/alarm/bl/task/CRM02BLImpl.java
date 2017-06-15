/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.alarm.model.CRM02Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM02SearchCond;
import com.deliverik.infogovernor.soc.alarm.model.dao.CRM02DAO;
import com.deliverik.infogovernor.soc.alarm.model.entity.CRM02TB;

/**
  * ����: CRM02ҵ���߼�ʵ��
  * ��������: CRM02ҵ���߼�ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public class CRM02BLImpl extends BaseBLImpl implements
		CRM02BL {

	/** CRM02DAO�ӿ� */
	protected CRM02DAO crm02DAO;
	

	/**
	 * CRM02ʵ��ȡ��
	 *
	 * @return CRM02ʵ��
	 */
	public CRM02TB getCRM02TBInstance() {
		return new CRM02TB();
	}

	public CRM02DAO getCrm02DAO() {
		return crm02DAO;
	}

	public void setCrm02DAO(CRM02DAO crm02DAO) {
		this.crm02DAO = crm02DAO;
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CRM02Info> searchCRM02() {
		return crm02DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CRM02Info searchCRM02ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CRM02SearchCond cond) {
		return crm02DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CRM02Info> searchCRM02(
			CRM02SearchCond cond) {
		return crm02DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CRM02Info> searchCRM02(
			CRM02SearchCond cond, int start,
			int count) {
		return crm02DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CRM02Info registCRM02(CRM02Info instance)
		throws BLException {
		return crm02DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CRM02Info updateCRM02(CRM02Info instance)
		throws BLException {
		checkExistInstance(instance.getTablename());
		return crm02DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCRM02ByPK(String pk)
		throws BLException {
		crm02DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCRM02(CRM02Info instance)
		throws BLException {
		crm02DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CRM02Info checkExistInstance(String pk)
		throws BLException {
		CRM02Info instance = crm02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}