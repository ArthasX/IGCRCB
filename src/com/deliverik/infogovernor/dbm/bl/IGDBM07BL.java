/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM07DTO;

/**
 * @�����������б���ۺϷ�����ҳBL
 * @�������� 1. ȡ���±������������ռ��ֵ
 *           2. ȡ�ñ��ƽ�����ʱ������ֵ
 *           3. ȡ�ñ����������ֵ
 *           4. ȡ�ñ����ʱ�����ֵ
 * @������¼ �Կ�  2010/11/30
 * @version 1.0
 */

public interface IGDBM07BL extends BaseBL {

	/**
	 * ����: ȡ���±������������ռ��ֵ
	 * @param  IGDBM07DTO dto
	 * @return �������������ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getPieValue(IGDBM07DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ñ��ƽ�����ʱ������ֵ
	 * @param  IGDBM07DTO dto
	 * @return ���ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForAvg(IGDBM07DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ñ����������ֵ
	 * @param  IGDBM07DTO dto
	 * @return �����������12����ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForCount(IGDBM07DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ñ����ʱ���������ֵ
	 * @param  IGDBM07DTO dto
	 * @return �����������12����ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeLineForSolve(IGDBM07DTO dto) throws BLException;
	/**
	 * ����: ȡ�ñ���ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM07DTO dto
	 * @return ����ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM07DTO getProcessChangeAllMode(IGDBM07DTO dto) throws BLException;
}
