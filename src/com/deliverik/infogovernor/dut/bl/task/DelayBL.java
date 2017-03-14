/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;
import com.deliverik.infogovernor.dut.model.entity.DelayTB;

/**
  * ����: ��ʱ������Ϣ��ҵ���߼��ӿ�
  * ��������: ��ʱ������Ϣ��ҵ���߼��ӿ�
  * ������¼: 2012/04/05
  * �޸ļ�¼: 
  */
public interface DelayBL extends BaseBL {

	/**
	 * ��ʱ������Ϣ��ʵ��ȡ��
	 *
	 * @return ��ʱ������Ϣ��ʵ��
	 */
	public DelayTB getDelayTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<DelayInfo> searchDelay();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public DelayInfo searchDelayByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(DelaySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<DelayInfo> searchDelay(
			DelaySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DelayInfo> searchDelay(
			DelaySearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public DelayInfo registDelay(DelayInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public DelayInfo updateDelay(DelayInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteDelayByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteDelay(DelayInfo instance)
		throws BLException;

}