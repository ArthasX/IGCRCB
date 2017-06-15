/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCond;
import com.deliverik.infogovernor.rdp.model.entity.RealtimedetailTB;

/**
  * ����: ��־��Ϣҵ���߼��ӿ�
  * ��������: ��־��Ϣҵ���߼��ӿ�
  * ������¼: 2014/05/06
  * �޸ļ�¼: 
  */
public interface RealtimedetailBL extends BaseBL {

	/**
	 * ��־��Ϣʵ��ȡ��
	 *
	 * @return ��־��Ϣʵ��
	 */
	public RealtimedetailTB getRealtimedetailTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RealtimedetailInfo> searchRealtimedetail();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RealtimedetailInfo searchRealtimedetailByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RealtimedetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RealtimedetailInfo> searchRealtimedetail(
			RealtimedetailSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RealtimedetailInfo> searchRealtimedetail(
			RealtimedetailSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RealtimedetailInfo registRealtimedetail(RealtimedetailInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RealtimedetailInfo updateRealtimedetail(RealtimedetailInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRealtimedetailByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRealtimedetail(RealtimedetailInfo instance)
		throws BLException;

}