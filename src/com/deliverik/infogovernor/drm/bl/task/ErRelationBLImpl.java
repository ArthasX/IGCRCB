/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.ErRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.ErRelationSearchCond;
import com.deliverik.infogovernor.drm.model.dao.ErRelationDAO;
import com.deliverik.infogovernor.drm.model.entity.ErRelationTB;

/**
  * ����: ErRelationҵ���߼�ʵ��
  * ��������: ErRelationҵ���߼�ʵ��
  * ������¼: 2016/06/14
  * �޸ļ�¼: 
  */
public class ErRelationBLImpl extends BaseBLImpl implements
		ErRelationBL {

	/** ErRelationDAO�ӿ� */
	protected ErRelationDAO erRelationDAO;
	
	/**
	 * ErRelationDAO�ӿ��趨
	 *
	 * @param erRelationDAO ErRelationDAO�ӿ�
	 */
	public void setErRelationDAO(ErRelationDAO erRelationDAO) {
		this.erRelationDAO = erRelationDAO;
	}

	/**
	 * ErRelationʵ��ȡ��
	 *
	 * @return ErRelationʵ��
	 */
	public ErRelationTB getErRelationTBInstance() {
		return new ErRelationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ErRelationInfo> searchErRelation() {
		return erRelationDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ErRelationInfo searchErRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(ErRelationSearchCond cond) {
		return erRelationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond) {
		return erRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ErRelationInfo> searchErRelation(
			ErRelationSearchCond cond, int start,
			int count) {
		return erRelationDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public ErRelationInfo registErRelation(ErRelationInfo instance)
		throws BLException {
		return erRelationDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ErRelationInfo updateErRelation(ErRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getErrid());
		return erRelationDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteErRelationByPK(Integer pk)
		throws BLException {
		erRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteErRelation(ErRelationInfo instance)
		throws BLException {
		erRelationDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public ErRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		ErRelationInfo instance = erRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}