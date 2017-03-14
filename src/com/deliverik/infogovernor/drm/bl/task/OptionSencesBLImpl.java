/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.OptionSencesInfo;
import com.deliverik.infogovernor.drm.model.condition.OptionSencesSearchCond;
import com.deliverik.infogovernor.drm.model.dao.OptionSencesDAO;
import com.deliverik.infogovernor.drm.model.entity.OptionSencesTB;

/**
  * ����: ��ѡ����ҵ���߼�ʵ��
  * ��������: ��ѡ����ҵ���߼�ʵ��
  * ������¼: 2016/10/09
  * �޸ļ�¼: 
  */
public class OptionSencesBLImpl extends BaseBLImpl implements
		OptionSencesBL {

	/** ��ѡ����DAO�ӿ� */
	protected OptionSencesDAO optionSencesDAO;
	
	/**
	 * ��ѡ����DAO�ӿ��趨
	 *
	 * @param optionSencesDAO ��ѡ����DAO�ӿ�
	 */
	public void setOptionSencesDAO(OptionSencesDAO optionSencesDAO) {
		this.optionSencesDAO = optionSencesDAO;
	}

	/**
	 * ��ѡ����ʵ��ȡ��
	 *
	 * @return ��ѡ����ʵ��
	 */
	public OptionSencesTB getOptionSencesTBInstance() {
		return new OptionSencesTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OptionSencesInfo> searchOptionSences() {
		return optionSencesDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public OptionSencesInfo searchOptionSencesByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(OptionSencesSearchCond cond) {
		return optionSencesDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond) {
		return optionSencesDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<OptionSencesInfo> searchOptionSences(
			OptionSencesSearchCond cond, int start,
			int count) {
		return optionSencesDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public OptionSencesInfo registOptionSences(OptionSencesInfo instance)
		throws BLException {
		return optionSencesDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public OptionSencesInfo updateOptionSences(OptionSencesInfo instance)
		throws BLException {
		checkExistInstance(instance.getOsid());
		return optionSencesDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteOptionSencesByPK(Integer pk)
		throws BLException {
		optionSencesDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteOptionSences(OptionSencesInfo instance)
		throws BLException {
		optionSencesDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public OptionSencesInfo checkExistInstance(Integer pk)
		throws BLException {
		OptionSencesInfo instance = optionSencesDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}