/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.bl;


import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2001DTO;

/**
 * ����: ��ȹ���ͳ��BL�ӿ�
 * ������¼:  lianghongyang 2014-8-7 09:34:11
 * �޸ļ�¼: 
 */

public interface IGCRC20BL  extends BaseBL{
	/**
	 * ��������Դ��ͳ�ƴ���
	 *
	 * @param dto IGCRC2001DTO
	 * @return IGCRC2001DTO
	 */
	public IGCRC2001DTO getFindStatistics(IGCRC2001DTO dto);

}
