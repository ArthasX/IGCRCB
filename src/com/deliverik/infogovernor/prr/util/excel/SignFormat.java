/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.write.WritableCellFormat;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ǹ�ʽ������������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SignFormat extends BaseFormatFactory{

	/**
	 * ȡ�ø�ʽ������
	 * @return ��ʽ������
	 */
	public CellFormat getFormat() throws WriteException{
		//ʵ������ʽ������
		WritableCellFormat format = new WritableCellFormat();
		//���ñ߿�
		setBorder(format);
		//���ñ�����ɫ
		format.setBackground(Colour.PINK);
		return format;
	}
}
