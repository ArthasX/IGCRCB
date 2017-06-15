/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.plugin.change.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCond;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
  * ����: ������������־ҵ���߼��ӿ�
  * ��������: ������������־ҵ���߼��ӿ�
  * ������¼: 2015/07/02
  * �޸ļ�¼: 
  */
public interface InitiateChangLogBL extends BaseBL {

	/**
	 * ������������־ʵ��ȡ��
	 *
	 * @return ������������־ʵ��
	 */
	public InitiateChangLogTB getInitiateChangLogTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InitiateChangLogInfo searchInitiateChangLogByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InitiateChangLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog(
			InitiateChangLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InitiateChangLogInfo> searchInitiateChangLog(
			InitiateChangLogSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InitiateChangLogInfo registInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InitiateChangLogInfo updateInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInitiateChangLogByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInitiateChangLog(InitiateChangLogInfo instance)
		throws BLException;

}