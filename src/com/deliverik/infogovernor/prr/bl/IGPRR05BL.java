/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;

/**
 * ����: ������BL
 * ��������: ������BL
 * ������¼: 2015/02/03
 * �޸ļ�¼: 
 */
public interface IGPRR05BL extends BaseBL{

	/**
	 * �������ѯ
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchGroupAction(IGPRR05DTO dto) throws BLException;
	
	/**
	 * �������Ա��ѯ
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchProcessAction(IGPRR05DTO dto) throws BLException;

}
