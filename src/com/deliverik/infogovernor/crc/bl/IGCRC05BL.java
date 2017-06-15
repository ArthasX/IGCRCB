/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC05DTO;

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
public interface IGCRC05BL extends BaseBL{

	/**
	 * ���̲�ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO searchProcessRecords(IGCRC03DTO dto) throws BLException;

	/**
	 * �����������ҳ���ʼ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO initIGCRC0402Action(IGCRC03DTO dto) throws BLException;

	/**
	 * ��������������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO disposeAction(IGCRC03DTO dto) throws BLException;

	/**
	 * ��ʼ������ҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO initAssignPageAction(IGCRC03DTO dto) throws BLException;

	/**
	 * �������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO assignAction(IGCRC03DTO dto) throws BLException;

	/**
	 * ��ȡ���̱������ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	//public IGCRC03DTO getPivarQueryInfoAction(IGCRC03DTO dto) throws BLException;
	
	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC05DTO getExcelDataList(IGCRC05DTO dto) throws BLException ;
}
