/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ����:����˵���
 * ��������������˵���
 * �����ˣ�����͢
 * ������¼�� 2013-09-03
 * �޸ļ�¼��
 */
public class IGSMR0801ExcelBLImpl extends ExcelBaseBLImpl implements
		IGSMR0801ExcelBL {

	public ExcelDTO initBody(ExcelDTO excelDto) throws BLException {
		IGSMR0801ExcelDTO dto = (IGSMR0801ExcelDTO)excelDto;
		dto.setStartRow(4);
		//���������������ѯ���д��excel
		for(int i=0;i<dto.getList().size();i++){
			IGSMR08001VO vo = dto.getList().get(i);
			//��������
			addCell(0, i,vo.getOrgname());
			//�걨�����
			addCell(1, i,vo.getYearnum());
			//�걨��ʱ��
			addCell(2, i,vo.getYeartime());
			//�걨׼ȷ��
			addCell(3, i,vo.getYeartrue());
			//���������
			addCell(4, i,vo.getQuarternum());
			//������ʱ��
			addCell(5, i,vo.getQuartertime());
			//����׼ȷ��
			addCell(6, i,vo.getQuartertrue());
			//�����ڱ��������
			addCell(7, i,vo.getNotimenum());
			//�����ڱ���ʱ��
			addCell(8, i,vo.getNotime());
			//�����ڱ���׼ȷ��
			addCell(9, i,vo.getNotimetrue());			
		}
		//д��ϼ�
		if(dto.getOrgsum()!=null&&dto.getList().size()!=0){
			//��������
			addCell(0,dto.getList().size() ,"�ϼ�");
			//�걨�����
			addCell(1, dto.getList().size() ,dto.getOrgsum().getYearnum());
			//�걨��ʱ��
			addCell(2, dto.getList().size() ,dto.getOrgsum().getYeartime());
			//�걨׼ȷ��
			addCell(3, dto.getList().size(),dto.getOrgsum().getYeartrue());
			//���������
			addCell(4, dto.getList().size() ,dto.getOrgsum().getQuarternum());
			//������ʱ��
			addCell(5, dto.getList().size() ,dto.getOrgsum().getQuartertime());
			//����׼ȷ��
			addCell(6, dto.getList().size() ,dto.getOrgsum().getQuartertrue());
			//�����ڱ��������
			addCell(7, dto.getList().size() ,dto.getOrgsum().getNotimenum());
			//�����ڱ���ʱ��
			addCell(8, dto.getList().size() ,dto.getOrgsum().getNotime());
			//�����ڱ���׼ȷ��
			addCell(9, dto.getList().size() ,dto.getOrgsum().getNotimetrue());			
		}
		return excelDto;
	}

	public ExcelDTO initFooter(ExcelDTO excelDto) throws BLException {
		return null;
	}

	public ExcelDTO initHeader(ExcelDTO excelDto) throws BLException {
		IGSMR0801ExcelDTO dto = (IGSMR0801ExcelDTO)excelDto;
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
		replaceCellContent("title", "��������ˣ����ţ�");
		if(StringUtils.isEmpty(startdate)&&StringUtils.isEmpty(overdate)){
			 replaceCellContent("date", "�������ڣ�");
		}else{			
			replaceCellContent("date", "�������ڣ�"+startdate+"-"+overdate);
		}
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
