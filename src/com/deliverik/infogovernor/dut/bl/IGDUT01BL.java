/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT01DTO;
/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ֵ�����_ֵ�����趨_BL
 * </p>
 * 
 * @version 
 */
public interface IGDUT01BL extends BaseBL{
	/**
	 * 
	 * Description: ֵ������Ϣ��ѯ
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGDUT01DTO searchDutyAuditDefAction(IGDUT01DTO dto) throws BLException;
	
	/**
	 * 
	 * Description: ֵ������Ϣ�趨
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT01DTO insertDutyAuditDefAction(IGDUT01DTO dto) throws BLException;
	


	/**
	 * 
	 * Description: ֵ������Ϣ���
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 * @throws BLException
	 * @update
	 */
	public IGDUT01DTO updateDutyAuditDefAction(IGDUT01DTO dto) throws BLException ;
	
	/**
	 * ״̬���³�����ʾ
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGDUT01DTO initDutyAuditDef(IGDUT01DTO dto) throws BLException ;

	/**
	 * ״̬���´���
	 *
	 * @param dto IGSDL04DTO
	 * @return IGSDL04DTO
	 */
	public IGDUT01DTO changeDutyAuditDefAction(IGDUT01DTO dto) throws BLException ;
}