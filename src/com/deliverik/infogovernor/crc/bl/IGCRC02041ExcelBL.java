/*	
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。	
 */
package com.deliverik.infogovernor.crc.bl;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
/**
 * 功能：告警事件查询导出
 * 
 * 日期：2016/10/14
 * 
 * gongyunpeng
 *
 */
public interface IGCRC02041ExcelBL extends BaseBL{
	
	/**
	 * 生成excel
	 * @param dto
	 * @return
	 * @throws BLException
	 */
    public String generatedFile(IGCRC02ExcelDTO dto)throws BLException;
    
    /**
	 * 文件下载
	 * @param fileName 文件名称
	 * @param response 响应对象
	 */
	public void downloadFile(String fileName, HttpServletResponse response) throws BLException;
}
