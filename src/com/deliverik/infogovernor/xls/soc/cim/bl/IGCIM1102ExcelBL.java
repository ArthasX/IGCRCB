/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.soc.cim.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBL;
import com.deliverik.framework.base.ExcelDTO;

/**
 * 
 * ����: �ʲ��Զ��屨��ҵ���߼��ӿ�
 * ��������: �ʲ��Զ��屨��ҵ���߼��ӿ�
 * ������¼: 2013/12/27
 * �޸ļ�¼:
 */
public interface IGCIM1102ExcelBL extends ExcelBaseBL{
	
	/**
	 * ��ʼ��Excel
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException;
	
}
