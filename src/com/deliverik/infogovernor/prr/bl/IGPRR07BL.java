/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BaseBL;



import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prr.dto.IGPRR0702DTO;



public interface IGPRR07BL extends BaseBL {
	/**
	 * �豸��Ϣ�ǼǴ���
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGPRR0702DTO insertEntityItemAction(IGPRR0702DTO dto) throws BLException;
	/**
	 * �ʲ������˵�,��ѯ�ʲ�������Ϣ���ʲ�ģ��������Ϣ
	 * 
	 * @param dto
	 * @return IGPRR0601DTO
	 */
	public IGPRR0702DTO getJsonString(IGPRR0702DTO dto);
	
}
