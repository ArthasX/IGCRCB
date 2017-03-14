/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.EiLinkMapInfo;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCond;
import com.deliverik.framework.asset.model.condition.EiLinkMapSearchCondImpl;
import com.deliverik.framework.asset.model.entity.EiLinkMapPK;
import com.deliverik.framework.asset.model.entity.EiLinkMapTB;

/**
  * ����: ʵ����·ͼҵ���߼��ӿ�
  * ��������: ʵ����·ͼҵ���߼��ӿ�
  * ������¼: 2011/05/24
  * �޸ļ�¼: 
  */
public interface EiLinkMapBL extends BaseBL {

	/**
	 * ʵ����·ͼʵ��ȡ��
	 *
	 * @return ʵ����·ͼʵ��
	 */
	public EiLinkMapTB getEiLinkMapTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiLinkMapInfo> searchEiLinkMap();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiLinkMapInfo searchEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EiLinkMapSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> searchEiLinkMap(
			EiLinkMapSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EiLinkMapInfo registEiLinkMap(EiLinkMapInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiLinkMapInfo updateEiLinkMap(EiLinkMapInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiLinkMapByPK(EiLinkMapPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiLinkMap(EiLinkMapInfo instance)
		throws BLException;
	
	/**
	 * ����ͼ��·��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiLinkMapInfo> queryEiLinkMapList(EiLinkMapSearchCond cond);
	
	/**
	 * Ӱ��CI��������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Integer> queryImpactCI(final EiLinkMapSearchCond cond);
	
	public List<EiLinkMapInfo> searchEiLinkMapByOtherEiid(EiLinkMapSearchCondImpl emCond);

}