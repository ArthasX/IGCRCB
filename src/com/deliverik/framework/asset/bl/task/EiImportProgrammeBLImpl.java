/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.EiImportProgrammeInfo;
import com.deliverik.framework.asset.model.condition.EiImportProgrammeSearchCond;
import com.deliverik.framework.asset.model.dao.EiImportProgrammeDAO;
import com.deliverik.framework.asset.model.entity.EiImportProgrammeTB;

/**
  * ����: �����������ҵ���߼�ʵ��
  * ��������: �����������ҵ���߼�ʵ��
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public class EiImportProgrammeBLImpl extends BaseBLImpl implements
		EiImportProgrammeBL {

	/** �����������DAO�ӿ� */
	protected EiImportProgrammeDAO eiImportProgrammeDAO;
	
	/**
	 * �����������DAO�ӿ��趨
	 *
	 * @param eiImportProgrammeDAO �����������DAO�ӿ�
	 */
	public void setEiImportProgrammeDAO(EiImportProgrammeDAO eiImportProgrammeDAO) {
		this.eiImportProgrammeDAO = eiImportProgrammeDAO;
	}

	/**
	 * �����������ʵ��ȡ��
	 *
	 * @return �����������ʵ��
	 */
	public EiImportProgrammeTB getEiImportProgrammeTBInstance() {
		return new EiImportProgrammeTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme() {
		return eiImportProgrammeDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EiImportProgrammeInfo searchEiImportProgrammeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EiImportProgrammeSearchCond cond) {
		return eiImportProgrammeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme(
			EiImportProgrammeSearchCond cond) {
		return eiImportProgrammeDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EiImportProgrammeInfo> searchEiImportProgramme(
			EiImportProgrammeSearchCond cond, int start,
			int count) {
		return eiImportProgrammeDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EiImportProgrammeInfo registEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException {
		return eiImportProgrammeDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiImportProgrammeInfo updateEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException {
		checkExistInstance(instance.getImpTypeid());
		return eiImportProgrammeDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiImportProgrammeByPK(Integer pk)
		throws BLException {
		eiImportProgrammeDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiImportProgramme(EiImportProgrammeInfo instance)
		throws BLException {
		eiImportProgrammeDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public EiImportProgrammeInfo checkExistInstance(Integer pk)
		throws BLException {
		EiImportProgrammeInfo instance = eiImportProgrammeDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}