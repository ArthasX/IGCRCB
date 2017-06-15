/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.HashMap;
import java.util.Map;

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
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.crc.dto.IGCRC10DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1005Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.dev.crc.igflow.event.status.IGCRC0401BLImpl;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���򿪷�������BLʵ��
 * </p>
 * 
 * @author ʷ����
 * @version 1.0
 */
public class IGCRC10BLImpl extends BaseBLImpl implements IGCRC10BL {

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
	public IGCRC10DTO getExcelDataList(IGCRC10DTO dto) throws BLException {
		log.debug("=================��ȡ���򿪷�������Ӧ���ݼ���ʼ=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if(StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())){
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// ��ѯ������Ϣ����
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// ����������ͱ��
		cond.setPrpdid(form.getPrpdid());
		cond = copyPropertie(dto.getIgwkm0101form(), cond);
		// ��ѯ������Ϣ
		dto.setProcessList(workFlowOperationBL.searchProcessByType(cond, 0, 0,form.getType()));
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
		log.debug("=================��ȡ���򿪷�������Ӧ���ݼ�����=================");
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
	
	/**
	 * ��������Ϣȡ�ò���
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC10DTO getParentProcessInfoAction(IGCRC10DTO dto) throws BLException {
		log.debug("===============��������Ϣȡ�ò�����ʼ================");
		if(dto.getForm() != null && dto.getForm() instanceof IGCRC1005Form){
			IGCRC1005Form form = (IGCRC1005Form) dto.getForm();
			IG500Info info = workFlowOperationBL.searchProcessRecordByKey(form.getParprid());
			Map<String, String> map = new HashMap<String, String>();
			if(info.getPrpdname().indexOf("ҵ���������") >= 0){
				map.put("prtitle", info.getPrtitle());
				map.put("prdesc", info.getPrdesc());
				map.put("type", "success");
			}else{
				map.put("type", "other");
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(map));
		}
		log.debug("===============��������Ϣȡ�ò�������================");
		return dto;
	}
}
