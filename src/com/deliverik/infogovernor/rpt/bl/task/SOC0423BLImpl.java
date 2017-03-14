/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0423Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0423SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0423DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0423TB;

/**
  * ����: ���������ҵ���߼�ʵ��
  * ��������: ���������ҵ���߼�ʵ��
  * ������¼: 2012/07/17
  * �޸ļ�¼: 2012/08/09 ��CapacityObjectListBLImpl������ΪSOC0423BLImpl
  */
public class SOC0423BLImpl extends BaseBLImpl implements
		SOC0423BL {

	/** ���������DAO�ӿ� */
	protected SOC0423DAO soc0423DAO;
	
	/**
	 * ���������DAO�ӿ��趨
	 *
	 * @param soc0423DAO ���������DAO�ӿ�
	 */
	public void setSoc0423DAO(SOC0423DAO soc0423DAO) {
		this.soc0423DAO = soc0423DAO;
	}

	/**
	 * ���������ʵ��ȡ��
	 *
	 * @return ���������ʵ��
	 */
	public SOC0423TB getSOC0423Instance() {
		return new SOC0423TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0423Info> searchSOC0423() {
		return soc0423DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0423Info searchSOC0423ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0423SearchCond cond) {
		return soc0423DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0423Info> searchSOC0423(
			SOC0423SearchCond cond) {
		return soc0423DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0423Info> searchSOC0423(
			SOC0423SearchCond cond, int start,
			int count) {
		return soc0423DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0423Info registSOC0423(SOC0423Info instance)
		throws BLException {
		return soc0423DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0423Info updateSOC0423(SOC0423Info instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return soc0423DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0423ByPK(Integer pk)
		throws BLException {
		soc0423DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0423(SOC0423Info instance)
		throws BLException {
		soc0423DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0423Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0423Info instance = soc0423DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}