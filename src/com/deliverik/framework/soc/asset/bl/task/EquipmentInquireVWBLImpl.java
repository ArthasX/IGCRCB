/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.condition.EquipmentInquireVWSearchCond;
import com.deliverik.framework.soc.asset.model.dao.EquipmentInquireVWDAO;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ
 * �����ˣ�����͢
 * ������¼�� 2013-02-01
 * �޸ļ�¼��
 */
public class EquipmentInquireVWBLImpl extends BaseBLImpl implements EquipmentInquireVWBL {
	
	/**EquipmentInquireVW DAO*/
	protected EquipmentInquireVWDAO equipmentInquireVWDAO ;
	
	

	public void setEquipmentInquireVWDAO(EquipmentInquireVWDAO equipmentInquireVWDAO) {
		this.equipmentInquireVWDAO = equipmentInquireVWDAO;
	}

	public List<EquipmentInquireVWInfo> getEquipmentAndIP(
			EquipmentInquireVWSearchCond cond, int start, int count) {
		
		return equipmentInquireVWDAO.getEquipmentAndIP(cond, start, count);
	}

	public int getEquipmentAndIPCount(EquipmentInquireVWSearchCond cond) {
		
		return equipmentInquireVWDAO.getEquipmentAndIPCount(cond);
	}

}
