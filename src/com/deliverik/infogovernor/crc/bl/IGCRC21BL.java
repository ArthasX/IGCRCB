/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;


/**	
 * ����:��Ա������ѯcontrolBL�ӿ�
 * ����������1.��ѯ��Ա������Ϣ�б�	
 * ������¼��yukexin    2014-8-7 09:28:50
 *         	
 */
public interface IGCRC21BL {
	/**	
	 * ���ܣ���Ա������Ϣ��ѯ����
	 * @param dto
	 * @return ��Ա������Ϣdto
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGCRC2101DTO searchEntityItemAction(IGCRC2101DTO dto) throws BLException;
	
	/**	
	 * ���ܣ���ѯ���������б�
	 * @param dto
	 * @return IGCRC2101DTO
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGCRC2101DTO searchDepartmentBeanList(IGCRC2101DTO dto) throws BLException;
	
}
