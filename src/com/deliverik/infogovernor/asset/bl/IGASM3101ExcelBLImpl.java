/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.dto.IGASM3101ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3101Form;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;

/**
 * @����������1.����ָ���ѯ����������� 2.����ָ���Զ����ѯ
 * @�����ߣ� hujuwen
 * @����ʱ�䣺2014/07/26
 * 
 * @Version V1.0
 */
public class IGASM3101ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM3101ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory
			.getLog(IGASM3101ExcelBLImpl.class);

	/** ����syscondingĬ��ֵ */
	protected static final String SYSCODE = "999019";

	/**����ָ���ѯ*/
	protected RiskIndexSearchVWBL riskIndexSearchVWBL;
	

	public void setRiskIndexSearchVWBL(RiskIndexSearchVWBL riskIndexSearchVWBL) {
		this.riskIndexSearchVWBL = riskIndexSearchVWBL;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================����ָ���ѯ�����������ʼ=================");
		// ʵ����DTO
		IGASM3101ExcelDTO exceldto = (IGASM3101ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ò�ѯ����list����
		List<RiskIndexSearchVWInfo> processList = exceldto.getProcessList();
		// д�������Ԫ��
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// ��ȡ���̶���
				RiskIndexSearchVWInfo info = processList.get(i);
				// ����������
				addCell(0, i, info.getRiskly());
				// ��������
				addCell(1, i, info.getRiskarea());
				// ��������
				addCell(2, i, info.getRiskitem());
				// ���ָ����
				addCell(3, i, info.getEilabel());
				// ���ָ������
				addCell(4, i, info.getEiname());
				// ���ָ����;
				addCell(5, i, info.getIndexused());
				// ��䷧ֵ
				addCell(6, i, info.getZbfz());
				// ����Ƿ�ؼ�ָ��
				addCell(7, i, info.getKeyindex());
				// ���ָ�������
				addCell(8, i, info.getMgusername());
				// ���ָ�����β���
				addCell(9, i, info.getDutydepartment());
				// ���ָ��������
				addCell(10, i, info.getDutyuser());
			}
		}
		log.debug("=================����ָ���ѯ��������������=================");
		return dto;
	}

	/**
	 * ����ָ���Զ����ѯ
	 * 
	 * @rerturn dto
	 */
	public IGASM31DTO searchRiskPointManagerAction(IGASM31DTO dto)
			throws BLException {

		IGASM3101Form form = dto.getIGASM3101FORM();
		/** ����ָ���ѯ�����趨 */
		RiskIndexSearchVWSearchCondImpl cond  = new RiskIndexSearchVWSearchCondImpl();
		
		cond.setEiname(form.getEiname());//ָ������
		cond.setEilabel(form.getEilabel());//ָ����
		cond.setIndexused(form.getIndexused());//ָ����;
		cond.setZbfz(form.getZbfz());//��ֵ
		cond.setDutyuser(form.getDutyuser());//ָ��������
		cond.setDutydepartment(form.getDutydepartment());//ָ�����β���
		cond.setKeyindex(form.getKeyindex());//�Ƿ�ؼ�ָ��
		cond.setMguserid(form.getMguserid());//ָ�������
		cond.setEiStartDate(form.getEiStartDate());//�Ǽ����ڿ�ʼ
		cond.setEiEndDate(form.getEiEndDate());//�Ǽ����ڽ���
		cond.setEuStartDate(form.getEuStartDate());//�������ڿ�ʼ
		cond.setEuEndDate(form.getEuEndDate());//�������ڽ���
		/**�趨���շ��� syscoding��*/
		if(null==form.getEsyscoding()||"".equals(form.getEsyscoding())){
			cond.setSyscoding(SYSCODE);
		}else{
			cond.setSyscoding(form.getEsyscoding());
		}
		/** ����taskBL��ѯ */
		List<RiskIndexSearchVWInfo> searchRiskIndexSearchVWList = riskIndexSearchVWBL.searchRiskIndexSearchVW(cond, 0, 0);
		dto.setSearchRiskIndexSearchVWList(searchRiskIndexSearchVWList);
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
