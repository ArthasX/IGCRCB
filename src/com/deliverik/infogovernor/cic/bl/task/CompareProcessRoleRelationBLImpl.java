/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareProcessRoleRelationSearchCond;
import com.deliverik.infogovernor.cic.model.dao.CompareProcessRoleRelationDAO;
import com.deliverik.infogovernor.cic.model.entity.CompareProcessRoleRelationTB;

/**
  * ����: ��ϵ��ҵ���߼�ʵ��
  * ��������: ��ϵ��ҵ���߼�ʵ��
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
public class CompareProcessRoleRelationBLImpl extends BaseBLImpl implements
		CompareProcessRoleRelationBL {

	/** ��ϵ��DAO�ӿ� */
	protected CompareProcessRoleRelationDAO compareProcessRoleRelationDAO;
	
	/**
	 * ��ϵ��DAO�ӿ��趨
	 *
	 * @param compareProcessRoleRelationDAO ��ϵ��DAO�ӿ�
	 */
	public void setCompareProcessRoleRelationDAO(CompareProcessRoleRelationDAO compareProcessRoleRelationDAO) {
		this.compareProcessRoleRelationDAO = compareProcessRoleRelationDAO;
	}

	/**
	 * ��ϵ��ʵ��ȡ��
	 *
	 * @return ��ϵ��ʵ��
	 */
	public CompareProcessRoleRelationTB getCompareProcessRoleRelationTBInstance() {
		return new CompareProcessRoleRelationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation() {
		return compareProcessRoleRelationDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CompareProcessRoleRelationInfo searchCompareProcessRoleRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CompareProcessRoleRelationSearchCond cond) {
		return compareProcessRoleRelationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation(
			CompareProcessRoleRelationSearchCond cond) {
		return compareProcessRoleRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CompareProcessRoleRelationInfo> searchCompareProcessRoleRelation(
			CompareProcessRoleRelationSearchCond cond, int start,
			int count) {
		return compareProcessRoleRelationDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CompareProcessRoleRelationInfo registCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException {
		return compareProcessRoleRelationDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CompareProcessRoleRelationInfo updateCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getId());
		return compareProcessRoleRelationDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCompareProcessRoleRelationByPK(Integer pk)
		throws BLException {
		compareProcessRoleRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCompareProcessRoleRelation(CompareProcessRoleRelationInfo instance)
		throws BLException {
		compareProcessRoleRelationDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public CompareProcessRoleRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		CompareProcessRoleRelationInfo instance = compareProcessRoleRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}