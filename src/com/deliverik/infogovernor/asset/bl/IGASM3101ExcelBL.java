/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;


/**
 * @��������������ָ���Զ����ѯ
 * @�����ߣ� hujuwen
 * @����ʱ�䣺2014/07/26
 * 
 * @Version V1.0
 */
public interface IGASM3101ExcelBL extends ExcelBaseBL{
	
	/**
	 * ����ָ���Զ����ѯ
	 * 
	 * @rerturn dto
	 */
	public IGASM31DTO searchRiskPointManagerAction(IGASM31DTO dto)
			throws BLException;

}
