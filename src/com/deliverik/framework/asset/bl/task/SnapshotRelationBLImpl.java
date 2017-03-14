/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.asset.model.SnapshotRelationInfo;
import com.deliverik.framework.asset.model.SwitchPortVW;
import com.deliverik.framework.asset.model.SwitchZoneVW;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.dao.SnapshotEntityVWDAO;
import com.deliverik.framework.asset.model.dao.SnapshotRelationDAO;
import com.deliverik.framework.asset.model.entity.ShowEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;

/**
  * ����: ���չ�ϵ��ҵ���߼�ʵ��
  * ��������: ���չ�ϵ��ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SnapshotRelationBLImpl extends BaseBLImpl implements
		SnapshotRelationBL {

	/** ���չ�ϵ��DAO�ӿ� */
	protected SnapshotRelationDAO snapshotRelationDAO;
	
	/** ���չ�ϵ��DAO��ͼ�ӿ� */
	protected SnapshotEntityVWDAO snapshotEntityVWDAO;
	
	/**
	 * ���չ�ϵ��DAO�ӿ��趨
	 *
	 * @param snapshotRelationDAO���չ�ϵ��DAO�ӿ�
	 */
	public void setSnapshotRelationDAO(SnapshotRelationDAO snapshotRelationDAO) {
		this.snapshotRelationDAO = snapshotRelationDAO;
	}

	/**
	 * ���չ�ϵ��ʵ��ȡ��
	 *
	 * @return ���չ�ϵ��ʵ��
	 */
	public SnapshotRelationTB getSnapshotRelationTBInstance() {
		return new SnapshotRelationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation() {
		return snapshotRelationDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SnapshotRelationInfo searchSnapshotRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SnapshotRelationSearchCond cond) {
		return snapshotRelationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation(
			SnapshotRelationSearchCond cond) {
		return snapshotRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation(
			SnapshotRelationSearchCond cond, int start,
			int count) {
		return snapshotRelationDAO.findByCond(cond, start, count);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SnapshotEntityVW> searchSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findByCond(cond);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ShowEntityVW> searchDiskFromSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findDiskByCond(cond);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchDaFromSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findDaByCond(cond);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchFaFromSnapshotEntityVW(SnapshotRelationSearchCond cond) {
		return snapshotEntityVWDAO.findFaByCond(cond);
	}
	
	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SnapshotRelationInfo registSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException {
		return snapshotRelationDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SnapshotRelationInfo updateSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getSrid());
		return snapshotRelationDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException {
		snapshotRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException {
		snapshotRelationDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SnapshotRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		SnapshotRelationInfo instance = snapshotRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public void setSnapshotEntityVWDAO(SnapshotEntityVWDAO snapshotEntityVWDAO) {
		this.snapshotEntityVWDAO = snapshotEntityVWDAO;
	}

	public List<SwitchPortVW> searchSwitchPortByCond(
			SnapshotRelationSearchCond cond) {
		
		return snapshotEntityVWDAO.findSwitchPortByCond(cond);
	}

	public List<SwitchZoneVW> searchSwitchZoneByCond(
			SnapshotRelationSearchCond cond) {
		
		return snapshotEntityVWDAO.findSwitchZoneByCond(cond);
	}
	 /**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SnapshotRelationTB> searchSwitchRelationByCond(SnapshotRelationSearchCond cond1,SnapshotRelationSearchCond cond2){
		return snapshotEntityVWDAO.findSwitchRelationByCond(cond1, cond2);
	}


}