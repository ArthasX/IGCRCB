/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM0422ExcelDTO;
/**
 * 
 * ����: ��ͬӦ�������ʵ��
 * ��������: ��ͬӦ�������ʵ��
 * ������¼: 2012/04/11
 * �޸ļ�¼:
 */
public class IGASM0422ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM0422ExcelBL {

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {

		IGASM0422ExcelDTO exceldto = (IGASM0422ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);

		// ������������ȡ��
		List<IG499Info> reportDataList = exceldto.getReportDataList();
		// д�������Ԫ��
		if (reportDataList != null && reportDataList.size() > 0) {
			for (int i = 0; i < reportDataList.size(); i++) {
				//��ǰ��ͬӦ�������ȡ��
				IG499Info info=reportDataList.get(i);
				
				//��ͬ���
				addCell(0, i, info.getEilabel());
				//��ͬ����
				addCell(1, i, info.getEiname());
				//��ͬ����
				addCell(2, i, info.getCompacttype());
				//����������(�Զ���ȡ)
				if(StringUtils.isNotEmpty(info.getFacilitator())){
					int temp = info.getFacilitator().indexOf("(");
					if(temp<0){
						temp = info.getFacilitator().length();
					}
					addCell(3, i, info.getFacilitator().substring(0, temp));
				}else{
					addCell(3, i,"");
				}
				//��ͬ��
				addCell(4, i, info.getContractpayment()==null?"0":info.getContractpayment());
				//�Ѹ���
				addCell(5, i, info.getCountmoney()==null?"0":info.getCountmoney());
				//����Ӧ����
				addCell(6, i, info.getImprest()==null?"0":info.getImprest());
				//������ʱδ����
				BigDecimal sumMoney = new BigDecimal("0");
				//�жϺ�ͬ���ǲ���Ϊ��
				if(StringUtils.isNotEmpty(info.getContractpayment())){
					//�ж��Ѹ����ǲ���Ϊ��
					if(StringUtils.isNotEmpty(info.getCountmoney())){
						//���㻹�ж��ٿ�û����
						sumMoney=BigDecimal.valueOf(Double.parseDouble(info.getContractpayment())).subtract(BigDecimal.valueOf(Double.parseDouble(info.getCountmoney())));
					}else{
						//���Ѹ���Ϊ�յ�ʱ��ֱ����ʾ��ͬ��
						sumMoney=BigDecimal.valueOf(Double.parseDouble(info.getContractpayment()));
					}
					
				}
				NumberFormat nf=NumberFormat.getInstance();
				//δ����
				addCell(7, i, nf.format(sumMoney));
			}
		}
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return dto;
	}

}
