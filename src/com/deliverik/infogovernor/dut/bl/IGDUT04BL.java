/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.dto.IGDUT04DTO;

/**
 * ��ʱ����BL
 */
public interface IGDUT04BL extends BaseBL {

	/**
	 * ��ʱ�����Ǽ�
	 * @param dto
	 * @return
	 */
	public IGDUT04DTO insertEntityAction(IGDUT04DTO dto) throws BLException;

	/**
	 * ����������ʱ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO searchDelayByCond(IGDUT04DTO dto) throws BLException;

	/**
	 * ��ʱ�������������ʾ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO initDelayAudit(IGDUT04DTO dto) throws BLException;

	/**
	 * ��ʱ�����������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO updateDelayAuditAction(IGDUT04DTO dto) throws BLException;

	/**
	 * ��ʱ����ɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT04DTO deleteDelayAction(IGDUT04DTO dto) throws BLException;

	/**
	 * ȡ��������������б���
	 * @return
	 */
	public IGDUT04DTO getTitle(IGDUT04DTO dto) throws BLException;
}
