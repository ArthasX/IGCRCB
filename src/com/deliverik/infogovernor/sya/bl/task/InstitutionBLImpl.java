/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sya.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sya.model.InstitutionInfo;
import com.deliverik.infogovernor.sya.model.condition.InstitutionSearchCond;
import com.deliverik.infogovernor.sya.model.dao.InstitutionDAO;
import com.deliverik.infogovernor.sya.model.entity.InstitutionTB;

/**
  * ����: ��Ч����ҵ���߼�ʵ��
  * ��������: ��Ч����ҵ���߼�ʵ��
  * ������¼: 2015/01/05
  * �޸ļ�¼: 
  */
public class InstitutionBLImpl extends BaseBLImpl implements
		InstitutionBL {

	/** ��Ч����DAO�ӿ� */
	protected InstitutionDAO institutionDAO;
	
	/**
	 * ��Ч����DAO�ӿ��趨
	 *
	 * @param institutionDAO ��Ч����DAO�ӿ�
	 */
	public void setInstitutionDAO(InstitutionDAO institutionDAO) {
		this.institutionDAO = institutionDAO;
	}

	/**
	 * ��Ч����ʵ��ȡ��
	 *
	 * @return ��Ч����ʵ��
	 */
	public InstitutionTB getInstitutionTBInstance() {
		return new InstitutionTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<InstitutionInfo> searchInstitution() {
		return institutionDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public InstitutionInfo searchInstitutionByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(InstitutionSearchCond cond) {
		return institutionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<InstitutionInfo> searchInstitution(
			InstitutionSearchCond cond) {
		return institutionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<InstitutionInfo> searchInstitution(
			InstitutionSearchCond cond, int start,
			int count) {
		return institutionDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public InstitutionInfo registInstitution(InstitutionInfo instance)
		throws BLException {
		return institutionDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public InstitutionInfo updateInstitution(InstitutionInfo instance)
		throws BLException {
		checkExistInstance(instance.getInid());
		return institutionDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteInstitutionByPK(Integer pk)
		throws BLException {
		institutionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteInstitution(InstitutionInfo instance)
		throws BLException {
		institutionDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public InstitutionInfo checkExistInstance(Integer pk)
		throws BLException {
		InstitutionInfo instance = institutionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}