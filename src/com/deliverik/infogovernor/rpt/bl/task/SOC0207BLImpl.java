/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0207Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0207DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0207TB;

/**
  * ����: ����ģ��ҵ���߼�ʵ��
  * ��������: ����ģ��ҵ���߼�ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/10 ��ReportTemplateBLImpl�����޸�ΪSOC0207BLImpl
  */
public class SOC0207BLImpl extends BaseBLImpl implements
		SOC0207BL {

	/** ����ģ��DAO�ӿ� */
	protected SOC0207DAO soc0207DAO;
	
	/**
	 * ����ģ��DAO�ӿ��趨
	 *
	 * @param soc0207DAO ����ģ��DAO�ӿ�
	 */
	public void setSoc0207DAO(SOC0207DAO soc0207DAO) {
		this.soc0207DAO = soc0207DAO;
	}

	/**
	 * ����ģ��ʵ��ȡ��
	 *
	 * @return ����ģ��ʵ��
	 */
	public SOC0207TB getSOC0207Instance() {
		return new SOC0207TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0207Info> searchSOC0207() {
		return soc0207DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0207Info searchSOC0207ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0207SearchCond cond) {
		return soc0207DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0207Info> searchSOC0207(
			SOC0207SearchCond cond) {
		return soc0207DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0207Info> searchSOC0207(
			SOC0207SearchCond cond, int start,
			int count) {
		return soc0207DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0207Info registSOC0207(SOC0207Info instance)
		throws BLException {
		return soc0207DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0207Info updateSOC0207(SOC0207Info instance)
		throws BLException {
		checkExistInstance(instance.getRtId());
		return soc0207DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0207ByPK(Integer pk)
		throws BLException {
		soc0207DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0207(SOC0207Info instance)
		throws BLException {
		soc0207DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0207Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0207Info instance = soc0207DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}