/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.model.ComparescopeInfo;
import com.deliverik.infogovernor.cic.model.condition.ComparescopeSearchCond;
import com.deliverik.infogovernor.cic.model.entity.ComparescopeTB;

/**
  * ����: �Ա���ҵ���߼��ӿ�
  * ��������: �Ա���ҵ���߼��ӿ�
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
public interface ComparescopeBL extends BaseBL {

	/**
	 * �Ա���ʵ��ȡ��
	 *
	 * @return �Ա���ʵ��
	 */
	public ComparescopeTB getComparescopeTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ComparescopeInfo> searchComparescope();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ComparescopeInfo searchComparescopeByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ComparescopeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ComparescopeInfo> searchComparescope(
			ComparescopeSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ComparescopeInfo registComparescope(ComparescopeInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ComparescopeInfo updateComparescope(ComparescopeInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteComparescopeByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteComparescope(ComparescopeInfo instance)
		throws BLException;

}