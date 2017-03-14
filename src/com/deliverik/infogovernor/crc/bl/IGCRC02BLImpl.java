/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author changhao@deliverik.com
 * @version 1.0
 */
public class IGCRC02BLImpl extends BaseBLImpl implements  IGCRC02BL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	public WorkFlowOperationBL getWorkFlowOperationBL() {
		return workFlowOperationBL;
	}
	public WorkFlowDefinitionBL getWorkFlowDefinitionBL() {
		return workFlowDefinitionBL;
	}

	/** 流程处理类API */
	protected FlowOptBL flowOptBL;
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;
	
	protected FlowSearchBL flowSearchBL;
	
	/** 集成告警表业务逻辑BL */
	private IgalarmBL igalarmBL;
	
	/**
	 * 集成告警表业务逻辑BL设置
	 * @param igalarmBL 集成告警表业务逻辑BL
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}
	/**
	 * 流程处理BL设定
	 * 
	 * @param workFlowOperationBL
	 *            流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 流程定义BL设定
	 * 
	 * @param workFlowDefinitionBL
	 *            流程定义BL
	 */
	public void setWorkFlowDefinitionBL(
			WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 流程处理类API设定
	 * 
	 * @param flowOptBL
	 *            流程处理类API
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
	 * 更新类API设定
	 * 
	 * @param flowSetBL
	 *            更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	/** 平台用户BL */
	protected UserBL userBL;
	public UserBL getUserBL() {
		return userBL;
	}
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	/***
	 * 通过dto创建查询条件并查询
	 * 根据主机名称，IP地址，触发时间，恢复时间排序查询
	 * @param dto
	 */
	public void serachIgalarmSortList(IGCRC02DTO dto) {
		//集成告警表检索条件
		IgalarmSearchCondImpl alarmSearchCond =  new IgalarmSearchCondImpl(dto.getForm());
		//判断是要将哪个字段排序，不排序的字段设置为空
		//主机名称
		if("appname".equals(dto.getForm().getType())){
			alarmSearchCond.setAppnamestatus(dto.getForm().getAppnamestatus());
			dto.getForm().setIpaddrstatus("");
			dto.getForm().setLasttimestatus("");
			dto.getForm().setRecoverytimestatus("");
		}
		//ip地址
		if("ipaddr".equals(dto.getForm().getType())){
			alarmSearchCond.setIpaddrstatus(dto.getForm().getIpaddrstatus());
			dto.getForm().setAppnamestatus("");
			dto.getForm().setLasttimestatus("");
			dto.getForm().setRecoverytimestatus("");
		}
		//触发时间
		if("lasttime".equals(dto.getForm().getType())){
			alarmSearchCond.setLasttimestatus(dto.getForm().getLasttimestatus());
			dto.getForm().setAppnamestatus("");
			dto.getForm().setIpaddrstatus("");
			dto.getForm().setRecoverytimestatus("");
		}
		//恢复时间
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
	 * 通过dto创建查询条件并查询
	 * @param dto
	 */
	public void serachIgalarmList(IGCRC02DTO dto) {
		//集成告警表检索条件
		IgalarmSearchCondImpl alarmSearchCond =  new IgalarmSearchCondImpl(dto.getForm());
		dto.setIgalarmInfos(igalarmBL.searchIgalarm(alarmSearchCond, 0,0));
//		dto.getPagingDTO().setTotalCount(igalarmBL.getSearchCount(alarmSearchCond));
		
	}
	
	
	/***
	 * 通过id组 查询告警信息
	 * @param alarmIds
	 * @return
	 */
	public List<IgalarmInfo> serachByAlarmIds(String[] alarmIds) {
		//集成告警表检索条件
		IgalarmSearchCondImpl alarmSearchCond =  new IgalarmSearchCondImpl();
		alarmSearchCond.setAlarmIds(alarmIds);
		return igalarmBL.searchIgalarm(alarmSearchCond);
	}

	public IGCRC02DTO getExcelDataList(IGCRC02DTO dto) throws BLException {
		log.debug("=================获取事件管理相应数据集开始=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if(StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())){
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// 查询流程信息条件
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// 变更管理类型编号
		this.copyProperties(cond, form);
		// 查询流程信息
		dto.setProcessList(igalarmBL.searchProcessByType(cond, 0, 0,null));

		// 查询表单信息条件
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		// 变更管理类型编号
		processInfoCond.setPdid(form.getPrpdid());
		// 查询表单信息
		dto.setProcessInfoList(workFlowOperationBL
				.searchProcessInfoByCond(processInfoCond));

		// 查询参与人信息条件(暂无)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		// 查询参与人信息
		dto.setProcessParticipantList(workFlowOperationBL
				.searchProcessParticipants(processParticipantCond));

		
		// 查询流状态定义信息条件
		IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
		// 变更管理类型编号
		processStatusDefCond.setPsdid_like(form.getPrpdid());
		// 查询流状态定义
		dto.setProcessStatusDefList(workFlowDefinitionBL
				.searchProcessStatusDef(processStatusDefCond));
		log.debug("=================获取事件管理相应数据集结束=================");
		return dto;
	}
	
	/**	
	 * 功能：通过id 查询告警信息
	 * @param id
	 * @return 告警信息
	 * 修改记录：null
	 * @throws BLException 
	 */	
	public IGCRC02DTO searchIgalarmByPK(IGCRC02DTO dto) throws BLException {
		IgalarmInfo igalarmInfo = igalarmBL.searchIgalarmByPK(dto.getIgcrc0204Form().getPk());
		dto.setIgalarmInfo(igalarmInfo);
		return dto;
	}
	
	/**	
	 * 功能：根据告警id更新
	 * @param form中的告警对象
	 * @return
	 * @throws BLException
	 * 修改记录：null
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
	 * 功能：根据告警id删除
	 * @param dto
	 * @throws BLException
	 * 修改记录：null
	 */	
	public void deleteIgalarmByPK(IGCRC02DTO dto) throws BLException {
		igalarmBL.deleteIgalarmByPK(dto.getIgcrc0204Form().getPk());
	}
	
	/**	
	 * 功能：根据告警id更新
	 * @param 告警对象
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGCRC02DTO updateIgalarmByIgalarm(IGCRC02DTO dto) throws BLException {
		IgalarmInfo igalarmInfo = igalarmBL.updateIgalarm(dto.getIgalarmInfo());
		dto.setIgalarmInfo(igalarmInfo);
		
		Map<String, ProcessInfoDefinitionInfo> def = flowSearchBL.searchProcessTableColumnDef(dto.getIgcrc0204Form().getPrcorid());
		//查询评估内容表格式表单值
		Object obj = flowSearchBL.searchPublicTableValue("告警信息",dto.getIgcrc0204Form().getPrcorid(), null);
		//表单值结构：第一层--每一个分类下的风险点和检查项，第二层，具体到风险点或检查项内部值
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) obj;
		

		flowSetBL.setPublicTableColumnValue(def, "告警信息#告警ID", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getSerial());
		flowSetBL.setPublicTableColumnValue(def, "告警信息#事件内容", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getSummary());
		flowSetBL.setPublicTableColumnValue(def, "告警信息#触发时间", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getLasttime());
		flowSetBL.setPublicTableColumnValue(def, "告警信息#恢复时间", dto.getIgcrc0204Form().getPrcorid(), dataList.size()+ 1+"", dto.getIgalarmInfo().getRecoveryTime());

		return dto;
	}
	
	/**
	 *告警事件查询
	 */
	public IGCRC02DTO getProcessRecords(IGCRC02DTO dto) throws BLException {
		log.debug("========查询工作记录处理开始========");
		// 查询记录总数
		int totalCount = igalarmBL.searchProcessCount(dto.getPrSearchCond(), dto.getType());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			this.getProcessTemplate(dto);
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			this.getProcessTemplate(dto);
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
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
		
		log.debug("========查询工作记录处理终了========");
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
