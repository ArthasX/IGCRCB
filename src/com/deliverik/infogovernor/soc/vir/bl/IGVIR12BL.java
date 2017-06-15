package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR12DTO;

/**
 * ����: ��Դռ�����
 * ��������: ��Դռ�����
 * ������¼: 2014/02/12
 * �޸ļ�¼:
 */
public interface IGVIR12BL extends BaseBL {
	/**
	 * vCenter��host��Ϣȡ��
	 *
	 * @param dto IGVIR12DTO
	 * @return IGVIR12DTO
	 */
	public IGVIR12DTO getvCenterList(IGVIR12DTO dto) throws BLException;
	/**
	 * vCenter��host��Ϣȡ��
	 *
	 * @param dto IGVIR12DTO
	 * @return IGVIR12DTO
	 */
	public IGVIR12DTO getHostInfo(IGVIR12DTO dto) throws BLException;
	
	/**
	 * �������߹ر����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO startOrStopPowerOfVM(IGVIR12DTO dto) throws BLException;
	
	/**
	 * ʹ�������ʼ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO initIGVIR1202Action(IGVIR12DTO dto) throws BLException;
	
	/**
	 * ָ��vCenterHost��Դʹ�������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR12DTO searchHostUsedAction(IGVIR12DTO dto) throws BLException;
}
