/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.svc.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.xls.svc.dto.IGSVC0642ExcelDTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������ͳ��Excel����BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSVC0642ExcelBLImpl extends ExcelBaseBLImpl implements IGSVC0642ExcelBL{

	public ExcelDTO initBody(ExcelDTO excelDTO) throws BLException {
		IGSVC0642ExcelDTO dto = (IGSVC0642ExcelDTO) excelDTO;
		dto.setStartRow(2);
		addCell(0, 0, "δ�ر�");
		addCell(1, 0,dto.getCountI_E());
		addCell(2, 0,dto.getCountP_E());
		addCell(3, 0,dto.getCountC_E());
		addCell(0, 1, "�ѹر�");
		addCell(1, 1,dto.getCountI_C());
		addCell(2, 1,dto.getCountP_C());
		addCell(3, 1,dto.getCountC_C());
		addCell(0, 2, "�ϼ�");
		addCell(1, 2,dto.getCountI());
		addCell(2, 2,dto.getCountP());
		addCell(3, 2,dto.getCountC());
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO excelDTO) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO excelDTO) throws BLException {
		return null;
	}

}
