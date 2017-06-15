/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditTime;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditTimeSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyAuditTimeDAO;

/**
 * 
 * ֵ��������ʱ��ҵ���߼�ʵ����
 *
 */
public class DutyAuditTimeBLImpl   extends BaseBLImpl implements DutyAuditTimeBL{
	
	/** DutyAuditTime DAO */
	protected DutyAuditTimeDAO dutyAuditTimeDAO;
	
	public void setDutyAuditTimeDAO(
			DutyAuditTimeDAO dutyAuditTimeDAO) {
		this.dutyAuditTimeDAO = dutyAuditTimeDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyAuditTimeSearchCond cond){
		
		return dutyAuditTimeDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param dadid ֵ������ID
	 * @return ֵ������ID
	 */
	public DutyAuditTime searchDutyAuditTimeByKey(Integer datid) throws BLException{
		
		return checkExistDutyAuditTime(datid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyAuditTime> searchDutyAuditTimeAll(){
		
		return dutyAuditTimeDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyAuditTime> searchDutyAuditTime(DutyAuditTimeSearchCond cond, int start, int count){
		
		return dutyAuditTimeDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param dutyAuditTime ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditTime registDutyAuditTime(DutyAuditTime dutyAuditTime) throws BLException{
		
		return dutyAuditTimeDAO.save(dutyAuditTime);
	}

	/**
	 * ɾ������
	 * 
	 * @param dadid ֵ������ID
	 * @return
	 */
	public void deleteDutyAuditTime(Integer datid) throws BLException{
		
		DutyAuditTime dutyAuditTime = checkExistDutyAuditTime(datid);
		
		dutyAuditTimeDAO.delete(dutyAuditTime);
	}

	/**
	 * �������
	 * 
	 * @param dutyAuditTime �������
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditTime updateDutyAuditTime(DutyAuditTime dutyAuditTime) throws BLException{
		
		checkExistDutyAuditTime(dutyAuditTime.getDadid());
		return dutyAuditTimeDAO.save(dutyAuditTime);
	}

	/**
	 * ֵ��������Ϣ���ڼ��
	 * 
	 * @param dadid ֵ������ID
	 * @return ֵ��������Ϣ
	 * @throws BLException 
	 */
	protected DutyAuditTime checkExistDutyAuditTime(Integer datid) throws BLException{
		DutyAuditTime info = dutyAuditTimeDAO.findByPK(datid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ֵ���������");
		}
		return info;
	}

}
