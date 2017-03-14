/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.prj.model.condition.InvestUseInfoSearchCond;
import com.deliverik.infogovernor.prj.model.dao.InvestUseInfoDAO;

/**
 * ����:Ͷ��ʹ�������ϸ����BLʵ�� 
 * ����������Ͷ��ʹ�������ϸ����BLʵ��
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
public class InvestUseInfoBLImpl extends BaseBLImpl implements InvestUseInfoBL{
	
	/** Ͷ��ʹ�����DAO */
	private InvestUseInfoDAO  investUseInfoDAO;

	/**
	 * Ͷ��ʹ�����DAO�趨
	 * @param investUseInfoDAO Ͷ��ʹ�����DAO
	 */
	public void setInvestUseInfoDAO(InvestUseInfoDAO investUseInfoDAO) {
		this.investUseInfoDAO = investUseInfoDAO;
	}
	
	public List<InvestUseInfoVW> findAll(InvestUseInfoSearchCond cond){
		return investUseInfoDAO.findAll(cond);
	}
	
	/***
	 * Ͷ�ʺ�ͬ��ϸ�����ѯ
	 * @return
	 */
	public List<InvestContractInfoVW> findInvestContractInfo(){
		return investUseInfoDAO.findInvestContractInfo();
	}
}
