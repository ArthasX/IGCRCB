/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ʽ����������������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public abstract class BaseFormatFactory implements FormatFactory{
	
	/**
	 * ���ñ߿�
	 */
	protected void setBorder(CellFormat format) throws WriteException{
		if(format instanceof WritableCellFormat){
			WritableCellFormat _format = (WritableCellFormat) format;
			_format.setBorder(Border.ALL, BorderLineStyle.THIN);
		}
	}
}
