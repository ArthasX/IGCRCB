/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.condition.EEOrgVWSearchCond;
import com.csebank.lom.model.condition.EESearchCond;
import com.csebank.lom.model.dao.EEDetailDAO;
import com.csebank.lom.model.dao.EEOrgVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż���ҵ���߼��ӿ�ʵ��
 * ���ߣ�������
 */
public class EEOrgVWBLImpl extends BaseBLImpl implements EEOrgVWBL {
	
	/** RecptionOrgVW DAO */
	protected EEOrgVWDAO eeOrgVWDAO;
	protected EEDetailDAO eeDetailDAO;
	

	public List<EEOrg> searchEEOrgVW(EEOrgVWSearchCond cond,
			int start, int count) {
		
		return eeOrgVWDAO.findByCond(cond, start, count);
	}
	public List<Eentertainment> searchEEOrgVWDetail(EESearchCond cond, int start, int count){
		return eeDetailDAO.findByCond(cond, start, count);
	}


	public EEOrgVWDAO getEeOrgVWDAO() {
		return eeOrgVWDAO;
	}



	public void setEeOrgVWDAO(EEOrgVWDAO eeOrgVWDAO) {
		this.eeOrgVWDAO = eeOrgVWDAO;
	}
	public EEDetailDAO getEeDetailDAO() {
		return eeDetailDAO;
	}
	public void setEeDetailDAO(EEDetailDAO eeDetailDAO) {
		this.eeDetailDAO = eeDetailDAO;
	}
	

	
}
