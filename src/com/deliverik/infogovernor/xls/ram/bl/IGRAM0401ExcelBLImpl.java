/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.xls.ram.bl;

import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.xls.ram.dto.IGRAM0401ExcelDTO;

/**
 * 
 * ����: �����������ͳ�ƹ�����ʵ��
 * ��������: �����������ͳ�ƹ�����ʵ��
 * ������¼: 2013/06/27
 * �޸ļ�¼:
 */
public class IGRAM0401ExcelBLImpl extends ExcelBaseBLImpl implements
IGRAM0401ExcelBL{

	public ExcelDTO initBody(ExcelDTO exceldto) throws BLException {
		
		IGRAM0401ExcelDTO dto = (IGRAM0401ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(1);
		// ����������ȡ��
		List<String> list = dto.getYearReport();
		
		addCell(0, 0, "��ȣ�"+dto.getCurrentyear()+"��");// ��������
		int j = 2;
		for(int i=0,col=0;i<list.size();i++){
			addCell(col,j,list.get(i));
			//�жϻ���
			if(col!=0&&col%12==0){ 
				j++;
				col=0;
				}else{
					//�ƶ��к�
					col++;
				}
		}
		
		return exceldto;
	}

	public ExcelDTO initFooter(ExcelDTO exceldto) throws BLException {
		return exceldto;
	}

	public ExcelDTO initHeader(ExcelDTO exceldto) throws BLException {				
		replaceCellContent("title", "�������ͳ��");		
		return exceldto;
	}
	
	/**
	 * д�뵥Ԫ������
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
	 */
	protected void addCell(int pColumn, int pRow, String pValue) 
				throws BLException{
		
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
	    WritableSheet wsheet = excelDTO.getWritableSheet();
	    wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    
		Cell cell = wsheetTemplate.getCell(pColumn, excelDTO.getStartRow());
		CellFormat format = cell.getCellFormat();
		Label label = new Label(pColumn, pRow + excelDTO.getStartRow(), pValue, format);
		try {			
			wsheet.addCell(label);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}
	
	
	/**
	 * �����и�
	 * @param rowNum �б��
	 * @param rowHeight �п��
	 */
	public void setRowHeight(int rowNum,int rowHeight) throws BLException{
		try {
			excelDTO.getWritableSheet().setRowView(excelDTO.getStartRow()+rowNum, rowHeight);
		} catch (RowsExceededException e) {
			throw new BLException();
		}
	}
}
