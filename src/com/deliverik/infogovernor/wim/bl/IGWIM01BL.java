/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.dto.IGWIM01DTO;

/**
 * @Description ���������BL�ӿ�
 * 
 * @date 2017��6��9��16:12:59
 * 
 * @author WangLiang
 *
 */
public interface IGWIM01BL extends BaseBL{

	/**
	 * @Description ������Ǽ�
	 * @param dto IGWIM01DTO
	 * @return IGWIM01DTO
	 * @throws BLException
	 */
	public IGWIM01DTO insertWorkDefinitionAction(IGWIM01DTO dto) throws BLException;
}
