/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.util.excel;

import jxl.format.CellFormat;
import jxl.write.WriteException;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Format����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface FormatFactory {

	/**
	 * ȡ�ø�ʽ������
	 * @return ��ʽ������
	 */
	public CellFormat getFormat() throws WriteException;
}
