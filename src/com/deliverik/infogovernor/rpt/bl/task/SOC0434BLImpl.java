/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0434Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0434SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0434DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0434TB;

/**
  * ����: PVVIOҵ���߼�ʵ��
  * ��������: PVVIOҵ���߼�ʵ��
  * ������¼: 2012/08/20
  * �޸ļ�¼: 
  */
public class SOC0434BLImpl extends BaseBLImpl implements
		SOC0434BL {

	/** PVVIODAO�ӿ� */
	protected SOC0434DAO soc0434DAO;
	
	
	/**
	 * PVVIOʵ��ȡ��
	 *
	 * @return PVVIOʵ��
	 */
	public SOC0434TB getPVVIOTBInstance() {
		return new SOC0434TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0434Info> searchPVVIO() {
		return soc0434DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0434Info searchPVVIOByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0434SearchCond cond) {
		return soc0434DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0434Info> searchPVVIO(
			SOC0434SearchCond cond) {
		return soc0434DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0434Info> searchPVVIO(
			SOC0434SearchCond cond, int start,
			int count) {
		return soc0434DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0434Info registPVVIO(SOC0434Info instance)
		throws BLException {
		return soc0434DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0434Info updatePVVIO(SOC0434Info instance)
		throws BLException {
		checkExistInstance(instance.getPVVID());
		return soc0434DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePVVIOByPK(Integer pk)
		throws BLException {
		soc0434DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePVVIO(SOC0434Info instance)
		throws BLException {
		soc0434DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0434Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0434Info instance = soc0434DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * PVVIODAO�ӿ��趨
	 *
	 * @param soc0434DAO PVVIODAO�ӿ�
	 */
	public void setSoc0434DAO(SOC0434DAO soc0434DAO) {
		this.soc0434DAO = soc0434DAO;
	}



}