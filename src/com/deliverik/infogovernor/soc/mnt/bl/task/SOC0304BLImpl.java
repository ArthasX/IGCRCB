/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0304SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.SOC0304DAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.SOC0304TB;

/**
  * ����: �����������ҵ���߼�ʵ��
  * ��������: �����������ҵ���߼�ʵ��
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
public class SOC0304BLImpl extends BaseBLImpl implements
		SOC0304BL {

	/** �����������DAO�ӿ� */
	protected SOC0304DAO soc0304DAO;
	
	/**
	 * �����������DAO�ӿ��趨
	 *
	 * @param soc0304DAO �����������DAO�ӿ�
	 */
	public void setSoc0304DAO(SOC0304DAO soc0304DAO) {
		this.soc0304DAO = soc0304DAO;
	}

	/**
	 * �����������ʵ��ȡ��
	 *
	 * @return �����������ʵ��
	 */
	public SOC0304TB getSoc0304Instance() {
		return new SOC0304TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0304Info> searchSoc0304() {
		return soc0304DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0304Info searchSoc0304ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0304SearchCond cond) {
		return soc0304DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond) {
		return soc0304DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0304Info> searchSoc0304(
			SOC0304SearchCond cond, int start,
			int count) {
		return soc0304DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0304Info registSoc0304(SOC0304Info instance)
		throws BLException {
		return soc0304DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0304Info updateSoc0304(SOC0304Info instance)
		throws BLException {
		checkExistInstance(instance.getMtId());
		return soc0304DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSoc0304ByPK(Integer pk)
		throws BLException {
		soc0304DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSoc0304(SOC0304Info instance)
		throws BLException {
		soc0304DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0304Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0304Info instance = soc0304DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}