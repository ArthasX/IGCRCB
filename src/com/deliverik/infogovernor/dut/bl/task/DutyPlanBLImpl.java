/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyPlanDAO;

/**
 * ֵ�������ҵ���߼��ӿ�
 */
public class DutyPlanBLImpl extends BaseBLImpl implements DutyPlanBL {
	/** DutyAuditDef DAO */
	protected DutyPlanDAO dutyPlanDAO;

	public void setDutyPlanDAO(DutyPlanDAO dutyPlanDAO) {
		this.dutyPlanDAO = dutyPlanDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyPlanSearchCond cond){
		
		return dutyPlanDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param dpid ֵ������ID
	 * @return ֵ������ID
	 */
	public DutyPlan searchDutyPlanByKey(Integer dpid) throws BLException{
		
		return checkExistDutyPlan(dpid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyPlan> searchDutyPlanAll(){
		
		return dutyPlanDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyPlan> searchDutyPlan(DutyPlanSearchCond cond, int start, int count){
		
		return dutyPlanDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param dutyPlan ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyPlan registDutyPlan(DutyPlan dutyPlan) throws BLException{
		
		return dutyPlanDAO.save(dutyPlan);
	}

	/**
	 * ɾ������
	 * 
	 * @param dadid ֵ������ID
	 * @return
	 */
	public void deleteDutyPlan(Integer dpid) throws BLException{
		
		DutyPlan dutyPlan = checkExistDutyPlan(dpid);
		
		dutyPlanDAO.delete(dutyPlan);
	}

	/**
	 * �������
	 * 
	 * @param dutyAuditDef �������
	 * @return ֵ��������Ϣ
	 */
	public DutyPlan updateDutyPlan(DutyPlan dutyPlan) throws BLException{
		
		checkExistDutyPlan(dutyPlan.getDpid());
		return dutyPlanDAO.save(dutyPlan);
	}

	/**
	 * ֵ��������Ϣ���ڼ��
	 * 
	 * @param dadid ֵ������ID
	 * @return ֵ��������Ϣ
	 * @throws BLException 
	 */
	protected DutyPlan checkExistDutyPlan(Integer dpid) throws BLException{
		DutyPlan info = dutyPlanDAO.findByPK(dpid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ֵ�����");
		}
		return info;
	}
}
