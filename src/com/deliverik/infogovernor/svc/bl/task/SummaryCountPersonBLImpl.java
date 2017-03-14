/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCond;
import com.deliverik.infogovernor.svc.model.dao.SummaryCountPersonDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SummaryCountPersonBLImpl extends BaseBLImpl implements SummaryCountPersonBL{

	/** ��Ա������ͳ��DAO */
	protected SummaryCountPersonDAO summaryCountPersonDAO;


	
	/** ������Ա������ͳ��DAO */
	public void setSummaryCountPersonDAO(SummaryCountPersonDAO summaryCountPersonDAO) {
		this.summaryCountPersonDAO = summaryCountPersonDAO;
	}



	/**
	 * ��ѯͳ������
	 */
	public List<IG160Info> searchSummary(SummaryCountPersonSearchCond cond){
		
		return summaryCountPersonDAO.searchSummary(cond);
	}



}
