/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC03DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������BL�ӿ�
 * </p>
 * 
 * @author ʷ����
 * @version 1.0
 */
public interface IGCRC03BL extends BaseBL{


	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC03DTO getExcelDataList(IGCRC03DTO dto) throws BLException ;
}
