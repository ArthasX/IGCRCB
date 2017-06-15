/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0409Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0409SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0409DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0409TB;

/**
  * ����: ����pvʵʱ��ҵ���߼�ʵ��
  * ��������: ����pvʵʱ��ҵ���߼�ʵ��
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/09 ��PVHostRealTimeBLImpl������ΪSOC0409BLImpl
  */
public class SOC0409BLImpl extends BaseBLImpl implements
		SOC0409BL {

	/** ����pvʵʱ��DAO�ӿ� */
	protected SOC0409DAO soc0409DAO;
	

	/**
	 * ����pvʵʱ��ʵ��ȡ��
	 *
	 * @return ����pvʵʱ��ʵ��
	 */
	public SOC0409TB getSOC0409Instance() {
		return new SOC0409TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0409Info> searchSOC0409() {
		return soc0409DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0409Info searchSOC0409ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0409SearchCond cond) {
		return soc0409DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0409Info> searchSOC0409(
			SOC0409SearchCond cond) {
		return soc0409DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0409Info> searchSOC0409(
			SOC0409SearchCond cond, int start,
			int count) {
		return soc0409DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0409Info registSOC0409(SOC0409Info instance)
		throws BLException {
		return soc0409DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0409Info updateSOC0409(SOC0409Info instance)
		throws BLException {
		checkExistInstance(instance.getPhId());
		return soc0409DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0409ByPK(Integer pk)
		throws BLException {
		soc0409DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0409(SOC0409Info instance)
		throws BLException {
		soc0409DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0409Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0409Info instance = soc0409DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ����pvʵʱ��DAO�ӿ�ȡ��
	 *
	 * @return soc0409DAO ����pvʵʱ��DAO�ӿ�
	 */
	public SOC0409DAO getSoc0409DAO() {
		return soc0409DAO;
	}

	/**
	 * ����pvʵʱ��DAO�ӿ��趨
	 *
	 * @param soc0409DAO ����pvʵʱ��DAO�ӿ�
	 */
	public void setSoc0409DAO(SOC0409DAO soc0409DAO) {
		this.soc0409DAO = soc0409DAO;
	}

}