/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.model.AUDITPROJECTInfo;
import com.deliverik.infogovernor.iam.model.condition.AUDITPROJECTSearchCond;
import com.deliverik.infogovernor.iam.model.entity.AUDITPROJECTTB;

/**
  * ����: ��Ʊ����ҵ���߼��ӿ�
  * ��������: ��Ʊ����ҵ���߼��ӿ�
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
public interface AUDITPROJECTBL extends BaseBL {

	/**
	 * ��Ʊ����ʵ��ȡ��
	 *
	 * @return ��Ʊ����ʵ��
	 */
	public AUDITPROJECTTB getAUDITPROJECTTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public AUDITPROJECTInfo searchAUDITPROJECTByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(AUDITPROJECTSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<AUDITPROJECTInfo> searchAUDITPROJECT(
			AUDITPROJECTSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public AUDITPROJECTInfo registAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public AUDITPROJECTInfo updateAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteAUDITPROJECTByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteAUDITPROJECT(AUDITPROJECTInfo instance)
		throws BLException;

}