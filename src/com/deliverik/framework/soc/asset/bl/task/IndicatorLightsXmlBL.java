/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.IndicatorLightsXmlInfo;
import com.deliverik.framework.soc.asset.model.condition.IndicatorLightsXmlSearchCond;
import com.deliverik.framework.soc.asset.model.entity.IndicatorLightsXmlTB;

/**
  * ����: �澯ϵͳ��ʾ�����ҵ���߼��ӿ�
  * ��������: �澯ϵͳ��ʾ�����ҵ���߼��ӿ�
  * ������¼: 2014/03/05
  * �޸ļ�¼: 
  */
public interface IndicatorLightsXmlBL extends BaseBL {

	/**
	 * �澯ϵͳ��ʾ�����ʵ��ȡ��
	 *
	 * @return �澯ϵͳ��ʾ�����ʵ��
	 */
	public IndicatorLightsXmlTB getIndicatorLightsXmlTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IndicatorLightsXmlInfo searchIndicatorLightsXmlByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IndicatorLightsXmlSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IndicatorLightsXmlInfo> searchIndicatorLightsXml(
			IndicatorLightsXmlSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IndicatorLightsXmlInfo registIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IndicatorLightsXmlInfo updateIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIndicatorLightsXmlByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIndicatorLightsXml(IndicatorLightsXmlInfo instance)
		throws BLException;

}