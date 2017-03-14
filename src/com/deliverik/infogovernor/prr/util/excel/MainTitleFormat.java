/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ܱ����ʽ������������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class MainTitleFormat extends BaseFormatFactory{

	/**
	 * ȡ�ø�ʽ������
	 * @return ��ʽ������
	 */
	public CellFormat getFormat() throws WriteException{
		//ʵ�����������
		WritableFont font = new WritableFont(WritableFont.ARIAL,20,WritableFont.BOLD);
		//ʵ������ʽ������
		WritableCellFormat format = new WritableCellFormat(font);
		//�������־���
		format.setAlignment(Alignment.CENTRE);
		//���������Զ�����
		format.setWrap(true);
		//���ñ߿�
		setBorder(format);
		return format;
	}
}
