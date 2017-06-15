package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR11DTO;
/**
 * �±��ҵ���߼��ӿ�
 *
 */
public interface IGSMR11BL extends BaseBL {
	/**
	 * ������������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR11DTO insertSMR1101Action(IGSMR11DTO dto) throws BLException;
	/**
	 * �������ѯ
	 *
	 */
	public IGSMR11DTO needMeManagerAction(IGSMR11DTO dto)throws BLException;
	
	/**
	 * ��ѯ��������
	 *
	 */
	public IGSMR11DTO reportExamineAction(IGSMR11DTO dto)throws BLException;
	
	/**
	 * ��ѯ�걨����
	 *
	 */
	public IGSMR11DTO AnnualreportExamineAction(IGSMR11DTO dto);
	
	/**
	 * ��鿴
	 *
	 */
	public IGSMR11DTO seeFillInAction(IGSMR11DTO dto)throws BLException;
	
	/**
	 * ���ֹ
	 *
	 */
	public IGSMR11DTO stopFillInAction(IGSMR11DTO dto)throws BLException;
	
	
	/**
	 * �߰�
	 *
	 */
	public IGSMR11DTO pressAction(IGSMR11DTO dto)throws BLException;	

	/**
	 * ������ϸ�б��ѯ����
	 *
	 * @param dto IGSMR11DTO
	 * @return IGSMR11DTO
	 */
	public IGSMR11DTO initIGSMR1104Action(IGSMR11DTO dto) throws BLException;
	
	/**
	 * ������������
	 *
	 * @param dto IGSMR11DTO
	 * @return IGSMR11DTO
	 */
	public IGSMR11DTO managerIGSMR1104Action (IGSMR11DTO dto) throws BLException;
	
}
