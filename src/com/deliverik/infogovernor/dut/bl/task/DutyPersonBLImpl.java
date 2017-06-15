/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyPersonDAO;

/**
 * ֵ�������ҵ���߼��ӿ�
 */
public class DutyPersonBLImpl extends BaseBLImpl implements DutyPersonBL {
	/** DutyAuditDef DAO */
	protected DutyPersonDAO dutyPersonDAO;

	public void setDutyPersonDAO(DutyPersonDAO dutyPersonDAO) {
		this.dutyPersonDAO = dutyPersonDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyPersonSearchCond cond){
		
		return dutyPersonDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param dpid ֵ������ID
	 * @return ֵ������ID
	 */
	public DutyPerson searchDutyPersonByKey(Integer dperid) throws BLException{
		
		return checkExistDutyPerson(dperid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyPerson> searchDutyPersonAll(){
		
		return dutyPersonDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyPerson> searchDutyPerson(DutyPersonSearchCond cond, int start, int count){
		
		return dutyPersonDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param dutyAuditDef ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyPerson registDutyPerson(DutyPerson DutyPerson) throws BLException{
		
		return dutyPersonDAO.save(DutyPerson);
	}

	/**
	 * ɾ������
	 * 
	 * @param dadid ֵ������ID
	 * @return
	 */
	public void deleteDutyPerson(Integer dperid) throws BLException{
		
		DutyPerson DutyPerson = checkExistDutyPerson(dperid);
		
		dutyPersonDAO.delete(DutyPerson);
	}

	/**
	 * �������
	 * 
	 * @param dutyAuditDef �������
	 * @return ֵ��������Ϣ
	 */
	public DutyPerson updateDutyPerson(DutyPerson DutyPerson) throws BLException{
		
		checkExistDutyPerson(DutyPerson.getDpid());
		return dutyPersonDAO.save(DutyPerson);
	}

	/**
	 * ֵ��������Ϣ���ڼ��
	 * 
	 * @param dadid ֵ������ID
	 * @return ֵ��������Ϣ
	 * @throws BLException 
	 */
	protected DutyPerson checkExistDutyPerson(Integer dperid) throws BLException{
		DutyPerson info = dutyPersonDAO.findByPK(dperid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ֵ���˻���");
		}
		return info;
	}
}
