package com.deliverik.framework.asset.model.dao;

import java.util.List;

import com.deliverik.framework.asset.model.SwitchPortVW;
import com.deliverik.framework.asset.model.SwitchZoneVW;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.entity.ShowEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotEntityVW;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * �ʲ�����ͼDAO�ӿ�
 * 
 * @author 
 */
public interface SnapshotEntityVWDAO extends BaseHibernateDAO<SnapshotEntityVW> {
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SnapshotEntityVW> findByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ShowEntityVW> findDiskByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<String> findDaByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<String> findFaByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SwitchZoneVW> findSwitchZoneByCond(final SnapshotRelationSearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
    public List<SwitchPortVW> findSwitchPortByCond(final SnapshotRelationSearchCond cond);	
    
    /**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SnapshotRelationTB> findSwitchRelationByCond(final SnapshotRelationSearchCond cond1,final SnapshotRelationSearchCond cond2);

}
