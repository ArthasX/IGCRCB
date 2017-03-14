/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyResultDAO;

/**
 * 
 * ֵ��������ҵ���߼��ӿ�
 *
 */
public class DutyResultBLImpl extends BaseBLImpl implements DutyResultBL{
	
	/** DutyResult DAO */
	protected DutyResultDAO dutyResultDAO;
	
	public void setDutyResultDAO(
			DutyResultDAO dutyResultDAO) {
		this.dutyResultDAO = dutyResultDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(DutyResultSearchCond cond){
		
		return dutyResultDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param drid ֵ��������ID
	 * @return ֵ��������
	 */
	public DutyResult searchDutyResultByKey(Integer drid) throws BLException{
		
		return checkExistDutyResult(drid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ��ֵ��������
	 */
	public List<DutyResult> searchDutyResultAll(){
		
		return dutyResultDAO.findAll();
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<DutyResult> searchDutyResult(DutyResultSearchCond cond, int start, int count){
		
		return dutyResultDAO.findByCond(cond,start,count);
	}

	/**
	 * ��¼����
	 * 
	 * @param dutyResult ��¼����
	 * @return ֵ��������
	 */
	public DutyResult registDutyResult(DutyResult dutyResult) throws BLException{
		
		return dutyResultDAO.save(dutyResult);
	}

	/**
	 * ɾ������
	 * 
	 * @param drid ֵ��������ID
	 * @return
	 */
	public void deleteDutyResult(Integer drid) throws BLException{
		
		DutyResult dutyResult = checkExistDutyResult(drid);
		
		dutyResultDAO.delete(dutyResult);
	}

	/**
	 * �������
	 * 
	 * @param dutyResult �������
	 * @return ֵ��������
	 */
	public DutyResult updateDutyResult(DutyResult dutyResult) throws BLException{
		
		checkExistDutyResult(dutyResult.getDrid());
		return dutyResultDAO.save(dutyResult);
	}

	/**
	 * ֵ�������ݴ��ڼ��
	 * 
	 * @param drid ֵ��������ID
	 * @return ֵ��������
	 * @throws BLException 
	 */
	protected DutyResult checkExistDutyResult(Integer drid) throws BLException{
		DutyResult info = dutyResultDAO.findByPK(drid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","ֵ�������ݻ���");
		}
		return info;
	}
}
