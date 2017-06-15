/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ݸ�ʽ������������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ContentFormat extends BaseFormatFactory{

	/**
	 * ȡ�ø�ʽ������
	 * @return ��ʽ������
	 */
	public CellFormat getFormat() throws WriteException{
		//ʵ�����������
		WritableFont font = new WritableFont(WritableFont.ARIAL,12,WritableFont.NO_BOLD);
		//ʵ������ʽ������
		WritableCellFormat format = new WritableCellFormat(font);
		//��������ˮƽ����
		format.setAlignment(Alignment.LEFT);
		//�������ִ�ֱ����
		format.setVerticalAlignment(VerticalAlignment.CENTRE);
		//���������Զ�����
		format.setWrap(true);
		//���ñ߿�
		setBorder(format);
		return format;
	}
}
