/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.SnapshotRelationInfo;
import com.deliverik.framework.asset.model.SwitchPortVW;
import com.deliverik.framework.asset.model.SwitchZoneVW;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.entity.ShowEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;

/**
  * ����: ���չ�ϵ��ҵ���߼��ӿ�
  * ��������: ���չ�ϵ��ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SnapshotRelationBL extends BaseBL {

	/**
	 * ���չ�ϵ��ʵ��ȡ��
	 *
	 * @return ���չ�ϵ��ʵ��
	 */
	public SnapshotRelationTB getSnapshotRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SnapshotRelationInfo searchSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SnapshotRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SnapshotRelationInfo> searchSnapshotRelation(
			SnapshotRelationSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SnapshotRelationInfo registSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SnapshotRelationInfo updateSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSnapshotRelation(SnapshotRelationInfo instance)
		throws BLException;
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SnapshotEntityVW> searchSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ShowEntityVW> searchDiskFromSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchDaFromSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchFaFromSnapshotEntityVW(SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SwitchZoneVW> searchSwitchZoneByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SwitchPortVW> searchSwitchPortByCond(final SnapshotRelationSearchCond cond);	
    
    /**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SnapshotRelationTB> searchSwitchRelationByCond(SnapshotRelationSearchCond cond1,SnapshotRelationSearchCond cond2);

	
}