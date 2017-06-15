/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.svc.bl;

import jxl.Sheet;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.BorderLineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.xls.svc.dto.IGSVC1301ExcelDTO;

/**
 * 工作信息导出
 */
public class IGSVC1301ExcelBLImpl extends ExcelBaseBLImpl implements
		IGSVC1301ExcelBL {

	public ExcelDTO initBody(ExcelDTO excelDto) throws BLException {
		IGSVC1301ExcelDTO dto = (IGSVC1301ExcelDTO)excelDto;
		dto.setStartRow(2);
		//遍历结果集，将查询结果写入excel
		for(int i=0;i<dto.getWmList().size();i++){
			WorkmanagerInfo info = dto.getWmList().get(i);
			//工作名称
			addCell(0, i,info.getWmname());
			//工作描述
			addCell(1, i,info.getWmdesc());
			//工作周期
			String wmfrequency = "";
			if("once".equals(info.getWmfrequency()))
				wmfrequency = "立即发起";
			else if("day".equals(info.getWmfrequency()))
				wmfrequency = "每日";
			else if("week".equals(info.getWmfrequency()))
				wmfrequency = "每周";
			else if("month".equals(info.getWmfrequency()))
				wmfrequency = "每月";
			else if("quarter".equals(info.getWmfrequency()))
				wmfrequency = "每季度";
			else if("halfyear".equals(info.getWmfrequency()))
				wmfrequency = "每半年";
			else if("year".equals(info.getWmfrequency()))
				wmfrequency = "每年";
			addCell(2, i, wmfrequency);
			//发起人
			addCell(3, i,info.getWmusername());
			//发起时间
			addCell(4, i,info.getWmstartdate().trim());
			//限期完成时间
			addCell(5, i,info.getWmlimitdate().trim());
			//实际完成时间
			addCell(6, i, info.getWmfactdate()!=null?info.getWmfactdate().trim():"");
			//备注
			addCell(7, i, info.getWmremark());
			//完成状态
			String wmstatus = "";
			if("0".equals(info.getWmstatus()))
				wmstatus = "未完成";
			else 
				wmstatus = "已完成";
			addCell(8, i, wmstatus);
			//是否提醒
//			addCell(9, i,vo.getNotimetrue());			
		}
		return excelDto;
	}

	public ExcelDTO initFooter(ExcelDTO excelDto) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO excelDto) throws BLException {
//		IGSMR0801ExcelDTO dto = (IGSMR0801ExcelDTO)excelDto;
//		//考核周期开始
//		String startdate ="";
//		//考核周期结束
//		String overdate ="";
//		//将日期时间格式改变
//		if(StringUtils.isNotEmpty(dto.getAssessstartdate())){
//			startdate = dto.getAssessstartdate().substring(0, 4)+"年"+dto.getAssessstartdate().substring(6, 7)+"月"+dto.getAssessstartdate().substring(9, 10)+"日";
//		}
//		if(StringUtils.isNotEmpty(dto.getAssessoverdate())){
//			overdate = dto.getAssessoverdate().substring(0, 4)+"年"+dto.getAssessoverdate().substring(6, 7)+"月"+dto.getAssessoverdate().substring(9, 10)+"日";
//		}
		replaceCellContent("title", "工作信息");
//		if(StringUtils.isEmpty(startdate)&&StringUtils.isEmpty(overdate)){
//			 replaceCellContent("date", "考核周期：");
//		}else{			
//			replaceCellContent("date", "考核周期："+startdate+"-"+overdate);
//		}
		return excelDto;
	}

	/**
     * 插入颜色方法
     * 
     * @return wcf
     */
	protected void addCell(int pColumn, int pRow, String pValue)	
			throws BLException {

		// 定义格式 字体 下划线 斜体 粗体 颜色
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
		// 单元格定义
		WritableCellFormat wcf = new WritableCellFormat(wf);
		try {
			// 设置单元格的背景颜色
			wcf.setAlignment(Alignment.CENTRE);
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
}
