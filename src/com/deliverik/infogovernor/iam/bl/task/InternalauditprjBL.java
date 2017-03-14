/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;
import com.deliverik.infogovernor.iam.model.condition.InternalauditprjSearchCond;
import com.deliverik.infogovernor.iam.model.entity.InternalauditprjTB;

/**
  * ����: ������Ŀҵ���߼��ӿ�
  * ��������: ������Ŀҵ���߼��ӿ�
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
public interface InternalauditprjBL extends BaseBL {

	/**
	 * ������Ŀʵ��ȡ��
	 *
	 * @return ������Ŀʵ��
	 */
	public InternalauditprjTB getInternalauditprjTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InternalauditprjInfo> searchInternalauditprj();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InternalauditprjInfo searchInternalauditprjByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InternalauditprjSearchCond cond);
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int auditProjectHelpSearchConut(final InternalauditprjSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InternalauditprjInfo> searchInternalauditprj(
			InternalauditprjSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InternalauditprjInfo> searchInternalauditprj(
			InternalauditprjSearchCond cond, int start,
			int count);

	public List<InternalauditprjInfo> auditProjectHelpSearch(
			InternalauditprjSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InternalauditprjInfo registInternalauditprj(InternalauditprjInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InternalauditprjInfo updateInternalauditprj(InternalauditprjInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInternalauditprjByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInternalauditprj(InternalauditprjInfo instance)
		throws BLException;

}