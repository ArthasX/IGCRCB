/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.model.EntityItemFacilitatorVWInfo;
import com.deliverik.infogovernor.asset.model.condition.EntityItemFacilitatorVWSearchCond;
/**
 * ����:��������Ϣ��ͼBL�ӿ�
 * ��������: ��������Ϣ��ͼBL�ӿ�
 * �����ˣ�����
 * ������¼: 2013/05/13
 * �޸ļ�¼: 
 */
public interface EntityItemFacilitatorVWBL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EntityItemFacilitatorVWInfo> findByCond(final EntityItemFacilitatorVWSearchCond cond);
}
