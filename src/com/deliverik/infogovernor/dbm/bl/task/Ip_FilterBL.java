/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.model.Ip_FilterInfo;
import com.deliverik.infogovernor.dbm.model.condition.Ip_FilterSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.Ip_FilterTB;

/**
  * ����: ȫ��IP����ҵ���߼��ӿ�
  * ��������: ȫ��IP����ҵ���߼��ӿ�
  * ������¼: 2012/11/07
  * �޸ļ�¼: 
  */
public interface Ip_FilterBL extends BaseBL {

	/**
	 * ȫ��IP����ʵ��ȡ��
	 *
	 * @return ȫ��IP����ʵ��
	 */
	public Ip_FilterTB getIp_FilterTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Ip_FilterInfo> searchIp_Filter();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Ip_FilterInfo searchIp_FilterByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Ip_FilterSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Ip_FilterInfo> searchIp_Filter(
			Ip_FilterSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Ip_FilterInfo registIp_Filter(Ip_FilterInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Ip_FilterInfo updateIp_Filter(Ip_FilterInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIp_FilterByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIp_Filter(Ip_FilterInfo instance)
		throws BLException;

}