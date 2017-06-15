/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:����˰���Ա
 * ��������������˰���Ա
 * �����ˣ�����͢
 * ������¼�� 2013-09-04
 * �޸ļ�¼��
 */
public class IGSMR0802ExcelBLImpl extends ExcelBaseBLImpl implements
		IGSMR0802ExcelBL {

	public ExcelDTO initBody(ExcelDTO exceldto) throws BLException {
		IGSMR0802ExcelDTO dto = (IGSMR0802ExcelDTO)exceldto;
		dto.setStartRow(4);
		//���ü�ֵ����
		Set set = dto.getMap().keySet();
		//�����б���
		int row =0;
		//���������
		for(Object orgname:set){
			//���ݼ��õ�ֵ
			List<IGSMR08001VO> list = dto.getMap().get(orgname.toString());
			addCell(0,row,orgname.toString());
			int size = list.size();
			//�����ŵ�Ԫ��ϲ�
			try {
				dto.getWritableSheet().mergeCells(0, dto.getStartRow()+row, 0, dto.getStartRow()+row+size-1);
			} catch (Exception e) {
				throw new BLException("");
			}
			//��������
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
		//д��ϼ�
		if(dto.getUsersum()!=null&&dto.getMap().size()!=0){
			//��������
			addCell(0,row ,"�ϼ�");
			addCell(1,row ,"");
			//�걨�����
			addCell(2,row  ,dto.getUsersum().getYearnum());
			//�걨��ʱ��
			addCell(3, row ,dto.getUsersum().getYeartime());
			//�걨׼ȷ��
			addCell(4, row,dto.getUsersum().getYeartrue());
			//���������
			addCell(5, row ,dto.getUsersum().getQuarternum());
			//������ʱ��
			addCell(6, row ,dto.getUsersum().getQuartertime());
			//����׼ȷ��
			addCell(7, row ,dto.getUsersum().getQuartertrue());
			//�����ڱ��������
			addCell(8,row ,dto.getUsersum().getNotimenum());
			//�����ڱ���ʱ��
			addCell(9, row ,dto.getUsersum().getNotime());
			//�����ڱ���׼ȷ��
			addCell(10, row ,dto.getUsersum().getNotimetrue());	
			//���ϼƵ�Ԫ��ϲ�
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
		//�������ڿ�ʼ
		String startdate ="";
		//�������ڽ���
		String overdate ="";
		//������ʱ���ʽ�ı�
		if(StringUtils.isNotEmpty(dto.getAssessstartdate())){
			startdate = dto.getAssessstartdate().substring(0, 4)+"��"+dto.getAssessstartdate().substring(6, 7)+"��"+dto.getAssessstartdate().substring(9, 10)+"��";
		}
		if(StringUtils.isNotEmpty(dto.getAssessoverdate())){
			overdate = dto.getAssessoverdate().substring(0, 4)+"��"+dto.getAssessoverdate().substring(6, 7)+"��"+dto.getAssessoverdate().substring(9, 10)+"��";
		}
		replaceCellContent("title", "��������ˣ���Ա��");
		if(StringUtils.isEmpty(startdate)&&StringUtils.isEmpty(overdate)){
			 replaceCellContent("date", "�������ڣ�");
		}else{			
			replaceCellContent("date", "�������ڣ�"+startdate+"-"+overdate);
		}
		return exceldto;
	}
    /**
     * ������ɫ����
     * 
     * @return wcf
     */
	protected void addCell(int pColumn, int pRow, String pValue)	
			throws BLException {

		// �����ʽ ���� �»��� б�� ���� ��ɫ
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE);
		// ��Ԫ����
		WritableCellFormat wcf = new WritableCellFormat(wf);
		try {
			// ���õ�Ԫ��ı�����ɫ
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
