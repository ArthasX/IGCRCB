/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;


/**
 * @�������������յ��Զ����ѯ
 * @�����ߣ� hujuwen
 * @����ʱ�䣺2014/07/22
 * 
 * @Version V1.0
 */
public interface IGASM2714ExcelBL extends ExcelBaseBL{
	
	/**
	 * ���յ��Զ����ѯ
	 * 
	 * @rerturn dto
	 */
	public IGASM27DTO searchRiskPointManagerAction(IGASM27DTO dto)
			throws BLException;

}
