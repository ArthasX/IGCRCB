/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.smr.bl;

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

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;
import com.deliverik.infogovernor.xls.smr.dto.IGSMR0801ExcelDTO;

/**
 * 概述:填报考核导出
 * 功能描述：填报考核导出
 * 创建人：赵梓廷
 * 创建记录： 2013-09-03
 * 修改记录：
 */
public class IGSMR0801ExcelBLImpl extends ExcelBaseBLImpl implements
		IGSMR0801ExcelBL {

	public ExcelDTO initBody(ExcelDTO excelDto) throws BLException {
		IGSMR0801ExcelDTO dto = (IGSMR0801ExcelDTO)excelDto;
		dto.setStartRow(4);
		//遍历结果集，将查询结果写入excel
		for(int i=0;i<dto.getList().size();i++){
			IGSMR08001VO vo = dto.getList().get(i);
			//部门名称
			addCell(0, i,vo.getOrgname());
			//年报填报次数
			addCell(1, i,vo.getYearnum());
			//年报及时率
			addCell(2, i,vo.getYeartime());
			//年报准确率
			addCell(3, i,vo.getYeartrue());
			//季报填报次数
			addCell(4, i,vo.getQuarternum());
			//季报及时率
			addCell(5, i,vo.getQuartertime());
			//季报准确率
			addCell(6, i,vo.getQuartertrue());
			//不定期报表填报次数
			addCell(7, i,vo.getNotimenum());
			//不定期报表及时率
			addCell(8, i,vo.getNotime());
			//不定期报表准确率
			addCell(9, i,vo.getNotimetrue());			
		}
		//写入合计
		if(dto.getOrgsum()!=null&&dto.getList().size()!=0){
			//部门名称
			addCell(0,dto.getList().size() ,"合计");
			//年报填报次数
			addCell(1, dto.getList().size() ,dto.getOrgsum().getYearnum());
			//年报及时率
			addCell(2, dto.getList().size() ,dto.getOrgsum().getYeartime());
			//年报准确率
			addCell(3, dto.getList().size(),dto.getOrgsum().getYeartrue());
			//季报填报次数
			addCell(4, dto.getList().size() ,dto.getOrgsum().getQuarternum());
			//季报及时率
			addCell(5, dto.getList().size() ,dto.getOrgsum().getQuartertime());
			//季报准确率
			addCell(6, dto.getList().size() ,dto.getOrgsum().getQuartertrue());
			//不定期报表填报次数
			addCell(7, dto.getList().size() ,dto.getOrgsum().getNotimenum());
			//不定期报表及时率
			addCell(8, dto.getList().size() ,dto.getOrgsum().getNotime());
			//不定期报表准确率
			addCell(9, dto.getList().size() ,dto.getOrgsum().getNotimetrue());			
		}
		return excelDto;
	}

	public ExcelDTO initFooter(ExcelDTO excelDto) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO excelDto) throws BLException {
		IGSMR0801ExcelDTO dto = (IGSMR0801ExcelDTO)excelDto;
		//考核周期开始
		String startdate ="";
		//考核周期结束
		String overdate ="";
		//将日期时间格式改变
		if(StringUtils.isNotEmpty(dto.getAssessstartdate())){
			startdate = dto.getAssessstartdate().substring(0, 4)+"年"+dto.getAssessstartdate().substring(6, 7)+"月"+dto.getAssessstartdate().substring(9, 10)+"日";
		}
		if(StringUtils.isNotEmpty(dto.getAssessoverdate())){
			overdate = dto.getAssessoverdate().substring(0, 4)+"年"+dto.getAssessoverdate().substring(6, 7)+"月"+dto.getAssessoverdate().substring(9, 10)+"日";
		}
		replaceCellContent("title", "填报质量考核（部门）");
		if(StringUtils.isEmpty(startdate)&&StringUtils.isEmpty(overdate)){
			 replaceCellContent("date", "考核周期：");
		}else{			
			replaceCellContent("date", "考核周期："+startdate+"-"+overdate);
		}
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
