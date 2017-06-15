/*	
 * ��������������������޹�˾��Ȩ���У���������Ȩ����	
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.crc.dto.IGCRC02ExcelDTO;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;

/**
 * ����:�¼����������BL 
 * ������¼��ʷ���� 2014/07/20
 */
public class IGCRC0203ExcelBLImpl extends ExcelBaseBLImpl implements
		IGCRC0203ExcelBL {
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC0204ExcelBLImpl.class);

	/** ���̲���BL */
	private WorkFlowOperationBL workFlowOperationBL ;
	
	/**
	 * ���̲���BL�趨
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================�¼���������ʼ=================");
		log.debug("=================�����ύͳ�Ƶ�����ʼ=================");
		IGCRC02ExcelDTO exceldto = (IGCRC02ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		//��ȡ��������
		List<IgalarmInfo> igcrc0203voList = exceldto.getIgalarmInfos();
		
		for(int i=0;i<igcrc0203voList.size();i++){
			//��ȡ���̶���
			IgalarmInfo info = igcrc0203voList.get(i);
			//�¼������
			addCell(0, i, info.getPedeventid());
			if(StringUtils.isNotEmpty(info.getPedeventid())){
				IG500Info ig500Info = workFlowOperationBL.searchProcessRecordBySerialnum(info.getPedeventid());
				//��������
				addCell(1, i, ig500Info.getPrtitle());
			}

			//�澯���
			addCell(2, i, info.getSerial());
			//��������
			addCell(3, i, info.getAppname());
			//IP����
			addCell(4, i, info.getIpaddr());
			//ʱ������
			addCell(5, i, info.getSummary());
			//������ϵ��
			addCell(6, i, info.getFaultContact());
			//����ʱ��
			addCell(7, i, info.getLasttime());
			//�ָ�ʱ��
			addCell(8, i, info.getRecoveryTime());
			//�Ƿ����ɹ���
			if(StringUtils.isNotEmpty(info.getIsCreateOrder())){
				if("0".equals(info.getIsCreateOrder())){
					addCell(9, i, "��");
				}else if("1".equals(info.getIsCreateOrder())){
					addCell(9, i, "��");
				}
			}
			//״̬
			if(StringUtils.isNotEmpty(info.getStatus())){
				if("0".equals(info.getStatus())){
					addCell(10, i, "�澯");
				}else if("1".equals(info.getStatus())){
					addCell(10, i, "�ָ�");
				}else if("2".equals(info.getStatus())){
					addCell(10, i, "�ر�");
				}
			}
			//����
			addCell(11, i, info.getDescription());
		}
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
