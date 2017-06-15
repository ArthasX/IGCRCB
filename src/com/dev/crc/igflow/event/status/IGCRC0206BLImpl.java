/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
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
import com.deliverik.framework.workflow.prd.bl.task.IG237BL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.util.DateUtils;

/**
  * 概述: 流程策略管理业务逻辑接口
  * 功能描述: 流程策略管理业务逻辑接口
  * 创建记录: 2013/09/04
  * 修改记录: 
  */
public class IGCRC0206BLImpl implements WorkFlowTacticsHandlerBL {

	static Log log = LogFactory.getLog(IGCRC0206BLImpl.class);
	
	/** 更新功能API类 */
	@SuppressWarnings("unused")
	private FlowSetBL flowSetBL;
	
	/** 通知策略基本信息查询BL */
	protected IG334BL ig334BL;

	/** 流程定义状态信息查询BL */
	protected IG333BL ig333BL;
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 流程策略业务查询BL */
	protected  IG256BL ig256BL;
	
	/** 流程跃迁BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 用户BL */
	protected UserBL userBL;

	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** 发送短信BL */
	protected SendMessageBL sendMessageBL;
	
	/** 发送邮件BL */
	protected SendMailBL sendMailBL;
	
	/** 表单类型信息查询BL */
	protected IG380BL ig380BL;
	
	/** 表单策略信息查询BL */
	protected IG335BL ig335BL;
	
	/** 流程参与用户信息业务BL */
	protected IG337BL ig337BL;
	
	/** 报告上级指定人员查询BL */
	protected IG237BL processNoticeStrategyUserBL;
	/**
	 * 更新功能API类设定
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * 通知策略基本信息查询BL设定
	 * @param ig334bl 通知策略基本信息查询BL
	 */
	public void setIg334BL(IG334BL ig334bl) {
		ig334BL = ig334bl;
	}
	
	/**
	 * 流程定义状态信息查询BL设定
	 *
	 * @param ig333BL 流程定义状态信息查询BL
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}

	/**
	 * 查询类功能API类设定
	 * @param flowSearchBL 查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 流程跃迁BL设定
	 *
	 * @param workFlowOperationBL 流程跃迁BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	/**
	 * 流程策略业务查询BL设定
	 *
	 * @param ig256BL 流程策略业务查询BL
	 */
	public void setIg256BL(IG256BL ig256BL) {
		this.ig256BL = ig256BL;
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
	 * 用户角色BL设定
	 *
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
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
	 * 表单类型信息查询BL设定
	 *
	 * @param ig380BL 表单类型信息查询BL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
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
	 * 流程参与用户信息业务BL
	 * @param ig337bl 流程参与用户信息业务
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}
	
	/**
	 * 报告上级指定人员查询BL设定
	 *
	 * @param processNoticeStrategyUserBL 报告上级指定人员查询BL
	 */
	public void setProcessNoticeStrategyUserBL(IG237BL processNoticeStrategyUserBL) {
		this.processNoticeStrategyUserBL = processNoticeStrategyUserBL;
	}

	/**
	 * 初始化入口
	 * 
	 * @param pdid
	 * @param psdid
	 * @throws BLException 
	 * @throws JobExecutionException 
	 * @throws JobExecutionException 
	 */
	public void initExecute(String pdid, String psdid) throws BLException{
		System.out.println("**********************************************");
		//报告上级
		this.regulation(pdid, psdid);
		System.out.println("**********************************************");
	}
	/**
	 * 流程状态策略判断的规则的事件
	 * 
	 * @param pdid 
	 * @param psdid 
	 * @throws BLException
	 */
	public void regulation(String pdid, String psdid) throws BLException{
		String type = "ⅠⅡⅢⅣⅤ";
		//没有流程类型ID时不激活报告上级策略
		if(StringUtils.isEmpty(pdid)){
			log.debug("流程类型ID为不能为空。");
			return;
		}else{
			//根据流程类型查询流程类型名称
			IG380Info ig380Info = ig380BL.searchIG380InfoByKey(pdid);
			if(ig380Info == null){
				log.debug("在流程类型表中没有此类型的流程。");
				return;
			}
		}
		//查询流程是否设置通知策略信息
		IG334SearchCondImpl ig334cond = new IG334SearchCondImpl();
		ig334cond.setPdid_like(pdid);
		List<IG334Info> lstIG334 = this.ig334BL.searchIG334(ig334cond);
		if(lstIG334 != null && lstIG334.size() > 0){//存在结果时才有通知策略
			IG334Info ig334Info = lstIG334.get(0);//一般只会存在一行记录
			String pidid = ig334Info.getPidid();//获取相应表单ID(无表单相关时表单ID以000结束)
			//需要查询IG335表中关于流程整体的通知策略设置
			IG335SearchCondImpl ig335cond = new IG335SearchCondImpl();
			ig335cond.setPsdid_eq(psdid);
			ig335cond.setPidid_eq(pidid);
			ig335cond.setPdid_eq(pdid);
			List<IG335Info> lstIG335 = ig335BL.searchIG335(ig335cond);
			if(lstIG335 != null && lstIG335.size() > 0){//存在结果时才有通知策略
				for(IG335Info ig335Info : lstIG335){
					String roleManager = ig335Info.getRolemanager();//通知策略设置角色ID
					String processbl = ig335Info.getProcessbl();//通知策略执行BL
					if(StringUtils.isEmpty(ig335Info.getProcessbl())) {//为空时设置为默认的流程整体策略BL
						processbl = IGPRDCONSTANTS.PROCESS_TACTICS_WHOLE;
					}
					if(StringUtils.isNotEmpty(roleManager) && roleManager.equals("1") && StringUtils.isNotEmpty(processbl)){//存在角色ID且存在通知策略执行BL时
						
						//根据流程类型ID查询所有未关闭的流程
						IG500SearchCondImpl cond = new IG500SearchCondImpl();
						cond.setPrpdid(pdid);
						cond.setPrstatus("W");
						List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
						//没有未关闭流程不需要进行超时校验
						if(lstIG500Info == null || lstIG500Info.isEmpty()){
							log.debug("事件类型的流程没有未关闭的需要执行通知策略判断。");
							return;
						}
						
						for(IG500Info info : lstIG500Info){
							
							Integer prid = info.getPrid();
							//根据流程的发起时间和当前时间差(结果按分钟显示)与流程整体设置的策略(结果按分钟显示)进行比较判断是否超时
							//进入到该节点的时间
							IG337SearchCondImpl ig337Cond = new IG337SearchCondImpl();
							ig337Cond.setPrid(prid);
							ig337Cond.setPpstatus("W");
							ig337Cond.setPpproctimeIsNull("Y");
							List<IG337Info> ig337InfoList = ig337BL.getIG337Infos(ig337Cond);
							if(ig337InfoList == null || ig337InfoList.size()<1 
									|| StringUtils.isNotEmpty(ig337InfoList.get(0).getPpproctime())){
								continue;
							}
							/*IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
							ig256Cond.setPrid(prid);
							ig256Cond.setFlag("4");
							List<IG256Info> ig256InfoList = ig256BL.searchIG256(ig256Cond);
							if(ig256InfoList!=null && ig256InfoList.size()>0){
								continue;
							}*/
							String initTimeDate = ig337InfoList.get(0).getPpinittime();//流程的发起日期时间
							String currTimeDate = IGStringUtils.getCurrentDateTime();//系统当前时间
							Long nodifyMin = getWholeNodifyMinutes(ig335Info.getReportd(), ig335Info.getReporth(), ig335Info.getReportm());//获取流程整体超时通知策略设置的超时时间
							Long dMin = DateUtils.getTimeDifferenceByMinutes(initTimeDate, currTimeDate);//获取当前时间差
							if(dMin > nodifyMin){//当当前时间差大于流程整体超时设置时间时发送超时通知
								//超时通知设置并在IG500表中记录已发送超时提醒
								IG500TB ig500TB = (IG500TB)SerializationUtils.clone(info);
								ig500TB.setPrPriority(IGPRDCONSTANTS.PROCESS_OVERTIME);
								IG500Info ig500Info = workFlowOperationBL.updateProcessRecord(ig500TB);
								
								//查询是否发过提醒信息
								IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
								ig256Cond.setPrid(info.getPrid());
								ig256Cond.setPrstatus(info.getPrstatus());
								ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);// 通知标识 值域 0:通知 1:超时2:报告上级
								List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
								//已发送过提醒通知不需要再次激活报告上级策略
								if(ig256Infos != null && ig256Infos.size() > 0){
									continue;
								}
								
								//发送超时通知信息
								this.processSend(ig334Info, ig500Info, currTimeDate);
							
								IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
								ig599Cond.setPrid(prid);//流程ID
								ig599Cond.setPivarlabel("事件级别");//表单名称
								List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(ig599Cond);
								if(lst_ProcessInfo.isEmpty()) {
									throw new BLException("IGFLOW0000.E001", "表单（事件级别）");
								} else if(lst_ProcessInfo.size() > 1) {
									throw new BLException("IGFLOW0000.E002", "表单（事件级别）");
								} else{
									IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
									String grade = instance.getPivarvalue();
									if(type.indexOf(grade) == 4){
										grade = "Ⅴ";
									}else if(type.indexOf(grade) == -1){
										
									}else{
										//将时间的级别增加一级
										grade = type.substring(type.indexOf(grade)+1, type.indexOf(grade)+2);
									}
									instance.setPivarvalue(grade);
									workFlowOperationBL.updateProcessInfo(instance);
								}
							}
						}
					}
				}
			}
		}
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
					User user = userBL.searchUserByKey("000117");
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
					sendSmsUserInfo.put("000117", new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
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
		saveRemindMessage(ig500Info.getPrid(), ig500Info.getPrpdid(),ig500Info.getPrstatus() , "000117", "李健" , IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
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
	
	/**
	 * 获取短信内容
	 * 
	 * @param message
	 * @param args
	 * @return
	 */
	private String getMessage(String message,List<String> args){
		if(args != null && args.size() > 0){
			for(int i = 0; i< args.size(); i++){
				message = StringUtils.replace(message, "{"+i+"}", args.get(i));
			}
		}
		return message;
	}
	/**
	 * 发短信
	 * 
	 * @param roleid
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMessage(Integer roleid, String userid, String message,List<String> args) throws BLException{
		if (StringUtils.isEmpty(userid)) {
			sendMessageToRole(roleid, message, args);
		} else {
			sendMessageToUser(userid, message, args);
		}
	}
	
	/**
	 * 给用户发短信
	 * 
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMessageToUser(String userid,String message,List<String> args) throws BLException{
		message = getMessage(message,args);
		sendMessageBL.sendSmsToUser(userid, message);
	}
	/**
	 * 给角色负责人手机发短信
	 * 
	 * @param roleid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMessageToRole(Integer roleid, String message, List<String> args) throws BLException{
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(roleid);
		cond.setRolemanager(true);
		List<UserRoleInfo> userRole = userRoleBL.searchUserRoleVW(cond);
		for(UserRoleInfo info: userRole){
			sendMessageToUser(info.getUserid(), message, args);
		}
	}
	/**
	 * 发邮件
	 * 
	 * @param roleid
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMail(String title,List<String> argsTitle,String content,List<String> argsContent,Integer roleid, String userid) throws BLException{
		if (StringUtils.isEmpty(userid)) {
			UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
			cond.setRoleid(roleid);
			cond.setRolemanager(true);
			List<UserRoleInfo> userRole = userRoleBL.searchUserRoleVW(cond);
			for(UserRoleInfo info: userRole){
				sendMailToUser(title,argsTitle,content,argsContent,info.getUserid());
			}
		} else {
			sendMailToUser(title,argsTitle,content,argsContent,userid);
		}
	}
	
	/**
	 * 给用户发邮件
	 * 
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMailToUser(String title,List<String> argsTitle,String content,List<String> argsContent, String userid) throws BLException{
		User user = userBL.searchUserByKey(userid);
		if(StringUtils.isEmpty(user.getUseremail())){
			log.debug("用户"+user.getUserid()+"没有设置邮箱！无法发送邮件");
			return;
		}
		title = getMessage(title,argsTitle);
		content = getMessage(content,argsContent);
		
		String[] address = new String[1];
		address[0] = user.getUseremail();
		sendMailBL.sendMail(title, content, address);
	}
	
	/**
	 * 提醒信息保存
	 * @param prid 流程ID
	 * @param pdid 流程定义ID
	 * @param prstatus 流程状态
	 * @param ppuserid 参与人id
	 * @param ppusername 参与人名称
	 * @param flag 提醒或超时标记
	 * @throws BLException
	 */
	private void saveRemindMessage(Integer prid, String pdid, String prstatus, String ppuserid, String ppusername, String flag) throws BLException {
		IG256TB ig256tb = ig256BL.getIG256TBInstance();
		ig256tb.setFlag(flag);
		ig256tb.setPdid(pdid);
		ig256tb.setPrid(prid);
		ig256tb.setPpuserid(ppuserid);
		ig256tb.setPpusername(ppusername);
		ig256tb.setPrstatus(prstatus);
		ig256BL.registIG256(ig256tb);
	}
	
	
}
