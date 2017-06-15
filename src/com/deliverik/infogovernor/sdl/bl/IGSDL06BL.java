/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL06DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_���KPIͳ��ҵ���߼��ӿ�
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */
public interface IGSDL06BL extends BaseBL {


	/**
	 * ���KPIͳ�Ʋ�ѯ����
	 *
	 * @param dto IGSDL06DTO
	 * @return IGSDL06DTO
	 */
	public IGSDL06DTO searchChangeKpiAction(IGSDL06DTO dto) throws BLException;
		
}
	
