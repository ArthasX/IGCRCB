/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;

/**
 * ͳ�Ʒ���ҵ���߼��ӿ�
 *
 */
public interface IGCOM02BL extends BaseBL {
	
	/**
	 * �����������ѯ����
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	public IGCOM02DTO searchReportTypeTreeAction(IGCOM02DTO dto) throws BLException;
	
	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	public IGCOM02DTO searchReportFileDefinitionAction(IGCOM02DTO dto) throws BLException;
	
	/**
	 * ������Ȩ��������ѯ
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGCOM02DTO filterReportTypeTreeAction(IGCOM02DTO dto) throws BLException;
	
	/**
	 * Ӧ�ù�����ҳ��ʾ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCOM02DTO searchIgcom0218Action(IGCOM02DTO dto)throws BLException;
	
}
