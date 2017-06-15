/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.bl;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
/**
 * ���ܣ��澯�¼���ѯ����
 * 
 * ���ڣ�2016/10/14
 * 
 * gongyunpeng
 *
 */
public interface IGCRC02041ExcelBL extends BaseBL{
	
	/**
	 * ����excel
	 * @param dto
	 * @return
	 * @throws BLException
	 */
    public String generatedFile(IGCRC02ExcelDTO dto)throws BLException;
    
    /**
	 * �ļ�����
	 * @param fileName �ļ�����
	 * @param response ��Ӧ����
	 */
	public void downloadFile(String fileName, HttpServletResponse response) throws BLException;
}
