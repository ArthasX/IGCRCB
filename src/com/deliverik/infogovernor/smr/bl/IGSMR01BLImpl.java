/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR01DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0101Form;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
 * 报表填报业务逻辑实现
 *
 */
public class IGSMR01BLImpl extends BaseBLImpl implements IGSMR01BL {

	static Log log = LogFactory.getLog(IGSMR01BLImpl.class);
	
	/** 报表填报实例表业务BL */
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;
	
	/** 报表填报明细表业务BL */
	protected RegulatoryReportDetailBL regulatoryReportDetailBL;
	
	/** 流程业务BL */
	protected FlowOptBL flowOptBL;
	
	/** 流程类型定义BL */
	protected IG380BL ig380BL;
	
	/** 角色BL */
	protected RoleBL roleBL;
	
	/** 流程BL */
	protected IG500BL ig500BL;
	
	/** 角色菜单BL */
	protected RoleActionBL roleActionBL;
	
	/**
	 * 报表填报实例表业务BL设定
	 * @param regulatoryReportInstanceBL
	 */
	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}

	/**
	 * 报表填报明细表业务BL
	 * @param regulatoryReportDetailBL
	 */
	public void setRegulatoryReportDetailBL(
			RegulatoryReportDetailBL regulatoryReportDetailBL) {
		this.regulatoryReportDetailBL = regulatoryReportDetailBL;
	}
	
	/**
	 * 流程业务BL设定
	 * @param flowOptBL 流程业务BL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	/**
	 * 流程类型定义BL设定
	 * 
	 * @param ig380bl 流程类型定义BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}
	
	/**
	 * 角色BL设定
	 * 
	 * @param roleBL 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 流程BL设定
	 * 
	 * @param ig500bl 流程BL
	 */	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	
	/**
	 * 角色菜单BL设定
	 * @param roleActionBL 角色菜单BL
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * 年报发起处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR01DTO insertSMR0101Action(IGSMR01DTO dto) throws BLException {
		log.debug("========年报发起处理开始========");
		IGSMR0101Form form = dto.getIgSMR0101Form();
		
		User user = dto.getUser();
		RegulatoryReportInstanceTB instance = regulatoryReportInstanceBL.getRegulatoryReportInstanceTBInstance();
		instance.setPrtype(IGPRDCONSTANTS.PRTYPE_YEAR);//组类型
		instance.setKey(form.getYear());//组标识
		instance.setInittime(IGStringUtils.getCurrentDateTime());//填报发起时间
		instance.setLimittime(form.getLimittime());//填报限制时间
		instance.setRemark(form.getRemark());//备注
		instance.setStatus(IGSMRCONSTANT.REPORT_STATUS_BEGIN);//状态：开启
		instance.setUserid(user.getUserid());//发起人ID
		instance.setUsername(user.getUsername());//发起人姓名
		instance.setReportdesc(form.getYear()+"_年报");
		instance.setYear(form.getYear());//年
		this.initRegulatoryReportIntance(instance, IGPRDCONSTANTS.PRTYPE_YEAR_ID, form.getTest());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "年报发起") );
		log.debug("========年报发起处理结束========");
		return dto;
	}
	
	/**
	 * 获取发起角色ID
	 * 
	 * @return 发起角色ID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		//获取具有"年报发起"菜单的角色ID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname(IGSMRCONSTANT.ACTION_YEAR);
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if(lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "填报发起角色");
		}
		return lst_RoleAction.get(0).getRoleid();
	}
	
	/**
	 * 创建填报实例，并且发起报表流程，保存填报明细数据
	 * @param instance 填报实例
	 * @param ptid 模版ID
	 * @param test 是否测试发起，是：1
	 * @throws BLException
	 */
	private void initRegulatoryReportIntance(RegulatoryReportInstanceTB instance, Integer ptid, String test) throws BLException {
		//获取发起角色ID
		Integer roleid = getInitRoleid();
		//创建年报填报实例
		RegulatoryReportInstanceInfo instanceInfo = 
				regulatoryReportInstanceBL.registRegulatoryReportInstanceInfo(instance);
		WorkFlowLog workFlowLog = new WorkFlowLog();
		workFlowLog.setExecutorid(instance.getUserid());//处理人ID
		workFlowLog.setExecutorRoleid(roleid);
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPtid(ptid);//年报模版ID
		if("1".equals(test)) {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_TESTABLE);//测试状态
		} else {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//发布状态
		}
		List<IG380Info> lst_IG380Info = ig380BL.searchIG380Info(cond_IG380);
		if(lst_IG380Info.isEmpty()) {
			throw new BLException("IGCO10000.E004", "报表");
		}
		Map<String, String> formvalue = new HashMap<String, String>();
//		formvalue.put("填报限制时间", instance.getLimittime());
		//formvalue.put("填报人", instance.getLimittime());
		//定义流程ID集合
		List<Integer> lst_Prid = new ArrayList<Integer>();
		for(IG380Info info : lst_IG380Info) {
			ProcessRecord process = new ProcessRecord(workFlowLog);
			process.setCrtuserid(instance.getUserid());//发起人ID
			process.setTitle(instanceInfo.getKey() + "（" + info.getPdname() + "）");//标题
			process.setDefid(info.getPdid());
			process.setRoleid(roleid);
			process.setFormvalue(formvalue);
			process.setDescription(instance.getRemark());//描述
			lst_Prid.add(flowOptBL.initProcessAction(process));
		}
		//保存填报明细表数据
		for(Integer prid : lst_Prid) {
			RegulatoryReportDetailTB detail = new RegulatoryReportDetailTB();
			detail.setPrid(prid);//流程ID
			detail.setInstanceID(instanceInfo.getInstanceID());//填报实例ID
			this.regulatoryReportDetailBL.registRegulatoryReportDetailInfo(detail);
		}
	}
	
}
