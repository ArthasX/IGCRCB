/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0106Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0106SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0106DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0106TB;

/**
  * ����: SOC0106ҵ���߼�ʵ��
  * ��������: SOC0106ҵ���߼�ʵ��
  * ������¼: 2012/07/31
  * �޸ļ�¼: 
  */
public class SOC0106BLImpl extends BaseBLImpl implements
		SOC0106BL {

	/** soc0106DAO�ӿ� */
	protected SOC0106DAO soc0106DAO;
	
	/**
	 * soc0106DAO�ӿ��趨
	 *
	 * @param soc0106DAO soc0106DAO�ӿ�
	 */
	public void setSoc0106DAO(SOC0106DAO soc0106DAO) {
		this.soc0106DAO = soc0106DAO;
	}

	/**
	 * AuditWaitTaskTempʵ��ȡ��
	 *
	 * @return AuditWaitTaskTempʵ��
	 */
	public SOC0106TB getSOC0106Instance() {
		return new SOC0106TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0106Info> searchSOC0106() {
		return soc0106DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0106Info searchSOC0106ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0106SearchCond cond) {
		return soc0106DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0106Info> searchSOC0106(
			SOC0106SearchCond cond) {
		return soc0106DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0106Info> searchSOC0106(
			SOC0106SearchCond cond, int start,
			int count) {
		return soc0106DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0106Info registSOC0106(SOC0106Info instance)
		throws BLException {
		return soc0106DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0106Info updateSOC0106(SOC0106Info instance)
		throws BLException {
		checkExistInstance(instance.getAwtId());
		return soc0106DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0106ByPK(Integer pk)
		throws BLException {
		soc0106DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0106(SOC0106Info instance)
		throws BLException {
		soc0106DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0106Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0106Info instance = soc0106DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "instance");
		}
		return instance;
	}

}