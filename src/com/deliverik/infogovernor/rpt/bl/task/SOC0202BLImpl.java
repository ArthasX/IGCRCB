/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0202Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0202SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0202DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0202TB;

/**
  * ����: ���ӱ���ҵ���߼�ʵ��
  * ��������: ���ӱ���ҵ���߼�ʵ��
  * ������¼: 2012/06/06
  * �޸ļ�¼: 2012/08/09 ��ReportAnnexationBLImpl������ΪSOC0202BLImpl
  */
public class SOC0202BLImpl extends BaseBLImpl implements
		SOC0202BL {

	/** ���ӱ���DAO�ӿ� */
	protected SOC0202DAO soc0202DAO;
	
	/**
	 * ���ӱ���DAO�ӿ��趨
	 *
	 * @param soc0202DAO ���ӱ���DAO�ӿ�
	 */
	public void setSoc0202DAO(SOC0202DAO soc0202DAO) {
		this.soc0202DAO = soc0202DAO;
	}

	/**
	 * ���ӱ���ʵ��ȡ��
	 *
	 * @return ���ӱ���ʵ��
	 */
	public SOC0202TB getSOC0202Instance() {
		return new SOC0202TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0202Info> searchSOC0202() {
		return soc0202DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0202Info searchSOC0202ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0202SearchCond cond) {
		return soc0202DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0202Info> searchSOC0202(
			SOC0202SearchCond cond) {
		return soc0202DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0202Info> searchSOC0202(
			SOC0202SearchCond cond, int start,
			int count) {
		return soc0202DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0202Info registSOC0202(SOC0202Info instance)
		throws BLException {
		return soc0202DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0202Info updateSOC0202(SOC0202Info instance)
		throws BLException {
		checkExistInstance(instance.getRaId());
		return soc0202DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0202ByPK(Integer pk)
		throws BLException {
		soc0202DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0202(SOC0202Info instance)
		throws BLException {
		soc0202DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0202Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0202Info instance = soc0202DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}