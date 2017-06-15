/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;

/**
 * �����ڱ����ҵ���߼��ӿ�
 *
 */
public interface IGSMR07BL extends BaseBL{
	
	/**
	 * 
	 *�����������ڱ�����
	 *ʱ�䣺2013-8-8����11:17:44
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	IGSMR07DTO insertSMR0701Action(IGSMR07DTO dto) throws BLException;
	
	/**
	 * 
	 *�����������ڱ�����ҳ��ʼ��
	 *ʱ�䣺2013-8-8����04:45:25
	 * @param dto 
	 *@throws BLException
	 */
	IGSMR07DTO initSMR0701Action(IGSMR07DTO dto)throws BLException;

	/**
	 * 
	 *��������ѯ��ǰ������Ҫ����Ĳ����ڱ���
	 *ʱ�䣺2013-8-8����11:11:05
	 *@param dto
	 *@return
	 *@throws BLException
	 */
	IGSMR07DTO needMeManagerAction(IGSMR07DTO dto)throws BLException;

	/**
	 * ��ѯ��������
	 *
	 */
	public IGSMR07DTO reportExamineAction(IGSMR07DTO dto)throws BLException;
	
	/**
	 * ��ѯ�����ڱ�������
	 *
	 */
	public IGSMR07DTO AnnualreportExamineAction(IGSMR07DTO dto);
	
	/**
	 * ��鿴
	 *
	 */
	public IGSMR07DTO seeFillInAction(IGSMR07DTO dto)throws BLException;
	
	/**
	 * �����ڱ�����ϸ�б��ѯ����
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO initIGSMR0704Action(IGSMR07DTO dto) throws BLException;
	
	/**
	 * �����ڱ�����������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO managerIGSMR0704Action (IGSMR07DTO dto) throws BLException;

}
