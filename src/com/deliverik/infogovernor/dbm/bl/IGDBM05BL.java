/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM05DTO;

/**
 * @�����������������ۺϷ�����ҳBL
 * @�������� 1. ȡ������������������ռ��ֵ
 *           2. ȡ������ƽ�����ʱ������ֵ
 *           3. ȡ��������������ֵ
 *           4. ȡ�����⼰ʱ�����ֵ
 * @������¼ �Կ�  2010/11/29
 * @version 1.0
 */

public interface IGDBM05BL extends BaseBL {

	/**
	 * ����: ȡ������������������ռ��ֵ
	 * @param  IGDBM05DTO dto
	 * @return �������������ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getPieValue(IGDBM05DTO dto) throws BLException;
	
	/**
	 * ����: ȡ������ƽ�����ʱ������ֵ
	 * @param  IGDBM05DTO dto
	 * @return ����ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForAvg(IGDBM05DTO dto) throws BLException;
	
	/**
	 * ����: ȡ��������������ֵ
	 * @param  IGDBM05DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForCount(IGDBM05DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�����⼰ʱ���������ֵ
	 * @param  IGDBM05DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemLineForSolve(IGDBM05DTO dto) throws BLException;
	/**
	 * ����: ȡ�������ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM05DTO dto
	 * @return �����ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM05DTO getProcessProblemAllMode(IGDBM05DTO dto) throws BLException;
}
