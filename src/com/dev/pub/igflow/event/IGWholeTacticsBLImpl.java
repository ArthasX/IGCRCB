/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.pub.igflow.event;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * 概述：流程整体超时的实现BL
 * 功能描述：流程整体超时的实现BL
 * 创建记录：2014/06/10
 * (1)此方法是流程整体超时策略的通知提醒
 * (2)此方法是期望流程结束时间若超时进行提醒
 * 修改记录：
 */
public class IGWholeTacticsBLImpl extends BaseBLImpl implements WorkFlowTacticsHandlerBL {
//extends IGReportSuperTacticsBLImpl
	static Log log = LogFactory.getLog(IGWholeTacticsBLImpl.class);
	
	/** 流程跳转BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 查询类功能API类 */
	protected FlowSearchBL flowSearchBL;
	
	/** 查询角色授权信息BL */
	protected UserRoleBL userRoleBL;

	/** 查询用户信息BL */
	protected UserBL userBL;
	
	/** 发送短信BL */
	protected SendMessageBL sendMessageBL;
	
	/** 发送邮件BL */
	protected SendMailBL sendMailBL;
	
	/** 通知策略基本信息查询BL */
	protected IG334BL ig334BL;
	
	/** 表单策略信息查询BL */
	protected IG335BL ig335BL;
	
	/** 表单类型信息查询BL */
	protected IG380BL ig380BL;
			
	/**
	 * 流程跳转BL设定
	 *
	 * @param workFlowOperationBL 流程跳转BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * 查询类功能API类设定
	 *
	 * @param flowSearchBL 查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 查询角色授权信息BL设定
	 *
	 * @param userRoleBL 查询角色授权信息BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 查询用户信息BL设定
	 *
	 * @param userBL 查询用户信息BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 发送短信BL设定
	 *
	 * @param sendMessageBL 发送短信BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 发送邮件BL设定
	 *
	 * @param sendMailBL 发送邮件BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/**
	 * 通知策略基本信息查询BL设定
	 *
	 * @param ig334BL 通知策略基本信息查询BL
	 */
	public void setIg334BL(IG334BL ig334BL) {
		this.ig334BL = ig334BL;
	}
	
	/**
	 * 表单策略信息查询BL设定
	 *
	 * @param ig335BL 表单策略信息查询BL
	 */
	public void setIg335BL(IG335BL ig335BL) {
		this.ig335BL = ig335BL;
	}
	
	/**
	 * 表单类型信息查询BL设定
	 *
	 * @param ig380BL 表单类型信息查询BL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	
	/**
	 * 流程超时判断
	 */
	public void initExecute(String pdid, String psdid) throws BLException {
		//调用流程超时判断
		this.processTactics(pdid, psdid);
	}

	/**
	 * 流程超时方法
	 * @throws BLException 
	 */
	public void processTactics(String pdid, String psdid) throws BLException{
		log.debug("========流程整体超时判断策略处理开始========");
		//根据流程类型查询流程类型名称
		IG380Info ig380Info = ig380BL.searchIG380InfoByKey(pdid);
		if(ig380Info == null){
			log.debug("在流程类型表中没有此类型的流程。");
			return;
		}
		String pdname = ig380Info.getPdname();//流程类型名称
		//查询流程是否设置通知策略信息
		IG334SearchCondImpl ig334cond = new IG334SearchCondImpl();
		ig334cond.setPdid_like(pdid);
		List<IG334Info> lstIG334 = this.ig334BL.searchIG334(ig334cond);
		if(lstIG334 != null && lstIG334.size() > 0){//存在结果时才有通知策略
			IG334Info ig334Info = lstIG334.get(0);//一般只会存在一行记录
			String pidid = ig334Info.getPidid();//获取相应表单ID(无表单相关时表单ID以000结束)
			//需要查询IG335表中关于流程整体的通知策略设置
			IG335SearchCondImpl ig335cond = new IG335SearchCondImpl();
			ig335cond.setPsdid_eq(IGPRDCONSTANTS.MAIN_PROCESS_FLAG);
			ig335cond.setPidid_eq(pidid);
			ig335cond.setPdid_eq(pdid);
			List<IG335Info> lstIG335 = ig335BL.searchIG335(ig335cond);
			if(lstIG335 != null && lstIG335.size() > 0){//存在结果时才有通知策略
				for(IG335Info ig335Info : lstIG335){
					Integer roleid = ig335Info.getRoleid();//通知策略设置角色ID
					String processbl = ig335Info.getProcessbl();//通知策略执行BL
					if(StringUtils.isEmpty(ig335Info.getProcessbl())) {//为空时设置为默认的流程整体策略BL
						processbl = IGPRDCONSTANTS.PROCESS_TACTICS_WHOLE;
					}
					if(roleid > 0 && StringUtils.isNotEmpty(processbl)){//存在角色ID且存在通知策略执行BL时
						//根据流程类型ID查询所有未关闭的流程
						IG500SearchCondImpl cond = new IG500SearchCondImpl();
						cond.setPrActive("Y");
						cond.setPrpdid(pdid);
						List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
						
						//没有未关闭流程不需要进行超时校验
						if(lstIG500Info == null || lstIG500Info.isEmpty()){
							log.debug(pdname+"类型的流程没有未关闭的需要执行通知策略判断。");
							return;
						}
						
						for(IG500Info info : lstIG500Info) {
							boolean isMatch = true;//是否匹配默认匹配即进行通知策略处理
							//获取当前流程对应相关下拉列表表单值是否与IG335表中进行设置的值相同
							String pivarvalue = "";
							if(StringUtils.isNotEmpty(ig334Info.getPidname())){
								pivarvalue = flowSearchBL.searchPublicProcessInfo(info.getPrid(), ig334Info.getPidname());
							}
							if(StringUtils.isNotEmpty(pivarvalue)){
								if(!pivarvalue.equals(ig335Info.getPivalue())){
									isMatch = false;
								}
							}
							if(!isMatch){//表单值和设置的值不匹配时跃过处理进行下个数据判断
								continue;
							}
							//已超时的流程不需要再次进行超时操作
							if(StringUtils.isNotEmpty(info.getPrPriority()) && IGPRDCONSTANTS.PROCESS_OVERTIME.equals(info.getPrPriority())){
								continue;
							}
							
							//根据流程的发起时间和当前时间差(结果按分钟显示)与流程整体设置的策略(结果按分钟显示)进行比较判断是否超时
							String initTimeDate = info.getPropentime();//流程的发起日期时间
							String currTimeDate = IGStringUtils.getCurrentDateTime();//系统当前时间
							Long nodifyMin = getWholeNodifyMinutes(ig335Info.getNotifyd(), ig335Info.getNotifyh(), ig335Info.getNotifym());//获取流程整体超时通知策略设置的超时时间
							Long dMin = DateUtils.getTimeDifferenceByMinutes(initTimeDate, currTimeDate);//获取当前时间差
							
							if(dMin > nodifyMin){//当当前时间差大于流程整体超时设置时间时发送超时通知
								//超时通知设置并在IG500表中记录已发送超时提醒
								IG500TB ig500TB = (IG500TB)SerializationUtils.clone(info);
								ig500TB.setPrPriority(IGPRDCONSTANTS.PROCESS_OVERTIME);
								IG500Info ig500Info = workFlowOperationBL.updateProcessRecord(ig500TB);
								
								//发送超时通知信息
								this.processSend(ig334Info, ig500Info, currTimeDate);
							}
						}
					}
				}
			} else {
				log.debug(pdname+"类型的流程未进行整体流程通知策略的设置。");
			}
		} else {
			log.debug(pdname+"类型的流程未进行通知策略的设置。");
		}
		log.debug("========流程整体超时判断策略处理结束========");
	}
	
	/**
	 * 流程超时发送提醒
	 * 
	 * @param info
	 * @throws BLException
	 */
	public void processSend(IG334Info info, IG500Info ig500Info, String now) throws BLException{
		/**
		 * 根据流程查询当前处理人 并发送短信或邮件，人员或角色
		 */
		//消息发送人Map Mail
		Map<String,String[]> sendMailUserInfo = new HashMap<String, String[]>();
		//消息发送人Map Sms
		Map<String,String[]> sendSmsUserInfo = new HashMap<String, String[]>();
		
		
		//根据prid流程当前状态的状态名称
		List<ProcessStatusInfo> psiCList = flowSearchBL.searchCurrentStatus(ig500Info.getPrid());
		String psdName = "";
		if (psiCList != null && psiCList.size() > 0) {
			ProcessStatusInfo psdInfo = flowSearchBL.searchProcessStatus(psiCList.get(0).getPsdid());
			psdName = psdInfo.getPsdname();
		}
		
		//给发起人发送提醒
		if(ig500Info != null){
			//发送短信
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
				//存放发送用户信息
				sendSmsUserInfo.put(ig500Info.getPruserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//				sendMessageBL.sendSmsToUser(ig500Info.getPruserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
			}			
			//发送邮件
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())){	
				User user = userBL.searchUserByKey(ig500Info.getPruserid());
				if(StringUtils.isEmpty(user.getUseremail())){
					log.debug("用户"+user.getUserid()+"没有设置邮箱！无法发送邮件");
					return;
				}
				String[] address = new String[1];
				address[0] = user.getUseremail();
				//存放发送用户信息
				sendMailUserInfo.put(ig500Info.getPruserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//				sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), address);
			}
		}
		
		//根据流程状态与流程ID获取该状态下的参与者信息
		List<IG337Info> ig337Infos = workFlowOperationBL.searchProcessParticipant(ig500Info.getPrid(), ig500Info.getPrstatus());
		for(int i = 0; i < ig337Infos.size(); i++) {
			//如果参与者指定到角色通过角色id获取角色下所有人发通知
			if(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE.equals(ig337Infos.get(i).getPptype())){
				if(ig337Infos.get(i).getPproleid() > 0){
					continue;
				}
				//获取角色下所有人
				UserRoleVWSearchCondImpl urvwCond = new UserRoleVWSearchCondImpl();
				urvwCond.setRoleid(ig337Infos.get(i).getPproleid());
				List<UserRoleInfo> userRoleInfos = userRoleBL.searchUserRoleVW(urvwCond);
				for(int j = 0; j < userRoleInfos.size(); j++) {
					//根据策略发送通知
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())){//邮件通知
						User user = userBL.searchUserByKey(userRoleInfos.get(j).getUserid());
						if(StringUtils.isEmpty(user.getUseremail())){
							log.debug("用户"+user.getUserid()+"没有设置邮箱！无法发送邮件");
							return;
						}						
						String[] address = new String[1];
						address[0] = user.getUseremail();
						//存放发送用户信息
						sendMailUserInfo.put(userRoleInfos.get(j).getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now,address[0]});
//						sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now),	address);
					}
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){//短信通知
						//存放发送用户信息
						sendSmsUserInfo.put(userRoleInfos.get(j).getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//						sendMessageBL.sendSmsToUser(userRoleInfos.get(j).getUserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
					}
				}
			//指定到人直接发通知
			} else{
				//邮件通知
				if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())) {
					User user = userBL.searchUserByKey(ig337Infos.get(i).getPpuserid());
					if(StringUtils.isEmpty(user.getUseremail())){
						log.debug("用户"+user.getUserid()+"没有设置邮箱！无法发送邮件");
						return;
					}
					String[] address = new String[1];
					address[0] = user.getUseremail();
					//存放发送用户信息
					sendMailUserInfo.put(ig337Infos.get(i).getPpuserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//					sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), address);
				}
				//短信通知
				if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
					//存放发送用户信息
					sendSmsUserInfo.put(ig337Infos.get(i).getPpuserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//					sendMessageBL.sendSmsToUser(ig337Infos.get(i).getPpuserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
				}
			}//end if
		}//end for
		
		//查询指定角色授权人员
		UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
		//没有指定的角色不发送提醒
		if(info.getRoleid() != null && info.getRoleid() > 0){
			urcond.setRoleid(info.getRoleid());
			List<UserRole> lstUserRole = userRoleBL.searchUserRole(urcond);
			//指定角色中没有人不发送提醒
			if(lstUserRole != null && lstUserRole.size() > 0){
				for(UserRole userRole : lstUserRole) {
					//发送短信
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
						//存放发送用户信息
						sendSmsUserInfo.put(userRole.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//						sendMessageBL.sendSmsToUser(userRole.getUserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
					}
					
					//发送邮件
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())){			
						User user = userBL.searchUserByKey(userRole.getUserid());
						if(StringUtils.isEmpty(user.getUseremail())){
							log.debug("用户"+user.getUserid()+"没有设置邮箱！无法发送邮件");
							return;
						}
						String[] address = new String[1];
						address[0] = user.getUseremail();
						//存放发送用户信息
						sendMailUserInfo.put(userRole.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//						sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now),	address);
					}
				}
			}
		}
		
		//发送邮件
		if(!sendMailUserInfo.isEmpty()) {
			Set<String> userIds = sendMailUserInfo.keySet();
			for(String userid : userIds) {
				String[] messageInfos = sendMailUserInfo.get(userid);
				sendMailBL.sendMail(messageFormatFactory(messageInfos[0], messageInfos[1], messageInfos[2], messageInfos[3]), 
									messageFormatFactory(messageInfos[0], messageInfos[1], messageInfos[2], messageInfos[3]), 
									new String[]{messageInfos[4]});
			}
		}
		
		//发送短信
		if(!sendSmsUserInfo.isEmpty()) {
			Set<String> userIds = sendSmsUserInfo.keySet();
			for(String userid : userIds) {
				String[] messageInfos = sendSmsUserInfo.get(userid);
				sendMessageBL.sendSmsToUser(userid, messageFormatFactory(messageInfos[0], messageInfos[1], messageInfos[2], messageInfos[3]));
			}
		}
	}
	
	/**
	 * 提示信息模板
	 * 
	 * @param prstatus
	 * @param prserialnum
	 * @param prtitle
	 * @param now
	 * @return
	 */
	private String messageFormatFactory(String prstatus, String prserialnum, String prtitle, String now) {
		return "工作提醒：当前时间为【" + now + "】，请注意状态为 【"+prstatus+"】 的工单号为【" + prserialnum + "】的 【" + prtitle + "】流程已经超时！请相关人员尽快完成工作";
	}
	
	/**
	 * Tools
	 */
	/**
	 * 根据IG335表设置的超时提醒天\小时\分钟计算超时的时间(结果按分钟显示)
	 * @param notifyd 超时天
	 * @param notifyh 超时小时
	 * @param notifym 超时分钟
	 * @return
	 */
	private Long getWholeNodifyMinutes(Integer notifyd, Integer notifyh, Integer notifym) {
		long result = 0l;//预先设置结果
		if(notifyd != null){
			result += (notifyd * 24 * 60);
		}
		if(notifyh != null){
			result += (notifyh * 60);
		}
		if(notifym != null){
			result += notifym;
		}
		return result;
	}
}