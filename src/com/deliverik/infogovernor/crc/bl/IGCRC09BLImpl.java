/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

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
import com.deliverik.infogovernor.crc.dto.IGCRC09DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.dev.crc.igflow.event.status.IGCRC0401BLImpl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⴦��BLʵ��
 * </p>
 * 
 * @author ʷ����@deliverik.com
 * @version 1.0
 */
public class IGCRC09BLImpl extends BaseBLImpl implements IGCRC09BL {

	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;

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
	public IGCRC09DTO getExcelDataList(IGCRC09DTO dto) throws BLException {
		log.debug("=================ָ�ɹ���������Ӧ���ݼ���ʼ=================");
		// ��ѯ������Ϣ����
		IGWKM0101Form form = dto.getIgwkm0101form();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// ����������ͱ��
		cond.setPrpdid(form.getPrpdid());
		cond = copyPropertie(dto.getIgwkm0101form(), cond);
		// ��ѯ������Ϣ
		dto.setProcessList(workFlowOperationBL.searchProcessByType(cond, 0, 0,
				null));

		// ��ѯ����Ϣ����
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		// ����������ͱ��
		processInfoCond.setPdid(form.getPrpdid());
		// ��ѯ����Ϣ
		dto.setProcessInfoList(workFlowOperationBL
				.searchProcessInfoByCond(processInfoCond));

		// ��ѯ��������Ϣ����(����)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		// ��ѯ��������Ϣ
		dto.setProcessParticipantList(workFlowOperationBL
				.searchProcessParticipants(processParticipantCond));

		
		// ��ѯ��״̬������Ϣ����
		IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
		// ����������ͱ��
		processStatusDefCond.setPsdid_like(form.getPrpdid());
		// ��ѯ��״̬����
		dto.setProcessStatusDefList(workFlowDefinitionBL
				.searchProcessStatusDef(processStatusDefCond));
		log.debug("=================��ָ�ɹ���������Ӧ���ݼ�����=================");
		return dto;
	}
	/**
	 * ��������  
	 * @param form
	 * @param cond
	 * @return
	 */
	private IG500SearchCondImpl copyPropertie(IGWKM0101Form form, IG500SearchCondImpl cond){
		//���ƹ���������
		if(form.getPrserialnum()!=null && !(form.getPrserialnum().equals(""))){
			cond.setPrserialnum(form.getPrserialnum());
		}
		//���ƹ������Ƶ�����
		if(form.getPrtitle()!=null && !(form.getPrtitle().equals(""))){
			cond.setPrtitle(form.getPrtitle());
		}
		//���Ʋ�ѯ��ʼʱ��
		if(form.getPropentime()!=null && !(form.getPropentime().equals(""))){
			cond.setPropentime( form.getPropentime());
		}
		//���Ʋ�ѯ����ʱ��
		if(form.getPrclosetime()!=null && !(form.getPrclosetime().equals(""))){
			cond.setPrclosetime(form.getPrclosetime());
		}
		//�жϹ���״̬
		if(form.getPrstatus()!=null && !(form.getPrstatus().equals(""))){	
			cond.setPrstatus(form.getPrstatus());
		}
		//�жϷ�����
		if(form.getPrusername()!=null && !(form.getPrusername().equals(""))){
			cond.setPrusername(form.getPrusername());
		}
		//���Ʊ�����
		if(form.getVarnames()!=null && form.getVarnames().length>0){
			cond.setVarnames(form.getVarnames());
		}
		//���Ʊ�ֵ
		if(form.getVarvalues()!=null && form.getVarvalues().length>0){
			cond.setVarvalues(form.getVarvalues());
		}
		return cond;
	}
	

}
