/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCond;
import com.deliverik.infogovernor.drm.model.dao.SOC0509DAO;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;

/**
  * ����: Ԥ���½���Ϣҵ���߼�ʵ��
  * ��������: Ԥ���½���Ϣҵ���߼�ʵ��
  * ������¼: 2016/07/07
  * �޸ļ�¼: 
  */
public class SOC0509BLImpl extends BaseBLImpl implements
		SOC0509BL {

	/** Ԥ���½���ϢDAO�ӿ� */
	protected SOC0509DAO soc0509DAO;
	
	/**
	 * Ԥ���½���ϢDAO�ӿ��趨
	 *
	 * @param sOC0509DAO Ԥ���½���ϢDAO�ӿ�
	 */

	/**
	 * Ԥ���½���Ϣʵ��ȡ��
	 *
	 * @return Ԥ���½���Ϣʵ��
	 */
	public SOC0509TB getSOC0509TBInstance() {
		return new SOC0509TB();
	}

	public void setSoc0509DAO(SOC0509DAO soc0509DAO) {
		this.soc0509DAO = soc0509DAO;
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0509Info> searchSOC0509() {
		return soc0509DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0509Info searchSOC0509ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0509SearchCond cond) {
		return soc0509DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0509Info> searchSOC0509(
			SOC0509SearchCond cond) {
		return soc0509DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0509Info> searchSOC0509(
			SOC0509SearchCond cond, int start,
			int count) {
		return soc0509DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0509Info registSOC0509(SOC0509Info instance)
		throws BLException {
		return soc0509DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0509Info updateSOC0509(SOC0509Info instance)
		throws BLException {
		checkExistInstance(instance.getCid());
		return soc0509DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0509ByPK(String pk)
		throws BLException {
		soc0509DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0509(SOC0509Info instance)
		throws BLException {
		soc0509DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0509Info checkExistInstance(String pk)
		throws BLException {
		SOC0509Info instance = soc0509DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public Integer getNextCorder() {
		return soc0509DAO.getNextCorder();
	}

}