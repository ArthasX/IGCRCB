package com.deliverik.plugin.change.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nl.justobjects.pushlet.util.Log;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.api.SysManageBL;
import com.deliverik.framework.igflow.parameter.ProcessInfoDefinitionInfo;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.UserInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG505BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.plugin.change.bl.task.InitiateChangLogBL;
import com.deliverik.plugin.change.dto.IGCHANGE01DTO;
import com.deliverik.plugin.change.model.InitiateChangLogInfo;
import com.deliverik.plugin.change.model.condition.InitiateChangLogSearchCondImpl;
import com.deliverik.plugin.change.model.entity.InitiateChangLogTB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发起变更日志处理BL实现
 * </p>
 * 
 * @author dinghaonan@deliverik.com
 * @version 1.0
 */
public class IGCHANGE01BLImpl implements IGCHANGE01BL {

	/** 变更日志BL */
	protected InitiateChangLogBL initiateChangLogBL;

	/** 流程定义业务 */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	protected FlowOptBL flowOptBL;

	/** 流程类表单值BL */
	protected IG505BL ig505BL;
	/** 流程变量信息实体BL */
	protected IG599BL ig599BL;

	protected IG036BL ig036BL;
	
	protected IG500BL ig500BL;
	
	
	protected IG224BL ig224BL;
	
	
	protected IG337BL ig337BL;
	
	protected FlowSearchBL flowSearchBL;
	
	protected FlowSetBL flowSetBL;
	
	protected UserRoleBL userRoleBL;
	
	protected WorkFlowOperationBL workFlowOperationBL;
	
	protected UserBL userBL;
	
	 /** 系统管理API类 */
    private SysManageBL sysManageBL;
    
    /** 部门审批 */
    private String CHANGE_STATUSNAME_BMSP = "部门审批";
    
    /** 数据运行中心负责人 */
    private Integer roleid_1227 = 1227;
    
    /** 系统网络中心负责人 */
    private Integer roleid_1228 = 1228;
    
    /** 软件开发中心负责人 */
    private Integer roleid_1229 = 1229;
    
    /** 综合管理部负责人 */
    private Integer roleid_1230 = 1230;
    
    /**质量管理岗  roleid*/
    private Integer roleid_1220 = 1220;
    
	
	/**
	 * 系统管理API类设定
	 * @param sysManageBL 系统管理API类
	 */
	public void setSysManageBL(SysManageBL sysManageBL) {
		this.sysManageBL = sysManageBL;
	}
	/**
	 * userBL设定
	 * @param userBL userBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	/**
	 * workFlowOperationBL设定
	 * @param workFlowOperationBL workFlowOperationBL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	/**
	 * flowSetBL设定
	 * @param flowSetBL flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	/**
	 * userRoleBL设定
	 * @param userRoleBL userRoleBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	public IGCHANGE01DTO registIGCHANGEAction(IGCHANGE01DTO dto,String[] acceptMsg)
			throws BLException {
		// 流程主键Id
		Integer prid;
		// 获取变更日志流程信息
		InitiateChangLogInfo info = initiateChangLogBL
				.searchInitiateChangLogByPK(Integer.parseInt(dto.getIcid()));
		InitiateChangLogTB entity = (InitiateChangLogTB) info;
		try {
			// 设置流程日志参数
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setExecutorid(info.getPruserId());
			logInfo.setExecutorRoleid(Integer.parseInt(info.getPrroleId()));

			// 获取变更流程版本
			IG380SearchCondImpl cond = new IG380SearchCondImpl();
			cond.setPdid_like("01084");
			List<IG380Info> lst_ProcessDefinition = workFlowDefinitionBL
					.searchProcessDefinition(cond);

			// 实例化流程信息
			ProcessRecord record = new ProcessRecord(logInfo);
			// 获取最大版本号
			record.setDefid(lst_ProcessDefinition.get(
					lst_ProcessDefinition.size() - 1).getPdid());
			// 发起人Id
			record.setCrtuserid(info.getPruserId());
			// 发起人角色id
			record.setRoleid(Integer.parseInt(info.getPrroleId()));
			// 标题
			record.setTitle(info.getChangeName());
			// 描述
			record.setDescription(info.getChangeDescription());
			// 将流程日志里的值放入流程表单里
			Map<String, String> formvalue = new HashMap<String, String>();
			formvalue.put("计划执行开始时间", info.getBeginTime());
			formvalue.put("计划执行结束时间", info.getEndTime());
			formvalue.put("变更类型", info.getChangeType());
			formvalue.put("变更类别", info.getChangeCategory());
			formvalue.put("所选变更类型", info.getSelectedChangeType());
			formvalue.put("变更分类", info.getChangeClassify());
			formvalue.put("更新平台", info.getUpdatePlatform());
			formvalue.put("变更原因分类", info.getChangeReasonClassify());
			formvalue.put("变更原因", info.getChangeReason());
			formvalue.put("变更内容", info.getChangeContent());
			formvalue.put("相关项目编号", info.getPrjid());
			formvalue.put("相关项目名称", info.getPrjtitle());
			formvalue.put("是否影响业务", info.getIsBusiness());
			formvalue.put("业务影响范围", info.getBusinessScope());
			formvalue.put("计划影响业务时长（分钟）", info.getBusinessTime());
			formvalue.put("执行计划", info.getDeliveryProgram());
			formvalue.put("回退计划", info.getRollbackProgram());
			formvalue.put("验证计划", info.getVerificationProgram());

			record.setFormvalue(formvalue);
			// 描述
			record.setDescription(info.getChangeDescription());
			
			// 发布流程 返回prid主键
			prid = flowOptBL.initProcessAction(record);
			if(acceptMsg==null){
				if(acceptMsg[7]!=null&&(acceptMsg[7].equals("紧急变更")||acceptMsg[7].equals("快速变更"))){
					//平台名称
					String[] ptname = acceptMsg[23].split("#");
					//平台信息
					String[] ptmsg = acceptMsg[24].split("#");
					//权限id
					String[] qxid = acceptMsg[25].split("#");
					
					Map<String, ProcessInfoDefinitionInfo> tableColumnDef = flowSearchBL.searchProcessTableColumnDef(prid);
					for (int i = 0; i < ptname.length; i++) {
						flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#更新平台名称", prid, (i+1)+"", ptname[i]);
						flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#平台信息", prid, (i+1)+"", ptmsg[i]);
						flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#HAC数据", prid, (i+1)+"", qxid[i]);
					}
				}else if(acceptMsg[7]!=null&&acceptMsg[7].equals("常规变更")){
					Map<String, ProcessInfoDefinitionInfo> tableColumnDef = flowSearchBL.searchProcessTableColumnDef(prid);
					flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#更新平台名称", prid, "1", "");
					flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#平台信息", prid, "1", "");
					flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#HAC数据", prid, "1", "");
				}
			}else{
				Map<String, ProcessInfoDefinitionInfo> tableColumnDef = flowSearchBL.searchProcessTableColumnDef(prid);
				flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#更新平台名称", prid, "1", "");
				flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#平台信息", prid, "1", "");
				flowSetBL.setPublicTableColumnValue(tableColumnDef,"平台详细信息#HAC数据", prid, "1", "");
			}
			
			
			entity.setFingerPrint("流程发起成功,");
			// 设置流程日志查询条件
			IG036SearchCondImpl cond036 = new IG036SearchCondImpl();
			// 设置流程id
			cond036.setPrid(prid);
			// 设置流程起始标示
			cond036.setPsdcode("Z");
			// 设置标示2
			cond036.setRlType("2");
			// 设置ig036
			List<IG036Info> list036 = ig036BL.searchIG036InfoByCond(cond036);
			// 如果列表不为空
			if (list036 != null && list036.size() > 0
					&& StringUtils.isNotBlank(dto.getAttkey())) {
				// 循环日志列表
				for (IG036Info info036 : list036) {
					// 设置tb
					IG036TB tb = (IG036TB) info036;
					// 设置attkey
					tb.setRlattkey(dto.getAttkey());
					// 更新ig036日志表
					ig036BL.updateG036Info(tb);
				}
			}
			entity.setFingerPrint("流程发起成功,流程日志插入成功");
//			if (StringUtils.isNotBlank(info.getRelatedPrid())) {
//				// 新增流程表单值表实体
//				IG505TB ig505tb = new IG505TB();
//				// 流程id
//				ig505tb.setPrid(prid);
//				ig505tb.setPiprid(Integer.parseInt(info.getRelatedPrid()));
//				ig505tb.setPiprtype("WD");
//				ig505tb.setPiprtitle(info.getChangeName());
//				IG505Info ig505info = ig505BL.registIG505(ig505tb);
//				// 添加查询条件
//				IG599SearchCondImpl ig599cond = new IG599SearchCondImpl();
//				ig599cond.setPrid(prid);
//				ig599cond.setPivarname("相关程序开发流程");
//				List<IG599Info> list = ig599BL
//						.searchIG599InfosByCond(ig599cond);
//				if (list.size() > 0) {
//					IG599TB ig599tb = (IG599TB) list.get(0);
//					// 修改流程变量值
//					ig599tb.setPivarvalue(String.valueOf(ig505info.getPiprrid()));
//					// 执行修改方法
//					ig599BL.updateIG599Info(ig599tb);
//				}
//			}

			// 将发布完的流程id放入流程日志里
			entity.setPrid(prid);
			// yyyy/MM/dd HH:mm
			entity.setPublishTime(IGStringUtils.getCurrentDateTime());
			// 设置状态 成功
			entity.setPublishStatus("1");
			// 更新变更流程日志
			initiateChangLogBL.updateInitiateChangLog(entity);
			
			
			User user = userBL.searchUserByKey(info.getPruserId());
			
			
			entity.setFingerPrint("流程发起成功,流程日志插入成功，成功发流");
			if("数据类".equals(info.getSelectedChangeType())){
				transitionProcessBy(prid, "000127", "提交", IGStringUtils.getCurrentDateTime());
			}
			
			
			/**
			 *设置部门审批节点的审批人
			 */
			List<UserInfo> userInfoList = new ArrayList<UserInfo>();
			List<UserInfo> userInfos = new ArrayList<UserInfo>();
			Integer roleid = null;
	        // 根据发起人机构查询节点处理人，机构id=1227为数据运行中心负责人
	        List<UserInfo> userInfoList1227 = this.sysManageBL.searchUserInfo(roleid_1227,user.getOrgid());
	        if(userInfoList1227 != null && userInfoList1227.size() != 0){
	        	roleid = roleid_1227;
	        	userInfoList.addAll(userInfoList1227);
	        }
	        // 根据发起人机构查询节点处理人，机构id=1228为系统网络中心负责人
	        List<UserInfo> userInfoList1228 = this.sysManageBL.searchUserInfo(roleid_1228, user.getOrgid());
	        if(userInfoList1228 != null && userInfoList1228.size() != 0){
	        	roleid = roleid_1228;
	        	userInfoList.addAll(userInfoList1228);
	        }
	        // 根据发起人机构查询节点处理人，机构id=1229为软件开发中心负责人
	        List<UserInfo> userInfoList1229 = this.sysManageBL.searchUserInfo(roleid_1229,user.getOrgid());
	        if(userInfoList1229 != null && userInfoList1229.size() != 0){
	        	roleid = roleid_1229;
	        	userInfoList.addAll(userInfoList1229);
	        	//查询所有质量管理岗的成员
	        	List<UserInfo> userInfoList1220 = this.sysManageBL.searchUserInfo(roleid_1220, "0002");
	        	userInfos.addAll(userInfoList1220);
	        }
	        // 根据发起人机构查询节点处理人，机构id=1230为综合管理部负责人
	        List<UserInfo> userInfoList1230 = this.sysManageBL.searchUserInfo(roleid_1230, user.getOrgid());
	        if(userInfoList1230 != null && userInfoList1230.size() != 0){
	        	roleid = roleid_1230;
	        	userInfoList.addAll(userInfoList1230);
	        }
	        if (userInfoList == null || userInfoList.size() == 0) {
		        throw new BLException("IGSVC0408.E001", CHANGE_STATUSNAME_BMSP);
		    }
	        String useridPrid = null;
		    for (UserInfo userInfo : userInfoList) {
		        //封装流程处理人id
		        useridPrid = userInfo.getUserid();
		
		    }
		    // 如果发起人是软件开发中心人员    则将质量管理岗的所有人员加入部门审批处理人中
		    if(userInfos != null && userInfos.size() > 0){
		    	for (UserInfo userInfo : userInfos) {
		    		if(!info.getPruserId().equals(userInfo.getUserid())){//如果发起人在处理人中,则去掉发起人
		    		
		    			useridPrid = userInfo.getUserid();
		    			
		    		}
			    }
		    }
		    
		    
			
			
			transitionProcessBy(prid, useridPrid, "审批通过", IGStringUtils.getCurrentDateTime());
			// 如果prid有值
			if (prid != null && prid != 0) {
				dto.setResult("1");
			}

		} catch (Exception e) {
			// 设置状态 失败
			entity.setPublishStatus("0");
			// 失败日志
			entity.setRemark(e.getMessage());
			entity.setFingerPrint(e.getMessage()+"流程发起失败");
			initiateChangLogBL.updateInitiateChangLog(entity);
			// 如果失败
			dto.setResult("0");
			e.printStackTrace();
		}
		return dto;
	}
	
	
	/***
	 * desc：保存数据日志 param：dto return：dto
	 * 
	 */
	public IGCHANGE01DTO saveInitiacteChangeAction(IGCHANGE01DTO dto)
			throws BLException {
		Log.debug("保存日志");
		// 获取实体
		InitiateChangLogTB tb = dto.getInitTB();
		// 插入数据
		InitiateChangLogInfo registInitiateChangLog = initiateChangLogBL
				.registInitiateChangLog(tb);
		// 判断是否为空
		if (registInitiateChangLog != null)
			// 设定主键
			dto.setIcid(registInitiateChangLog.getIcid() + "");

		return dto;
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
	public void transitionProcessBy(Integer prid, String userid, String action, String datetime) throws BLException {
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
	}

	
	
	
	/**
	 * 根据PRID 查询 流程记录的信息
	 */
	public IGCHANGE01DTO searchInitiacteChangeAction(IGCHANGE01DTO dto)
			throws BLException {

		// 获取PRID
		Integer prid = dto.getPrid();
		// 实例化查询
		InitiateChangLogSearchCondImpl cond = new InitiateChangLogSearchCondImpl();
		// 设定查询条件
		cond.setPrid(prid);
		// 调用查询方法查询数据
		List<InitiateChangLogInfo> searchInitiateChangLog = initiateChangLogBL
				.searchInitiateChangLog(cond);

		// 如果不为空 并且 数据数量不为0 那么在流程日志中他就有数据 这样我们获取到ticketid 发送给对方
		if (searchInitiateChangLog != null
				&& searchInitiateChangLog.size() != 0) {

			InitiateChangLogInfo info = searchInitiateChangLog.get(0);

			// PMS系统工单ID取得
			String ticketId = info.getTicketid();
			dto.setTicketId(ticketId);
			System.out.println(ticketId);
		}

		return dto;
	}

	/**
	 * 变更日志BL取得
	 * 
	 * @return initiateChangLogBL 变更日志BL
	 */
	public InitiateChangLogBL getInitiateChangLogBL() {
		return initiateChangLogBL;
	}

	/**
	 * 变更日志BL设定
	 * 
	 * @param initiateChangLogBL
	 *            变更日志BL
	 */
	public void setInitiateChangLogBL(InitiateChangLogBL initiateChangLogBL) {
		this.initiateChangLogBL = initiateChangLogBL;
	}

	/**
	 * 流程定义业务取得
	 * 
	 * @return workFlowDefinitionBL 流程定义业务
	 */
	public WorkFlowDefinitionBL getWorkFlowDefinitionBL() {
		return workFlowDefinitionBL;
	}

	/**
	 * 流程定义业务设定
	 * 
	 * @param workFlowDefinitionBL
	 *            流程定义业务
	 */
	public void setWorkFlowDefinitionBL(
			WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * flowOptBL取得
	 * 
	 * @return flowOptBL flowOptBL
	 */
	public FlowOptBL getFlowOptBL() {
		return flowOptBL;
	}

	/**
	 * flowOptBL设定
	 * 
	 * @param flowOptBL
	 *            flowOptBL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * 流程类表单值BL取得
	 * 
	 * @return ig505BL 流程类表单值BL
	 */
	public IG505BL getIg505BL() {
		return ig505BL;
	}

	/**
	 * 流程类表单值BL设定
	 * 
	 * @param ig505BL
	 *            流程类表单值BL
	 */
	public void setIg505BL(IG505BL ig505bl) {
		ig505BL = ig505bl;
	}

	/**
	 * 流程变量信息实体BL取得
	 * 
	 * @return ig599BL 流程变量信息实体BL
	 */
	public IG599BL getIg599BL() {
		return ig599BL;
	}

	/**
	 * 流程变量信息实体BL设定
	 * 
	 * @param ig599BL
	 *            流程变量信息实体BL
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**
	 * ig036BL设定
	 * 
	 * @param ig036BL
	 */
	public void setIg036BL(IG036BL ig036bl) {
		ig036BL = ig036bl;
	}

	/**
	 * ig500BL设定
	 * @param ig500BL ig500BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * ig224BL设定
	 * @param ig224BL ig224BL
	 */
	public void setIg224BL(IG224BL ig224bl) {
		ig224BL = ig224bl;
	}

	/**
	 * ig337BL设定
	 * @param ig337BL ig337BL
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	/**
	 * fsBL设定
	 * @param fsBL fsBL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
}

