/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC30DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������񵼳�BL�ӿ�
 * </p>
 * 
 * @author zhangxinru
 * @version 1.0
 */
public interface IGCRC30BL extends BaseBL{

	/**
	 * ��������������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC30DTO getExcelDataList(IGCRC30DTO dto) throws BLException ;
}
