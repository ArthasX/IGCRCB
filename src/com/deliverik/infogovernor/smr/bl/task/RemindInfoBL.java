/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindInfoSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RemindInfoTB;

/**
  * ����: ������Ϣ��ҵ���߼��ӿ�
  * ��������: ������Ϣ��ҵ���߼��ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface RemindInfoBL extends BaseBL {

	/**
	 * ������Ϣ��ʵ��ȡ��
	 *
	 * @return ������Ϣ��ʵ��
	 */
	public RemindInfoTB getRemindInfoTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindInfoInfo> searchRemindInfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindInfoInfo searchRemindInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RemindInfoSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RemindInfoInfo> searchRemindInfo(
			RemindInfoSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RemindInfoInfo> searchRemindInfo(
			RemindInfoSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RemindInfoInfo registRemindInfo(RemindInfoInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RemindInfoInfo updateRemindInfo(RemindInfoInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRemindInfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRemindInfo(RemindInfoInfo instance)
		throws BLException;

}