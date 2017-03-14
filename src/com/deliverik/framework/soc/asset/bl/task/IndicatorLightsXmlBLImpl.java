/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsXmlSearchCond;
import com.deliverik.framework.soc.asset.model.dao.IndicatorLightsXmlDAO;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsXmlTB;

/**
  * ����: �澯ϵͳ��ʾ�����ҵ���߼�ʵ��
  * ��������: �澯ϵͳ��ʾ�����ҵ���߼�ʵ��
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public class IndicatorLightsXmlBLImpl extends BaseBLImpl implements
		IndicatorLightsXmlBL {

	/** �澯ϵͳ��ʾ�����DAO�ӿ� */
	protected IndicatorLightsXmlDAO indicatorLightsXmlDAO;
	
	/**
	 * �澯ϵͳ��ʾ�����DAO�ӿ��趨
	 *
	 * @param indicatorLightsXmlDAO �澯ϵͳ��ʾ�����DAO�ӿ�
	 */
	public void setIndicatorLightsXmlDAO(IndicatorLightsXmlDAO indicatorLightsXmlDAO) {
		this.indicatorLightsXmlDAO = indicatorLightsXmlDAO;
	}

	/**
	 * �澯ϵͳ��ʾ�����ʵ��ȡ��
	 *
	 * @return �澯ϵͳ��ʾ�����ʵ��
	 */
	public IndicatorLightsXmlTB getIndicatorLightsXmlTBInstance() {
		return new IndicatorLightsXmlTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml() {
		return indicatorLightsXmlDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsXmlInfo searchIndicatorLightsXmlByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IndicatorLightsXmlSearchCond cond) {
		return indicatorLightsXmlDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml(
			IndicatorLightsXmlSearchCond cond) {
		return indicatorLightsXmlDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml(
			IndicatorLightsXmlSearchCond cond, int start,
			int count) {
		return indicatorLightsXmlDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IndicatorLightsXmlInfo registIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException {
		return indicatorLightsXmlDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IndicatorLightsXmlInfo updateIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException {
		checkExistInstance(instance.getIxid());
		return indicatorLightsXmlDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIndicatorLightsXmlByPK(Integer pk)
		throws BLException {
		indicatorLightsXmlDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException {
		indicatorLightsXmlDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IndicatorLightsXmlInfo checkExistInstance(Integer pk)
		throws BLException {
		IndicatorLightsXmlInfo instance = indicatorLightsXmlDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}