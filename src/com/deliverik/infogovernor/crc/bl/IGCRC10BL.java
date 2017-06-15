/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC10DTO;

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
public interface IGCRC10BL extends BaseBL{

	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC10DTO getExcelDataList(IGCRC10DTO dto) throws BLException ;

	/**
	 * ��������Ϣȡ�ò���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC10DTO getParentProcessInfoAction(IGCRC10DTO dto) throws BLException;
}
