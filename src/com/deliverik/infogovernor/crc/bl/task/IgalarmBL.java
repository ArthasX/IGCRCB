/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCond;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/**
  * ����: ���ɸ澯��ҵ���߼��ӿ�
  * ��������: ���ɸ澯��ҵ���߼��ӿ�
  * ������¼: 2014/06/21
  * �޸ļ�¼: 
  */
public interface IgalarmBL extends BaseBL {

	/**
	 * ���ɸ澯��ʵ��ȡ��
	 *
	 * @return ���ɸ澯��ʵ��
	 */
	public IgalarmTB getIgalarmTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IgalarmInfo> searchIgalarm();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IgalarmInfo searchIgalarmByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IgalarmSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgalarmInfo> searchIgalarm(
			IgalarmSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IgalarmInfo registIgalarm(IgalarmInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IgalarmInfo updateIgalarm(IgalarmInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIgalarmByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIgalarm(IgalarmInfo instance)
		throws BLException;

	/**
	 * �澯�¼���ѯ
	 */
	public int searchProcessCount(IG500SearchCond cond, String type) throws BLException;
	
	/**
	 * �澯�¼���ѯ
	 */
	public List<IGCRC0208VWInfo> searchProcessByType(IG500SearchCond cond, int start,
			int count, String type) throws BLException;
	
	/**
	 * ������������(û��Ĭ������)
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IgalarmInfo> searchIgalarmNoSort(IgalarmSearchCond cond, int start,int count);
	
}