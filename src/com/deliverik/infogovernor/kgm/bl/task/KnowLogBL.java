/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.kgm.model.KnowLogInfo;
import com.deliverik.infogovernor.kgm.model.condition.KnowLogSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowLogTB;

/**
  * ����: knowLogҵ���߼��ӿ�
  * ��������: knowLogҵ���߼��ӿ�
  * ������¼: 2011/05/30
  * �޸ļ�¼: 
  */
public interface KnowLogBL extends BaseBL {

	/**
	 * knowLogʵ��ȡ��
	 *
	 * @return knowLogʵ��
	 */
	public KnowLogTB getKnowLogTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<KnowLogInfo> searchKnowLog();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public KnowLogInfo searchKnowLogByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(KnowLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<KnowLogInfo> searchKnowLog(
			KnowLogSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<KnowLogInfo> searchKnowLog(
			KnowLogSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public KnowLogInfo registKnowLog(KnowLogInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public KnowLogInfo updateKnowLog(KnowLogInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteKnowLogByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteKnowLog(KnowLogInfo instance)
		throws BLException;

	/**
	 * �����־��Ϣ
	 *
	 * @param instance  �����־��Ϣ
	 */
	public KnowLogInfo addKnowLog(Integer klkid,String userId,String userName,String time,String desc) throws BLException;
}