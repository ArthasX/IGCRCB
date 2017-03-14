/*
 * ��������������ɷ����޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wki.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wki.model.WorkinfoInfo;
import com.deliverik.infogovernor.wki.model.condition.WorkinfoSearchCond;
import com.deliverik.infogovernor.wki.model.entity.WorkinfoTB;

/**
  * ����: ������Ϣҵ���߼��ӿ�
  * ��������: ������Ϣҵ���߼��ӿ�
  * ������¼: 2017/03/02
  * �޸ļ�¼: 
  */
public interface WorkinfoBL extends BaseBL {

	/**
	 * ������Ϣʵ��ȡ��
	 *
	 * @return ������Ϣʵ��
	 */
	public WorkinfoTB getWorkinfoTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkinfoInfo> searchWorkinfo();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkinfoInfo searchWorkinfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkinfoSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkinfoInfo> searchWorkinfo(
			WorkinfoSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkinfoInfo registWorkinfo(WorkinfoInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkinfoInfo updateWorkinfo(WorkinfoInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkinfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkinfo(WorkinfoInfo instance)
		throws BLException;

}