/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC14DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������̲�ѯBL�ӿ�
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
public interface IGCRC14BL extends BaseBL{

	/**
	 * ��ѯ�������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO searchEntityItemAction(IGCRC14DTO dto) throws BLException;
	
	/**
	 * ����PDID��ȡ���õ�����PDID
	 */
	public IGCRC14DTO searchPdid7BitAction(IGCRC14DTO dto) throws BLException;
	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO getExcelDataList(IGCRC14DTO dto) throws BLException;
}
