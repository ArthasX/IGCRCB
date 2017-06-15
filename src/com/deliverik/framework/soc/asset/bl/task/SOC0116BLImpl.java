/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0116Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0116SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0116DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0116TB;

/**
  * ����: EiWaitTaskTempҵ���߼�ʵ��
  * ��������: EiWaitTaskTempҵ���߼�ʵ��
  * ������¼: 2012/07/30
  * �޸ļ�¼: 
  */
public class SOC0116BLImpl extends BaseBLImpl implements
		SOC0116BL {

	/** EiWaitTaskTempDAO�ӿ� */
	protected SOC0116DAO soc0116DAO;
	


	/**
	 * EiWaitTaskTempDAO�ӿ��趨
	 *
	 * @param soc0116DAO EiWaitTaskTempDAO�ӿ�
	 */
	public void setSoc0116DAO(SOC0116DAO soc0116DAO) {
		this.soc0116DAO = soc0116DAO;
	}

	/**
	 * EiWaitTaskTempʵ��ȡ��
	 *
	 * @return EiWaitTaskTempʵ��
	 */
	public SOC0116TB getEiWaitTaskTempTBInstance() {
		return new SOC0116TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp() {
		return soc0116DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0116Info searchEiWaitTaskTempByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0116SearchCond cond) {
		return soc0116DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond) {
		return soc0116DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0116Info> searchEiWaitTaskTemp(
			SOC0116SearchCond cond, int start,
			int count) {
		return soc0116DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0116Info registEiWaitTaskTemp(SOC0116Info instance)
		throws BLException {
		return soc0116DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0116Info updateEiWaitTaskTemp(SOC0116Info instance)
		throws BLException {
		checkExistInstance(instance.getEwtId());
		return soc0116DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiWaitTaskTempByPK(Integer pk)
		throws BLException {
		soc0116DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiWaitTaskTemp(SOC0116Info instance)
		throws BLException {
		soc0116DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0116Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0116Info instance = soc0116DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "instance");
		}
		return instance;
	}

}