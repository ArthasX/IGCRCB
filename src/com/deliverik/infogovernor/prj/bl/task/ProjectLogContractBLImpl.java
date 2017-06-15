/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.ProjectLogContractInfo;
import com.deliverik.infogovernor.prj.model.condition.ProjectLogContractSearchCond;
import com.deliverik.infogovernor.prj.model.dao.ProjectLogContractDAO;
import com.deliverik.infogovernor.prj.model.entity.ProjectLogContractTB;

/**
  * ����: ��Ŀ��־��ͬ��ҵ���߼�ʵ��
  * ��������: ��Ŀ��־��ͬ��ҵ���߼�ʵ��
  * ������¼: 2012/04/10
  * �޸ļ�¼: 
  */
public class ProjectLogContractBLImpl extends BaseBLImpl implements
		ProjectLogContractBL {

	/** ��Ŀ��־��ͬ��DAO�ӿ� */
	protected ProjectLogContractDAO projectLogContractDAO;
	
	/**
	 * ��Ŀ��־��ͬ��DAO�ӿ��趨
	 *
	 * @param projectLogContractDAO ��Ŀ��־��ͬ��DAO�ӿ�
	 */
	public void setProjectLogContractDAO(ProjectLogContractDAO projectLogContractDAO) {
		this.projectLogContractDAO = projectLogContractDAO;
	}

	/**
	 * ��Ŀ��־��ͬ��ʵ��ȡ��
	 *
	 * @return ��Ŀ��־��ͬ��ʵ��
	 */
	public ProjectLogContractTB getProjectLogContractTBInstance() {
		return new ProjectLogContractTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract() {
		return projectLogContractDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ProjectLogContractInfo searchProjectLogContractByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ProjectLogContractSearchCond cond) {
		return projectLogContractDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ProjectLogContractInfo> searchProjectLogContract(
			ProjectLogContractSearchCond cond) {
		return projectLogContractDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return projectLogContractDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ProjectLogContractInfo registProjectLogContract(ProjectLogContractInfo instance)
		throws BLException {
		return projectLogContractDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ProjectLogContractInfo updateProjectLogContract(ProjectLogContractInfo instance)
		throws BLException {
		checkExistInstance(instance.getPlcid());
		return projectLogContractDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteProjectLogContractByPK(Integer pk)
		throws BLException {
		projectLogContractDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteProjectLogContract(ProjectLogContractInfo instance)
		throws BLException {
		projectLogContractDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ProjectLogContractInfo checkExistInstance(Integer pk)
		throws BLException {
		ProjectLogContractInfo instance = projectLogContractDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}