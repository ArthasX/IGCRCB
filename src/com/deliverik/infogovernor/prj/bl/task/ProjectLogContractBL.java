/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogContractSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogContractTB;

/**
  * ����: ��Ŀ��־��ͬ��ҵ���߼��ӿ�
  * ��������: ��Ŀ��־��ͬ��ҵ���߼��ӿ�
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public interface ProjectLogContractBL extends BaseBL {

	/**
	 * ��Ŀ��־��ͬ��ʵ��ȡ��
	 *
	 * @return ��Ŀ��־��ͬ��ʵ��
	 */
	public ProjectLogContractTB getProjectLogContractTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogContractInfo searchProjectLogContractByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ProjectLogContractSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract(
			ProjectLogContractSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract(
			ProjectLogContractSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ProjectLogContractInfo registProjectLogContract(ProjectLogContractInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProjectLogContractInfo updateProjectLogContract(ProjectLogContractInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectLogContractByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteProjectLogContract(ProjectLogContractInfo instance)
		throws BLException;

}