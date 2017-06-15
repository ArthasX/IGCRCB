/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.model.DispatchStatisticsVWInfo;
import com.deliverik.infogovernor.prr.model.condition.DispatchStatisticsVWSearchCond;
import com.deliverik.infogovernor.prr.model.entity.DispatchStatisticsVW;

/**
  * ����: ��������ͳ��ҵ���߼��ӿ�
  * ��������: ��������ͳ��ҵ���߼��ӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface DispatchStatisticsVWBL extends BaseBL {

	/**
	 * ��������ͳ��ʵ��ȡ��
	 *
	 * @return ��������ͳ��ʵ��
	 */
	public DispatchStatisticsVW getDispatchStatisticsVWTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DispatchStatisticsVWInfo searchDispatchStatisticsVWByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DispatchStatisticsVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DispatchStatisticsVWInfo> searchDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DispatchStatisticsVWInfo registDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DispatchStatisticsVWInfo updateDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDispatchStatisticsVWByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDispatchStatisticsVW(DispatchStatisticsVWInfo instance)
		throws BLException;
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DispatchStatisticsVWInfo> findDispatchStatisticsVW(
			DispatchStatisticsVWSearchCond cond, int start,int count);
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getDispatchStatisticsSearchCount(DispatchStatisticsVWSearchCond cond);

}