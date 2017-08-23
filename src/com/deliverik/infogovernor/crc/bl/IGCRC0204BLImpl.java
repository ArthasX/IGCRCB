/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.dto.IGCRC0204DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.dev.crc.igflow.event.status.IGCRC0401BLImpl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼�����BLʵ��
 * </p>
 * 
 * @author ʷ����@deliverik.com
 * @version 1.0
 */
public class IGCRC0204BLImpl extends BaseBLImpl implements IGCRC0204BL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ���ɸ澯��ҵ���߼�BL */
	private IgalarmBL igalarmBL;

	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** ���̴�����API */
	protected FlowOptBL flowOptBL;

	/** ������API */
	protected FlowSetBL flowSetBL;

	/** ƽ̨�û�BL */
	protected UserBL userBL;

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
	 * ���ɸ澯��ҵ���߼�BL����
	 * @param igalarmBL ���ɸ澯��ҵ���߼�BL
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
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
	 * ���̴�����API�趨
	 * 
	 * @param flowOptBL
	 *            ���̴�����API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * ������API�趨
	 * 
	 * @param flowSetBL
	 *            ������API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * ƽ̨�û�BL�趨
	 * 
	 * @param userBL
	 *            ƽ̨�û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * �����������Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC0204DTO getExcelDataList(IGCRC0204DTO dto) throws BLException {
		log.debug("=================��ȡ���������Ӧ���ݼ���ʼ=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if(StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())){
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// ��ѯ������Ϣ����
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// ����������ͱ��
		this.copyProperties(cond, form);
		
		// ��ѯ������Ϣ
		dto.setProcessList(igalarmBL.searchProcessByType(cond, 0, 0, form.getType()));

		// ��ѯ����Ϣ����
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		
		
		// ����������ͱ��
		processInfoCond.setPdid(form.getPrpdid());
		// ��ѯ����Ϣ
		dto.setProcessInfoList(workFlowOperationBL.searchProcessInfoByCond(processInfoCond));

		// ��ѯ��������Ϣ����(����)
		//IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		// ��ѯ��������Ϣ
		//dto.setProcessParticipantList(workFlowOperationBL.searchProcessParticipants(processParticipantCond));

		
		// ��ѯ��״̬������Ϣ����
		IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
		// ����������ͱ��
		processStatusDefCond.setPsdid_like(form.getPrpdid());
		// ��ѯ��״̬����
		dto.setProcessStatusDefList(workFlowDefinitionBL
				.searchProcessStatusDef(processStatusDefCond));
		log.debug("=================��ȡ���������Ӧ���ݼ�����=================");
		return dto;
	}

}
