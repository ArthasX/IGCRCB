/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.CellFormat;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.utility.ResourceUtility;



/**
 * 概述: Excel导出通用业务BL实现
 * 功能描述: Excel导出通用业务BL实现
 * 创建记录:
 * 修改记录: 
 */
public abstract class ExcelBaseBLImpl extends BaseBLImpl implements ExcelBaseBL {
	
	/** 模版路径 */
	protected final static String EXCEL_FILE_ROOT_PATH = ResourceUtility
            .getString("EXCEL_FILE_ROOT_PATH");
	
	/** 基础数据BL */
	protected CodeDetailBL codeDetailBL;
	
	/** Excel导出通用DTO */
	protected ExcelDTO excelDTO;
	
	/**
	 * 基础数据BL设定
	 * 
	 * @param codeDetailBL 基础数据BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * Excel导出通用DTO取得
	 * 
	 */
	public ExcelDTO getExcelDTO() {
		return excelDTO;
	}

	/**
	 * Excel导出通用DTO设定
	 * 
	 * @param excelDTO Excel导出通用DTO
	 */
	public void setExcelDTO(ExcelDTO excelDTO) {
		this.excelDTO = excelDTO;
	}

	/**
	 * 初始化Excel内容
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException {
	
		setExcelDTO(dto);
		
		//定义可写模版
		WritableWorkbook writableWorkbook = null;
		try {
			//获取模版
			Workbook template = getTemplate(dto);
			
			//设定模版Sheet页
			dto.setTemplateSheet(template.getSheet(0));
			
			//设定导出报表的文件类型及文件名
			HttpServletResponse response = dto.getResponse();
			response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String(dto.getDisplayName().getBytes("gb2312"), "ISO8859-1"));
            
            WorkbookSettings settings = new WorkbookSettings();
                             
            settings.setEncoding("utf-8");  
            
            //创建可写模版
			writableWorkbook = Workbook.createWorkbook(response.getOutputStream(), template, settings);
		
			//设定可写Sheet页
			dto.setWritableSheet(writableWorkbook.getSheet(0));
			
			// 设定可写模板
			dto.setWritableWorkbook(writableWorkbook);
			
			//初始化Excel表头
			initHeader(dto);
			
			//初始化Excel表主体
			initBody(dto);
			
			//初始化Excel表底部
			initFooter(dto);
			
		} catch (Exception e) {
			//IGRPT0000.E003=（{0}）生成Excel时发生错误。
			e.printStackTrace();
			throw new BLException("IGRPT0000.E003", dto.getFileid());
		} finally {
			try {
				if(writableWorkbook != null) {
					writableWorkbook.write();
					writableWorkbook.close();
				}
				if(dto.getResponse().getOutputStream() != null) {
					dto.getResponse().getOutputStream().close();
				}
			} catch (Exception e) {
				//IGRPT0000.E003=（{0}）生成Excel时发生错误。
				throw new BLException("IGRPT0000.E003", dto.getFileid());
			}
		}
		return dto;
	}
	
	/**
	 * 模板取得
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException 
	 */
	protected Workbook getTemplate(ExcelDTO dto) throws BLException {
		CodeDetail cd =	codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK(ResourceUtility.getString("EXCEL_CATAGORY_CCID"), dto.getFileid()));
		Workbook template = null;
		try {
			File file = new File(EXCEL_FILE_ROOT_PATH, cd.getCvalue() + ".xls"); 	
			template = Workbook.getWorkbook(new FileInputStream(file));
			dto.setDisplayName(cd.getCdinfo() + ".xls");
		} catch (Exception e) {
			//IGRPT0000.E001={0}模版不存在。
			e.printStackTrace();
			throw new BLException("IGRPT0000.E001", dto.getFileid());
		}
		return template;
	}
	
	/**
	 * 根据指定内容获取单元格
	 * 
	 * @param sheet页
	 * @param value 搜索值
	 * @return 单元格集合
	 */
	protected static ArrayList<Cell> searchCellContent(WritableSheet ws, String value) {
		ArrayList<Cell> lst_cell = null;
		if (StringUtils.isNotEmpty(value)) {
			lst_cell = new ArrayList<Cell>();
			int numCol = ws.getColumns();
			int numRows = ws.getRows();
			for (int i = 0; i < numCol; i++) {
				for (int j = 0; j < numRows; j++) {
					Cell cell = ws.getCell(i, j);
					String content = cell.getContents();
					if (value.equals(content)) {
						lst_cell.add(cell);
					}
				}
			}
		}
		return lst_cell;
	}
	
	/**
	 * 替换单元格内容
	 * 
	 * @param sheet页
	 * @param value 搜索值
	 * @param newValue	替换值
	 */
	protected void replaceCellContent(String value,
			String newValue) throws BLException {
		
		try {
			ArrayList<Cell> lst_cell = searchCellContent(excelDTO.getWritableSheet(), value);
			Cell cell = null;
			CellFormat format = null;
			Label label = null;
			int col = 0;
			int row = 0;
			for(Iterator<Cell> iter = lst_cell.iterator(); iter.hasNext();) {
				cell = iter.next();
				format = cell.getCellFormat();
				col = cell.getColumn();
				row = cell.getRow();
				label = new Label(col, row, newValue, format);
				excelDTO.getWritableSheet().addCell(label);
			}
		} catch (Exception e) {
			//IGRPT0000.E002=（{0}）替换（{1}）时发生异常。
			throw new BLException("IGRPT0000.E002", value, newValue);
		}
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
	 * 写入单元格内容重复列样式
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
	 */
	protected void addCell(int pColumn, int pRow, String pValue,int styleColnum) 
				throws BLException{
		
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
	    WritableSheet wsheet = excelDTO.getWritableSheet();
	    wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    
		Cell cell = wsheetTemplate.getCell(pColumn>styleColnum?styleColnum:pColumn, excelDTO.getStartRow());
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
	 * 写入单元格内容
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
	 */
	protected void addCell(int pColumn, int pRow, int pValue) 
				throws BLException{
		
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
	    WritableSheet wsheet = excelDTO.getWritableSheet();
	    wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    
		Cell cell = wsheetTemplate.getCell(pColumn, excelDTO.getStartRow());
		CellFormat format = cell.getCellFormat();
		jxl.write.Number number = new jxl.write.Number(pColumn,pRow + excelDTO.getStartRow(),pValue,format);

		try {
			wsheet.addCell(number);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}
	
	/**
	 * 写入单元格内容
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
	 */
	protected void addCell(int pColumn, int pRow, double pValue) 
				throws BLException{
		
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
	    WritableSheet wsheet = excelDTO.getWritableSheet();
	    wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    
		Cell cell = wsheetTemplate.getCell(pColumn, excelDTO.getStartRow());
		CellFormat format = cell.getCellFormat();
		jxl.write.Number number = new jxl.write.Number(pColumn,pRow + excelDTO.getStartRow(),pValue,format);

		try {
			wsheet.addCell(number);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}
	
	/**
	 * 写入单元格内容重复列样式
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
	 */
	protected void addCell(int pColumn, int pRow, int pValue,int styleColnum) 
				throws BLException{
		
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
	    WritableSheet wsheet = excelDTO.getWritableSheet();
	    wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    
		Cell cell = wsheetTemplate.getCell(pColumn>styleColnum?styleColnum:pColumn, excelDTO.getStartRow());
		CellFormat format = cell.getCellFormat();
		jxl.write.Number number = new jxl.write.Number(pColumn,pRow + excelDTO.getStartRow(),pValue,format);

		try {
			wsheet.addCell(number);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}

	/**
	 * 写入单元格内容重复列样式
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
	 */
	protected void addCell(int pColumn, int pRow, double pValue,int styleColnum) 
				throws BLException{
		
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
	    WritableSheet wsheet = excelDTO.getWritableSheet();
	    wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    
		Cell cell = wsheetTemplate.getCell(pColumn>styleColnum?styleColnum:pColumn, excelDTO.getStartRow());
		CellFormat format = cell.getCellFormat();
		jxl.write.Number number = new jxl.write.Number(pColumn,pRow + excelDTO.getStartRow(),pValue,format);

		try {
			wsheet.addCell(number);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}
	
	/**
	 * 写入单元格内容
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
	 */
	@SuppressWarnings("unused")
	protected void addCell(int pColumn, int pRow) throws BLException{
		
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
	    WritableSheet wsheet = excelDTO.getWritableSheet();
	    wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
	    
		Cell cell = wsheetTemplate.getCell(pColumn, excelDTO.getStartRow());
		CellFormat format = cell.getCellFormat();
		jxl.write.Number number = new jxl.write.Number(pColumn,pRow + excelDTO.getStartRow(),new Integer(""),format);

		try {
			wsheet.addCell(null);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}


}

