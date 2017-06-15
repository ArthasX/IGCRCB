/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: 风险评估年度统计管理导出实现
 * 功能描述: 风险评估年度统计管理导出实现
 * 创建记录: 2013/06/27
 * 修改记录:
 */
public class IGRAM0401ExcelBLImpl extends ExcelBaseBLImpl implements
IGRAM0401ExcelBL{

	public ExcelDTO initBody(ExcelDTO exceldto) throws BLException {
		
		IGRAM0401ExcelDTO dto = (IGRAM0401ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(1);
		// 表单数据内容取得
		List<String> list = dto.getYearReport();
		
		addCell(0, 0, "年度："+dto.getCurrentyear()+"年");// 评估日期
		int j = 2;
		for(int i=0,col=0;i<list.size();i++){
			addCell(col,j,list.get(i));
			//判断换行
			if(col!=0&&col%12==0){ 
				j++;
				col=0;
				}else{
					//移动列号
					col++;
				}
		}
		
		return exceldto;
	}

	public ExcelDTO initFooter(ExcelDTO exceldto) throws BLException {
		return exceldto;
	}

	public ExcelDTO initHeader(ExcelDTO exceldto) throws BLException {				
		replaceCellContent("title", "年度评估统计");		
		return exceldto;
	}
	
	/**
	 * 写入单元格内容
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
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
	 * 设置行高
	 * @param rowNum 行编号
	 * @param rowHeight 行宽度
	 */
	public void setRowHeight(int rowNum,int rowHeight) throws BLException{
		try {
			excelDTO.getWritableSheet().setRowView(excelDTO.getStartRow()+rowNum, rowHeight);
		} catch (RowsExceededException e) {
			throw new BLException();
		}
	}
}
