/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 */
public interface SummaryCountPersonBL extends BaseBL{

	/**
	 * ��ѯͳ������
	 * @param cond ��������
	 * @return
	 */
	public List<IG160Info> searchSummary(SummaryCountPersonSearchCond cond);
}
