/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM09DTO;

/**
 * @������������ϵͳ�����ʷ�����ҳBL
 * @�������� 1.��ǰʵ�ʿ�����         
 *			2.ʵ�ʿ�����ȫ���ۼ�        
 *			3.�������������         
 *			4.������ʱ���������
 * @������¼��������    2010/12/01
 * @version 1.0
 */

public interface IGDBM09BL extends BaseBL {

	/**
	 * ����: ȡ�õ�ǰʵ�ʿ�����
	 * @param  IGDBM09DTO dto
	 * @return ��ǰʵ�ʿ�����ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getCurrentActualAvailability(IGDBM09DTO dto) throws BLException;
	
	/**
	 * ����: ȡ��ʵ�ʿ�����ȫ���ۼ�
	 * @param  IGDBM09DTO dto
	 * @return ʵ�ʿ�����ȫ���ۼ�ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getYearActualAvailability(IGDBM09DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ÿ������������
	 * @param  IGDBM09DTO dto
	 * @return �������������12����ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getAvailabilityYearTrends(IGDBM09DTO dto) throws BLException;
	
	/**
	 * ����: ȡ�ù�����ʱ���������
	 * @param  IGDBM09DTO dto
	 * @return ������ʱ���������12����ֵ
	 * @throws BLException
	 */
	public IGDBM09DTO getWorkTimelySolutionlyTrends(IGDBM09DTO dto) throws BLException;
}
