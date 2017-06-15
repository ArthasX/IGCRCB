/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCond;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;

/**
  * ����: �������ñ�ҵ���߼��ӿ�
  * ��������: �������ñ�ҵ���߼��ӿ�
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
public interface RemindConfigureBL extends BaseBL {

	/**
	 * �������ñ�ʵ��ȡ��
	 *
	 * @return �������ñ�ʵ��
	 */
	public RemindConfigureTB getRemindConfigureTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<RemindConfigureInfo> searchRemindConfigure();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public RemindConfigureInfo searchRemindConfigureByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(RemindConfigureSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<RemindConfigureInfo> searchRemindConfigure(
			RemindConfigureSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public RemindConfigureInfo registRemindConfigure(RemindConfigureInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public RemindConfigureInfo updateRemindConfigure(RemindConfigureInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteRemindConfigureByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteRemindConfigure(RemindConfigureInfo instance)
		throws BLException;

}