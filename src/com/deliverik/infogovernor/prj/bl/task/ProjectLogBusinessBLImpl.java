/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectLogBusinessInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogBusinessSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectLogBusinessDAO;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogBusinessTB;

/**
  * ����: ��Ŀ��־�����ҵ���߼�ʵ��
  * ��������: ��Ŀ��־�����ҵ���߼�ʵ��
  * ������¼: 2012/04/11
  * �޸ļ�¼: 
  */
public class ProjectLogBusinessBLImpl extends BaseBLImpl implements
		ProjectLogBusinessBL {

	/** ��Ŀ��־�����DAO�ӿ� */
	protected ProjectLogBusinessDAO projectLogBusinessDAO;
	
	/**
	 * ��Ŀ��־�����DAO�ӿ��趨
	 *
	 * @param projectLogBusinessDAO ��Ŀ��־�����DAO�ӿ�
	 */
	public void setProjectLogBusinessDAO(ProjectLogBusinessDAO projectLogBusinessDAO) {
		this.projectLogBusinessDAO = projectLogBusinessDAO;
	}

	/**
	 * ��Ŀ��־�����ʵ��ȡ��
	 *
	 * @return ��Ŀ��־�����ʵ��
	 */
	public ProjectLogBusinessTB getProjectLogBusinessTBInstance() {
		return new ProjectLogBusinessTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness() {
		return projectLogBusinessDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogBusinessInfo searchProjectLogBusinessByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ProjectLogBusinessSearchCond cond) {
		return projectLogBusinessDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ProjectLogBusinessInfo> searchProjectLogBusiness(
			ProjectLogBusinessSearchCond cond) {
		return projectLogBusinessDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return projectLogBusinessDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ProjectLogBusinessInfo registProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException {
		return projectLogBusinessDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProjectLogBusinessInfo updateProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException {
		checkExistInstance(instance.getPlbid());
		return projectLogBusinessDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectLogBusinessByPK(Integer pk)
		throws BLException {
		projectLogBusinessDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteProjectLogBusiness(ProjectLogBusinessInfo instance)
		throws BLException {
		projectLogBusinessDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ProjectLogBusinessInfo checkExistInstance(Integer pk)
		throws BLException {
		ProjectLogBusinessInfo instance = projectLogBusinessDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}