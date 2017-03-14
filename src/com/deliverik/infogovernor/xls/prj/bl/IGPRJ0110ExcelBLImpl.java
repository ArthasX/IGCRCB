/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.prj.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Sheet;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.prj.model.InvestContractInfoVW;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0110ExcelDTO;

/**
 * 概述: 投资合同明细报表导出BL实现
 * 功能描述：投资合同明细报表导出BL实现
 * 创建人：王廷志
 * 创建记录： 2012-5-25
 * 修改记录：
 */
public class IGPRJ0110ExcelBLImpl extends ExcelBaseBLImpl implements IGPRJ0110ExcelBL{

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		IGPRJ0110ExcelDTO excelDTO = (IGPRJ0110ExcelDTO) dto;
		List<InvestContractInfoVW> investContractList = excelDTO.getInvestContractList();
		Map<String, Double> sumMap = new HashMap<String, Double>();
		if(investContractList!=null&&investContractList.size()>0){
			double plcsum = 0;
			double plbplcsum = 0;
			double subnum = 0;
			for(InvestContractInfoVW invest:investContractList){
				plcsum += invest.getPlcsum()==null?0:invest.getPlcsum();
				plbplcsum +=invest.getPlbsum() == null?0:invest.getPlbsum();
				subnum += invest.getSubnum()==null?0:invest.getSubnum();
			}
			sumMap.put("plcsum", plcsum);
			sumMap.put("plbsum", plbplcsum);
			sumMap.put("subnum", subnum);
		}
		dto.setStartRow(2);
		addCell(0,0,"合计：",Colour.YELLOW);
		addCell(1,0,"",Colour.YELLOW);
		addCell(2,0,"",Colour.YELLOW);
		addCell(3,0,"",Colour.YELLOW);
		addCell(4,0,"",Colour.YELLOW);
		addCell(5,0,"",Colour.YELLOW);
		addCell(6,0,sumMap.get("plcsum"),Colour.YELLOW);
		addCell(7,0,sumMap.get("plbsum"),Colour.YELLOW);
		addCell(8,0,sumMap.get("subnum"),Colour.YELLOW);
		addCell(9,0,"",Colour.YELLOW);
		addCell(10,0,"",Colour.YELLOW);
		addCell(11,0,"",Colour.YELLOW);
		if(investContractList!=null&&investContractList.size()>0){
			for(int i=0;i<investContractList.size();i++){
				InvestContractInfoVW invest = investContractList.get(i);
				addCell(0,i+1,invest.getPname());
				addCell(1,i+1,invest.getPcode());
				addCell(2,i+1,invest.getPstorecode());
				addCell(3,i+1,invest.getBtitle()==null?"无预算":invest.getBtitle());
				addCell(4,i+1,invest.getPcut());
				addCell(5,i+1,invest.getPlcnumber());
				addCell(6,i+1,invest.getPlcsum()==null?0:invest.getPlcsum());
				addCell(7,i+1,invest.getPlbsum()==null?0:invest.getPlbsum());
				addCell(8,i+1,invest.getSubnum()==null?0:invest.getSubnum());
				addCell(9,i+1,invest.getLcount()==null?0:invest.getLcount());
				addCell(10,i+1,invest.getBcount()==null?0:invest.getBcount());
				addCell(11,i+1,invest.getUsername());
			}
		}
		try {
			dto.getWritableSheet().mergeCells(0, 2, 5, 2);
		} catch (Exception e) {
			throw new BLException();
		} 
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return dto;
	}
	
	protected void addCell(int pColumn, int pRow, String pValue, Colour c)
			throws BLException {

		// 定义格式 字体 下划线 斜体 粗体 颜色
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.AUTOMATIC);
		// 单元格定义
		WritableCellFormat wcf = new WritableCellFormat(wf);
		try {
			// 设置单元格的背景颜色
			wcf.setBackground(c);
			wcf.setAlignment(Alignment.RIGHT);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);

		} catch (WriteException e) {
			throw new BLException(e.getMessage());
		}
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
		WritableSheet wsheet = excelDTO.getWritableSheet();
		wsheet.getSettings().setScaleFactor(
				wsheetTemplate.getSettings().getScaleFactor());

		Label label = new Label(pColumn, pRow + excelDTO.getStartRow(), pValue,
				wcf);
		try {
			wsheet.addCell(label);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}

	protected void addCell(int pColumn, int pRow, double pValue, Colour c)
			throws BLException {

		// 定义格式 字体 下划线 斜体 粗体 颜色
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.AUTOMATIC);
		// 单元格定义
		WritableCellFormat wcf = new WritableCellFormat(wf);
		try {
			// 设置单元格的背景颜色
			wcf.setBackground(c);
			wcf.setAlignment(Alignment.RIGHT);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);

		} catch (WriteException e) {
			throw new BLException(e.getMessage());
		}
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
		WritableSheet wsheet = excelDTO.getWritableSheet();
		wsheet.getSettings().setScaleFactor(
				wsheetTemplate.getSettings().getScaleFactor());

		jxl.write.Number number = new jxl.write.Number(pColumn, pRow
				+ excelDTO.getStartRow(), pValue, wcf);

		try {
			wsheet.addCell(number);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}

}
