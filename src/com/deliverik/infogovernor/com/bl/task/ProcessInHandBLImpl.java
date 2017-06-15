/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.com.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCondImpl;
import com.deliverik.infogovernor.com.model.dao.ProcessInHandSingleVWDAO;

/**
 * ֵ�������ҵ���߼��ӿ�
 */
public class ProcessInHandBLImpl extends BaseBLImpl implements ProcessInHandBL {
	/** DutyAuditDef DAO */
	protected ProcessInHandSingleVWDAO processInHandSingleVWDAO;

	public void setProcessInHandSingleVWDAO(
			ProcessInHandSingleVWDAO processInHandSingleVWDAO) {
		this.processInHandSingleVWDAO = processInHandSingleVWDAO;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessInHandVWInfo> searchProcessInHandByUserID(String userid,int start, int count,boolean desc) throws BLException{
		ProcessInHandVWInfoSearchCondImpl cond = new ProcessInHandVWInfoSearchCondImpl();
		cond.setUserid(userid);
		return processInHandSingleVWDAO.searchProcessInhand(cond,start,count,desc);
		
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessInHandVWInfo> searchProcessInHandGroupByUserID(String userid,int start,int count,boolean desc) throws BLException{
		ProcessInHandVWInfoSearchCondImpl cond = new ProcessInHandVWInfoSearchCondImpl();
		cond.setUserid(userid);
		return processInHandSingleVWDAO.searchProcessInhandGroup(cond,start,count, desc);
		
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<ProcessInHandVWInfo> searchProcessInHandDiscontinueByUserID(
			String userid, boolean desc) throws BLException {
		ProcessInHandVWInfoSearchCondImpl cond = new ProcessInHandVWInfoSearchCondImpl();
		cond.setUserid(userid);
		return processInHandSingleVWDAO.searchProcessInhandDiscontinue(cond,desc);
	}
}
