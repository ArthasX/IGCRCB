/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.crc.dto.IGCRC30DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������BLʵ��
 * </p>
 * 
 * @author zhangxinru
 */
public class IGCRC30BLImpl extends BaseBLImpl implements IGCRC30BL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC30BLImpl.class);

	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	

	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;



	/**
	 * ���̴���BL�趨
	 * 
	 * @param workFlowOperationBL
	 *            ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	
	/**
	 * ���̶���BL�趨
	 * 
	 * @param workFlowDefinitionBL
	 *            ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(
			WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}


	/**
	 * ��������������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC30DTO getExcelDataList(IGCRC30DTO dto) throws BLException {
		log.debug("=================��ȡ������������Ӧ���ݼ���ʼ=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if (StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())) {
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// ��ѯ������Ϣ����
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// �������������ͱ��
		cond.setPrpdid(form.getPrpdid());
		this.copyProperties(cond,dto.getIgwkm0101form());
		// ��ѯ������Ϣ
		dto.setProcessList(workFlowOperationBL.searchProcessByType(cond, 0, 0, form.getType()));

		// ��ѯ����Ϣ����
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		// ����������ͱ��
		processInfoCond.setPdid(form.getPrpdid());
		// ��ѯ����Ϣ
		dto.setProcessInfoList(workFlowOperationBL.searchProcessInfoByCond(processInfoCond));

		// ��ѯ��������Ϣ����(����)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		// ��ѯ��������Ϣ
		dto.setProcessParticipantList(workFlowOperationBL.searchProcessParticipants(processParticipantCond));

		// ��ѯ��״̬������Ϣ����
		IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
		// ����������ͱ��
		processStatusDefCond.setPsdid_like(form.getPrpdid());
		// ��ѯ��״̬����
		dto.setProcessStatusDefList(workFlowDefinitionBL.searchProcessStatusDef(processStatusDefCond));
		log.debug("=================��ȡ������������Ӧ���ݼ�����=================");
		return dto;
	}

}
