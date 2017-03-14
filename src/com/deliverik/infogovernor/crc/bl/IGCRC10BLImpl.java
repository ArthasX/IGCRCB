/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 程序开发管理处理BL实现
 * </p>
 * 
 * @author 史凯龙
 * @version 1.0
 */
public class IGCRC10BLImpl extends BaseBLImpl implements IGCRC10BL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** 流程处理类API */
	protected FlowOptBL flowOptBL;

	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/** 平台用户BL */
	protected UserBL userBL;

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
	 * 更新类API设定
	 * 
	 * @param flowSetBL
	 *            更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 平台用户BL设定
	 * 
	 * @param userBL
	 *            平台用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 导出变更管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC10DTO getExcelDataList(IGCRC10DTO dto) throws BLException {
		log.debug("=================获取程序开发管理相应数据集开始=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if(StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())){
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// 查询流程信息条件
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// 变更管理类型编号
		cond.setPrpdid(form.getPrpdid());
		cond = copyPropertie(dto.getIgwkm0101form(), cond);
		// 查询流程信息
		dto.setProcessList(workFlowOperationBL.searchProcessByType(cond, 0, 0,form.getType()));
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
		log.debug("=================获取程序开发管理相应数据集结束=================");
		return dto;
	}

	/**
	 * 复制属性  
	 * @param form
	 * @param cond
	 * @return
	 */
	private IG500SearchCondImpl copyPropertie(IGWKM0101Form form, IG500SearchCondImpl cond){
		//复制工单号属性
		if(form.getPrserialnum()!=null && !(form.getPrserialnum().equals(""))){
			cond.setPrserialnum(form.getPrserialnum());
		}
		//复制工单名称的属性
		if(form.getPrtitle()!=null && !(form.getPrtitle().equals(""))){
			cond.setPrtitle(form.getPrtitle());
		}
		//复制查询开始时间
		if(form.getPropentime()!=null && !(form.getPropentime().equals(""))){
			cond.setPropentime( form.getPropentime());
		}
		//复制查询结束时间
		if(form.getPrclosetime()!=null && !(form.getPrclosetime().equals(""))){
			cond.setPrclosetime(form.getPrclosetime());
		}
		//判断工单状态
		if(form.getPrstatus()!=null && !(form.getPrstatus().equals(""))){	
			cond.setPrstatus(form.getPrstatus());
		}
		//判断发起人
		if(form.getPrusername()!=null && !(form.getPrusername().equals(""))){
			cond.setPrusername(form.getPrusername());
		}
		//复制表单名称
		if(form.getVarnames()!=null && form.getVarnames().length>0){
			cond.setVarnames(form.getVarnames());
		}
		//复制表单值
		if(form.getVarvalues()!=null && form.getVarvalues().length>0){
			cond.setVarvalues(form.getVarvalues());
		}
		return cond;
	}
	
	/**
	 * 主流程信息取得操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC10DTO getParentProcessInfoAction(IGCRC10DTO dto) throws BLException {
		log.debug("===============主流程信息取得操作开始================");
		if(dto.getForm() != null && dto.getForm() instanceof IGCRC1005Form){
			IGCRC1005Form form = (IGCRC1005Form) dto.getForm();
			IG500Info info = workFlowOperationBL.searchProcessRecordByKey(form.getParprid());
			Map<String, String> map = new HashMap<String, String>();
			if(info.getPrpdname().indexOf("业务服务请求") >= 0){
				map.put("prtitle", info.getPrtitle());
				map.put("prdesc", info.getPrdesc());
				map.put("type", "success");
			}else{
				map.put("type", "other");
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(map));
		}
		log.debug("===============主流程信息取得操作结束================");
		return dto;
	}
}
