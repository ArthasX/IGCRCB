/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.bl;


import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2401DTO;

public interface IGCRC24BL  extends BaseBL{
	/**
	 * �¼�ƽ�����ʱ�䴦��
	 *
	 * @param dto IGCRC2401DTO
	 * @return IGCRC2401DTO
	 */
	public IGCRC2401DTO getFindStatistics(IGCRC2401DTO dto);
	
	
	/**
	 * �¼�ƽ�����ʱ�䴦��
	 * ��ʼʱ��-ȷ��ʱ��
	 * zhangq
	 * @param dto IGCRC2401DTO
	 * @return IGCRC2401DTO
	 */
	public IGCRC2401DTO getFindStatisticsConfirm(IGCRC2401DTO dto);
	
	
	
	
	

}
