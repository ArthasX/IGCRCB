/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 格式化对象生成器基类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public abstract class BaseFormatFactory implements FormatFactory{
	
	/**
	 * 设置边框
	 */
	protected void setBorder(CellFormat format) throws WriteException{
		if(format instanceof WritableCellFormat){
			WritableCellFormat _format = (WritableCellFormat) format;
			_format.setBorder(Border.ALL, BorderLineStyle.THIN);
		}
	}
}
