package com.deliverik.infogovernor.prr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.dto.IGPRR06DTO;

public interface IGPRR06BL {
	
	public IGPRR01DTO search(IGPRR01DTO dto)throws BLException ;

	public IGPRR01DTO searchAll(IGPRR01DTO dto)throws BLException;
	
	public IGPRR01DTO searchByEIID(IGPRR01DTO dto) throws BLException;
		/**
	 * ���̲�ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessRecordAction(IGPRR06DTO dto) throws BLException;

	/**
	 * ��ѯ����ID
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessDefinitionIdAction(IGPRR06DTO dto) throws BLException;

	/**
	 * ��ȡ��ѯ������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO searchProcessQueryTitleAction(IGPRR06DTO dto) throws BLException;

	/**
	 * ���̵�������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR06DTO exportProcessRecordAction(IGPRR06DTO dto) throws BLException;
	
	/**
	 * ���̲�ѯJSPȡ��
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGPRR06DTO searchForwardJsp(IGPRR06DTO dto) throws BLException;
}
