/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0113Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0113SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0113DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0113TB;

/**
  * ����: �����������ҵ���߼�ʵ��
  * ��������: �����������ҵ���߼�ʵ��
  * ������¼: 2011/05/05
  * �޸ļ�¼: 
  */
public class SOC0113BLImpl extends BaseBLImpl implements
		SOC0113BL {

	/** �����������DAO�ӿ� */
	protected SOC0113DAO soc0113DAO;
	

	/**
	 * �����������DAO�ӿ��趨
	 *
	 * @param soc0113DAO �����������DAO�ӿ�
	 */
	public void setSoc0113DAO(SOC0113DAO soc0113DAO) {
		this.soc0113DAO = soc0113DAO;
	}

	/**
	 * �����������ʵ��ȡ��
	 *
	 * @return �����������ʵ��
	 */
	public SOC0113TB getEiImportProgrammeTBInstance() {
		return new SOC0113TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0113Info> searchEiImportProgramme() {
		return soc0113DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0113Info searchEiImportProgrammeByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0113SearchCond cond) {
		return soc0113DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0113Info> searchEiImportProgramme(
			SOC0113SearchCond cond) {
		return soc0113DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0113Info> searchEiImportProgramme(
			SOC0113SearchCond cond, int start,
			int count) {
		return soc0113DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0113Info registEiImportProgramme(SOC0113Info instance)
		throws BLException {
		return soc0113DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0113Info updateEiImportProgramme(SOC0113Info instance)
		throws BLException {
		checkExistInstance(instance.getImpTypeid());
		return soc0113DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEiImportProgrammeByPK(Integer pk)
		throws BLException {
		soc0113DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEiImportProgramme(SOC0113Info instance)
		throws BLException {
		soc0113DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0113Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0113Info instance = soc0113DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}