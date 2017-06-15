/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;
import com.deliverik.infogovernor.smr.dto.IGSMR06DTO;

/**
 * ����:��������
 * ������������������
 * �����ˣ�����͢
 * ������¼�� 2013-08-08
 * �޸ļ�¼��
 */
public interface IGSMR06BL extends BaseBL {

	/**
	 * ������������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR06DTO insertSMR0601Action(IGSMR06DTO dto) throws BLException;
	
	/**
	 * �������ѯ
	 *
	 */
	public IGSMR06DTO needMeManagerAction(IGSMR06DTO dto)throws BLException;
	
	/**
	 * ��ѯ��������
	 *
	 */
	public IGSMR06DTO reportExamineAction(IGSMR06DTO dto)throws BLException;
	
	/**
	 * ��ѯ�걨����
	 *
	 */
	public IGSMR06DTO AnnualreportExamineAction(IGSMR06DTO dto);
	
	/**
	 * ��鿴
	 *
	 */
	public IGSMR06DTO seeFillInAction(IGSMR06DTO dto)throws BLException;
	
	/**
	 * ���ֹ
	 *
	 */
	public IGSMR06DTO stopFillInAction(IGSMR06DTO dto)throws BLException;
	
	
	/**
	 * �߰�
	 *
	 */
	public IGSMR06DTO pressAction(IGSMR06DTO dto)throws BLException;	

	/**
	 * ������ϸ�б��ѯ����
	 *
	 * @param dto IGSMR06DTO
	 * @return IGSMR06DTO
	 */
	public IGSMR06DTO initIGSMR0604Action(IGSMR06DTO dto) throws BLException;
	
	/**
	 * ������������
	 *
	 * @param dto IGSMR06DTO
	 * @return IGSMR06DTO
	 */
	public IGSMR06DTO managerIGSMR0604Action (IGSMR06DTO dto) throws BLException;
	
}
