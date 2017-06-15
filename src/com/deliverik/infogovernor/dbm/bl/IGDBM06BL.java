/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM06DTO;

/**
 * @�������������¼��ۺϷ�����ҳBL
 * @�������� 1. ȡ�����¼�����������ռ��ֵ
 *           2. ȡ���¼�ƽ�����ʱ������ֵ
 *           3. ȡ���¼���������ֵ
 *           4. ȡ���¼���ʱ�����ֵ
 * @������¼ �Կ�  2010/11/30
 * @version 1.0
 */

public interface IGDBM06BL extends BaseBL {

	/**
	 * ����: ȡ�����¼�����������ռ��ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼�����������ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getPieValue(IGDBM06DTO dto) throws BLException;
	
	/**
	 * ����: ȡ���¼�ƽ�����ʱ������ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼�ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForAvg(IGDBM06DTO dto) throws BLException;
	
	/**
	 * ����: ȡ���¼���������ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼���������12����ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForCount(IGDBM06DTO dto) throws BLException;
	
	/**
	 * ����: ȡ���¼���ʱ���������ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼���������12����ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForSolve(IGDBM06DTO dto) throws BLException;
	/**
	 * ����: ȡ���¼��ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM06DTO dto
	 * @return �¼��ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentAllMode(IGDBM06DTO dto) throws BLException;
}
