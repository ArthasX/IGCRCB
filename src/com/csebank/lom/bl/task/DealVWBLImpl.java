/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.condition.DealVWSearchCond;
import com.csebank.lom.model.dao.DealVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * �Ӵ�����ҵ���߼��ӿ�ʵ��
 */
public class DealVWBLImpl extends BaseBLImpl implements DealVWBL {
	
	/** RecptionVW DAO */
	protected DealVWDAO dealVWDAO;
	


	public List<DealVWInfo> searchDealVW(DealVWSearchCond cond,
			int start, int count) {
		
		return dealVWDAO.findByCond(cond, start, count);
	}



	public DealVWDAO getDealVWDAO() {
		return dealVWDAO;
	}



	public void setDealVWDAO(DealVWDAO dealVWDAO) {
		this.dealVWDAO = dealVWDAO;
	}

}
