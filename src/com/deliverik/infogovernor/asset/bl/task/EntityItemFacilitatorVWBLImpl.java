/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;
import com.deliverik.infogovernor.asset.model.dao.EntityItemFacilitatorVWDAO;

/**
 * ����:��������Ϣ��ͼBLʵ��
 * ��������: ��������Ϣ��ͼBLʵ��
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼: 
 */
public class EntityItemFacilitatorVWBLImpl extends BaseBLImpl implements
		EntityItemFacilitatorVWBL {
	
	/** ��������Ϣ��ͼDAO */
	protected EntityItemFacilitatorVWDAO entityItemFacilitatorVWDAO;

	public void setEntityItemFacilitatorVWDAO(
			EntityItemFacilitatorVWDAO entityItemFacilitatorVWDAO) {
		this.entityItemFacilitatorVWDAO = entityItemFacilitatorVWDAO;
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EntityItemFacilitatorVWInfo> findByCond(final EntityItemFacilitatorVWSearchCond cond){
		return entityItemFacilitatorVWDAO.findByCond(cond);
	}
}
