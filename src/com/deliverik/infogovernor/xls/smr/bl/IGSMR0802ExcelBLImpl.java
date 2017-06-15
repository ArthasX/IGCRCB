/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.smr.bl;

import java.util.List;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.CellFormat;
import jxl.format.Colour;
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
import com.deliverik.infogovernor.xls.smr.dto.IGSMR0802ExcelDTO;

/**
 * 概述:填报考核按人员
 * 功能描述：填报考核按人员
 * 创建人：赵梓廷
 * 创建记录： 2013-09-04
 * 修改记录：
 */
public class IGSMR0802ExcelBLImpl extends ExcelBaseBLImpl implements
		IGSMR0802ExcelBL {

	public ExcelDTO initBody(ExcelDTO exceldto) throws BLException {
		IGSMR0802ExcelDTO dto = (IGSMR0802ExcelDTO)exceldto;
		dto.setStartRow(4);
		//设置键值集合
		Set set = dto.getMap().keySet();
		//设置行变量
		int row =0;
		//遍历结果集
		for(Object orgname:set){
			//根据键得到值
			List<IGSMR08001VO> list = dto.getMap().get(orgname.toString());
			addCell(0,row,orgname.toString());
			int size = list.size();
			//将部门单元格合并
			try {
				dto.getWritableSheet().mergeCells(0, dto.getStartRow()+row, 0, dto.getStartRow()+row+size-1);
			} catch (Exception e) {
				throw new BLException("");
			}
			//遍历集合
			for(IGSMR08001VO vo:list){
				addCell(1,row,vo.getUsername());
				addCell(2,row,vo.getYearnum());
				addCell(3,row,vo.getYeartime());
				addCell(4,row,vo.getYeartrue());
				addCell(5,row,vo.getQuarternum());
				addCell(6,row,vo.getQuartertime());
				addCell(7,row,vo.getQuartertrue());
				addCell(8,row,vo.getNotimenum());
				addCell(9,row,vo.getNotime());
				addCell(10,row,vo.getNotimetrue());
				row++;
			}
			
			
		}
		//写入合计
		if(dto.getUsersum()!=null&&dto.getMap().size()!=0){
			//部门名称
			addCell(0,row ,"合计");
			addCell(1,row ,"");
			//年报填报次数
			addCell(2,row  ,dto.getUsersum().getYearnum());
			//年报及时率
			addCell(3, row ,dto.getUsersum().getYeartime());
			//年报准确率
			addCell(4, row,dto.getUsersum().getYeartrue());
			//季报填报次数
			addCell(5, row ,dto.getUsersum().getQuarternum());
			//季报及时率
			addCell(6, row ,dto.getUsersum().getQuartertime());
			//季报准确率
			addCell(7, row ,dto.getUsersum().getQuartertrue());
			//不定期报表填报次数
			addCell(8,row ,dto.getUsersum().getNotimenum());
			//不定期报表及时率
			addCell(9, row ,dto.getUsersum().getNotime());
			//不定期报表准确率
			addCell(10, row ,dto.getUsersum().getNotimetrue());	
			//将合计单元格合并
			try {
				dto.getWritableSheet().mergeCells(0, dto.getStartRow()+row, 1, dto.getStartRow()+row);
			} catch (Exception e) {
				throw new BLException("");
			}
		}
		return exceldto;
	}

	public ExcelDTO initFooter(ExcelDTO exceldto) throws BLException {
		
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO exceldto) throws BLException {
		IGSMR0802ExcelDTO dto = (IGSMR0802ExcelDTO)exceldto;
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
		replaceCellContent("title", "填报质量考核（人员）");
		if(StringUtils.isEmpty(startdate)&&StringUtils.isEmpty(overdate)){
			 replaceCellContent("date", "考核周期：");
		}else{			
			replaceCellContent("date", "考核周期："+startdate+"-"+overdate);
		}
		return exceldto;
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
