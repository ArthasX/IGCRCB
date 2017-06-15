/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;

/**
 * ����: ���̲����趨��ѯAction����
 * �������������̲����趨��ѯAction����
 * ������¼������    2010/11/26
 * �޸ļ�¼��
 */
public interface IGSYM17BL extends BaseBL {
	
	/**
	 * ���ܣ����̶�����Ϣ��ѯ����
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO searchProcessDefinitionAction(IGSYM17DTO dto) throws BLException;
	
	/**
	 * ���ܣ����̲����趨��ѯ����
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO initIGSYM1702Action(IGSYM17DTO dto) throws BLException;
	
	/**
	 * ���ܣ����̲����趨�༭����
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO editIGSYM1702Action(IGSYM17DTO dto) throws BLException;
	
}
