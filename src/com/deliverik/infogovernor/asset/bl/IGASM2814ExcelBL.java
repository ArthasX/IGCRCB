/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM28DTO;


/**
 * @����������������Զ����ѯ
 * @�����ߣ� hujuwen
 * @����ʱ�䣺2014/07/23
 * 
 * @Version V1.0
 */
public interface IGASM2814ExcelBL extends ExcelBaseBL{
	
	/**
	 * ������Զ����ѯ
	 * 
	 * @rerturn dto
	 */
	public IGASM28DTO searchCheckItemListAction(IGASM28DTO dto)
			throws BLException;

}
