/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.model.InternalauditJobInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditJobSearchCond;
import com.deliverik.infogovernor.iam.model.entity.InternalauditJobTB;

/**
  * ����: ���ù�����ҵ���߼��ӿ�
  * ��������: ���ù�����ҵ���߼��ӿ�
  * ������¼: 2012/07/25
  * �޸ļ�¼: 
  */
public interface InternalauditJobBL extends BaseBL {

	/**
	 * ���ù�����ʵ��ȡ��
	 *
	 * @return ���ù�����ʵ��
	 */
	public InternalauditJobTB getInternalauditJobTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditJobInfo> searchInternalauditJob();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditJobInfo searchInternalauditJobByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InternalauditJobSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InternalauditJobInfo> searchInternalauditJob(
			InternalauditJobSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InternalauditJobInfo> searchInternalauditJob(
			InternalauditJobSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InternalauditJobInfo registInternalauditJob(InternalauditJobInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InternalauditJobInfo updateInternalauditJob(InternalauditJobInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInternalauditJobByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInternalauditJob(InternalauditJobInfo instance)
		throws BLException;

}