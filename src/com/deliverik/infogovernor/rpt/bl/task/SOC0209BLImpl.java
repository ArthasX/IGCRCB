/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0209Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0209SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0209DAO;
import com.deliverik.infogovernor.rpt.model.entity.SOC0209VW;

/**
  * ����: ������Դ��ͼҵ���߼�ʵ��
  * ��������: ������Դ��ͼҵ���߼�ʵ��
  * ������¼: 2011/11/24
  * �޸ļ�¼: 2012/08/09 ��ProcessRecordInfoVWBLImpl������ΪSOC0209BLImpl
  */
public class SOC0209BLImpl extends BaseBLImpl implements
		SOC0209BL {

	/** ������Դ��ͼDAO�ӿ� */
	protected SOC0209DAO soc0209DAO;
	
	/**
	 * ������Դ��ͼDAO�ӿ��趨
	 *
	 * @param soc0209DAO ������Դ��ͼDAO�ӿ�
	 */
	public void setSoc0209DAO(SOC0209DAO soc0209DAO) {
		this.soc0209DAO = soc0209DAO;
	}

	/**
	 * ������Դ��ͼʵ��ȡ��
	 *
	 * @return ������Դ��ͼʵ��
	 */
	public SOC0209VW getSOC0209Instance() {
		return new SOC0209VW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0209Info> searchSOC0209() {
		return soc0209DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0209Info searchSOC0209ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0209SearchCond cond) {
		return soc0209DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0209Info> searchSOC0209(
			SOC0209SearchCond cond) {
		return soc0209DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0209Info> searchSOC0209(
			SOC0209SearchCond cond, int start,
			int count) {
		return soc0209DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0209Info registSOC0209(SOC0209Info instance)
		throws BLException {
		return soc0209DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0209Info updateSOC0209(SOC0209Info instance)
		throws BLException {
		checkExistInstance(instance.getPrid());
		return soc0209DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0209ByPK(Integer pk)
		throws BLException {
		soc0209DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0209(SOC0209Info instance)
		throws BLException {
		soc0209DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0209Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0209Info instance = soc0209DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}