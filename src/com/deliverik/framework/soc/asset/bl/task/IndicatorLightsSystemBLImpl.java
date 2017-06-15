/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsSystemInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsSystemSearchCond;
import com.deliverik.framework.soc.asset.model.dao.IndicatorLightsSystemDAO;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsSystemTB;

/**
  * ����: �澯ϵͳ��ʾ��Ϣ��ҵ���߼�ʵ��
  * ��������: �澯ϵͳ��ʾ��Ϣ��ҵ���߼�ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public class IndicatorLightsSystemBLImpl extends BaseBLImpl implements
		IndicatorLightsSystemBL {

	/** �澯ϵͳ��ʾ��Ϣ��DAO�ӿ� */
	protected IndicatorLightsSystemDAO indicatorLightsSystemDAO;
	
	/**
	 * �澯ϵͳ��ʾ��Ϣ��DAO�ӿ��趨
	 *
	 * @param indicatorLightsSystemDAO �澯ϵͳ��ʾ��Ϣ��DAO�ӿ�
	 */
	public void setIndicatorLightsSystemDAO(IndicatorLightsSystemDAO indicatorLightsSystemDAO) {
		this.indicatorLightsSystemDAO = indicatorLightsSystemDAO;
	}

	/**
	 * �澯ϵͳ��ʾ��Ϣ��ʵ��ȡ��
	 *
	 * @return �澯ϵͳ��ʾ��Ϣ��ʵ��
	 */
	public IndicatorLightsSystemTB getIndicatorLightsSystemTBInstance() {
		return new IndicatorLightsSystemTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem() {
		return indicatorLightsSystemDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsSystemInfo searchIndicatorLightsSystemByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IndicatorLightsSystemSearchCond cond) {
		return indicatorLightsSystemDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem(
			IndicatorLightsSystemSearchCond cond) {
		return indicatorLightsSystemDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IndicatorLightsSystemInfo> searchIndicatorLightsSystem(
			IndicatorLightsSystemSearchCond cond, int start,
			int count) {
		return indicatorLightsSystemDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IndicatorLightsSystemInfo registIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException {
		return indicatorLightsSystemDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IndicatorLightsSystemInfo updateIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException {
		checkExistInstance(instance.getIlsid());
		return indicatorLightsSystemDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIndicatorLightsSystemByPK(Integer pk)
		throws BLException {
		indicatorLightsSystemDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIndicatorLightsSystem(IndicatorLightsSystemInfo instance)
		throws BLException {
		indicatorLightsSystemDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IndicatorLightsSystemInfo checkExistInstance(Integer pk)
		throws BLException {
		IndicatorLightsSystemInfo instance = indicatorLightsSystemDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}