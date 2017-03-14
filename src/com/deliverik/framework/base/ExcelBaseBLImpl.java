/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: Excel����ͨ��ҵ��BLʵ��
 * ��������: Excel����ͨ��ҵ��BLʵ��
 * ������¼:
 * �޸ļ�¼: 
 */
public abstract class ExcelBaseBLImpl extends BaseBLImpl implements ExcelBaseBL {
	
	/** ģ��·�� */
	protected final static String EXCEL_FILE_ROOT_PATH = ResourceUtility
            .getString("EXCEL_FILE_ROOT_PATH");
	
	/** ��������BL */
	protected CodeDetailBL codeDetailBL;
	
	/** Excel����ͨ��DTO */
	protected ExcelDTO excelDTO;
	
	/**
	 * ��������BL�趨
	 * 
	 * @param codeDetailBL ��������BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * Excel����ͨ��DTOȡ��
	 * 
	 */
	public ExcelDTO getExcelDTO() {
		return excelDTO;
	}

	/**
	 * Excel����ͨ��DTO�趨
	 * 
	 * @param excelDTO Excel����ͨ��DTO
	 */
	public void setExcelDTO(ExcelDTO excelDTO) {
		this.excelDTO = excelDTO;
	}

	/**
	 * ��ʼ��Excel����
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException {
	
		setExcelDTO(dto);
		
		//�����дģ��
		WritableWorkbook writableWorkbook = null;
		try {
			//��ȡģ��
			Workbook template = getTemplate(dto);
			
			//�趨ģ��Sheetҳ
			dto.setTemplateSheet(template.getSheet(0));
			
			//�趨����������ļ����ͼ��ļ���
			HttpServletResponse response = dto.getResponse();
			response.reset();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String(dto.getDisplayName().getBytes("gb2312"), "ISO8859-1"));
            
            WorkbookSettings settings = new WorkbookSettings();
                             
            settings.setEncoding("utf-8");  
            
            //������дģ��
			writableWorkbook = Workbook.createWorkbook(response.getOutputStream(), template, settings);
		
			//�趨��дSheetҳ
			dto.setWritableSheet(writableWorkbook.getSheet(0));
			
			// �趨��дģ��
			dto.setWritableWorkbook(writableWorkbook);
			
			//��ʼ��Excel��ͷ
			initHeader(dto);
			
			//��ʼ��Excel������
			initBody(dto);
			
			//��ʼ��Excel��ײ�
			initFooter(dto);
			
		} catch (Exception e) {
			//IGRPT0000.E003=��{0}������Excelʱ��������
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
				//IGRPT0000.E003=��{0}������Excelʱ��������
				throw new BLException("IGRPT0000.E003", dto.getFileid());
			}
		}
		return dto;
	}
	
	/**
	 * ģ��ȡ��
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
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
			//IGRPT0000.E001={0}ģ�治���ڡ�
			e.printStackTrace();
			throw new BLException("IGRPT0000.E001", dto.getFileid());
		}
		return template;
	}
	
	/**
	 * ����ָ�����ݻ�ȡ��Ԫ��
	 * 
	 * @param sheetҳ
	 * @param value ����ֵ
	 * @return ��Ԫ�񼯺�
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
	 * �滻��Ԫ������
	 * 
	 * @param sheetҳ
	 * @param value ����ֵ
	 * @param newValue	�滻ֵ
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
			//IGRPT0000.E002=��{0}���滻��{1}��ʱ�����쳣��
			throw new BLException("IGRPT0000.E002", value, newValue);
		}
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
	 * д�뵥Ԫ�������ظ�����ʽ
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
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
	 * д�뵥Ԫ������
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
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
	 * д�뵥Ԫ������
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
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
	 * д�뵥Ԫ�������ظ�����ʽ
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
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
	 * д�뵥Ԫ�������ظ�����ʽ
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
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
	 * д�뵥Ԫ������
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
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

