/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM23DTO;
/**
 * ����: �ʲ�����ҵ���߼��ӿ�
 * ��������: �ʲ�����ҵ���߼��ӿ�
 * ������¼: 2311/04/25
 * �޸ļ�¼: 
 */
public interface IGASM23BL extends BaseBL{

	/**
	 * �ɼ�����̨��ѯ����
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO initIGASM2301Action(IGASM23DTO dto) throws BLException;
	
	/**
	 * �ɼ�����
	 * @param dto IGASM23DTO
	 * @throws BLException
	 */
	public IGASM23DTO collectIGASM2301Action(IGASM23DTO dto) throws BLException;
	
}
