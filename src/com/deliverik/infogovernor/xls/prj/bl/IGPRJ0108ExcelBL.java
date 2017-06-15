package com.deliverik.infogovernor.xls.prj.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0108ExcelDTO;

public interface IGPRJ0108ExcelBL  extends ExcelBaseBL {

	/**
	 * ��ʼ��Excel���ݲ�����Zip����
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcelToDownZip(IGPRJ0108ExcelDTO dto) throws BLException;

}
