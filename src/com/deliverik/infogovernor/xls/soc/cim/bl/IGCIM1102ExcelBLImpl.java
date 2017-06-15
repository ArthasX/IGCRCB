/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.soc.cim.bl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.xls.soc.cim.dto.IGCIM1102ExcelDTO;
/**
 * 
 * 概述: 阜新业务系统资产导出实现
 * 功能描述: 阜新业务系统资产导出实现
 * 创建记录: 2012/12/27
 * 修改记录:
 */
public class IGCIM1102ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCIM1102ExcelBL {

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		
		IGCIM1102ExcelDTO exceldto = (IGCIM1102ExcelDTO) excelDTO;
		
		int num=0;
		Set<Entry<String, List<String>>> ssSet = exceldto.getTitleListMap().entrySet();
		for (Iterator<Map.Entry<String, List<String>>> ssiter = ssSet.iterator(); ssiter.hasNext();) {
			Map.Entry<String, List<String>> entry = ssiter.next();
			// 设置起始行数
			exceldto.setStartRow(0);
		    WritableSheet wsheet = excelDTO.getWritableWorkbook().createSheet(entry.getKey(), num);
		    exceldto.setWritableSheet(wsheet);
			WritableCellFormat contentformat = getStyle(Colour.BLACK);
			WritableCellFormat titleformat = getStyle(Colour.BLUE);
			// 报表数据表头取得
			List<String> titleList = exceldto.getTitleListMap().get(entry.getKey());
			// 写入各个单元格
			if (titleList != null && titleList.size() > 0) {
				addCell(0, 0, "序号", titleformat);
				for (int i = 0; i < titleList.size(); i++) {
					addCell(i+1, 0, titleList.get(i), titleformat);
				}
			}
			// 报表数据内容取得
			List<String[]> contentList = exceldto.getContentListMap().get(entry.getKey());
			// 写入各个单元格
			if (contentList != null && contentList.size() > 0) {
				for (int i = 0; i < contentList.size(); i++) {
					//序号
					addCell(0, i+1, i+1+"", contentformat);
					String[] content = contentList.get(i);
					for (int j = 0; j < content.length; j++) {
						//值
						addCell(j+1, i+1, content[j], contentformat);
					}
				}
			}
			num++;
		}
		return dto;
	}
	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return dto;
	}
	
	public WritableCellFormat getStyle(Colour colour){
		// 定义格式 字体 下划线 斜体 粗体 颜色
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.AUTOMATIC);
		// 单元格定义
		WritableCellFormat wcf = new WritableCellFormat(wf);
			// 设置单元格的背景颜色
			try {
				wcf.setBackground(colour);
				wcf.setAlignment(Alignment.RIGHT);
				wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
				wcf.setBorder(Border.ALL, BorderLineStyle.THIN);
			} catch (WriteException e) {
				e.printStackTrace();
			}
		return wcf;
	}
	/**
	 * 写入单元格内容
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn 列数
	 * @param pRow 累加行数
	 * @param pValue 写入值
	 * @param format 单元格样式
	 */
	protected void addCell(int pColumn, int pRow, String pValue, CellFormat format) 
	throws BLException{
		
		WritableSheet wsheet = excelDTO.getWritableSheet();
		
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
	 * 初始化Excel内容
	 * 
	 * @param dto Excel导出通用DTO
	 * @return Excel导出通用DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException {
	
		setExcelDTO(dto);
		IGCIM1102ExcelDTO igcim1102Dto  = (IGCIM1102ExcelDTO)dto;
		
		//定义可写模版
		WritableWorkbook writableWorkbook = null;
		try {
			//获取模版
			Workbook template = getTemplate(dto);
			
			//设定导出报表的文件类型及文件名
			HttpServletResponse response = dto.getResponse();
			response.reset();
            response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(igcim1102Dto.getReportTitle().getBytes("gb2312"), "ISO8859-1"));
            
			//创建可写模版
			writableWorkbook = Workbook.createWorkbook(response.getOutputStream(), template);
			
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
}
