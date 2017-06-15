/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM08DTO;

/**
 * @�����������й����ۺϷ�����ҳBL
 * @�������� 1. ȡ���¹�������������ռ��ֵ
 *           2. ȡ�ù���ƽ�����ʱ������ֵ
 *           3. ȡ�ù�����������ֵ
 *           4. ȡ�ù�����ʱ�����ֵ
 * @������¼ �Կ�  2010/11/30
 * @version 1.0
 */

public interface IGDBM08BL extends BaseBL {

	/**
	 * ����: ȡ���¹�������������ռ��ֵ
	 * @param  IGDBM08DTO dto
	 * @return ��������������ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getPieValue(IGDBM08DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ù���ƽ�����ʱ������ֵ
	 * @param  IGDBM08DTO dto
	 * @return ����ƽ�����ʱ������12����ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForAvg(IGDBM08DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ù�����������ֵ
	 * @param  IGDBM08DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForCount(IGDBM08DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ù�����ʱ���������ֵ
	 * @param  IGDBM08DTO dto
	 * @return ������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForSolve(IGDBM08DTO dto) throws BLException;
	/**
	 * ����: ȡ�ù����ۺϷ���ҳ������ģ��ֵ
	 * @param  IGDBM08DTO dto
	 * @return �����ۺϷ���ҳ������ģ��ֵ
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkAllMode(IGDBM08DTO dto) throws BLException;
}
