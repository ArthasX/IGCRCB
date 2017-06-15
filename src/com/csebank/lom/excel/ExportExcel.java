package com.csebank.lom.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.common.OrgValueBean;
import com.csebank.common.SysConfigManager;
import com.csebank.lom.bl.IGLOM02BL;
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.AdvanceSummary;
import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.DeptEentertainment;
import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.Eentertainment;
import com.csebank.lom.model.EentertainmentStatistics;
import com.csebank.lom.model.Ginoutstockdetail;
import com.csebank.lom.model.GoodsStock;
import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.Gstock;
import com.csebank.lom.model.Inventory;
import com.csebank.lom.model.InvoiceTj;
import com.csebank.lom.model.PersonLoanDetail;
import com.csebank.lom.model.PersonLoanSummary;
import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.model.SingleGoodsStock;
import com.csebank.lom.model.WorkLunchEatery;
import com.csebank.lom.model.entity.GinoutStockDetailVW;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM05051VO;
import com.csebank.lom.vo.IGLOM05141VO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;


/**
 * Excel���������࣬ÿ��������Ҫ��дһ����Ӧ��exportIGSVC0621����
 */
public class ExportExcel {
	private static Log log = LogFactory.getLog(ExportExcel.class);
	
	private static final String NULL_STR = "-";


	
	/**
	 * ����ָ���ı��滻��Ԫ������
	 * 
	 * @param ws sheetҳ
	 * @param value ����ֵ
	 * @param newValue	�滻ֵ
	 * @return
	 */
	private static boolean setCellByContents(WritableSheet ws, String value,
			String newValue) {
		try {
			ArrayList<Cell> cellList = getCellByValue(ws, value);
			Cell cell = null;
			Iterator<Cell> cellIt = cellList.iterator();
			while (cellIt.hasNext()) {
				cell = (Cell) cellIt.next();
				if (cell != null) {
					CellFormat format = cell.getCellFormat();
					//WritableCellFormat wcf = new WritableCellFormat(format);
					int col = cell.getColumn();
					int row = cell.getRow();
					Label label = new Label(col, row, newValue, format);
					ws.addCell(label);
				}
			}
			return true;
		} catch (RowsExceededException e) {
			log.debug(e);
			return false;
		} catch (WriteException e) {
			log.debug(e);
			return false;
		}
	}

	/**
	 * ����ָ�����ݻ�ȡ��Ԫ��
	 * 
	 * @param ws sheetҳ
	 * @param value ����ֵ
	 * @return
	 */
	private static ArrayList<Cell> getCellByValue(WritableSheet ws, String value) {
		ArrayList<Cell> cellList = new ArrayList<Cell>();
		if (StringUtils.isNotEmpty(value)) {
			int numCol = ws.getColumns();
			int numRows = ws.getRows();
			for (int i = 0; i < numCol; i++) {
				for (int j = 0; j < numRows; j++) {
					Cell cell = ws.getCell(i, j);
					String content = cell.getContents();
					if (value.equals(content)) {
						cellList.add(cell);
					}
				}
			}
		}
		return cellList;
	}

	/**
	 * ��ȡģ��
	 * 
	 * @param filename
	 * @return
	 */
	private static Workbook getTemplate(String filename) {
		//String path = ExportExcel.class.getResource("/").getPath();
		String rootPath = ResourceUtility.getString("EXCEL_FILE_ROOT_PATH");
//		log.debug("----------------"+path);
//		if (path != null && path.indexOf("WEB-INF") != -1) {
//			path = path.substring(1, path.indexOf("WEB-INF"));
//		} 
		String templatePath = rootPath + filename;
		Workbook template = null;
		
		//log.debug("----------------"+templatePath);

		try {
			template = Workbook.getWorkbook(new FileInputStream(templatePath));
		} catch (BiffException e) {
			log.debug(e);
		} catch (FileNotFoundException e) {
			log.debug(e);
		} catch (IOException e) {
			log.debug(e);
		}
		return template;

	}
	
	
	/**
	 * ��������
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportLOM0215(OutputStream os,
			List<GinoutStockDetailVW> dataList, String category) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGLOM0215.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�������ܱ�");
		String strCategory = "ȫ������";
		if(StringUtils.isNotEmpty(category)){
			strCategory = SysConfigManager.getConfigInfo(CodeUtils.GOODS_CATEGORY + "_" + category);
		}
		setCellByContents(wsheet, "category", strCategory);
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			//Cell cell6 = wsheetTemplate.getCell(6, startrow);
			//CellFormat format6 = cell6.getCellFormat();
			IGLOM02BL ctrlBL = (IGLOM02BL) WebApplicationSupport.getBean("iglom02BL");
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				GinoutStockDetailVW data = dataList.get(j);
				
				Label label0 = new Label(0, j + startrow, String.valueOf((j+1)) ,format0);
				wsheet.addCell(label0);
				
//				String gcategory = SysConfigManager.getConfigInfo(CodeUtils.GOODS_CATEGORY + "_" + data.getGiodcategory());
				String gcategory = ctrlBL.getCodeValue(data.getGiodcategory());
				Label label1 = new Label(1, j + startrow, gcategory ,format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getGiodname(),format2);
				wsheet.addCell(label2);
                			
				Label label3 = new Label(3, j + startrow,data.getGiodunit() , format3);
				wsheet.addCell(label3);				

				Label label4 = new Label(4, j + startrow,String.valueOf(data.getGiodinnum()), format4);
				wsheet.addCell(label4);
				
				String outStockNum = new BigDecimal(data.getGiodreliefnum()==null ? "0": data.getGiodreliefnum()).add(
									 new BigDecimal(String.valueOf(data.getGiodoutnum()==null ? "0": data.getGiodoutnum())).add(
									 new BigDecimal(String.valueOf(data.getGiodhavocnum()==null ? "0": data.getGiodhavocnum())))).toString();		 

				Label label5 = new Label(5, j + startrow,outStockNum, format5);
				wsheet.addCell(label5);
				
				//Integer stockNum = data.getGiodinnum() - data.getGiodreliefnum() - data.getGiodoutnum() - data.getGiodhavocnum();
				//Label label6 = new Label(6, j + startrow,String.valueOf(stockNum), format6);
				//wsheet.addCell(label6);
			}		
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * "��һ��Ʒ�������ϸ
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportLOM0216(OutputStream os,
			List<Ginoutstockdetail> dataList, String gname,Integer[] totalStockNum) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGLOM0216.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��һ��Ʒ�������ϸ��");
		setCellByContents(wsheet, "name", gname);
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Ginoutstockdetail data = dataList.get(j);
				
				Label label0 = new Label(0, j + startrow, String.valueOf(j+1) ,format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getGiodtime() ,format1);
				wsheet.addCell(label1);
				
				String outnum = "";
				String innum = "";
				if(IGLOMCONSTANTS.GIODTYPE_RK.equals(data.getGiodtype())){
					innum = String.valueOf(data.getGiodinnum());
				} else {
					outnum = String.valueOf(data.getGiodinnum());
				}
				Label label2 = new Label(2, j + startrow, innum,format2);
				wsheet.addCell(label2);
                
				Label label3 = new Label(3, j + startrow,outnum , format3);
				wsheet.addCell(label3);				

				String giodtype = SysConfigManager.getConfigInfo(CodeUtils.INOUTSTOCK_TYPE + "_" + data.getGiodtype());
				Label label4 = new Label(4, j + startrow,giodtype, format4);
				wsheet.addCell(label4);
				
				String reqorg = OrgValueBean.getConfigInfo(data.getGiodreqorg());
				Label label5 = new Label(5, j + startrow,reqorg, format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow,data.getGiodrequsername(), format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,String.valueOf(totalStockNum[j]), format7);
				wsheet.addCell(label7);
			}		
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ��Ʒ�������ϸ
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportLOM0218(OutputStream os,
			List<Ginoutstockdetail> dataList) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGLOM0218.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 2;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��Ʒ�������ϸ��");
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();		
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Ginoutstockdetail data = dataList.get(j);
				
				String gcategory = SysConfigManager.getConfigInfo(CodeUtils.GOODS_CATEGORY + "_" + data.getGiodcategory());
				Label label0 = new Label(0, j + startrow, gcategory ,format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getGiodname() ,format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getGiodcode() ,format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, data.getGiodtime() ,format3);
				wsheet.addCell(label3);
				
				String outnum = "";
				String innum = "";
				if(IGLOMCONSTANTS.GIODTYPE_RK.equals(data.getGiodtype())){
					innum = String.valueOf(data.getGiodinnum());
				} else {
					outnum = String.valueOf(data.getGiodinnum());
				}
				Label label4 = new Label(4, j + startrow, innum,format4);
				wsheet.addCell(label4);
                
				Label label5 = new Label(5, j + startrow,outnum , format5);
				wsheet.addCell(label5);				

				String giodtype = SysConfigManager.getConfigInfo(CodeUtils.INOUTSTOCK_TYPE + "_" + data.getGiodtype());
				Label label6 = new Label(6, j + startrow,giodtype, format6);
				wsheet.addCell(label6);
				
				String reqorg = OrgValueBean.getConfigInfo(data.getGiodreqorg());
				Label label7 = new Label(7, j + startrow,reqorg, format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,data.getGiodrequsername(), format8);
				wsheet.addCell(label8);
				
			}		
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ���õ�������
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportLOM0219(OutputStream os,
			List<Goutstock> dataList) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGLOM0219.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 2;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���õ���������ϸ��");
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();		
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			IGLOM02BL ctrlBL = (IGLOM02BL) WebApplicationSupport.getBean("iglom02BL");
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Goutstock data = dataList.get(j);
				String category_name = ctrlBL.getCodeValue(data.getGocategory());
				String reqorg = OrgValueBean.getConfigInfo(data.getGoreqorg());
	 			
				Label label0 = new Label(0, j + startrow, String.valueOf(j+1) ,format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, category_name ,format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getGoname() ,format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, data.getGotime() ,format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow, String.valueOf(data.getGoinnum()),format4);
				wsheet.addCell(label4);
                
				Label label5 = new Label(5, j + startrow, reqorg, format5);
				wsheet.addCell(label5);				

				Label label6 = new Label(6, j + startrow, data.getGorequsername(), format6);
				wsheet.addCell(label6);
				
				String gotype = SysConfigManager.getConfigInfo(CodeUtils.INOUTSTOCK_TYPE + "_" + data.getGotype());
				Label label7 = new Label(7, j + startrow, gotype, format7);
				wsheet.addCell(label7);
				
			}		
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Ԥ֧��Աͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0308(OutputStream os,
			List<PersonLoanSummary> dataList, String orgname, String lpddate_from,String lpddate_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0308.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "Ԥ֧��Աͳ�Ʊ���");	
		setCellByContents(wsheet, "orgname", "�������ţ�"+(null != orgname ? orgname:""));
		if(StringUtils.isEmpty(lpddate_from) && StringUtils.isEmpty(lpddate_to)){
			setCellByContents(wsheet, "date", "��ѯ���ڣ�");
		}else{
			setCellByContents(wsheet, "date","��ѯ���ڣ�" +(null!=lpddate_from ?lpddate_from:"") + "��" + (null!=lpddate_to?lpddate_to:""));
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			BigDecimal loanamount = new BigDecimal(0);
			BigDecimal invoiceamount = new BigDecimal(0);
			BigDecimal payamount = new BigDecimal(0);
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				PersonLoanSummary data = (PersonLoanSummary) dataList.get(j);
				//����
				Label label0 = new Label(0, j + startrow, data.getLpduser(),format0);
				wsheet.addCell(label0);
				//����˻���
				Label label1 = new Label(1, j + startrow, data.getOrganizationTB().getOrgname(), format1);
				wsheet.addCell(label1);
				//�����
				Label label2 = new Label(2, j + startrow, data.getLoanamount()+ "", format2);
				wsheet.addCell(label2);
				//���Ʊ���			
				Label label3 = new Label(3, j + startrow, data.getInvoiceamount()+ "", format3);
				wsheet.addCell(label3);
				//�����ֽ���		
				Label label4 = new Label(4, j + startrow, data.getPayamount()+ "", format4);
				wsheet.addCell(label4);
				
				loanamount = LOMHelper.getAdd(loanamount, data.getLoanamount());
				invoiceamount = LOMHelper.getAdd(invoiceamount, data.getInvoiceamount());
				payamount = LOMHelper.getAdd(payamount, data.getPayamount());
			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);
			
			Label label1 = new Label(1, size + startrow, "-",
					format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow, String.valueOf(loanamount), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,String.valueOf(invoiceamount), format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(payamount),
					format4);
			wsheet.addCell(label4);
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ��Ա�����ϸͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0311(OutputStream os,
			List<PersonLoanDetail> dataList, String username, String date_from,String date_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0311.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��Ա�����ϸͳ�Ʊ���");	
		setCellByContents(wsheet, "username", "����ˣ�" + username);	
		if(StringUtils.isEmpty(date_from) && StringUtils.isEmpty(date_to)){
			setCellByContents(wsheet, "date", "��ѯ���ڣ�");
		}else{
			setCellByContents(wsheet, "date","��ѯ���ڣ�" +(null!=date_from ?date_from:"") + "��" + (null!=date_to?date_to:""));
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				PersonLoanDetail data = (PersonLoanDetail) dataList.get(j);
				//��������
				Label label0 = new Label(0, j + startrow, data.getDate(),format0);
				wsheet.addCell(label0);
				String type = "";
				if(StringUtils.isNotEmpty(data.getType())){
					type = SysConfigManager.getConfigInfo(CodeUtils.ADVANCEDETAIL_TYPE + "_" + data.getType());
				}
				//��������
				Label label1 = new Label(1, j + startrow, type, format1);
				wsheet.addCell(label1);
				Label label2 = new Label(2, j + startrow, data.getOrganizationTB().getOrgname(), format2);
				wsheet.addCell(label2);
				//���		
				BigDecimal amount = data.getAmount();
				
				String amount_str = ExportExcel.NULL_STR;
				
				if(amount != null && (amount.doubleValue() > 0 || amount.doubleValue() < 0)) {
					amount_str = amount.doubleValue() + "";
				}		
				Label label3 = new Label(3, j + startrow, amount_str, format3);
				wsheet.addCell(label3);
				//��Ʊ���		
				BigDecimal invoiceamount = data.getInvoiceamount();
				
				String invoiceamount_str = ExportExcel.NULL_STR;
				
				if(invoiceamount != null && invoiceamount.doubleValue() > 0) {
					invoiceamount_str = invoiceamount.doubleValue() + "";
				}
				Label label4 = new Label(4, j + startrow, invoiceamount_str, format4);
				wsheet.addCell(label4);
				//��;	
				Label label5 = new Label(5, j + startrow, data.getComment(), format5);
				wsheet.addCell(label5);
				//״̬		
				String status_str = ExportExcel.NULL_STR;
				
				if(StringUtils.isNotEmpty(data.getStatus())) {
					status_str = data.getStatus();
				}		
				Label label6 = new Label(6, j + startrow, status_str, format6);
				wsheet.addCell(label6);
			}
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * Ԥ֧��ϸͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0317(OutputStream os,
			List<AdvanceDetail> dataList, String date_from,String date_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0317.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "Ԥ֧��ϸͳ�Ʊ���");	
		if(StringUtils.isEmpty(date_from) && StringUtils.isEmpty(date_to)){
			setCellByContents(wsheet, "date", "��ѯ���ڣ�");
		}else{
			setCellByContents(wsheet, "date","��ѯ���ڣ�" +(null!=date_from ?date_from:"") + "��" + (null!=date_to?date_to:""));
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				AdvanceDetail data = (AdvanceDetail) dataList.get(j);
				//��������
				Label label0 = new Label(0, j + startrow, data.getDate(),format0);
				wsheet.addCell(label0);
				String type = "";
				if(StringUtils.isNotEmpty(data.getType())){
					type = SysConfigManager.getConfigInfo(CodeUtils.ADVANCEDETAIL_TYPE + "_" + data.getType());
				}
				//��������
				Label label1 = new Label(1, j + startrow, type, format1);
				wsheet.addCell(label1);
				//��Ա			
				Label label2 = new Label(2, j + startrow, data.getUsername(), format2);
				wsheet.addCell(label2);
				//���		
				BigDecimal amount = data.getAmount();
				
				String amount_str = ExportExcel.NULL_STR;
				
				if(amount != null && (amount.doubleValue() > 0 || amount.doubleValue() < 0)) {
					amount_str = amount.doubleValue() + "";
				}
				
				Label label3 = new Label(3, j + startrow, amount_str, format3);
				wsheet.addCell(label3);
				//��Ʊ���		
				BigDecimal invoiceamount = data.getInvoiceamount();
				
				String invoiceamount_str = ExportExcel.NULL_STR;
				
				if(invoiceamount != null && invoiceamount.doubleValue() > 0) {
					invoiceamount_str = invoiceamount.doubleValue() + "";
				}
				Label label4 = new Label(4, j + startrow, invoiceamount_str, format4);
				wsheet.addCell(label4);
				//�����		
				Label label5 = new Label(5, j + startrow, data.getStockamount() == null ? "0.00":data.getStockamount()+"", format5);
				wsheet.addCell(label5);
				//״̬		
				String status_str = ExportExcel.NULL_STR;
				
				if(StringUtils.isNotEmpty(data.getStatus())) {
					status_str = data.getStatus();
				}
				Label label6 = new Label(6, j + startrow, status_str, format6);
				wsheet.addCell(label6);
			}
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ��������ͳ��
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public static void exportLOM0217(OutputStream os,
			List<Goutstock> dataList,String orgname, String gotime_f,String gotime_t) throws Exception  {
		try{
		Workbook template = ExportExcel.getTemplate("IGLOM0217.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��������ͳ��");
		
		setCellByContents(wsheet, "orgname", "���û�����"+(null != orgname ? orgname:""));
		setCellByContents(wsheet, "date", "��ѯʱ�䣺"+ (null!=gotime_f ? gotime_f:"") + "��" + 
				(null != gotime_t ? gotime_t:""));
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();		
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Goutstock data = dataList.get(j);
				
				Label label0 = new Label(0, j + startrow, String.valueOf(j + 1) ,format0);
				wsheet.addCell(label0);
				
				Label label1 = new Label(1, j + startrow, data.getGotime() ,format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getGoname(),format2);
				wsheet.addCell(label2);
                
				Label label3 = new Label(3, j + startrow,String.valueOf(data.getGoinnum()) , format3);
				wsheet.addCell(label3);				

				Label label4 = new Label(4, j + startrow,String.valueOf(data.getGooutprice()), format4);
				wsheet.addCell(label4);
				
				BigDecimal outprice = data.getGooutprice();
				if(outprice == null){
					outprice = new BigDecimal(0);
				}
				Label label5 = new Label(5, j + startrow,String.valueOf(LOMHelper.getMultiply(data.getGoinnum()+"", outprice+"")), format5);
				wsheet.addCell(label5);
				
				String reqorg = OrgValueBean.getConfigInfo(data.getGoreqorg());
				Label label6 = new Label(6, j + startrow,reqorg, format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,data.getGorequsername(), format7);
				wsheet.addCell(label7);
				
				String rname = "";
				if(data.getRecptionTB() != null){
					rname = data.getRecptionTB().getRname();
				}
				Label label8 = new Label(8, j + startrow,rname, format8);
				wsheet.addCell(label8);
			}		
		}
		wwb.write();
		wwb.close();
		os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ��Ʊ���ղ���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0405(OutputStream os,
			List<InvoiceTj> dataList,String orgname, String opentime_from, String opentime_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0405.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��Ʊ����ͳ�Ʊ���");
		setCellByContents(wsheet, "orgname", "���벿�ţ�"+(null != orgname ? orgname:""));
		if(StringUtils.isEmpty(opentime_from) && StringUtils.isEmpty(opentime_to)){
			setCellByContents(wsheet, "date", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date","��ѯʱ�䣺" +(null!=opentime_from ?opentime_from:"") + "��" + (null!=opentime_to?opentime_to:""));
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			
			
			int sum_Invoicenum = 0;
			BigDecimal sumiamount = new BigDecimal(0);
			BigDecimal sumiamounted = new BigDecimal(0);
			BigDecimal unsumiamounted = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				InvoiceTj data = (InvoiceTj) dataList.get(j);

				Label label0 = new Label(0, j + startrow, String.valueOf(j+1)+"",format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getIreqemp()+ "", format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getInvoicenum()+ "", format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, data.getSumiamount()+ "", format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow, data.getSumiamounted()+ "", format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow, data.getUnsumiamounted()+ "", format5);
				wsheet.addCell(label5);
				sum_Invoicenum=sum_Invoicenum+Integer.valueOf(data.getInvoicenum());
				sumiamount=LOMHelper.getAdd(sumiamount, data.getSumiamount());
				sumiamounted=LOMHelper.getAdd(sumiamounted, data.getSumiamounted());
				unsumiamounted=LOMHelper.getAdd(unsumiamounted, data.getUnsumiamounted());

			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(""), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(sum_Invoicenum), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow, String.valueOf(sumiamount),
					format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(sumiamounted), format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, size + startrow, String.valueOf(unsumiamounted),
					format5);
			wsheet.addCell(label5);
			
			
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ��Ʊ������ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0406(OutputStream os,
			List<InvoiceTj> dataList, String iyear) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0406.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��Ʊ���ͳ�Ʊ���");	
		if(StringUtils.isEmpty(iyear)){
			setCellByContents(wsheet, "date", "��ѯʱ�䣺");
		}else{
			setCellByContents(wsheet, "date","��ѯʱ�䣺" +(null!=iyear ?iyear+"��":""));
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			
			
			
			int sum_Invoicenum = 0;
			BigDecimal sumiamount = new BigDecimal(0);
			BigDecimal sumiamounted = new BigDecimal(0);
			BigDecimal unsumiamounted = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				InvoiceTj data = (InvoiceTj) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getNum(),format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getInvoicenum()+ "", format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getSumiamount()+ "", format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, data.getSumiamounted()+ "", format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow, data.getUnsumiamounted()+ "", format4);
				wsheet.addCell(label4);
				
				
				sum_Invoicenum=sum_Invoicenum+Integer.valueOf(data.getInvoicenum());
				sumiamount=LOMHelper.getAdd(sumiamount, data.getSumiamount());
				sumiamounted=LOMHelper.getAdd(sumiamounted, data.getSumiamounted());
				unsumiamounted=LOMHelper.getAdd(unsumiamounted, data.getUnsumiamounted());

			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_Invoicenum), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(sumiamount), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow, String.valueOf(sumiamounted),
					format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(unsumiamounted), format4);
			wsheet.addCell(label4);
			
			
			
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * Ԥ֧�¶�ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0309(OutputStream os,
			List<AdvanceSummary> dataList, String year) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0309.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "Ԥ֧�¶�ͳ�Ʊ���");	
//		if(StringUtils.isEmpty(year)){
			setCellByContents(wsheet, "date", "��ȣ�" + year);
//		}else{
//			setCellByContents(wsheet, "date","��ѯʱ�䣺" +(null!=opentime_from ?opentime_from:"") + "��" + (null!=opentime_to?opentime_to:""));
//		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			
			
			BigDecimal sum_getAsprebalance = new BigDecimal(0);
			BigDecimal sum_getAsadvancescost = new BigDecimal(0);
			BigDecimal sum_getAsinvoice = new BigDecimal(0);
			BigDecimal sum_getAsloan = new BigDecimal(0);
			BigDecimal sum_getAsbalance = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				AdvanceSummary data = (AdvanceSummary) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getAsyear()+"/"+data.getAsmonth(),format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getAsprebalance()==null?"0.0":data.getAsprebalance()+"", format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getAsadvancescost()==null?"0.0":data.getAsadvancescost()+"", format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, data.getAsinvoice()==null?"0.0":data.getAsinvoice()+"", format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow,data.getAsloan()==null?"0.0":data.getAsloan()+"", format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow, data.getAsbalance()==null?"0.0":data.getAsbalance()+"", format5);
				wsheet.addCell(label5);
				
				sum_getAsprebalance=LOMHelper.getAdd(sum_getAsprebalance, (data.getAsprebalance()==null?new BigDecimal(0):data.getAsprebalance()));
				sum_getAsadvancescost=LOMHelper.getAdd(sum_getAsadvancescost, (data.getAsadvancescost()==null?new BigDecimal(0):data.getAsadvancescost()));
				sum_getAsinvoice=LOMHelper.getAdd(sum_getAsinvoice, (data.getAsinvoice()==null?new BigDecimal(0):data.getAsinvoice()));
				sum_getAsloan=LOMHelper.getAdd(sum_getAsloan, (data.getAsloan()==null?new BigDecimal(0):data.getAsloan()));
				
				sum_getAsbalance=LOMHelper.getAdd(sum_getAsbalance, (data.getAsbalance()==null?new BigDecimal(0):data.getAsbalance()));

			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_getAsprebalance), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(sum_getAsadvancescost), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow, String.valueOf(sum_getAsinvoice),
					format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(sum_getAsloan), format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, size + startrow, String.valueOf(sum_getAsbalance),
					format5);
			wsheet.addCell(label5);
			
			
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * �Ӵ������¶�ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0110(OutputStream os,
			List<RecptionVWInfo> dataList, String iyear) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0110.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�Ӵ������¶�ͳ�Ʊ���");	
//		if(StringUtils.isEmpty(iyear)){
			setCellByContents(wsheet, "year", "��ȣ�" + iyear);
//		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			
			
			
			int sum_Rnum = 0;
			BigDecimal amount = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				RecptionVWInfo data = (RecptionVWInfo) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getMonth(),format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getRnum()+ "", format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getAmount()+ "", format2);
				wsheet.addCell(label2);
				
				
				sum_Rnum=sum_Rnum+Integer.valueOf(data.getRnum());
				amount=LOMHelper.getAdd(amount, data.getAmount());
			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_Rnum), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(amount), format2);
			wsheet.addCell(label2);
					
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ����Ͳ͹����¶�ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0123(OutputStream os,
			List<DealVWInfo> dataList, String iyear) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0123.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "����Ͳ��¶�ͳ�Ʊ���");	
//		if(StringUtils.isEmpty(iyear)){
			setCellByContents(wsheet, "year", "��ȣ�" + iyear);
//		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			
			
			
			int sum_Rnum = 0;
			BigDecimal amount = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				DealVWInfo data = (DealVWInfo) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getMonth(),format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getRnum()+ "", format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getAmount()+ "", format2);
				wsheet.addCell(label2);
				
				
				sum_Rnum=sum_Rnum+Integer.valueOf(data.getRnum());
				amount=LOMHelper.getAdd(amount, data.getAmount());
			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_Rnum), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(amount), format2);
			wsheet.addCell(label2);
					
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ���ŽӴ�����ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0112(OutputStream os,
			List<RecptionOrg> dataList, String iyear, String month_from, String month_to, String rapporgname) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0112.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���ŽӴ�����ͳ�Ʊ���");	
		setCellByContents(wsheet, "rapporgname", "���벿�ţ�"+(null != rapporgname ? rapporgname:""));
		setCellByContents(wsheet, "year", "��/�£�" + iyear + "/" + month_from + " �� " + iyear + "/" + month_to);
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			
			
			
			int sum_Rnum = 0;
			int sum_disnum = 0;
			int sum_ennum = 0;
			BigDecimal amount = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				RecptionOrg data = (RecptionOrg) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getRapporgname()+ "",format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getRnum()+ "", format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getDisnum()+ "", format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, data.getEnnum()+ "", format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow, data.getAmount()+ "", format4);
				wsheet.addCell(label4);
				
				
				sum_Rnum=sum_Rnum+Integer.valueOf(data.getRnum());
				sum_disnum=sum_disnum+Integer.valueOf(data.getDisnum());
				sum_ennum=sum_ennum+Integer.valueOf(data.getEnnum());
				amount=LOMHelper.getAdd(amount, data.getAmount());
			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_Rnum), format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow,String.valueOf(sum_disnum), format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow,String.valueOf(sum_ennum), format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow,String.valueOf(amount), format4);
			wsheet.addCell(label4);
					
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ��������Ͳ͹���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0124(OutputStream os,
			List<DealOrg> dataList, String iyear, String month_from, String month_to, String deptName) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0124.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��������Ͳ�ͳ�Ʊ���");	
		setCellByContents(wsheet, "deptName", "���벿�ţ�"+(null != deptName ? deptName:""));
		setCellByContents(wsheet, "year", "��/�£�" + iyear + "/" + month_from + " �� " + iyear + "/" + month_to);
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			
			
			
			
			int sum_Rnum = 0;
			
			BigDecimal amount = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				DealOrg data = (DealOrg) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getRapporgname()+ "",format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getRnum()+ "", format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, data.getAmount()+ "", format2);
				wsheet.addCell(label2);

				sum_Rnum=sum_Rnum+Integer.valueOf(data.getRnum());
				amount=LOMHelper.getAdd(amount, data.getAmount());
			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_Rnum), format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow,String.valueOf(amount), format2);
			wsheet.addCell(label2);
					
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ʳ�ù������������ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0505(OutputStream os,
			IGLOM05051VO dataList, String opentime_year,
			String opentime_mon, String opentime_quarter) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0505.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "����������ͳ��");
		if (!StringUtils.isEmpty(opentime_year)
				&& !StringUtils.isEmpty(opentime_mon)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_year + "��"
					+ opentime_mon + "��");
		} else if (!StringUtils.isEmpty(opentime_year)
				&& !StringUtils.isEmpty(opentime_quarter)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_year + "���"
					+ opentime_quarter + "����");
		} else if ((!StringUtils.isEmpty(opentime_year) && StringUtils
				.isEmpty(opentime_mon))
				|| (!StringUtils.isEmpty(opentime_year) && StringUtils
						.isEmpty(opentime_quarter))) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_year + "��");
		} else {
			setCellByContents(wsheet, "date", "ȫ��ʱ�䣺");
		}
		
		if(dataList.getMap()!=null && dataList.getMap().size() > 0){
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
//			Cell cell8 = wsheetTemplate.getCell(8, startrow);
//			CellFormat format8 = cell8.getCellFormat();
//			Cell cell9 = wsheetTemplate.getCell(9, startrow);
//			CellFormat format9 = cell9.getCellFormat();
			Map<String,IGLOM05051VO> map = dataList.getMap();
			Set<Map.Entry<String,IGLOM05051VO>> set = map.entrySet();
			int num=0;
			for(Iterator<Map.Entry<String,IGLOM05051VO>> iter = set.iterator();iter.hasNext();){
				Map.Entry<String,IGLOM05051VO> entry = iter.next();
				IGLOM05051VO ivo = (IGLOM05051VO)entry.getValue();
				
				for (int j = 0; j < ivo.getWorkLunchEateryList().size(); j++) {
					WorkLunchEatery data = (WorkLunchEatery) ivo.getWorkLunchEateryList().get(j);
					Label label0 = new Label(0, num + startrow, data.getWldate(), format0);
					wsheet.addCell(label0);
					Label label1 = new Label(1, num + startrow, data.getEstaplecost()+ "", format1);
					wsheet.addCell(label1);
					Label label2 = new Label(2, num + startrow, data.getEflavouringcost()+ "", format2);
					wsheet.addCell(label2);
					Label label3 = new Label(3, num + startrow, data.getEothercost()+ "", format3);
					wsheet.addCell(label3);
					Label label4 = new Label(4, num + startrow, data.getAllcost()+ "", format4);
					wsheet.addCell(label4);
//					Label label5 = new Label(5, num + startrow, data.getLunchcardname()+ "", format5);
//					wsheet.addCell(label5);
//					Label label6 = new Label(6, num + startrow, data.getLunchcardprice()+ "", format6);
//					wsheet.addCell(label6);
					Label label5 = new Label(5, num + startrow, data.getLunchcardnum(), format5);
					wsheet.addCell(label5);
					Label label6 = new Label(6, num + startrow, data.getIncost()+ "", format6);
					wsheet.addCell(label6);
					Label label7 = new Label(7, num + startrow, data.getOutcost()+ "", format7);
					wsheet.addCell(label7);
					num++;
				}
			}
		}

		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ʳ�ù��������������ϸͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0585(OutputStream os,
			List<WorkLunchEatery> dataList, String opentime_year,
			String opentime_mon) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0585.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "������������ϸͳ��");
		setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_year + "��"
				+ opentime_mon + "��");
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			
			// ���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				WorkLunchEatery data = (WorkLunchEatery) dataList.get(j);
				Label label0 = new Label(0, j + startrow, data.getWldate().split("-")[0], format0);
				wsheet.addCell(label0);
				Label label1 = new Label(1, j + startrow, "null".equals(String
						.valueOf(data.getEstaplecost())) ? "0" : String
						.valueOf(data.getEstaplecost()), format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, "null".equals(String
						.valueOf(data.getEflavouringcost())) ? "0" : String
						.valueOf(data.getEflavouringcost())
						+ "", format2);
				wsheet.addCell(label2);

				Label label3 = new Label(3, j + startrow, "null".equals(String
						.valueOf(data.getEothercost())) ? "0" : String
						.valueOf(data.getEothercost()), format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow, "null".equals(String
						.valueOf(data.getAllcost())) ? "0" : String
						.valueOf(data.getAllcost()), format4);
				wsheet.addCell(label4);

				Label label5 = new Label(5, j + startrow, data.getLunchcardname(), format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow, data.getLunchcardprice(), format6);
				wsheet.addCell(label6);

				Label label7 = new Label(7, j + startrow, "null".equals(String
						.valueOf(data.getLunchcardnum())) ? "0" : String
						.valueOf(data.getLunchcardnum()), format7);
				wsheet.addCell(label7);
				BigDecimal cost = new BigDecimal("0");
				cost = new BigDecimal(StringUtils.isEmpty(data.getLunchcardprice()) ? "0" : String
								.valueOf(data.getLunchcardprice())).multiply(new BigDecimal(StringUtils.isEmpty(data.getLunchcardnum()) ? "0" : String
								.valueOf(data.getLunchcardnum())));
				Label label8 = new Label(8, j + startrow, cost.toString(), format8);
				wsheet.addCell(label8);
			}

		}

		wwb.write();
		wwb.close();
		os.close();
	}

	/**
	 * ʳ���д�������ϸ����
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0507(OutputStream os,
			List<Eentertainment> dataList, String opentime_from,
			String opentime_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0509.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�д�ͳ����ϸ");
		if (!StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "��"
					+ opentime_to);
		} else if (!StringUtils.isEmpty(opentime_from)
				&& StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "֮��");
		} else if (StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_to + "֮ǰ");
		} else {
			setCellByContents(wsheet, "date", "ȫ��ʱ�䣺");
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();
			
			//�ϼƱ���
			
			//ÿ���˼۸�
			BigDecimal cprice = new BigDecimal("0");
			//����
			Integer znum = 0;
			//�Ƽ�
			BigDecimal jprice = new BigDecimal("0");
			//�̼�
			BigDecimal yprice = new BigDecimal("0");
			//������Ʒ�۸�
			BigDecimal qtprice = new BigDecimal("0");
			//���úϼ�
			BigDecimal allprice = new BigDecimal("0");
			
			// ���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Eentertainment data = (Eentertainment) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getEedate(),
						format0);
				wsheet.addCell(label0);
				try {
					Label label1 = new Label(1, j + startrow, data
							.getRecptionTB().getRname(), format1);
					wsheet.addCell(label1);
				} catch (Exception e) {
					Label label1 = new Label(1, j + startrow, "", format1);
					wsheet.addCell(label1);
				}
				Label label2 = new Label(2, j + startrow, data.getRecptionTB().getOrganizationTB().getOrgname(),
						format2);
				wsheet.addCell(label2);
				Label label3 = new Label(3, j + startrow, data.getEeuser(),
						format3);
				wsheet.addCell(label3);
				/////////////////////////////////////////////////////////////////
				Label label4 = new Label(4, j + startrow, "null".equals(String
						.valueOf(data.getEetableprice())) ? "0" : String
						.valueOf(data.getEetableprice()), format4);
				wsheet.addCell(label4);

				Label label5 = new Label(5, j + startrow, "null".equals(String
						.valueOf(data.getEetablenum())) ? "0" : String
						.valueOf(data.getEetablenum()), format5);
				wsheet.addCell(label5);

				Label label6 = new Label(6, j + startrow, "null".equals(String
						.valueOf(data.getEedrinkprice())) ? "0" : String
						.valueOf(data.getEedrinkprice()), format6);
				wsheet.addCell(label6);

				Label label7 = new Label(7, j + startrow, "null".equals(String
						.valueOf(data.getEesmokeprice())) ? "0" : String
						.valueOf(data.getEesmokeprice()), format7);
				wsheet.addCell(label7);

				Label label8 = new Label(8, j + startrow, "null".equals(String
						.valueOf(data.getEeotherprice())) ? "0" : String
						.valueOf(data.getEeotherprice()), format8);
				wsheet.addCell(label8);
				
				BigDecimal costA = LOMHelper.getAdd(data.getEeotherprice(), data.getEesmokeprice());
				BigDecimal costB = LOMHelper.getAdd(data.getEedrinkprice(), LOMHelper.getMultiply(String.valueOf(data.getEetableprice()), String.valueOf(data.getEetablenum())));
				BigDecimal costAll = LOMHelper.getAdd(costA, costB);
				
				Label label9 = new Label(9, j + startrow, String.valueOf(costAll), format9);
				wsheet.addCell(label9);
				
				//����ϼ�
				cprice = cprice.add(new BigDecimal("null".equals(String
						.valueOf(data.getEetableprice())) ? "0" : String
						.valueOf(data.getEetableprice())));
				znum = znum+Integer.parseInt("null".equals(String
						.valueOf(data.getEetablenum())) ? "0" : String
						.valueOf(data.getEetablenum()));
				jprice = jprice.add(new BigDecimal("null".equals(String
						.valueOf(data.getEedrinkprice())) ? "0" : String
								.valueOf(data.getEedrinkprice())));
				yprice = yprice.add(new BigDecimal("null".equals(String
						.valueOf(data.getEesmokeprice())) ? "0" : String
								.valueOf(data.getEesmokeprice())));
				
				qtprice = qtprice.add(new BigDecimal("null".equals(String
						.valueOf(data.getEeotherprice())) ? "0" : String
								.valueOf(data.getEeotherprice())));
				allprice = allprice.add(new BigDecimal(String.valueOf(costAll)));
				
			}
			Label label0 = new Label(0, dataList.size() + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);
			Label label1 = new Label(1, dataList.size() + startrow, "", format1);
			wsheet.addCell(label1);
			Label label2 = new Label(2, dataList.size() + startrow, "",
					format2);
			wsheet.addCell(label2);
			Label label3 = new Label(3, dataList.size() + startrow, "",
					format3);
			wsheet.addCell(label3);
			/////////////////////////////////////////////////////////////////
			Label label4 = new Label(4, dataList.size() + startrow, cprice.toString(), format4);
			wsheet.addCell(label4);

			Label label5 = new Label(5, dataList.size() + startrow, String.valueOf(znum), format5);
			wsheet.addCell(label5);

			Label label6 = new Label(6, dataList.size() + startrow, jprice.toString(), format6);
			wsheet.addCell(label6);

			Label label7 = new Label(7, dataList.size() + startrow, yprice.toString(), format7);
			wsheet.addCell(label7);

			Label label8 = new Label(8, dataList.size() + startrow, qtprice.toString(), format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, dataList.size() + startrow, String.valueOf(allprice), format9);
			wsheet.addCell(label9);
		}

		wwb.write();
		wwb.close();
		os.close();
	}

	/**
	 * ʳ���д����û���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0508(OutputStream os,
			List<EentertainmentStatistics> dataList, String opentime_from,
			String opentime_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0508.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�д�����ͳ��");
		if (!StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "��"
					+ opentime_to);
		} else if (!StringUtils.isEmpty(opentime_from)
				&& StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "֮��");
		} else if (StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_to + "֮ǰ");
		} else {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺");
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();

			// ���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				EentertainmentStatistics data = (EentertainmentStatistics) dataList
						.get(j);

				Label label0 = new Label(0, j + startrow, data.getEdate(),
						format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, "null".equals(String
						.valueOf(data.getEnumber())) ? "0" : String
						.valueOf(data.getEnumber()), format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, "null".equals(String
						.valueOf(data.getEefoodprice())) ? "0" : String
						.valueOf(data.getEefoodprice()), format2);
				wsheet.addCell(label2);

				Label label3 = new Label(3, j + startrow, "null".equals(String
						.valueOf(data.getEedrinkprice())) ? "0" : String
						.valueOf(data.getEedrinkprice())
						+ "", format3);
				wsheet.addCell(label3);

				Label label4 = new Label(4, j + startrow, "null".equals(String
						.valueOf(data.getEesmokeprice())) ? "0" : String
						.valueOf(data.getEesmokeprice()), format4);
				wsheet.addCell(label4);

				Label label5 = new Label(5, j + startrow, "null".equals(String
						.valueOf(data.getEeotherprice())) ? "0" : String.valueOf(data.getEeotherprice()), format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow, "null".equals(String
						.valueOf(data.getEtotal())) ? "0" : String.valueOf(data
						.getEtotal()), format6);
				wsheet.addCell(label6);
			}
		}

		wwb.write();
		wwb.close();
		os.close();
	}

	/**
	 * �����д����û���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0509(OutputStream os,
			List<DeptEentertainment> dataList, String opentime_from,
			String opentime_to) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0510.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���ŽӴ�����ͳ��");
		if (!StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "��"
					+ opentime_to);
		} else if (!StringUtils.isEmpty(opentime_from)
				&& StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "֮��");
		} else if (StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_to + "֮ǰ");
		} else {
			setCellByContents(wsheet, "date", "ȫ��ʱ�䣺");
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();

			// ���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				DeptEentertainment data = (DeptEentertainment) dataList.get(j);
				if (j == (dataList.size() - 1)) {
					Label label0 = new Label(0, j + startrow, "�ϼ�", format0);
					wsheet.addCell(label0);
				} else {
					try {
						Label label0 = new Label(0, j + startrow, data
								.getRecptionTB().getOrganizationTB()
								.getOrgname(), format0);
						wsheet.addCell(label0);
					} catch (Exception e) {
						Label label0 = new Label(0, j + startrow, "", format0);
						wsheet.addCell(label0);
					}
				}
				Label label1 = new Label(1, j + startrow, "null".equals(String
						.valueOf(data.getEnumber())) ? "0" : String
						.valueOf(data.getEnumber()), format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, "null".equals(String
						.valueOf(data.getEefoodprice())) ? "0" : String
						.valueOf(data.getEefoodprice()), format2);
				wsheet.addCell(label2);

				Label label3 = new Label(3, j + startrow, "null".equals(String
						.valueOf(data.getEedrinkprice())) ? "0" : String
						.valueOf(data.getEedrinkprice())
						+ "", format3);
				wsheet.addCell(label3);

				Label label4 = new Label(4, j + startrow, "null".equals(String
						.valueOf(data.getEesmokeprice())) ? "0" : String
						.valueOf(data.getEesmokeprice()), format4);
				wsheet.addCell(label4);

				Label label5 = new Label(5, j + startrow, "null".equals(String
						.valueOf(data.getEeotherprice())) ? "0" : String.valueOf(data
						.getEeotherprice()), format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow, "null".equals(String
						.valueOf(data.getEtotal())) ? "0" : String.valueOf(data
						.getEtotal()), format6);
				wsheet.addCell(label6);
			}
		}

		wwb.write();
		wwb.close();
		os.close();
	}

	/**
	 * ����»���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0514(OutputStream os,
			IGLOM05141VO dataList, String year, String month)
			throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0514.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "����»���ͳ��");
		setCellByContents(wsheet, "date", "��ѯʱ�䣺" + year + "��" + month + "��");
		if(dataList.getMap()!=null && dataList.getMap().size() > 0){
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Map<String,IGLOM05141VO> map = dataList.getMap();
			Set<Map.Entry<String,IGLOM05141VO>> set = map.entrySet();
			int num = 0;
			for(Iterator<Map.Entry<String,IGLOM05141VO>> iter = set.iterator();iter.hasNext();){
				Map.Entry<String,IGLOM05141VO> entry = iter.next();
				
				Label label0 = new Label(0, num + startrow, (num+1)+ "",
						format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, num + startrow, entry.getKey().split("-")[0],
						format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, num + startrow, "null".equals(String
						.valueOf(dataList.getMap().get(entry.getKey()).getInnum())) ? "0" : String
								.valueOf(dataList.getMap().get(entry.getKey()).getInnum()), format2);
				wsheet.addCell(label2);

				Label label3 = new Label(3, num + startrow, "null".equals(String
						.valueOf(dataList.getMap().get(entry.getKey()).getOutnum())) ? "0" : String
								.valueOf(dataList.getMap().get(entry.getKey()).getOutnum()), format3);
				wsheet.addCell(label3);

				Label label4 = new Label(4, num + startrow, "null".equals(String
						.valueOf(dataList.getMap().get(entry.getKey()).getNownum())) ? "0" : String
								.valueOf(dataList.getMap().get(entry.getKey()).getNownum()), format4);
				wsheet.addCell(label4);
				num++;
			}
//			Label label0 = new Label(0, num + startrow, "�ϼ�", format0);
//			wsheet.addCell(label0);
//			
//			Label label1 = new Label(1, num + startrow, "",
//					format1);
//			wsheet.addCell(label1);
//
//			Label label2 = new Label(2, num + startrow, dataList.getInnum(), format2);
//			wsheet.addCell(label2);
//
//			Label label3 = new Label(3, num + startrow, dataList.getOutnum(), format3);
//			wsheet.addCell(label3);
//
//			Label label4 = new Label(4, num + startrow, dataList.getNownum(), format4);
//			wsheet.addCell(label4);
		}

		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ����»���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0517(OutputStream os,
			List<GoodsStock> dataList, String year, String month, String name)
			throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0517.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�������ϸͳ��");
		setCellByContents(wsheet, "date", "��ѯʱ�䣺" + year + "��" + month + "��"+"   ��Ʒ���ƣ�"+name);
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
//			Cell cell4 = wsheetTemplate.getCell(4, startrow);
//			CellFormat format4 = cell4.getCellFormat();

			// ���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				GoodsStock data = (GoodsStock) dataList.get(j);
				Label label0 = new Label(0, j + startrow, data.getGid().split("-")[0],
						format0);
				wsheet.addCell(label0);
//				Label label1 = new Label(1, j + startrow, data.getGiodname(),
//						format1);
//				wsheet.addCell(label1);
				
				if(IGLOMCONSTANTS.GIODTYPE_RK.equals(data.getType())){
					Label label1 = new Label(1, j + startrow, "null".equals(String
							.valueOf(data.getGiodinnum())) ? "0" : String
							.valueOf(data.getGiodinnum()), format1);
					wsheet.addCell(label1);
					
					Label label2 = new Label(2, j + startrow, "-", format2);
					wsheet.addCell(label2);
				}else{
					Label label1 = new Label(1, j + startrow, "-", format1);
					wsheet.addCell(label1);
					
					Label label2 = new Label(2, j + startrow, "null".equals(String
							.valueOf(data.getGiodinnum())) ? "0" : String
							.valueOf(data.getGiodinnum())
							+ "", format2);
					wsheet.addCell(label2);
				}
				Label label3 = new Label(3, j + startrow, "null".equals(String
						.valueOf(data.getGiodnum())) ? "0" : String
						.valueOf(data.getGiodnum()), format3);
				wsheet.addCell(label3);
			}
		}

		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ����»���ͳ��ȫ��ϸ����
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0518(OutputStream os,
			List<GoodsStock> dataList, String year, String month, String name)
			throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0518.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�¿��ȫ��ϸͳ��");
		setCellByContents(wsheet, "date", "��ѯʱ�䣺" + year + "��" + month + "��");
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();

			// ���õ�Ԫ��
			for (int j = dataList.size()-1; j >=0; j--) {
				GoodsStock data = (GoodsStock) dataList.get(j);
				Label label0 = new Label(0, Math.abs(j+1-dataList.size()) + startrow, data.getGiodname(),
						format0);
				wsheet.addCell(label0);
				Label label1 = new Label(1, Math.abs(j+1-dataList.size()) + startrow, data.getGid().split("-")[0],
						format1);
				wsheet.addCell(label1);
//				Label label1 = new Label(1, j + startrow, data.getGiodname(),
//						format1);
//				wsheet.addCell(label1);
				if(IGLOMCONSTANTS.GIODTYPE_RK.equals(data.getType())){
					Label label2 = new Label(2, Math.abs(j+1-dataList.size()) + startrow, "null".equals(String
							.valueOf(data.getGiodinnum())) ? "0" : String
							.valueOf(data.getGiodinnum()), format2);
					wsheet.addCell(label2);
					
					Label label3 = new Label(3, Math.abs(j+1-dataList.size()) + startrow, "-", format3);
					wsheet.addCell(label3);
				}else{
					Label label2 = new Label(2, Math.abs(j+1-dataList.size()) + startrow, "-", format2);
					wsheet.addCell(label2);
					
					Label label3 = new Label(3, Math.abs(j+1-dataList.size()) + startrow, "null".equals(String
							.valueOf(data.getGiodinnum())) ? "0" : String
							.valueOf(data.getGiodinnum())
							+ "", format3);
					wsheet.addCell(label3);
				}
				Label label4 = new Label(4, Math.abs(j+1-dataList.size()) + startrow, "null".equals(String
						.valueOf(data.getGiodnum())) ? "0" : String
						.valueOf(data.getGiodnum()), format4);
				wsheet.addCell(label4);
			}
				
		}

		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ��һ��Ʒ����»���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0515(OutputStream os,
			List<SingleGoodsStock> dataList, String opentime_from,
			String opentime_to, String goods) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0515.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		// �滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "��һ��Ʒ������ͳ��");
		if (!StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "��"
					+ opentime_to+"    ��Ʒ����"+goods);
		} else if (!StringUtils.isEmpty(opentime_from)
				&& StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_from + "֮��"+"    ��Ʒ����"+goods);
		} else if (StringUtils.isEmpty(opentime_from)
				&& !StringUtils.isEmpty(opentime_to)) {
			setCellByContents(wsheet, "date", "��ѯʱ�䣺" + opentime_to + "֮ǰ"+"    ��Ʒ����"+goods);
		} else {
			setCellByContents(wsheet, "date", "ȫ��ʱ��"+"    ��Ʒ����"+goods);
		}
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();

			// ���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				SingleGoodsStock data = (SingleGoodsStock) dataList.get(j);
				Label label0 = new Label(0, j + startrow, data.getGiodtime().split("-")[0],
						format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, "0".equals(data
						.getGiodtype()) ? "���" : "����", format1);
				wsheet.addCell(label1);

				if(IGLOMCONSTANTS.GIODTYPE_RK.equals(data.getGiodtype())){
					Label label2 = new Label(2, j + startrow, "null".equals(String
							.valueOf(data.getGiodinnum())) ? "0" : String
							.valueOf(data.getGiodinnum()), format2);
					wsheet.addCell(label2);
					
					Label label3 = new Label(3, j + startrow, "-", format3);
					wsheet.addCell(label3);
				}else{
					Label label2 = new Label(2, j + startrow, "-", format2);
					wsheet.addCell(label2);
					
					Label label3 = new Label(3, j + startrow, "null".equals(String
							.valueOf(data.getGiodinnum())) ? "0" : String
							.valueOf(data.getGiodinnum()), format3);
					wsheet.addCell(label3);
				}

				Label label4 = new Label(4, j + startrow, "null".equals(String
						.valueOf(data.getGiodnum())) ? "0" : String
						.valueOf(data.getGiodnum()), format4);
				wsheet.addCell(label4);
				try {
					Label label5 = new Label(5, j + startrow, data
							.getRecptionTB().getOrganizationTB().getOrgname(),
							format5);
					wsheet.addCell(label5);
				} catch (Exception e) {
					Label label5 = new Label(5, j + startrow, "", format5);
					wsheet.addCell(label5);
				}
				try {
					Label label6 = new Label(6, j + startrow, data
							.getRecptionTB().getRname(), format6);
					wsheet.addCell(label6);
				} catch (Exception e) {
					Label label6 = new Label(6, j + startrow, "", format6);
					wsheet.addCell(label6);
				}
			}
		}

		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ���ͳ�Ƶ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0214(OutputStream os,
			List<Gstock> dataList, String gscategory) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0214.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 3;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "���ͳ�Ʊ���");	
		
		setCellByContents(wsheet, "date","��ѯʱ�䣺" + IGStringUtils.getCurrentDate());
		
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			IGLOM02BL ctrlBL = (IGLOM02BL) WebApplicationSupport.getBean("iglom02BL");
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Gstock data = (Gstock) dataList.get(j);
				String category_name = ctrlBL.getCodeValue(data.getGscategory());
					//SysConfigManager.getConfigInfo(CodeUtils.GOODS_CATEGORY + "_" + data.getGscategory());

				Label label0 = new Label(0, j + startrow, String.valueOf(j+1)+"",format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, category_name + "", format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, data.getGsname()+ "", format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, data.getGscode()+ "", format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow, data.getGsnum()+ "", format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow, data.getGsfreezenum()+ "", format5);
				wsheet.addCell(label5);

			}

		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ʳ�ýӴ����Ż��ܵ���
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0522(OutputStream os,
			List<EEOrg> dataList, String iyear, String month_from, String month_to, String rapporgname) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0522.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "�����д����ܱ���");	
		setCellByContents(wsheet, "rapporgname", "���벿�ţ�"+(null != rapporgname ? rapporgname:""));
		setCellByContents(wsheet, "year", "��/�£�" + iyear + "/" + month_from + " �� " + iyear + "/" + month_to);
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			
			
			
			
			int sum_Rnum = 0;
			
			BigDecimal amount = new BigDecimal(0);
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				EEOrg data = (EEOrg) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getRapporgname()+ "",format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getRnum()+ "", format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, data.getAmount()+ "", format2);
				wsheet.addCell(label2);

				sum_Rnum=sum_Rnum+Integer.valueOf(data.getRnum());
				amount=LOMHelper.getAdd(amount, data.getAmount());
			}
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_Rnum), format1);
			wsheet.addCell(label1);

			Label label2 = new Label(2, size + startrow,String.valueOf(amount), format2);
			wsheet.addCell(label2);
					
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	/**
	 * ʳ����Ʒ������ϸ����
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0524(OutputStream os,
			List<GoutDetailInfo> dataList, String iyear, String month_from, String month_to, String guser) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0524.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", "ʳ����Ʒ������ϸ����");	
		setCellByContents(wsheet, "guser", "��ȡ�ˣ�"+(null != guser ? guser:""));
		setCellByContents(wsheet, "year", "��/�£�" + iyear + "/" + month_from + " �� " + iyear + "/" + month_to);
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				GoutDetailInfo data = (GoutDetailInfo) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getGorequsername()+ "",format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, data.getGocode()+ "", format1);
				wsheet.addCell(label1);

				Label label2 = new Label(2, j + startrow, data.getGoname()+ "", format2);
				wsheet.addCell(label2);
				Label label3 = new Label(3, j + startrow, data.getGoinnum()+ "", format3);
				wsheet.addCell(label3);
				Label label4 = new Label(4, j + startrow, data.getGotime()+ "", format4);
				wsheet.addCell(label4);
				if(data.getRname()!=null){
					Label label5 = new Label(5, j + startrow, data.getRname()+ "", format5);
					wsheet.addCell(label5);
				}else{
					Label label5 = new Label(5, j + startrow,  "", format5);
					wsheet.addCell(label5);
				}
				if(data.getRid().equals("0")){
					Label label6 = new Label(6, j + startrow, "��ͨ����", format6);
					wsheet.addCell(label6);
				}
				else{
					Label label6 = new Label(6, j + startrow, "�д�����", format6);
					wsheet.addCell(label6);
				}
				
				
			}
			
			
					
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
	/**
	 * ÿ���̵�
	 * ��Ʒ���̴����
	 * 
	 * @param os
	 * @param dataList
	 * @throws Exception
	 */
	public synchronized static void exportIGLOM0221(OutputStream os,
			List<Inventory> dataList, String year, String month) throws Exception {
		Workbook template = ExportExcel.getTemplate("IGLOM0221.xls");
		Sheet wsheetTemplate = template.getSheet(0);
		WritableWorkbook wwb = Workbook.createWorkbook(os, template);
		WritableSheet wsheet = wwb.getSheet(0);
		wsheet.getSettings().setScaleFactor( wsheetTemplate.getSettings().getScaleFactor());
		int startrow = 4;
		//�滻ָ����Ԫ��
		setCellByContents(wsheet, "title", year + "��" + month + "����Ʒ���̴��");	
		setCellByContents(wsheet, "date", IGStringUtils.getCurrentYear() + " �� " + IGStringUtils.getCurrentDate().substring(6,7) + " �� " + IGStringUtils.getCurrentDate().substring(8) + " ��");
		if (dataList != null && dataList.size() > 0) {
			// ��ȡָ����Ԫ���ʽ����4��
			Cell cell0 = wsheetTemplate.getCell(0, startrow);
			CellFormat format0 = cell0.getCellFormat();
			Cell cell1 = wsheetTemplate.getCell(1, startrow);
			CellFormat format1 = cell1.getCellFormat();
			Cell cell2 = wsheetTemplate.getCell(2, startrow);
			CellFormat format2 = cell2.getCellFormat();
			Cell cell3 = wsheetTemplate.getCell(3, startrow);
			CellFormat format3 = cell3.getCellFormat();
			Cell cell4 = wsheetTemplate.getCell(4, startrow);
			CellFormat format4 = cell4.getCellFormat();
			Cell cell5 = wsheetTemplate.getCell(5, startrow);
			CellFormat format5 = cell5.getCellFormat();
			Cell cell6 = wsheetTemplate.getCell(6, startrow);
			CellFormat format6 = cell6.getCellFormat();
			Cell cell7 = wsheetTemplate.getCell(7, startrow);
			CellFormat format7 = cell7.getCellFormat();
			Cell cell8 = wsheetTemplate.getCell(8, startrow);
			CellFormat format8 = cell8.getCellFormat();
			Cell cell9 = wsheetTemplate.getCell(9, startrow);
			CellFormat format9 = cell9.getCellFormat();
			Cell cell10 = wsheetTemplate.getCell(10, startrow);
			CellFormat format10 = cell10.getCellFormat();
			Cell cell11 = wsheetTemplate.getCell(11, startrow);
			CellFormat format11 = cell11.getCellFormat();
			Cell cell12 = wsheetTemplate.getCell(12, startrow);
			CellFormat format12 = cell12.getCellFormat();		
			Cell cell13 = wsheetTemplate.getCell(13, startrow);
			CellFormat format13 = cell13.getCellFormat();
			Cell cell14 = wsheetTemplate.getCell(14, startrow);
			CellFormat format14 = cell14.getCellFormat();
			
			
			//���´���
			int sum_la = 0;
			BigDecimal sum_lm = new BigDecimal(0);
			//���¹���
			int sum_cia = 0;
			BigDecimal sum_cim = new BigDecimal(0);
			//ƽ����
			BigDecimal sum_average = new BigDecimal(0);
			//��������
			int sum_coa = 0;
			BigDecimal sum_com = new BigDecimal(0);
			//���µ���
			int sum_cra = 0;
			BigDecimal sum_crm = new BigDecimal(0);
			//���º���
			int sum_cha = 0;
			BigDecimal sum_chm = new BigDecimal(0);
			//���½��
			int sum_csa = 0;
			BigDecimal sum_csm = new BigDecimal(0);
			
			BigDecimal sum = new BigDecimal(0);//����
			Integer sum_a = 0;//��ĸ
			
			//���õ�Ԫ��
			for (int j = 0; j < dataList.size(); j++) {
				Inventory data = (Inventory) dataList.get(j);

				Label label0 = new Label(0, j + startrow, data.getGoodsname()+ "",format0);
				wsheet.addCell(label0);

				Label label1 = new Label(1, j + startrow, 
						"null".equals(String.valueOf(data.getLminventoryamount())) ? "" : String.valueOf(data.getLminventoryamount()), 
								format1);
				wsheet.addCell(label1);
				
				Label label2 = new Label(2, j + startrow, 
						"null".equals(String.valueOf(data.getLminventorymoney())) ? "" : String.valueOf(data.getLminventorymoney()), 
								format2);
				wsheet.addCell(label2);
				
				Label label3 = new Label(3, j + startrow, 
						"null".equals(String.valueOf(data.getCminputamount())) ? "" : String.valueOf(data.getCminputamount()), 
								format3);
				wsheet.addCell(label3);
				
				Label label4 = new Label(4, j + startrow,
						"null".equals(String.valueOf(data.getCminputmoney())) ? "" : String.valueOf(data.getCminputmoney()), 
								format4);
				wsheet.addCell(label4);
				
				Label label5 = new Label(5, j + startrow,
						"null".equals(String.valueOf(data.getAverage())) ? "" : String.valueOf(data.getAverage()), 
								format5);
				wsheet.addCell(label5);
				
				Label label6 = new Label(6, j + startrow,
						"null".equals(String.valueOf(data.getCmoutamount())) ? "" : String.valueOf(data.getCmoutamount()), 
								format6);
				wsheet.addCell(label6);
				
				Label label7 = new Label(7, j + startrow,
						"null".equals(String.valueOf(data.getCmoutmoney())) ? "" : String.valueOf(data.getCmoutmoney()), 
								format7);
				wsheet.addCell(label7);
				
				Label label8 = new Label(8, j + startrow,
						"null".equals(String.valueOf(data.getCmregamount())) ? "" : String.valueOf(data.getCmregamount()), 
								format8);
				wsheet.addCell(label8);
				
				Label label9 = new Label(9, j + startrow,
						"null".equals(String.valueOf(data.getCmregmoney())) ? "" : String.valueOf(data.getCmregmoney()), 
								format9);
				wsheet.addCell(label9);
				
				Label label10 = new Label(10, j + startrow,
						"null".equals(String.valueOf(data.getCmhavoamount())) ? "" : String.valueOf(data.getCmhavoamount()), 
								format10);
				wsheet.addCell(label10);
				
				Label label11 = new Label(11, j + startrow,
						"null".equals(String.valueOf(data.getCmhavomoney())) ? "" : String.valueOf(data.getCmhavomoney()), 
								format11);
				wsheet.addCell(label11);
				
				Label label12 = new Label(12, j + startrow,
						"null".equals(String.valueOf(data.getCmsurplusamount())) ? "" : String.valueOf(data.getCmsurplusamount()), 
								format12);
				wsheet.addCell(label12);
				
				Label label13 = new Label(13, j + startrow, 
						"null".equals(String.valueOf(data.getCmsurplusmoney())) ? "" : String.valueOf(data.getCmsurplusmoney()), 
								format13);
				wsheet.addCell(label13);
				
				Label label14 = new Label(14, j + startrow, "", format14);
				wsheet.addCell(label14);

				if(data.getLminventoryamount() != null){
					sum_la = sum_la + data.getLminventoryamount();
				}
				
				if(data.getLminventorymoney() != null){
					sum_lm = LOMHelper.getAdd(sum_lm, data.getLminventorymoney());
				}
				
				if(data.getCminputamount() != null){
					sum_cia = sum_cia + data.getCminputamount();
				}
				
				if(data.getCminputmoney() != null){
					sum_cim = LOMHelper.getAdd(sum_cim, data.getCminputmoney());
				}
				
				if(data.getCmoutamount() != null){
					sum_coa = sum_coa + data.getCmoutamount();
				}
				
				if(data.getCmoutmoney() != null){
					sum_com = LOMHelper.getAdd(sum_com, data.getCmoutmoney());
				}
				
				if(data.getCmregamount() != null){
					sum_cra = sum_cra + data.getCmregamount();
				}
				
				if(data.getCmregmoney() != null){
					sum_crm = LOMHelper.getAdd(sum_crm, data.getCmregmoney());
				}
				
				if(data.getCmhavoamount() != null){
					sum_cha = sum_cha + data.getCmhavoamount();
				}
				
				if(data.getCmhavomoney() != null){
					sum_chm = LOMHelper.getAdd(sum_chm, data.getCmhavomoney());
				}
				
				if(data.getCmsurplusamount() != null){
					sum_csa = sum_csa + data.getCmsurplusamount();
				}
				
				if(data.getCmsurplusmoney() != null){
					sum_csm = LOMHelper.getAdd(sum_csm, data.getCmsurplusmoney());
				}
				
			}

			sum = LOMHelper.getAdd(sum_lm, sum_cim);
			sum = LOMHelper.getAdd(sum, sum_com);
			sum = LOMHelper.getAdd(sum, sum_crm);
			sum = LOMHelper.getAdd(sum, sum_chm);
			sum = LOMHelper.getAdd(sum, sum_csm);
			
			sum_a = sum_la + sum_cia + sum_coa + sum_cra + sum_cha + sum_csa;
			
			if(sum_a != 0){
				sum_average = LOMHelper.getDivide(String.valueOf(sum), String.valueOf(sum_a));
				sum_average = LOMHelper.roundForBigDecimal(String.valueOf(sum_average),2);
			}
			
			
			//����ͳ����
			int size = dataList.size();
			Label label0 = new Label(0, size + startrow, "�ϼ�",
					format0);
			wsheet.addCell(label0);

			Label label1 = new Label(1, size + startrow, String.valueOf(sum_la), 
							format1);
			wsheet.addCell(label1);
			
			Label label2 = new Label(2, size + startrow, String.valueOf(sum_lm), 
							format2);
			wsheet.addCell(label2);
			
			Label label3 = new Label(3, size + startrow, String.valueOf(sum_cia), 
							format3);
			wsheet.addCell(label3);
			
			Label label4 = new Label(4, size + startrow, String.valueOf(sum_cim), 
							format4);
			wsheet.addCell(label4);
			
			Label label5 = new Label(5, size + startrow, String.valueOf(sum_average), 
							format5);
			wsheet.addCell(label5);
			
			Label label6 = new Label(6, size + startrow, String.valueOf(sum_coa), 
							format6);
			wsheet.addCell(label6);
			
			Label label7 = new Label(7, size + startrow, String.valueOf(sum_com), 
							format7);
			wsheet.addCell(label7);
			
			Label label8 = new Label(8, size + startrow, String.valueOf(sum_cra), 
							format8);
			wsheet.addCell(label8);
			
			Label label9 = new Label(9, size + startrow, String.valueOf(sum_crm), 
							format9);
			wsheet.addCell(label9);
			
			Label label10 = new Label(10, size + startrow, String.valueOf(sum_cha), 
							format10);
			wsheet.addCell(label10);
			
			Label label11 = new Label(11, size + startrow, String.valueOf(sum_chm), 
							format11);
			wsheet.addCell(label11);
			
			Label label12 = new Label(12, size + startrow, String.valueOf(sum_csa), 
							format12);
			wsheet.addCell(label12);
			
			Label label13 = new Label(13, size + startrow, String.valueOf(sum_csm), 
							format13);
			wsheet.addCell(label13);
			
			Label label14 = new Label(14, size + startrow,"", format14);
			wsheet.addCell(label14);
					
			
		}
		wwb.write();
		wwb.close();
		os.close();
	}
	
}
