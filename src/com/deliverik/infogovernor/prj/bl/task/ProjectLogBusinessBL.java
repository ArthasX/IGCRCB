/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCond;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogBusinessTB;

/**
  * ����: ��Ŀ��־�����ҵ���߼��ӿ�
  * ��������: ��Ŀ��־�����ҵ���߼��ӿ�
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public interface ProjectLogBusinessBL extends BaseBL {

	/**
	 * ��Ŀ��־�����ʵ��ȡ��
	 *
	 * @return ��Ŀ��־�����ʵ��
	 */
	public ProjectLogBusinessTB getProjectLogBusinessTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogBusinessInfo searchProjectLogBusinessByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ProjectLogBusinessSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness(
			ProjectLogBusinessSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness(
			ProjectLogBusinessSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ProjectLogBusinessInfo registProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProjectLogBusinessInfo updateProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectLogBusinessByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException;

}