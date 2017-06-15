/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM10DTO;

/**
 * @����������������ҵ��ʵʱ�����ҳBL
 * @�������� 1.����ҵ��ʵʱ���         
 *			2.db2��Ϣ        
 *			3.���������HCAMP״̬         
 *			4.cpuռ����TOP5
 *			5.Omnibus�¼�����
 * @������¼��������    2010/12/01
 * @version 1.0
 */

public interface IGDBM10BL extends BaseBL {

	/**
	 * ����: ����ҵ��ʵʱ���
	 * @param  IGDBM10DTO dto
	 * @return ����ҵ��ʵʱ����
	 * @throws BLException
	 */
	public IGDBM10DTO getChannelsBusinessRealtime(IGDBM10DTO dto) throws BLException;
	
	/**
	 * ����: db2��Ϣ
	 * @param  IGDBM10DTO dto
	 * @return db2��Ϣ����
	 * @throws BLException
	 */
	public IGDBM10DTO getDB2Information(IGDBM10DTO dto) throws BLException;
	
	/**
	 * ����: ���������HCAMP״̬
	 * @param  IGDBM10DTO dto
	 * @return ���������HCAMP״ֵ̬
	 * @throws BLException
	 */
	public IGDBM10DTO getBackupAndHCAMPType(IGDBM10DTO dto) throws BLException;
	
	/**
	 * ����:cpuռ����TOP5
	 * @param  IGDBM10DTO dto
	 * @return cpuռ����TOP5ֵ
	 * @throws BLException
	 */
	public IGDBM10DTO getCPUOccupancyrateTOP5(IGDBM10DTO dto) throws BLException;
	
	/**
	 * ����: Omnibus�¼�����
	 * @param  IGDBM10DTO dto
	 * @return Omnibus�¼�����ֵ
	 * @throws BLException
	 */
	public IGDBM10DTO getOmnibusEventWarning(IGDBM10DTO dto) throws BLException;
}
