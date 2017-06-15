/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.condition.InvestUseInfoSearchCond;

/**
 * ����:Ͷ��ʹ�������ϸ����BL�ӿ� 
 * ����������Ͷ��ʹ�������ϸ����BL�ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
public interface InvestUseInfoBL extends BaseBL{
	public List<InvestUseInfoVW> findAll(InvestUseInfoSearchCond cond);
	
	/***
	 * Ͷ�ʺ�ͬ��ϸ�����ѯ
	 * @return
	 */
	public List<InvestContractInfoVW> findInvestContractInfo();
}
