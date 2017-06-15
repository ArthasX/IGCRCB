/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG715BL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.bl.task.ProcessTimeBL;
import com.deliverik.framework.workflow.prr.bl.task.ProcessWorkTimeBL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.jobs.JOBCONSTANTS;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCondImpl;
import com.deliverik.infogovernor.soc.srv.dto.IGSRV02DTO;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_事件业务逻辑接口实现类
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @History 2010-7-13     0000000: 增加快捷发起事件功能
 *          2010-12-07    yangliang: 增加查询全部流程功能
 * @version 1.0
 */

public class IGSRV02BLImpl extends BaseBLImpl implements IGSRV02BL {




	/**
	 * ig715BL设定
	 *
	 * @param ig715bl ig715BL
	 */
	public void setIg715BL(IG715BL ig715bl) {
		ig715BL = ig715bl;
	}


	static Log log = LogFactory.getLog(IGSRV02BLImpl.class);
	
	private CodeDetailBL codeDetailBL;
	
	//private SendMessageBL sendMessageBL;
	
	private QuartzJobsBL quartzJobsBL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**用户角色授权信息BL*/
	protected UserRoleBL userRoleBL;
	
	/**角色信息业务BL*/
	protected RoleBL roleBL;
	
	/**服务工单BL*/
	protected IG933BL ig933BL;
	
	/**服务工单关联流程BL*/
	protected IG715BL ig715BL;

	/**查看详细计时情况BL*/
	protected ProcessTimeBL processTimeBL;
	
	/**用户作息表详细情况BL*/
	protected ProcessWorkTimeBL processWorkTimeBL;
	
	public void setProcessTimeBL(ProcessTimeBL processTimeBL) {
		this.processTimeBL = processTimeBL;
	}
	
	public void setProcessWorkTimeBL(ProcessWorkTimeBL processWorkTimeBL) {
		this.processWorkTimeBL = processWorkTimeBL;
	}
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

//	public void setSendMessageBL(SendMessageBL sendMessageBL) {
//		this.sendMessageBL = sendMessageBL;
//	}

	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ig933BL设定
	 *
	 * @param ig933bl ig933BL
	 */
	public void setIg933BL(IG933BL ig933bl) {
		ig933BL = ig933bl;
	}


	/**
	 * <p>
	 * Description: 获取事件处理显示状态（处理按钮权限） 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getActionStatus(IGSRV02DTO dto) throws BLException{
		log.debug("========获取事件处理显示状态开始========");
		String userid = dto.getUserid();
		Integer prid = dto.getPrid();
		List<UserRoleInfo> userRoleList = userRoleBL.getUserRoles(dto.getUserid());
		IG500Info processRecord = workFlowOperationBL.searchProcessRecordByKey(prid);
		char curStatus = processRecord.getPrstatus().charAt(0);
		String todoAction;
		switch(curStatus){
			case IGSRV02BLType.PROCESS_STATUS_WAITING_DISPATCH_CHAR:
			//等待分派	
				todoAction = IGSRV02BLType.PROCESS_ACTION_DISPATCH;
				break;
			case IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT_CHAR:
			//等待处理
				todoAction = IGSRV02BLType.PROCESS_ACTION_IMPLEMENT;
				break;
			case IGSRV02BLType.PROCESS_STATUS_WAITING_VERIFY_CHAR:
			//等待审核
				todoAction = IGSRV02BLType.PROCESS_ACTION_VERIFY;
				break;
			case IGSRV02BLType.PROCESS_STATUS_CLOSE_CHAR:
			//已经关闭
				todoAction = IGSRV02BLType.ACTION_NONE;
				break;
			default:
				throw new BLException("IGSVC0203.E001", "工单号"+processRecord.getPrserialnum()+"状态"+curStatus );
		}
		if(todoAction.equals(IGSRV02BLType.ACTION_NONE)){
			dto.setActionnameList(null);
			dto.addMessage(new ActionMessage("IGSVC0203.I001",prid));
			return dto;
		}
		List<IG337Info> todoRoleList = workFlowOperationBL.searchProcessParticipantTodoRole(prid, 
				String.valueOf(curStatus));
		List<Integer> todoRoleidList = new ArrayList<Integer>();
		for (int i = 0; i < todoRoleList.size(); i++) {
			todoRoleidList.add(todoRoleList.get(i).getPproleid());
		}
		List<String> actionList = new ArrayList<String>();
		actionList.add(IGSRV02BLType.PROCESS_ACTION_ADDCOMMENT);
		boolean confirmflag = false;
		
		
		boolean showDoFlag = false;//是否显示"申请复核"

		for(int i=0; i<userRoleList.size(); i++){
			UserRoleInfo ur = userRoleList.get(i);
			//如果具有系统管理员的角色，调整级别,中止和审核人按钮可视
			if(roleBL.isProcessAdminRole(ur.getRoleid())){
				actionList.add(IGSRV02BLType.PROCESS_ACTION_ADJUSTLEVEL);
				actionList.add(IGSRV02BLType.PROCESS_ACTION_TERMINATE);
				actionList.add(IGSRV02BLType.PROCESS_ACTION_VERIFIORS);
				//如果事件处于待处理状态，流程管理员可以重新分派
				if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT)){
					actionList.add(IGSRV02BLType.PROCESS_ACTION_IMPLEMENTORS);
				}
			}
			
			for(IG337Info pp : todoRoleList){
				if(pp.getPproleid().equals(ur.getRoleid())&&!IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())&&!"0".equals(dto.getConfirmflag())){
					confirmflag = true;
				}
			}
			//根据流程当前的状态，设定处理按钮
			if(todoRoleidList.contains(ur.getRoleid())){
				//如果流程状态为等待处理，则只有确认人可以处理
				if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT) && !confirmflag){
					String uid = "";
					for(IG337Info pp : todoRoleList){
						if(IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus()) && 
								IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
							uid = pp.getPpuserid();
							//if(StringUtils.isNotEmpty(uid) && userid.equals(uid)){
							if(StringUtils.isNotEmpty(uid)){
								if(!actionList.contains(todoAction)){
									actionList.add(todoAction);
									break;
								}
									
							}
						}
					}
				}else{
					//等待处理状态下，当前用户为已经确认过的处理人，则其可以申请复核
					if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT) && !showDoFlag){
						String uid = "";
						for(IG337Info pp:todoRoleList){
							if(IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus()) && 
									IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
								uid = pp.getPpuserid();
								//if(StringUtils.isNotEmpty(uid) && userid.equals(uid)){
								if(StringUtils.isNotEmpty(uid)){
									showDoFlag = true;
									break;	
								}
								
							}
						}
						//等待处理环节当前处理人未确认，则可见确认按钮
						if(!showDoFlag){
							if(!actionList.contains(todoAction))
								actionList.add(todoAction);//可以确认
						}
					}else{
						//非等待处理环节
						if(!todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT)){
							if(!actionList.contains(todoAction))
								actionList.add(todoAction);
						}else{
							//等待处理环节当前处理人未确认，则可见确认按钮
							if(!showDoFlag){
								if(!actionList.contains(todoAction))
									actionList.add(todoAction);//可以确认
							}
						}
						
					}
					
					
				}

			}
			
		}
		
		if(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT.equals(todoAction)){
			if(confirmflag){
				dto.setConfirmflag("0");//可以确认
			}else{
				dto.setConfirmflag("1");//已经确认
			}
		}
		if(showDoFlag){
			dto.setCanDoFlag("1");//当前用户可以处理
			if(!actionList.contains(todoAction))
				actionList.add(todoAction);//可以处理
		}
		
		//如果当前状态为等待处理
		boolean imgFlag = false;//查看页流程图是否高亮等待确认图标
		if(todoAction.equals(IGSRV02BLType.PROCESS_ACTION_IMPLEMENT)){
			//获得等待处理状态下的所有参与者集合
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(processRecord.getPrid(),IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT);
			if(pplist!=null && pplist.size()>0){
				for(IG337Info pp:pplist){
					if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRM.equals(pp.getPpsubstatus())){
						imgFlag = true;
						break;
					}
				}
			}
		}
		if(imgFlag){
			dto.setConfirmImgFlag("1");//存在未确认的参与者
		}else{
			dto.setConfirmImgFlag("0");//不存在未确认的参与者
		}
		
		List<IG337Info> manager = workFlowOperationBL.queryRolemanager(userid, prid);
		if(!manager.isEmpty()) {
			//当前用户是流程参与者角色的负责人
			actionList.add(IGSRV02BLType.PROCESS_ACTION_MANAGER);
		}
		dto.setActionnameList(actionList);
		log.debug("========获取事件处理显示状态结束========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 获取事件处理人 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getImplementors(IGSRV02DTO dto) throws BLException {
		log.debug("========处理人查询处理开始========");
		// 获取已添加角色
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(),IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT);
		dto.setProcessParticipantList(pplist);
		// 获取可添加角色
		List<Role> roleList = workFlowOperationBL.getRoleNotInProcessParticipants(pplist);
		dto.setRoleList(roleList);
		log.debug("========处理人查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 获取历史记录 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getRecordLogs(IGSRV02DTO dto) throws BLException {
		log.debug("========获取事件历史记录处理开始========");
		workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setRecordLogAttachmentMap(workFlowOperationBL.searchRecordLog(dto.getPrid()));
		dto.addMessage(new ActionMessage("IGSVC0211.I001",dto.getPrid()));
		log.debug("========获取事件历史记录处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 获取事件审核人
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getVerifiors(IGSRV02DTO dto) throws BLException {
		log.debug("========审核人查询处理开始========");
		// 获取已添加角色
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(),IGSRV02BLType.PARTICIPANT_STATUS_VERIFY);
		dto.setProcessParticipantList(pplist);
		// 获取可添加角色
		List<Role> roleList = workFlowOperationBL.getRoleNotInProcessParticipants(pplist);
		dto.setRoleList(roleList);
		log.debug("========审核人查询处理终了========");
		return dto;
	}
////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: 删除事件记录
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO delProcessRecord(IGSRV02DTO dto) throws BLException {
		workFlowOperationBL.delProcessRecord(dto.getPrid());
		dto.addMessage(new ActionMessage("IGSVC0201.I001"));
		return dto;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: 查询事件记录
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecords(IGSRV02DTO dto) throws BLException {
		log.debug("========查询事件记录处理开始========");
		boolean flag = false;//流程管理员标识
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(dto.getUser().getUserid());
		for(UserRoleInfo uri:userroleList){
			//判断是否为流程管理员
			if(roleBL.isProcessAdminRole(uri.getRoleid())){
				flag = true;
				break;
			}
		}
		
		
		log.debug("========查询事件记录处理终了========");
		return dto;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: 查询全部流程记录
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessRecordsAll(IGSRV02DTO dto) throws BLException {
		log.debug("========查询全部记录处理开始========");
		boolean flag = false;//流程管理员标识
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(dto.getUser().getUserid());
		for(UserRoleInfo uri:userroleList){
			//判断是否为流程管理员
			if(roleBL.isProcessAdminRole(uri.getRoleid())){
				flag = true;
				break;
			}
		}
		
		log.debug("========查询全部记录处理终了========");
		return dto;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * <p>
	 * Description: 通过prid来查询流程
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public List<IG500Info> searchProcessRecordByKey(Integer prid) throws BLException {
		log.debug("========获取事件基本信息处理开始========");
		return null;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: 用户角色查询
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getUserRoles(IGSRV02DTO dto) throws BLException{
		log.debug("========用户角色查询处理开始========");
		List<UserRoleInfo> roleList = userRoleBL.getUserRoles(dto.getUserid());
		dto.setUserRoleList(roleList);
		log.debug("========用户角色查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 用户非流程角色查询
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesNotInProcess(IGSRV02DTO dto) throws BLException {
		log.debug("========用户非事件角色查询处理开始========");
		List<UserRoleInfo> roleList = userRoleBL.getUserRolesNotInProcess(dto.getUserid());
		dto.setUserRoleList(roleList);
		log.debug("========用户非事件角色查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 获取指定事件状态的参与者
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getProcessParticipantsByStatus(IGSRV02DTO dto) throws BLException {
		log.debug("========获取指定事件状态的参与者处理开始========");
		String status = dto.getStatus();
		if(IGSRV02BLType.PROCESS_STATUS_WAITING_CONFIRM.equals(status)){
			status = IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT;
		}
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(), status);
		if(pplist.isEmpty()){
			throw new BLException("IGSVC0200.E002",
					dto.getPrid().toString());
		}
		String comment = "";
		comment = this.appendLogTitleCssBegin(comment);
		for(IG337Info pp : pplist){
			String message = "未处理";
			if(!IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())&&IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus())){
				message = "未确认";
			}
			if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())&&IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT.equals(pp.getPpstatus())){
				message = "处理中";
			}
			comment +=this.appendLogContent(pp.getPprolename(),(StringUtils.isEmpty(pp.getPpusername())?"":pp.getPpusername())
					+(StringUtils.isEmpty(pp.getPpproctime())?message:"已处理"));
		}
		comment =this.appendLogTitleCssEnd(comment);
		dto.setStatus(comment.replaceAll(",", "&nbsp;&nbsp;&nbsp;&nbsp;"));
		log.debug("========获取指定事件状态的参与者处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 获取用户所具有的指定事件的参与者角色
	 * </p>
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */

	public IGSRV02DTO getUserRolesInProcessParticipants(IGSRV02DTO dto) throws BLException {
		log.debug("========获取用户所具有的指定事件的参与者角色处理开始========");
		List<UserRoleInfo> userRoleList = workFlowOperationBL.getUserRolesInProcessParticipants(dto.getPrid(), dto.getUserid(), dto.getStatus());
		if(userRoleList.isEmpty()){
			throw new BLException("IGSVC0200.E002",
					dto.getPrid().toString());
		}
		//如果当前流程状态为等待处理，则要过滤掉未确认的处理者角色
		if(IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT.equals(dto.getStatus())){
			List<UserRoleInfo> reallist = new ArrayList<UserRoleInfo>();
			//获得等待处理状态下的所有参与者集合
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(),IGSRV02BLType.PROCESS_STATUS_WAITING_IMPLEMENT);
			if(pplist!=null && pplist.size()>0){
				for(IG337Info pp:pplist){
					for(UserRoleInfo uri:userRoleList){
						if(uri.getRoleid().equals(pp.getPproleid())){
							//if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus()) && dto.getUserid().equals(pp.getPpuserid())){
							if(IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
								reallist.add(uri);
							}
						}
					}
					
				}
			}
			if(reallist.size()>0){
				dto.setUserRoleList(reallist);
			}else{
				dto.setUserRoleList(userRoleList);
			}
			
		}else{
			dto.setUserRoleList(userRoleList);
		}

		log.debug("========获取用户所具有的指定事件的参与者角色处理终了========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 查询可以分派的角色
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO getDispatchRoles(IGSRV02DTO dto) throws BLException {
		log.debug("========流程角色查询处理开始========");
		List<Role> roleList = roleBL.getRolesNotInProcess();
		dto.setRoleList(roleList);
		log.debug("========流程角色查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 查询事件类别
	 * <p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentCategory(IGSRV02DTO dto) throws BLException{
		log.debug("========事件类别查询处理开始========");
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("INCIDENT_CATEGORY_CODE").getCcid());
		List<CodeDetail> cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		for(CodeDetail cd : cds){
			if(StringUtils.isNotEmpty(cd.getPccid())){
				continue;
			}
			TreeNode node = new TreeNode();
			node.setId(cd.getCid());
			node.setName(cd.getCvalue());
			node.setRemark("#"+cd.getCid());
			getChildTreeNodeMap(cd.getCcid(),cd.getCid(),node);
			treeNodeMap.put(node.getId(),node);
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========事件类别查询处理开始========");
		return dto;
		
	}

	/**
	 * <p>
	 * Description:  查询叶子节点
	 * </p>
	 * 
	 * @param pccid 数据分类id
	 * @param pcid 数据id
	 * @param parentNode
	 */
	private void getChildTreeNodeMap(String pccid,String pcid,TreeNode parentNode){
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setPccid(pccid);
		cond.setPcid(pcid);
		List<CodeDetail> cds = codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
		for(CodeDetail cd : cds){
			TreeNode node = new TreeNode();
			node.setId(cd.getCid());
			node.setName(cd.getCvalue());
			node.setRemark(parentNode.getRemark()+"#"+cd.getCid());
			getChildTreeNodeMap(cd.getCcid(),cd.getCid(),node);
			parentNode.addChildTreeNode(node.getId(), node);
		}
	}
	
	/**
	 * <p>
	 * 记录日志标题式样拼接开始，暂时是记录人员信息时调用
	 * </p>
	 * 
	 * @param massage 日志描述信息
	 * @return 含有HTML标签的日志描述信息
	 */

	private String appendLogTitleCssBegin(String massage) {
		return massage + "<span>";
	}

	/**
	 * <p>
	 * 记录人员日志内容拼接，暂时记录人员信息时调用
	 * </p>
	 * 
	 * @param rolename 角色名称
	 * @param username 用户名称
	 * @return 含有HTML标签的日志描述信息，已", "结尾，需去掉末尾巴两位
	 */

	private String appendLogContent(String rolename, String username) {
		String str ="";
		if("已处理".equals(username)||"未处理".equals(username)){
			str = rolename+ "(" + username + ")"+ ", ";
		}else{
			str = rolename+ (StringUtils.isEmpty(username) ? ", " : "(" + username + ")"+ ", ");
			
		}
		return str;
	}

	/**
	 * <p>
	 * 记录日志标题式样拼接结束，暂时是记录人员信息时调用
	 * </p>
	 * 
	 * @param massage 日志描述信息
	 * @return 含有HTML标签的日志描述信息
	 */

	private String appendLogTitleCssEnd(String massage) {
		massage=massage.substring(0, massage.length() - 2);
		return massage + "</span>";
	}
	
	
//	/**
//	 * 发短信
//	 * 
//	 * @param participantList
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessage(List<IG337Info> participantList,Integer prid) throws BLException{
//		if(participantList!=null){
//			for(IG337Info pp : participantList){
//				if(!StringUtils.isEmpty(pp.getPpuserid())){
//					sendMessageToUser(pp.getPpuserid(), prid);
//					continue;
//				}
//				if(pp.getPproleid()!=null&&pp.getPproleid()!=0){
//					sendMessageToRole(pp.getPproleid(), prid);
//				}
//			}
//		}
//	}

//	/**
//	 * 给用户发短信
//	 * 
//	 * @param userid
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessageToUser(String userid, Integer prid) throws BLException{
//		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
//		String message = "事件类型为（"+processrecord.getPrpdname() + ")、" + 
//		                 "工单号为("+ processrecord.getPrserialnum() + ")的"+processrecord.getPrtitle()+"事件需要您处理。";
//		sendMessageBL.sendSmsToUser(userid, message);
//	}

//	/**
//	 * 给角色值班手机发短信
//	 * 
//	 * @param roleid
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessageToRole(Integer roleid, Integer prid) throws BLException{
//		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
//		String message = "事件类型为（"+processrecord.getPrpdname() + ")、" + 
//		                 "工单号为("+ processrecord.getPrserialnum() + ")的"+processrecord.getPrtitle()+"事件需要您处理。";
//		sendMessageBL.sendSmsToRole(roleid, message);
//	}
	
//	/**
//	 * 给发起者发短信
//	 * 
//	 * @param userid
//	 * @param prid
//	 * @throws BLException 
//	 */
//	private void sendMessageToOpener(String userid, Integer prid, String sms) throws BLException{
//		IG500Info processrecord = workFlowOperationBL.searchProcessRecordByKey(prid);
//		String message = "事件类型为（"+processrecord.getPrpdname() + ")、" + 
//			             "工单号为("+ processrecord.getPrserialnum() + ")的"+processrecord.getPrtitle()+"事件已"+sms+"。";
//		sendMessageBL.sendSmsToUser(userid, message);
//	}
	
//	/**
//	 * 比较时间
//	 * 
//	 * @param timeA
//	 * @param timeB
//	 * @return int
//	 */
//	private static int getBetweenTimeNumber(String timeA, String timeB) throws Exception {
//		long timeNumber = 0;
//		// 1小时=60分钟=3600秒=3600000
//		long mins = 60L * 1000L;
//		// long time= 24L * 60L * 60L * 1000L;计算天数之差
//		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//		Date d1 = df.parse(timeA);
//		Date d2 = df.parse(timeB);
//		timeNumber = (d2.getTime() - d1.getTime()) / mins;
//		return (int) timeNumber;
//	}
	
	/**
	 * 事件紧急程度服务策略查询
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 */
	
	public IGSRV02DTO searchIncidentUrgency(IGSRV02DTO dto) throws BLException{
		
		QuartzJobsSearchCondImpl cond = new QuartzJobsSearchCondImpl();
		cond.setQjname(JOBCONSTANTS.INCIDENT_MONITOR);
		List<QuartzJobs> qjList = quartzJobsBL.searchQuartzJobs(cond, 0, 0);
		if (qjList.size() > 1) {
			throw new BLException("IGSCH0401.E001");
		}
		
		for (QuartzJobs quartzJobs : qjList) {
			String[] resolveTime =quartzJobs.getQjinfo().split("#");
			String temp = "" ;
			for(String str : resolveTime){
				if("-1".equals(str)){
					temp += "#";
				}else{
					temp += this.dateOperation(dto.getProcess().getPropentime(),Integer.parseInt(str))+"#";
				}
			}
			dto.setUrgency(quartzJobs.getQjorgname());
			dto.setResolveTime(temp);
		}
		 return dto;
	}
	
	/**
	 * 累计时间
	 * @param dateStr
	 * @param m
	 * @return
	 */
	private String dateOperation(String dateStr,int m){
		
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");   
		Date mydate;
		try {
			mydate = myFormatter.parse(dateStr);
			Calendar cal=Calendar.getInstance();
			cal.setTime(mydate);
			cal.add(Calendar.MINUTE,m); //加分钟数
			return myFormatter.format(cal.getTime());
		} catch (ParseException e) {
			log.error(e);
			return "";
		}
	}
	
	/**
	 * <p>
	 * Description: 获取未确认参与者
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGSRV02DTO getConfirmer(IGSRV02DTO dto) throws BLException {
		log.debug("========获取未确认参与者处理开始========");
		Integer prid = dto.getPrid();
		List<IG337Info> piList = workFlowOperationBL.searchProcessParticipant(prid, IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT);
		List<UserRoleInfo> uiList = workFlowOperationBL.getUserRolesInProcessParticipants(prid, dto.getUserid(), IGSRV02BLType.PARTICIPANT_STATUS_IMPLEMENT);
		List<IG337Info> confirmerList = new ArrayList<IG337Info>();
		for(int i=0;i<piList.size();i++){
			IG337Info pp =piList.get(i);
			for(UserRoleInfo ur : uiList){
				if(pp.getPproleid().equals(ur.getRoleid()) && !IGSRV02BLType.PROCESS_SUB_STATUS_CONFIRMED.equals(pp.getPpsubstatus())){
					confirmerList.add(pp);
					break;
				}
			}
		}
		if(confirmerList.size()==0){
			throw new BLException("IGSVC0215.E001");
		}
		log.debug("========获取未确认参与者处理终了========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 获取执行人
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSRV02DTO searchAssignPersonAction(IGSRV02DTO dto) throws BLException {
		log.debug("========执行人查询处理开始========");
		// 获取已添加角色
		List<IG337Info> pplist = workFlowOperationBL.queryRolemanager(dto.getUserid(), dto.getPrid());
		dto.setProcessParticipantList(pplist);
		log.debug("========执行人查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 获取流程状态列表
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangshengnan@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinition(IGSRV02DTO dto) throws BLException {
		
		log.debug("========流程状态列表信息查寻处理开始========");
		
  		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(IGPROCESSType.INCIDENT_PRTYPE);
		List<IG259Info> pts = workFlowDefinitionBL.searchProcessTemplate(cond);
		cond.setPttype(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID);
		List<IG259Info> zdypts = workFlowDefinitionBL.searchProcessTemplate(cond);
		pts.addAll(zdypts);
		
  		IG380SearchCondImpl pdCond = new IG380SearchCondImpl();
		String[] pdstatuses = new String[2];
		pdstatuses[0] = "a";
		pdstatuses[1] = "t";
		pdCond.setPdstatuses(pdstatuses);
		
		List<IG380Info> pds = new ArrayList<IG380Info>();
		for(IG259Info pt : pts) {
			pdCond.setPtid(pt.getPtid());
			pds.addAll(workFlowDefinitionBL.searchProcessDefinition(pdCond));
		}

		dto.setProcessDefinitionList(pds);
		
		log.debug("========流程状态列表信息查寻处理终了========");
		return dto;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: 获取全部流程状态列表
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update yangliang@deliverik.com
	 */
	
	public IGSRV02DTO getProcessDefinitionAll(IGSRV02DTO dto) throws BLException {
		
		log.debug("========流程状态列表信息查寻处理开始========");
	
  		IG380SearchCondImpl pdCond = new IG380SearchCondImpl();
		
		List<IG380Info> pds = workFlowDefinitionBL.searchProcessDefinition(pdCond);
		
		dto.setProcessDefinitionList(pds);
		
		log.debug("========流程状态列表信息查寻处理终了========");
		return dto;
	}
/////////////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * <p>
	 * Description: 流程状态日志查看 
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGSRV02DTO searchRecordStatusLogAction(IGSRV02DTO dto) throws BLException {
		log.debug("========事件状态日志查看处理开始========");
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","事件基本");
		}
		dto.setRecordStatusLogList(this.workFlowOperationBL.searchRecordStatusLog(dto.getPrid()));
		
		log.debug("========事件状态日志查看处理终了========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 增加归类字段的处理，不想修改底层，所以此字段的值都添加到标题字段中
	 * </p>
	 * 
	 * @param dto IGSRV02DTO
	 * @return IGSRV02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSRV02DTO getSortOrder(IGSRV02DTO dto) throws BLException{
		
		String ptitle = dto.getPrtitle();
		String param = "";
		//是否选择归类字段进行排序
		if(StringUtils.isNotEmpty(dto.getPsort_order()))
		{
			param = dto.getPsort_order();
		}
		
		//点击字段名称排序
		if(StringUtils.isNotEmpty(dto.getPOrder()))
		{
			if(StringUtils.isEmpty(param))
			{
				param = dto.getPOrder();
			}
			else
			{
				if(dto.getPOrder().startsWith(dto.getPSort()))
				{
					param = dto.getPOrder();
					dto.setPsort_order(dto.getPOrder());
				}
				else
				{
					param = param + "," + dto.getPOrder();
				}
			}
		}
		
		if(StringUtils.isNotEmpty(param))
		{
			ptitle = StringUtils.isEmpty(ptitle) ? "&&&" + param : ptitle + "&&&" + param;
		}
		dto.setPrtitle(ptitle);
		return dto;
	}
}
