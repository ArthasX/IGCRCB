/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR02DTO;

/**
 * �������ҵ���߼��ӿ�
 *
 */
public interface IGSMR02BL  extends BaseBL  {

	/**
	 * ������Ч���������Ϣ��ѯ����
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestion(IGSMR02DTO dto) throws BLException;
	
	/**
	 * ���������������Ϣ��ѯ����
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO searchApproveSuggestionAllByPidid(IGSMR02DTO dto) throws BLException;
	
	/**
	 * ����������淽��
	 * 
	 * @param dto 
	 * @return IGSMR02DTO
	 */
	public IGSMR02DTO saveApproveSuggestion(IGSMR02DTO dto) throws BLException;
}
