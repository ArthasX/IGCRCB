/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: ����ҵ��ϵͳ�ʲ�����ʵ��
 * ��������: ����ҵ��ϵͳ�ʲ�����ʵ��
 * ������¼: 2012/12/27
 * �޸ļ�¼:
 */
public class IGCIM1102ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCIM1102ExcelBL {

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		
		IGCIM1102ExcelDTO exceldto = (IGCIM1102ExcelDTO) excelDTO;
		
		int num=0;
		Set<Entry<String, List<String>>> ssSet = exceldto.getTitleListMap().entrySet();
		for (Iterator<Map.Entry<String, List<String>>> ssiter = ssSet.iterator(); ssiter.hasNext();) {
			Map.Entry<String, List<String>> entry = ssiter.next();
			// ������ʼ����
			exceldto.setStartRow(0);
		    WritableSheet wsheet = excelDTO.getWritableWorkbook().createSheet(entry.getKey(), num);
		    exceldto.setWritableSheet(wsheet);
			WritableCellFormat contentformat = getStyle(Colour.BLACK);
			WritableCellFormat titleformat = getStyle(Colour.BLUE);
			// �������ݱ�ͷȡ��
			List<String> titleList = exceldto.getTitleListMap().get(entry.getKey());
			// д�������Ԫ��
			if (titleList != null && titleList.size() > 0) {
				addCell(0, 0, "���", titleformat);
				for (int i = 0; i < titleList.size(); i++) {
					addCell(i+1, 0, titleList.get(i), titleformat);
				}
			}
			// ������������ȡ��
			List<String[]> contentList = exceldto.getContentListMap().get(entry.getKey());
			// д�������Ԫ��
			if (contentList != null && contentList.size() > 0) {
				for (int i = 0; i < contentList.size(); i++) {
					//���
					addCell(0, i+1, i+1+"", contentformat);
					String[] content = contentList.get(i);
					for (int j = 0; j < content.length; j++) {
						//ֵ
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
		// �����ʽ ���� �»��� б�� ���� ��ɫ
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.AUTOMATIC);
		// ��Ԫ����
		WritableCellFormat wcf = new WritableCellFormat(wf);
			// ���õ�Ԫ��ı�����ɫ
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
	 * д�뵥Ԫ������
	 * 
	 * @param excelDto ExcelDTO
	 * @param pColumn ����
	 * @param pRow �ۼ�����
	 * @param pValue д��ֵ
	 * @param format ��Ԫ����ʽ
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
	 * ��ʼ��Excel����
	 * 
	 * @param dto Excel����ͨ��DTO
	 * @return Excel����ͨ��DTO
	 * @throws BLException
	 */
	public ExcelDTO initExcel(ExcelDTO dto) throws BLException {
	
		setExcelDTO(dto);
		IGCIM1102ExcelDTO igcim1102Dto  = (IGCIM1102ExcelDTO)dto;
		
		//�����дģ��
		WritableWorkbook writableWorkbook = null;
		try {
			//��ȡģ��
			Workbook template = getTemplate(dto);
			
			//�趨����������ļ����ͼ��ļ���
			HttpServletResponse response = dto.getResponse();
			response.reset();
            response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(igcim1102Dto.getReportTitle().getBytes("gb2312"), "ISO8859-1"));
            
			//������дģ��
			writableWorkbook = Workbook.createWorkbook(response.getOutputStream(), template);
			
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
}
