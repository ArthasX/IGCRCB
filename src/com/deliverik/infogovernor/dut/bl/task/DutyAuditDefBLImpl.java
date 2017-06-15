/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyAuditDef;
import com.deliverik.infogovernor.dut.model.condition.DutyAuditDefSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyAuditDefDAO;

/**
 * ֵ�������ҵ���߼��ӿ�
 */
public class DutyAuditDefBLImpl extends BaseBLImpl implements DutyAuditDefBL {
	
	/** DutyAuditDef DAO */
	protected DutyAuditDefDAO dutyAuditDefDAO;
	
	public void setDutyAuditDefDAO(
			DutyAuditDefDAO dutyAuditDefDAO) {
		this.dutyAuditDefDAO = dutyAuditDefDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyAuditDefSearchCond cond){
		
		return dutyAuditDefDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param dadid ֵ������ID
	 * @return ֵ������ID
	 */
	public DutyAuditDef searchDutyAuditDefByKey(Integer dadid) throws BLException{
		
		return checkExistDutyAuditDef(dadid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������Ϣ
	 */
	public List<DutyAuditDef> searchDutyAuditDefAll(){
		
		return dutyAuditDefDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyAuditDef> searchDutyAuditDef(DutyAuditDefSearchCond cond, int start, int count){
		
		return dutyAuditDefDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param dutyAuditDef ��¼����
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditDef registDutyAuditDef(DutyAuditDef dutyAuditDef) throws BLException{
		
		return dutyAuditDefDAO.save(dutyAuditDef);
	}

	/**
	 * ɾ������
	 * 
	 * @param dadid ֵ������ID
	 * @return
	 */
	public void deleteDutyAuditDef(Integer dadid) throws BLException{
		
		DutyAuditDef dutyAuditDef = checkExistDutyAuditDef(dadid);
		
		dutyAuditDefDAO.delete(dutyAuditDef);
	}

	/**
	 * �������
	 * 
	 * @param dutyAuditDef �������
	 * @return ֵ��������Ϣ
	 */
	public DutyAuditDef updateDutyAuditDef(DutyAuditDef dutyAuditDef) throws BLException{
		
		checkExistDutyAuditDef(dutyAuditDef.getDadid());
		return dutyAuditDefDAO.save(dutyAuditDef);
	}

	/**
	 * ֵ��������Ϣ���ڼ��
	 * 
	 * @param dadid ֵ������ID
	 * @return ֵ��������Ϣ
	 * @throws BLException 
	 */
	protected DutyAuditDef checkExistDutyAuditDef(Integer dadid) throws BLException{
		DutyAuditDef info = dutyAuditDefDAO.findByPK(dadid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ֵ���������");
		}
		return info;
	}
}
