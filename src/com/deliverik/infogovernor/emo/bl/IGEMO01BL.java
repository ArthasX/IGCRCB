/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.emo.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.emo.dto.IGEMO01DTO;
/**
 * <p>
 * Title : InfoGovernor oracle���ܼ��
 * </p>
 * <p>
 * Description: oracle���ܼ��_BL
 * </p>
 * 
 * @version 
 */
public interface IGEMO01BL extends BaseBL{

	/**
	 * oracle���ܼ�ش���
	 *
	 * @param dto IGDUT01DTO
	 * @return IGDUT01DTO
	 */
	public IGEMO01DTO getEmData(IGEMO01DTO dto) throws BLException;
}