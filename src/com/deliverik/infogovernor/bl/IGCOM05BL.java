package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM05DTO;

/**
 * portalҳ֪ͨ�ӿ�
 *
 *
 */
public interface IGCOM05BL extends BaseBL {


	/**
	 * ��ѯ���ڵ�֪ͨ
	 */
	public IGCOM05DTO getNotice(IGCOM05DTO dto) throws BLException;


	
}
