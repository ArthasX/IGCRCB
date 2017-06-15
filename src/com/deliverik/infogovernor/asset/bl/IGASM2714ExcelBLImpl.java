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
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.task.RiskPointVMBL;
import com.deliverik.infogovernor.asset.dto.IGASM2714ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2713Form;
import com.deliverik.infogovernor.asset.model.RiskPointVMInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskPointVMSearchCondImpl;

/**
 * @����������1.���յ��ѯ����������� 2.���յ��Զ����ѯ
 * @�����ߣ� hujuwen
 * @����ʱ�䣺2014/07/22
 * 
 * @Version V1.0
 */
public class IGASM2714ExcelBLImpl extends ExcelBaseBLImpl implements
		IGASM2714ExcelBL {

	/** ��־���� */
	private static final Log log = LogFactory
			.getLog(IGASM2714ExcelBLImpl.class);

	/** ����syscondingĬ��ֵ */
	protected static final String SYSCODE = "999017";

	/** ���յ��ѯTaskBl�ӿ� */
	protected RiskPointVMBL riskPointVMBL;
	
	protected UserBL userBL;

	public void setRiskPointVMBL(RiskPointVMBL riskPointVMBL) {
		this.riskPointVMBL = riskPointVMBL;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return null;
	}

	/**
	 * ��ȡ������Ӧ��Ϣ��дExcel�ļ����������
	 */
	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================���յ��ѯ�����������ʼ=================");
		// ʵ����DTO
		IGASM2714ExcelDTO exceldto = (IGASM2714ExcelDTO) excelDTO;
		// ������ʼ����
		exceldto.setStartRow(2);
		// ��ò�ѯ����list����
		List<RiskPointVMInfo> processList = exceldto.getProcessList();
		// д�������Ԫ��
		if (processList != null && processList.size() > 0) {
			for (int i = 0; i < processList.size(); i++) {
				// ��ȡ���̶���
				RiskPointVMInfo info = processList.get(i);
				// ����������
				addCell(0, i, info.getRiskly());
				// ����������
				addCell(1, i, info.getRiskarea());
				// ��������
				addCell(2, i, info.getRiskitem());
				// �����յ���
				addCell(3, i, info.getEilabel());
				// �����յ�����
				addCell(4, i, info.getEiname());
				// �����ռ���
				addCell(5, i, info.getLevels());
				// ���������صȼ�
				addCell(6, i, info.getGrad());
				// �����շ���������
				addCell(7, i, info.getPoss());
				// ��������
				addCell(8, i, info.getMguserid());
			}
		}

		log.debug("=================���յ��ѯ��������������=================");
		return dto;
	}

	/**
	 * ���յ��Զ����ѯ
	 * 
	 * @rerturn dto
	 */
	public IGASM27DTO searchRiskPointManagerAction(IGASM27DTO dto)
			throws BLException {

		IGASM2713Form form = dto.getIgasm2713Form();
		/** ���ղ�ѯ�����趨 */
		RiskPointVMSearchCondImpl cond = new RiskPointVMSearchCondImpl();
		cond.setEilabel(form.getEilabel());
		cond.setEiname(form.getEiname());
		cond.setStartdate(form.getStartdate());
		cond.setEnddate(form.getEnddate());
		cond.setGrad(form.getGrad());
		cond.setPoss(form.getPoss());
		cond.setRisksign(form.getRisksign());
		cond.setMguserid(form.getMguserid());
		/** �趨���շ��� */
		if (null == form.getSyscoding() || "".equals(form.getSyscoding())) {
			cond.setSyscoding(SYSCODE);
		} else {
			cond.setSyscoding(form.getSyscoding());
		}
		/** ����taskBL��ѯ */
		List<RiskPointVMInfo> riskList = riskPointVMBL.searchRiskPointVM(cond,
				0, 0);
		
		dto.setRiskList(riskList);
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		return null;
	}

}
