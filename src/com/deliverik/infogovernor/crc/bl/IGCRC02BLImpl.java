/*
 * ���������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.form.IGCRC0204Form;
import com.deliverik.infogovernor.crc.model.IGCRC0208VWInfo;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.crc.model.entity.IGCRC0208VW;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.dev.crc.igflow.event.status.IGCRC0401BLImpl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */
public class IGCRC02BLImpl extends BaseBLImpl implements  IGCRC02BL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}
	public WorkFlowDefinitionBL getWorkFlowDefinitionBL() {
		return workFlowDefinitionBL;
	}

	/** ���̴�����API */
	protected FlowOptBL flowOptBL;
	
	/** ������API */
	protected FlowSetBL flowSetBL;
	
	protected FlowSearchBL flowSearchBL;
	
	/** ���ɸ澯��ҵ���߼�BL */
	private IgalarmBL igalarmBL;
	
	/**
	 * ���ɸ澯��ҵ���߼�BL����
	 * @param igalarmBL ���ɸ澯��ҵ���߼�BL
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}
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
	 * @param flowSearchBL the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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
	/** ƽ̨�û�BL */
	protected UserBL userBL;
	public UserBL getUserBL() {
		return userBL;
	}
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	/***
	 * ͨ��dto������ѯ��������ѯ
	 * �����������ƣ�IP��ַ������ʱ�䣬�ָ�ʱ�������ѯ
	 * @param dto
	 */
	public void serachIgalarmSortList(IGCRC02DTO dto) {
		//���ɸ澯����������
		IgalarmSearchCondImpl alarmSearchCond =  new IgalarmSearchCondImpl(dto.getForm());
		//�ж���Ҫ���ĸ��ֶ����򣬲�������ֶ�����Ϊ��
		//��������
		if("appname".equals(dto.getForm().getType())){
			alarmSearchCond.setAppnamestatus(dto.getForm().getAppnamestatus());
			dto.getForm().setIpaddrstatus("");
			dto.getForm().setLasttimestatus("");
			dto.getForm().setRecoverytimestatus("");
		}
		//ip��ַ
		if("ipaddr".equals(dto.getForm().getType())){
			alarmSearchCond.setIpaddrstatus(dto.getForm().getIpaddrstatus());
			dto.getForm().setAppnamestatus("");
			dto.getForm().setLasttimestatus("");
			dto.getForm().setRecoverytimestatus("");
		}
		//����ʱ��
		if("lasttime".equals(dto.getForm().getType())){
			alarmSearchCond.setLasttimestatus(dto.getForm().getLasttimestatus());
			dto.getForm().setAppnamestatus("");
			dto.getForm().setIpaddrstatus("");
			dto.getForm().setRecoverytimestatus("");
		}
		//�ָ�ʱ��
		if("recoverytime".equals(dto.getForm().getType())){
			alarmSearchCond.setRecoverytimestatus(dto.getForm().getRecoverytimestatus());
			dto.getForm().setAppnamestatus("");
			dto.getForm().setIpaddrstatus("");
			dto.getForm().setLasttimestatus("");
		}
		
		dto.setIgalarmInfos(igalarmBL.searchIgalarmNoSort(alarmSearchCond, 0,0));
//		dto.setIgalarmInfos(igalarmBL.searchIgalarm(alarmSearchCond, 0,0));
//		dto.getPagingDTO().setTotalCount(igalarmBL.getSearchCount(alarmSearchCond));
		
	}
	
	/***
	 * ͨ��dto������ѯ��������ѯ
	 * @param dto
	 */
	public void serachIgalarmList(IGCRC02DTO dto) {
		//���ɸ澯����������
		IgalarmSearchCondImpl alarmSearchCond =  new IgalarmSearchCondImpl(dto.getForm());
		dto.setIgalarmInfos(igalarmBL.searchIgalarm(alarmSearchCond, 0,0));
//		dto.getPagingDTO().setTotalCount(igalarmBL.getSearchCount(alarmSearchCond));
		
	}
	
	
	/***
	 * ͨ��id�� ��ѯ�澯��Ϣ
	 * @param alarmIds
	 * @return
	 */
	public List<IgalarmInfo> serachByAlarmIds(String[] alarmIds) {
		//���ɸ澯����������
		IgalarmSearchCondImpl alarmSearchCond =  new IgalarmSearchCondImpl();
		alarmSearchCond.setAlarmIds(alarmIds);
		return igalarmBL.searchIgalarm(alarmSearchCond);
	}

	public IGCRC02DTO getExcelDataList(IGCRC02DTO dto) throws BLException {
		log.debug("=================��ȡ�¼�������Ӧ���ݼ���ʼ=================");
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
		dto.setProcessList(igalarmBL.searchProcessByType(cond, 0, 0,null));

		// ��ѯ������Ϣ����
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		// ����������ͱ��
		processInfoCond.setPdid(form.getPrpdid());
		// ��ѯ������Ϣ
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
		log.debug("=================��ȡ�¼�������Ӧ���ݼ�����=================");
		return dto;
	}
	
	/**	
	 * ���ܣ�ͨ��id ��ѯ�澯��Ϣ
	 * @param id
	 * @return �澯��Ϣ
	 * �޸ļ�¼��null
	 * @throws BLException 
	 */	
	public IGCRC02DTO searchIgalarmByPK(IGCRC02DTO dto) throws BLException {
		IgalarmInfo igalarmInfo = igalarmBL.searchIgalarmByPK(dto.getIgcrc0204Form().getPk());
		dto.setIgalarmInfo(igalarmInfo);
		return dto;
	}
	
	/**	
	 * ���ܣ����ݸ澯id����
	 * @param form�еĸ澯����
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null
	 */	
	public IGCRC02DTO updateIgalarmByForm(IGCRC02DTO dto) throws BLException {
		IgalarmTB igalarmTB = new IgalarmTB();
		IGCRC0204Form form = dto.getIgcrc0204Form();
		igalarmTB.setPk(form.getPk());
		igalarmTB.setSerial(form.getSerial());
		igalarmTB.setAppname(form.getAppname());
		igalarmTB.setIpaddr(form.getIpaddr());
		igalarmTB.setSummary(form.getSummary());
		igalarmTB.setLasttime(form.getLasttime());
		igalarmTB.setStatus(form.getStatus());
		igalarmTB.setPedeventid(form.getPedeventid());
		igalarmTB.setRecoveryTime(form.getRecoveryTime());
		igalarmTB.setDescription(form.getDescription());
		igalarmTB.setIsCreateOrder(form.getIsCreateOrder());
		igalarmTB.setFaultContact(form.getFaultContact());
		igalarmTB.setIsShow(form.getIsShow());
		IgalarmInfo igalarmInfo = igalarmBL.updateIgalarm((IgalarmInfo)igalarmTB);
		dto.setIgalarmInfo(igalarmInfo);
		return dto;
	}
	/**	
	 * ���ܣ����ݸ澯idɾ��
	 * @param dto
	 * @throws BLException
	 * �޸ļ�¼��null
	 */	
	public void deleteIgalarmByPK(IGCRC02DTO dto) throws BLException {
		igalarmBL.deleteIgalarmByPK(dto.getIgcrc0204Form().getPk());
	}
	
	/**	
	 * ���ܣ����ݸ澯id����
	 * @param �澯����
	 * @return
	 * @throws BLException
	 * �޸ļ�¼��null 	
	 */	
	public IGCRC02DTO updateIgalarmByIgalarm(IGCRC02DTO dto) throws BLException {
		IgalarmInfo igalarmInfo = igalarmBL.updateIgalarm(dto.getIgalarmInfo());
		dto.setIgalarmInfo(igalarmInfo);
		
		Map<String, ProcessInfoDefinitionInfo> def = flowSearchBL.searchProcessTableColumnDef(dto.getIgcrc0204Form().getPrcorid());
		//��ѯ�������ݱ���ʽ����ֵ
		Object obj = flowSearchBL.searchPublicTableValue("�澯��Ϣ",dto.getIgcrc0204Form().getPrcorid(), null);
		//����ֵ�ṹ����һ��--ÿһ�������µķ��յ�ͼ����ڶ��㣬���嵽���յ�������ڲ�ֵ
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) obj;
		

		flowSetBL.setPublicTableColumnValue(def, "�澯��Ϣ#�澯ID", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getSerial());
		flowSetBL.setPublicTableColumnValue(def, "�澯��Ϣ#�¼�����", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getSummary());
		flowSetBL.setPublicTableColumnValue(def, "�澯��Ϣ#����ʱ��", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getLasttime());
		flowSetBL.setPublicTableColumnValue(def, "�澯��Ϣ#�ָ�ʱ��", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getRecoveryTime());

		return dto;
	}
	
	/**
	 *�澯�¼���ѯ
	 */
	public IGCRC02DTO getProcessRecords(IGCRC02DTO dto) throws BLException {
		log.debug("========��ѯ������¼������ʼ========");
		// ��ѯ��¼����
		int totalCount = igalarmBL.searchProcessCount(dto.getPrSearchCond(), dto.getType());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			this.getProcessTemplate(dto);
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			this.getProcessTemplate(dto);
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		// ����DAO�ӿڲ�ѯ
		List<IGCRC0208VWInfo> prList = igalarmBL.searchProcessByType(dto.getPrSearchCond(), pDto.getFromCount(), pDto.getPageDispCount(),dto.getType());
		List<IGCRC0208VWInfo> newPrList = new ArrayList<IGCRC0208VWInfo>();
		String typeString = "";
		int length = 0;
		for (IGCRC0208VWInfo bean : prList) {
			IGCRC0208VW beanVW = (IGCRC0208VW)SerializationUtils.clone(bean);
			if(StringUtils.isNotEmpty(bean.getEventType())){
				typeString = bean.getEventType();
				length = typeString.split("-").length;
				beanVW.setEventType(typeString.split("-")[length - 1]);
			}
			newPrList.add(beanVW);
		}
		pDto.setTotalCount(totalCount);
		dto.setProcessList(newPrList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		this.setDetailURLToDTO(dto);
		this.getProcessTemplate(dto);
		
		log.debug("========��ѯ������¼��������========");
		return dto;
	}
	
	public IGCRC02DTO getProcessTemplate(IGCRC02DTO dto) throws BLException {
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setIsWorkPt(1);
		List<IG259Info> pts = workFlowDefinitionBL.searchProcessTemplate(cond);
		List<IG380Info> pds = new ArrayList<IG380Info>();
		for(IG259Info pt : pts) {
			if(StringUtils.isEmpty(dto.getPrtype()) || "".equals(dto.getPrtype())){
				pds.addAll(workFlowDefinitionBL.searchProcessDefinitionsByPtid(pt.getPtid()));
			}else{
				if(pt.getPttype().equals(dto.getPrtype())){
					pds.addAll(workFlowDefinitionBL.searchProcessDefinitionsByPtid(pt.getPtid()));
				}
			}
		}
		dto.setProcessDefinitionList(pds);
		dto.setProcessTemplateList(pts);
		
		return dto;
	}
	
	private void setDetailURLToDTO(IGCRC02DTO dto) throws BLException{
		Map<String,String> nameURLMap = new HashMap<String,String>();
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(dto.getPrtype());
		List<IG259Info> processTemplateList = workFlowDefinitionBL.searchProcessTemplate(cond);
		for (IG259Info processTemplate : processTemplateList) {
			nameURLMap.put(processTemplate.getPttype(), processTemplate.getPtdetailpg());
		}
		dto.setNameURLMap(nameURLMap);
	}
}