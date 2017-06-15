/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGCRC04BL extends BaseBL{

	/**
	 * ���̲�ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO searchProcessRecords(IGCRC04DTO dto) throws BLException;

	/**
	 * �����������ҳ���ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initIGCRC0402Action(IGCRC04DTO dto) throws BLException;

	/**
	 * ��������������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO disposeAction(IGCRC04DTO dto) throws BLException;

	/**
	 * ��ʼ������ҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initAssignPageAction(IGCRC04DTO dto) throws BLException;

	/**
	 * �������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO assignAction(IGCRC04DTO dto) throws BLException;
	/**
	 * ��鹤������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO assignWorkAction(IGCRC04DTO dto) throws BLException;
	/**
	 * ��ȡ���̱������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getPivarQueryInfoAction(IGCRC04DTO dto) throws BLException;
	
	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getExcelDataList(IGCRC04DTO dto) throws BLException ;

	/**
	 * ȡ����������Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getParentProcessInfoAction(IGCRC04DTO dto) throws BLException;

	/**
	 * ȡ����־����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getRecordLogAttachmentAction(IGCRC04DTO dto) throws BLException;
	
	public IGCRC04DTO assignSecureAction(IGCRC04DTO dto) throws BLException;
}
