/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ������Ϣ����
 */
public class IGSVC1301ExcelBLImpl extends ExcelBaseBLImpl implements
		IGSVC1301ExcelBL {

	public ExcelDTO initBody(ExcelDTO excelDto) throws BLException {
		IGSVC1301ExcelDTO dto = (IGSVC1301ExcelDTO)excelDto;
		dto.setStartRow(2);
		//���������������ѯ���д��excel
		for(int i=0;i<dto.getWmList().size();i++){
			WorkmanagerInfo info = dto.getWmList().get(i);
			//��������
			addCell(0, i,info.getWmname());
			//��������
			addCell(1, i,info.getWmdesc());
			//��������
			String wmfrequency = "";
			if("once".equals(info.getWmfrequency()))
				wmfrequency = "��������";
			else if("day".equals(info.getWmfrequency()))
				wmfrequency = "ÿ��";
			else if("week".equals(info.getWmfrequency()))
				wmfrequency = "ÿ��";
			else if("month".equals(info.getWmfrequency()))
				wmfrequency = "ÿ��";
			else if("quarter".equals(info.getWmfrequency()))
				wmfrequency = "ÿ����";
			else if("halfyear".equals(info.getWmfrequency()))
				wmfrequency = "ÿ����";
			else if("year".equals(info.getWmfrequency()))
				wmfrequency = "ÿ��";
			addCell(2, i, wmfrequency);
			//������
			addCell(3, i,info.getWmusername());
			//����ʱ��
			addCell(4, i,info.getWmstartdate().trim());
			//�������ʱ��
			addCell(5, i,info.getWmlimitdate().trim());
			//ʵ�����ʱ��
			addCell(6, i, info.getWmfactdate()!=null?info.getWmfactdate().trim():"");
			//��ע
			addCell(7, i, info.getWmremark());
			//���״̬
			String wmstatus = "";
			if("0".equals(info.getWmstatus()))
				wmstatus = "δ���";
			else 
				wmstatus = "�����";
			addCell(8, i, wmstatus);
			//�Ƿ�����
//			addCell(9, i,vo.getNotimetrue());			
		}
		return excelDto;
	}

	public ExcelDTO initFooter(ExcelDTO excelDto) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO excelDto) throws BLException {
//		IGSMR0801ExcelDTO dto = (IGSMR0801ExcelDTO)excelDto;
//		//�������ڿ�ʼ
//		String startdate ="";
//		//�������ڽ���
//		String overdate ="";
//		//������ʱ���ʽ�ı�
//		if(StringUtils.isNotEmpty(dto.getAssessstartdate())){
//			startdate = dto.getAssessstartdate().substring(0, 4)+"��"+dto.getAssessstartdate().substring(6, 7)+"��"+dto.getAssessstartdate().substring(9, 10)+"��";
//		}
//		if(StringUtils.isNotEmpty(dto.getAssessoverdate())){
//			overdate = dto.getAssessoverdate().substring(0, 4)+"��"+dto.getAssessoverdate().substring(6, 7)+"��"+dto.getAssessoverdate().substring(9, 10)+"��";
//		}
		replaceCellContent("title", "������Ϣ");
//		if(StringUtils.isEmpty(startdate)&&StringUtils.isEmpty(overdate)){
//			 replaceCellContent("date", "�������ڣ�");
//		}else{			
//			replaceCellContent("date", "�������ڣ�"+startdate+"-"+overdate);
//		}
		return excelDto;
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
