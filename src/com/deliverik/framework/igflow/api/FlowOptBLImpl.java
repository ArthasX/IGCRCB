/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.parameter.ProcessGroupInfo;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.ProcessRecordInfo;
import com.deliverik.framework.igflow.parameter.SuspendProcessInfo;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG481BL;
import com.deliverik.framework.workflow.prd.bl.task.IG482BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG484BL;
import com.deliverik.framework.workflow.prr.bl.task.IG485BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;
import com.deliverik.framework.workflow.prr.model.entity.IG484TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;

/**
 * 流程处理功能API
 */
public class FlowOptBLImpl extends BaseBLImpl implements FlowOptBL {

    /** 自定义流程日志*/
    private static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
	/** 流程定义BL */
    protected WorkFlowDefinitionBL workFlowDefinitionBL; 
    
	/** 流程BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 用户BL */
	protected UserBL userBL;

	/** 角色BL */
	protected RoleBL roleBL;
	
	/** 流程组定义BL */
	protected IG480BL ig480BL;
	
	/** 流程组成员定义BL */
	protected IG481BL ig481BL;
	
	/** 流程组关系定义BL */
	protected IG482BL ig482BL;
	
	/** 流程组实例BL */
	protected IG483BL ig483BL;
	
	/** 流程组成员实例BL */
	protected IG484BL ig484BL;
	
	/** 流程组关系实例BL */
	protected IG485BL ig485BL;
	
    /**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * 流程BL设定
	 * 
	 * @param workFlowOperationBL 流程BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * 用户BL设定
	 * 
	 * @param userBL 用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
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
	 * 流程组定义BL设定
	 * 
	 * @param ig480BL 流程组定义BL
	 */
	public void setIg480BL(IG480BL ig480BL) {
		this.ig480BL = ig480BL;
	}
	
	/**
	 * 流程组成员定义BL设定
	 * 
	 * @param ig481BL 流程组成员定义BL
	 */
	public void setIg481BL(IG481BL ig481BL) {
		this.ig481BL = ig481BL;
	}
	
	/**
	 * 流程组关系定义BL设定
	 * @param ig482BL 流程组关系定义BL
	 */
	public void setIg482BL(IG482BL ig482BL) {
		this.ig482BL = ig482BL;
	}

	/**
	 * 流程组实例BL设定
	 * 
	 * @param ig483BL 流程组实例BL
	 */
	public void setIg483BL(IG483BL ig483BL) {
		this.ig483BL = ig483BL;
	}
	
	/**
	 * 流程组成员实例BL设定
	 * 
	 * @param ig484BL 流程组成员实例BL
	 */
	public void setIg484BL(IG484BL ig484BL) {
		this.ig484BL = ig484BL;
	}
	
	/**
	 * 流程组关系实例BL设定
	 * 
	 * @param ig485BL 流程组关系实例BL
	 */
	public void setIg485BL(IG485BL ig485BL) {
		this.ig485BL = ig485BL;
	}

	/**
	 * 流程组发起
	 * 
	 * @param processGroupInfo 流程组发起信息
	 * @return 流程组ID
	 * @throws BLException
	 */
	public Integer initProcessGroupAction(ProcessGroupInfo processGroupInfo) throws BLException {
		
		igflowlog.debug("==========流程组发起处理开始==========");
		
		//当前处理时间
		String datetime = IGStringUtils.getCurrentDateTime();
		
		//流程组定义
		IG480Info ig480 = null;
		if(processGroupInfo.getDefid().length() == 7) {
			ig480 = this.ig480BL.searchIG480ByPK(processGroupInfo.getDefid());//流程组定义ID
		} else {
			IG480SearchCondImpl cond = new IG480SearchCondImpl();
			cond.setPgdid_like(processGroupInfo.getDefid());//流程组定义ID前5位
			cond.setPgdstatus(processGroupInfo.getDefstatus());//流程组定义状态
			ig480 = this.ig480BL.searchIG480(cond).get(0);
		}
		
		//发起人
		User user = userBL.searchUserByKey(processGroupInfo.getCrtuserid());
		
		//流程组实例
		IG483TB ig483 = this.ig483BL.getIG483TBInstance();
		ig483.setPgruserid(processGroupInfo.getCrtuserid());//流程组发起人id
		ig483.setPgrusername(user.getUsername());//流程组发起人名称
		ig483.setPgropentime(datetime);//流程组发起时间
		ig483.setPgrtitle(processGroupInfo.getTitle());//流程组标题
		ig483.setPgrorgid(user.getOrgid());//流程组发起人机构码
		ig483.setPgrorgname(user.getOrgname());//流程组发起人机构名称
		ig483.setPgdid(ig480.getPgdid());//流程组定义id
		ig483.setPgdname(ig480.getPgdname());//流程组定义名称
		ig483.setPttype(this.workFlowDefinitionBL.searchProcessTemplateByKey(ig480.getPtid()).getPttype());//流程模版类型
		//判断是否测试数据
		if(IGPRDCONSTANTS.PGD_STATUS_TESTABLE.equals(ig480.getPgdstatus())) {
			ig483.setIstest("1");
		} else {
			ig483.setIstest("0");
		}
		//查看流程组可发起的相关流程定义
		IG481SearchCondImpl cond_IG481 = new IG481SearchCondImpl();
		cond_IG481.setPgdid(processGroupInfo.getDefid());//流程组ID
		cond_IG481.setCreateType("0");//外部发起
		List<IG481Info> lst_IG481Info = this.ig481BL.searchIG481(cond_IG481);
		if(lst_IG481Info.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "流程组ID（" + processGroupInfo.getDefid() + "）相关流程定义");
		}
		
		//查询含有参考状态的流程定义，这些流程定义应该先发起，暂不考虑即是约束又是参考的情况
		IG482SearchCondImpl cond_IG482 = new IG482SearchCondImpl();
		cond_IG482.setPgdid(processGroupInfo.getDefid());//流程组ID
		List<IG482Info> lst_IG482Info = this.ig482BL.searchIG482(cond_IG482);
		List<IG481Info> lst_IG481Info_Init = new ArrayList<IG481Info>();
		for(IG481Info ig481 : lst_IG481Info) {
			for(IG482Info ig482 : lst_IG482Info) {
				if(ig481.getPdid().equals(ig482.getRpdid())) {
					lst_IG481Info_Init.add(ig481);
					break;
				}
			}
		}
		for(IG481Info ig481 : lst_IG481Info) {
			if(!lst_IG481Info_Init.contains(ig481)) {
				lst_IG481Info_Init.add(ig481);
			}
		}

		ig483.setOcount(lst_IG481Info.size());//发起流程数量
		ig483.setCcount(0);//关闭流程数量
		//创建流程组实例
		IG483Info ig483Info = ig483BL.registIG483(ig483);
        
		// 设定子流程信息
        IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
        cond_IG380.setPdstatus("a");//已启用流程定义
        
        //流程定义对应的发起参数集合
        Map<String, ProcessRecord> map_ProcessRecord = new LinkedHashMap<String, ProcessRecord>();
        
        //先校验
        for(IG481Info info : lst_IG481Info_Init) {
        	//日志信息
        	WorkFlowLog logInfo = new WorkFlowLog();
        	logInfo.setAuthuserid(null);
        	logInfo.setExecutorid(processGroupInfo.getCrtuserid());
        	
        	//流程信息
			ProcessRecord processRecord = new ProcessRecord(logInfo);
			//暂不校验流程定义是否停用???????????????????????????????????????????
			processRecord.setDefid(info.getPdid());
			//发起流程组的用户，必须具有发起子流程的权限，否则抛异常，默认取任意发起角色发起子流程
			List<LabelValueBean> lst_Role = this.workFlowDefinitionBL.searchInitProcessParticipantRole(
					processGroupInfo.getCrtuserid(), processRecord.getDefid());
			if(lst_Role.isEmpty()) {
				throw new BLException("IGFLOW0000.E000", "不具有流程定义ID（" + processRecord.getDefid() + "）的发起角色");
			} else {
		        logInfo.setExecutorRoleid(new Integer(lst_Role.get(0).getValue()));
			}
			processRecord.setLogInfo(logInfo);
			processRecord.setTitle(processGroupInfo.getTitle() + "_"
					+ this.workFlowDefinitionBL.searchProcessDefinitionByKey(info.getPdid()).getPdname()
					+ processGroupInfo.getProcessTitle(info.getPdid().substring(0, 5)));//定义ID不带版本号
			//processRecord.setDescription(processGroupInfo.getDescription());
			processRecord.setDefstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//流程定义必须启用状态
			processRecord.setGroupID(ig483Info.getPgrid());//流程组实例ID
			processRecord.setGroupDefID(ig483Info.getPgdid());//流程组定义ID
			map_ProcessRecord.put(processRecord.getDefid(), processRecord);
		}
        
        //发起流程，并保存流程组成员实例表
        cond_IG482 = new IG482SearchCondImpl();
		for(String pdid : map_ProcessRecord.keySet()) {
			Integer prid = launchProcess(map_ProcessRecord.get(pdid), IGPRDCONSTANTS.BUTTON_SUBMIT);//流程实例ID
			//获取流程组关系定义
			cond_IG482.setPgdid(ig483Info.getPgdid());//流程组定义ID
			cond_IG482.setRpdid(pdid);//参考流程定义ID
			List<IG482Info> lst_IG482 = this.ig482BL.searchIG482(cond_IG482);
			//根据发起的流程实例ID生成流程组关系实例信息
			for(IG482Info info : lst_IG482) {
				IG485TB ig485 = this.ig485BL.getIG485TBInstance();
				ig485.setPgreid(info.getPgreid());//流程组关系定义ID
				ig485.setPgrid(ig483Info.getPgrid());//流程组实例ID
				ig485.setPrid(prid);//参考流程实例ID
				ig485.setPgrrstatus("0");//状态：未完成
				this.ig485BL.registIG485(ig485);
			}
		}
		
		igflowlog.debug("==========流程组发起处理结束==========");
		
		return ig483Info.getPgrid();
	}

	/**
	 * 流程发起
	 * 
	 * @param processRecordInfo 流程发起信息
	 * @return 流程ID
	 * @throws BLException
	 */
	public Integer initProcessAction(ProcessRecordInfo processRecordInfo) throws BLException {
		return launchProcess(processRecordInfo, IGPRDCONSTANTS.BUTTON_SUBMIT);
	}
	
	/**
	 * 流程发起
	 * 
	 * @param processRecordInfo 流程发起信息
	 * @return 流程ID
	 * @throws BLException
	 */
	public Integer saveProcessAction(ProcessRecordInfo processRecordInfo) throws BLException {
		return launchProcess(processRecordInfo, IGPRDCONSTANTS.BUTTON_UPDATE);
	}
	
	/**
	 * 
	 * 流程发起
	 * 
	 * @param processRecordInfo 流程发起信息
	 * @param action 操作动作
	 * @return 流程ID
	 * @throws BLException
	 */
	private Integer launchProcess(ProcessRecordInfo processRecordInfo,String action) throws BLException{
		igflowlog.debug(">>>调用流程发起处理开始");
		User user = userBL.searchUserByKey(processRecordInfo.getLogInfo().getExecutorid());
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(processRecordInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(processRecordInfo.getLogInfo().getAuthuserid());
		}
		//发起者角色
		Role role = roleBL.searchRoleByKey(processRecordInfo.getLogInfo().getExecutorRoleid());
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(processRecordInfo.getDefid());
		cond.setPdstatus(processRecordInfo.getDefstatus());
		List<IG380Info> lst_ProcessDefinition = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_ProcessDefinition.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "流程定义ID（" + processRecordInfo.getDefid() + "）");
		} else {
			IG259Info processTemplate = workFlowDefinitionBL.searchProcessTemplateByKey(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPtid());
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());
			psdCond.setPsdcode(Constants.PROCESS_STATUS_START);
			psdCond.setFatherflag("Y");//应急合版
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "发起状态");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "发起状态");
			} else {
				List<IG599Info> prInfoList = new ArrayList<IG599Info>();
				//查询流程表单定义信息
				List<IG007Info> processInfoDefList  = workFlowOperationBL.getProcessInfoDefs(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());
				if(processInfoDefList != null){
					Map<String, String> formvalue = processRecordInfo.getFormvalue();
					if(formvalue == null){
						formvalue = new HashMap<String, String>();
					}
					IG599TB prInfo = null;
					for(IG007Info processInfoDef:processInfoDefList){
						String value = formvalue.get(processInfoDef.getPidname());
						prInfo = workFlowOperationBL.getProcessInfoTBInstance();
						prInfo.setPivarlabel(processInfoDef.getPidlabel());
						prInfo.setPivarname(processInfoDef.getPidname());
						prInfo.setPivartype(processInfoDef.getPidtype());
						prInfo.setPivarvalue(value);
						prInfo.setPidid(processInfoDef.getPidid());
						prInfo.setPidmode(processInfoDef.getPidmode());
						prInfo.setPrivatescope(processInfoDef.getPrivatescope());
						prInfo.setPidaccess("3");//可写
						prInfoList.add(prInfo);
					}
				}
				IG500TB instance = workFlowOperationBL.getProcessRecordTBInstance();
				instance.setPrpdid(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdid());//流程定义ID
				instance.setPrpdname(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdname());//流程定义名称
				instance.setPrtitle(processRecordInfo.getTitle());//流程标题
				instance.setPrdesc(processRecordInfo.getDescription());//流程描述
				instance.setPrtype(processTemplate.getPttype());//流程类型
				instance.setPrinfo(user.getUsermobile());//流程发起者联系方式
				instance.setPruserid(user.getUserid());//流程发起者ID
				instance.setPrusername(user.getUsername());//流程发起者姓名
				instance.setPrroleid(role.getRoleid());//流程发起者角色ID
				instance.setPrrolename(role.getRolename());//流程发起者角色名称
				instance.setProrgid(user.getOrgid());//流程发起者机构层次码
				instance.setProrgname(user.getOrgname());//流程发起者机构名称
				instance.setPid(processRecordInfo.getGroupID());//流程组实例ID，应急合版
				instance.setPname(processRecordInfo.getGroupDefID());//流程组定义ID
				//是否测试流程
				if(IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(lst_ProcessDefinition.get(lst_ProcessDefinition.size() - 1).getPdstatus())){
					instance.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
				}
				IG500Info processRecord = workFlowOperationBL.launchProcess(instance, user,
						processRecordInfo.getLogInfo().getExecutorRoleid(),
						null, null, processTemplate.getPttype(), prInfoList, processRecordInfo.getLogInfo().getComment(),
						lst_ProcessStatusDef.get(lst_ProcessDefinition.size() - 1).getPsdid(), action, null, authorizeuser,null,null,new HashMap<String, List<IG506TB>>(),null,null);
				//流程组成员ID保存
				if(StringUtils.isNotEmpty(processRecordInfo.getGroupDefID())) {//应急合版
					IG484TB ig484 = this.ig484BL.getIG484TBInstance();
					ig484.setPgrid(processRecordInfo.getGroupID());//流程组实例ID
					ig484.setPdid(instance.getPrpdid());//流程定义ID
					ig484.setPrid(processRecord.getPrid());//流程实例ID
					this.ig484BL.registIG484(ig484);
				}
				igflowlog.debug(">>>调用流程发起处理结束，返回流程ID：" + processRecord.getPrid());
				return processRecord.getPrid();
			}
		}
		
	}
	
	/**
	 * 流程中止
	 * 
	 * @param suspendProcessInfo 流程中止信息
	 * @throws BLException
	 */
	public void suspendProcess(SuspendProcessInfo suspendProcessInfo) throws BLException {
	    igflowlog.debug(">>>调用流程中止处理开始。");
		User user = userBL.searchUserByKey(suspendProcessInfo.getLogInfo().getExecutorid());
		User authorizeuser = null;
		if(StringUtils.isNotEmpty(suspendProcessInfo.getLogInfo().getAuthuserid())) {
			authorizeuser = userBL.searchUserByKey(suspendProcessInfo.getLogInfo().getAuthuserid());
		}
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(suspendProcessInfo.getLogInfo().getPrid());
		IG500TB instance = (IG500TB)SerializationUtils.clone(process);
		instance.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
		instance.setPrclosetime(IGStringUtils.getCurrentDateTime());
		workFlowOperationBL.updateProcessRecord(process.getPrstatus(),instance, user, suspendProcessInfo.getLogInfo().getExecutorRoleid(),
				suspendProcessInfo.getLogInfo().getComment(),IGPRDCONSTANTS.COMMENT_TERMINATE_MESSAGE, null,
				IGPRDCONSTANTS.RECORDLOG_TYPE_CL, authorizeuser, null,null);
		igflowlog.debug(">>>调用流程中止处理结束。");
	}
	
	/**
	 * 流程跃迁
	 * 只支持普通模式下的普通节点，支持按钮跃迁规则但不支持表单跃迁规则
	 * 
	 * @param prid 流程ID
	 * @param userid 处理用户ID
	 * @param action 按钮名称
	 * @param datetime 处理时间
	 * @throws BLException
	 */
	public void transitionProcess(Integer prid, String userid, String action, String datetime) throws BLException {
	    igflowlog.debug(">>>调用流程跃迁处理开始。");
//	    doFlow(List<IG599Info> prInfoList,Integer prid, User user,Integer roleid, String datetime, String rolename,
//				String psdid,String action,String desc,String nodeType,
//				Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException {
	    //获取当前登录用户
	    User user = userBL.searchUserByKey(userid);
	    //获取流程信息
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
		//获取状态ID
		IG333SearchCondImpl cond_IG333 = new IG333SearchCondImpl();
		cond_IG333.setPdid(process.getPrpdid());
		cond_IG333.setPsdcode(process.getPrstatus());
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDef(cond_IG333).get(0);
		//获取用户处理角色
		UserRoleInfo userRoleInfo = this.workFlowOperationBL.getUserRolesInProcessParticipants(
				prid, userid, psd.getPsdid()).get(0);
		//获取可视按钮
		List<IG309Info> lst_ParticipantVisibleButtonVWInfo = workFlowDefinitionBL.searchVisibleButton(psd.getPsdid(), userRoleInfo.getRoleid());
		String vbid = "";
		//ID以"1"开头的为处理按钮
		for(IG309Info button : lst_ParticipantVisibleButtonVWInfo) {
			if(button.getVbid().startsWith("1") && button.getVbname().equals(action)) {
				vbid = button.getVbid();
				break;
			}
		}
		//查询处理用户对应的参与者实体
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPsdid(psd.getPsdid());
		cond.setPpproctimeIsNull("Y");
		cond.setPproleid(userRoleInfo.getRoleid());
		cond.setPpuserid(userid);
		List<IG337Info> lst_IG337Info = this.workFlowOperationBL.searchProcessParticipants(cond);
		if(lst_IG337Info.isEmpty()) {
			//查询是否只指定到了角色
			cond.setPpuserid(null);
			lst_IG337Info = this.workFlowOperationBL.searchProcessParticipants(cond);
		}
		if(lst_IG337Info.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "参与者" + userid + "（" + userRoleInfo.getRoleid() + "）");
		} else {
			IG337TB participant = (IG337TB)SerializationUtils.clone(lst_IG337Info.get(0));
			participant.setPpproctime(datetime);
			participant.setPpuserid(userid);
			participant.setPbdid(vbid);
			//更新处理人信息（处理完成时间）
			this.workFlowOperationBL.updateProcessParticipant(participant, user, userRoleInfo.getRoleid(), null, 
					psd.getPsdname(), 
					null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL,null,null, vbid,null);
		}
		//跃迁
	    this.workFlowOperationBL.doFlow(prid, user,
	    		userRoleInfo.getRoleid(), datetime,
	    		userRoleInfo.getRolename(),
	    		psd.getPsdid(), 
	    		vbid, null, IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL, null, null, null);
		igflowlog.debug(">>>调用流程跃迁处理结束。");
	}

}
