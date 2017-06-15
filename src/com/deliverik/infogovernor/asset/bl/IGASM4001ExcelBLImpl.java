/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM41ExcelDTO;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�Ƶ���
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGASM4001ExcelBLImpl extends ExcelBaseBLImpl  implements IGASM4001ExcelBL {
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGASM4001ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================���ռ��ͳ�Ƶ�����ʼ=================");
		IGASM41ExcelDTO exceldto = (IGASM41ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		try {
			// ��ȡ��������
			int i = 0;  //�к�
			int risklyRowNum = 0;  //��������(��һ��ר��)
			int riskareaRowNum = 0;  //��������(�ڶ���ר��)
			int riskitemRowNum = 0;  //��������(������ר��)
			int totalRowNum = 0;  //key��������
			String tempRiskly=null;//��������(��������)��ʱ����
			String tempRiskarea=null;//��������(��������)��ʱ����
			Map<List<RiskVWInfo>, List<CheckVWInfo>> map = exceldto.getRiskCheckMap();
			//���key��������
			for(List<RiskVWInfo> riskList:map.keySet()){
				for(@SuppressWarnings("unused") RiskVWInfo risk:riskList){
					totalRowNum++;
				}
			}
			//��excel�в��뵥Ԫ��
			for(Entry<List<RiskVWInfo>, List<CheckVWInfo>> entry: map.entrySet()){
				for(int j=0;j<entry.getKey().size();j++){
					RiskVWInfo risk=entry.getKey().get(j);
					// ��������(һ������)
					addCell(0, i, risk.getRiskly());
					// ��������(��������)
					addCell(1, i, risk.getRiskarea());
					// ������
					addCell(2, i, risk.getRiskitem());
					// ���յ�(����)
					addCell(3, i, risk.getEiname());
					// ���صȼ�
					addCell(4, i, risk.getGrad());
					// ����������
					addCell(5, i, risk.getPoss());
					// ���ռ���
					addCell(6, i, risk.getLevels());
					// ���յ��־
					addCell(7, i, risk.getRisksign());
					
					//��һ�кϲ��ж�
					if(risklyRowNum == 0){
						tempRiskly = risk.getRiskly();
						risklyRowNum++;
					}else{
						//����һ��������ͬʱ�ϲ�
						if(tempRiskly.equals(risk.getRiskly())){
							risklyRowNum++;
							//���һ���ϲ�
							if(totalRowNum==i+1){
								dto.getWritableSheet().mergeCells(0,dto.getStartRow()+i-risklyRowNum+1,0, dto.getStartRow() + i);
							}
						}else{
							dto.getWritableSheet().mergeCells(0,dto.getStartRow()+i-risklyRowNum,0, dto.getStartRow() + i-1);
							tempRiskly = risk.getRiskly();
							risklyRowNum = 1;
						}
					}
					
					//�ڶ��кϲ��ж�
					if(riskareaRowNum == 0){
						tempRiskarea = risk.getRiskarea();
						riskareaRowNum++;
					}else{
						//����һ��������ͬʱ�ϲ�
						if(tempRiskarea.equals(risk.getRiskarea())){
							riskareaRowNum++;
							//���һ���ϲ�
							if(totalRowNum==i+1){
								dto.getWritableSheet().mergeCells(1,dto.getStartRow()+i-riskareaRowNum+1,1, dto.getStartRow() + i);
							}
						}else{
							dto.getWritableSheet().mergeCells(1,dto.getStartRow()+i-riskareaRowNum,1, dto.getStartRow() + i-1);
							tempRiskarea = risk.getRiskarea();
							riskareaRowNum = 1;
						}
					}
					/**
					 * ���鷽������Ƶ���в��뵥Ԫ��,ֻ�ڱ�����ÿ��Key(list)�ĵ�һ������ʱ������ֵ,
					 * ������ֵ,Ȼ��ϲ���Ԫ��
					 */
					if(j==0){
						//��鷽����
						StringBuffer checkMethod= new StringBuffer();
						//���Ƶ�ʴ�
						StringBuffer checkFrequency= new StringBuffer();
						if(entry.getValue()!=null){
							for(CheckVWInfo check:entry.getValue()){
								checkMethod.append(check.getCheckMethod()+"\n");
								checkFrequency.append(check.getCheckfrequency()+"\n");
							}
						}
						// ��鷽��
						if(StringUtils.isNotEmpty(checkMethod.toString())){
							addCell(8, i, checkMethod.toString());
						}else{
							addCell(8, i, "");
						}
						//���Ƶ��
						if(StringUtils.isNotEmpty(checkFrequency.toString())){
							addCell(9, i, checkFrequency.toString());
						}else{
							addCell(9, i, "");
						}
					}else{
						addCell(8, i, "");
						addCell(9, i, "");
					}
					/**
					 * ���key(list)����Ӧ��value(list)��������key(list)��������,
					 * ��key(list)��ÿһ�����и߼�һ���߶�,�Ա�value(list)����excel��ȫ����ʾ����
					 */
					if(entry.getValue()!=null){
						if(entry.getValue().size()>entry.getKey().size()){
							double distance = (entry.getValue().size()-entry.getKey().size())*270/entry.getKey().size();
							dto.getWritableSheet().setRowView(i+2, 280+(int)Math.floor(distance));
						}
					}
					i++;
				}
				//�ϲ�������
				dto.getWritableSheet().mergeCells(2,dto.getStartRow() + riskitemRowNum,2, dto.getStartRow() + riskitemRowNum + entry.getKey().size() - 1);
				//�ϲ��ھ���
				dto.getWritableSheet().mergeCells(8,dto.getStartRow() + riskitemRowNum,8, dto.getStartRow() + riskitemRowNum + entry.getKey().size() - 1);
				//�ϲ���ʮ��
				dto.getWritableSheet().mergeCells(9,dto.getStartRow() + riskitemRowNum,9, dto.getStartRow() + riskitemRowNum + entry.getKey().size() - 1);
				riskitemRowNum = riskitemRowNum + entry.getKey().size(); 
			}
			//�ϲ���һ��
			//dto.getWritableSheet().mergeCells(0,dto.getStartRow(),0, dto.getStartRow() + i-1);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
		log.debug("=================���ռ��ͳ�Ƶ�������=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

}
