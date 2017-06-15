/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM14DTO;

/**
 * ������Ϣҵ���߼��ӿ�
 *
 */
public interface IGSYM14BL extends BaseBL {
	
	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileDefinitionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * ������Ϣ�ǼǴ���
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO insertReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * ������Ϣ�����ʼ��
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO initReportFileDefinitionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * ������Ϣ���
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGSYM14DTO editReportFileDefinitionAction(IGSYM14DTO dto) throws BLException, FileNotFoundException, IOException;
	
	/**
	 * ������Ϣɾ������
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO deleteReportFileDefinitionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * ����汾��������
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO insertReportFileVersionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * ����汾��Ϣ��ѯ����
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO searchReportFileVersionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * ָ����ǰ�汾����
	 *
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 */
	public IGSYM14DTO assignCurrentReportFileVersionAction(IGSYM14DTO dto) throws BLException;
	
	/**
	 * ȡ�ñ�����ʾ����
	 * 
	 * @param dto IGSYM14DTO
	 * @return IGSYM14DTO
	 * @throws BLException
	 */
	
	public IGSYM14DTO getReportTitle(IGSYM14DTO dto) throws BLException;
	
	/**
	 * ȡ�ö�����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO getObjectName(IGSYM14DTO dto) throws BLException;

	/**
	 * ��ȡ��������
	 * @return
	 * @throws BLException
	 */
	public IGSYM14DTO searchPrtypeAndRfdFilenameList(IGSYM14DTO dto) throws BLException;
}
