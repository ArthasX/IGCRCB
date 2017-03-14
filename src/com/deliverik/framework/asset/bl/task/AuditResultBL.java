/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.AuditResultInfo;
import com.deliverik.framework.asset.model.condition.AuditResultSearchCond;
import com.deliverik.framework.asset.model.entity.AuditResultTB;

/**
  * ����: ��ƶԱȽ����Ϣ��ҵ���߼��ӿ�
  * ��������: ��ƶԱȽ����Ϣ��ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface AuditResultBL extends BaseBL {

	/**
	 * ��ƶԱȽ����Ϣ��ʵ��ȡ��
	 *
	 * @return ��ƶԱȽ����Ϣ��ʵ��
	 */
	public AuditResultTB getAuditResultTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AuditResultInfo> searchAuditResult();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AuditResultInfo searchAuditResultByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AuditResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AuditResultInfo> searchAuditResult(
			AuditResultSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AuditResultInfo> searchAuditResult(
			AuditResultSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AuditResultInfo registAuditResult(AuditResultInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AuditResultInfo updateAuditResult(AuditResultInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAuditResultByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAuditResult(AuditResultInfo instance)
		throws BLException;

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateAuditResultWithout(AuditResultSearchCond cond)
		throws BLException;

}