/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.condition.RecptionOrgVWSearchCond;
import com.csebank.lom.model.dao.RecptionOrgVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ���ŽӴ�����ҵ���߼��ӿ�ʵ��
 */
public class RecptionOrgVWBLImpl extends BaseBLImpl implements RecptionOrgVWBL {
	
	/** RecptionOrgVW DAO */
	protected RecptionOrgVWDAO recptionOrgVWDAO;
	
	public void setRecptionOrgVWDAO(
			RecptionOrgVWDAO recptionOrgVWDAO) {
		this.recptionOrgVWDAO = recptionOrgVWDAO;
	}

	public List<RecptionOrg> searchRecptionOrgVW(RecptionOrgVWSearchCond cond,
			int start, int count) {
		
		return recptionOrgVWDAO.findByCond(cond, start, count);
	}
	
}
