/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.pub.igflow.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG237BL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowTacticsHandlerBL;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;

/**
 * 概述：流程策略中报告上级的实现(通用父级类)
 * 功能描述：流程策略中报告上级的实现(通用父级类)
 * 创建记录：2014/06/17
 * (1)增加无表单关联的相应修正
 * 修改记录：
 */
public class IGReportSuperTacticsBLImpl extends BaseBLImpl implements WorkFlowTacticsHandlerBL {

	static Log log = LogFactory.getLog(IGReportSuperTacticsBLImpl.class);
	
	/** 提醒内容属性 */
	/** 短信通知提醒内容 */
	public String smsNotify;
	public String smsReport;
	public String mailTitleNotify;
	public String mailContentNotify;
	public String mailTitilReport;
	public String mailContectReport;
	
	/** 短信BL */
	protected SendMessageBL sendMessageBL;
	
	/** 邮件BL */
	protected SendMailBL sendMailBL;
	
	/** 用户BL */
	protected UserBL userBL;

	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/** 基础数据CodeDetailBL */
	protected CodeDetailBL codeDetailBL;
	
	/** 报告上级指定人员查询BL */
	protected IG237BL processNoticeStrategyUserBL;
	
	/** 通知策略基本信息查询BL */
	protected IG334BL ig334BL;
	
	/** 流程定义状态信息查询BL */
	protected IG333BL ig333BL;
	
	/** 流程跃迁BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 功能查询BL */
	protected FlowSearchBL flowSearchBL;
	
	/** 流程策略业务查询BL */
	protected  IG256BL ig256BL;
	
	/**
	 * 短信BL设定
	 *
	 * @param sendMessageBL 短信BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 邮件BL设定
	 *
	 * @param sendMailBL 邮件BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
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
	 * 基础数据CodeDetailBL设定
	 *
	 * @param codeDetailBL 基础数据CodeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
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
	 * 通知策略基本信息查询BL设定
	 *
	 * @param ig334BL 通知策略基本信息查询BL
	 */
	public void setIg334BL(IG334BL ig334BL) {
		this.ig334BL = ig334BL;
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
	 * 流程跃迁BL设定
	 *
	 * @param workFlowOperationBL 流程跃迁BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 功能查询BL设定
	 *
	 * @param flowSearchBL 功能查询BL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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
	 * 初始化入口
	 * 
	 * @param pdid
	 * @param psdid
	 * @throws BLException 
	 * @throws JobExecutionException 
	 * @throws JobExecutionException 
	 */
	public void initExecute(String pdid, String psdid) throws BLException{
		//报告上级
		try {
			this.reportSuperior(pdid, psdid);
		} catch (JobExecutionException e) {
			e.printStackTrace();
			throw new BLException("流程报告上级失败！");
		}
		this.regulation(pdid, psdid);
	}
	
	/**
	 * 报告上级需要的方法
	 * @throws JobExecutionException 
	 * @throws BLException 
	 */
	public void reportSuperior(String pdid, String psdid) throws JobExecutionException, BLException{
		//没有流程类型ID时不激活报告上级策略
		if(StringUtils.isEmpty(pdid)){
			log.debug("流程类型ID为不能为空。");
			return;
		}
		
		//报告上级时间设定
		Integer reportd = 0;//天
		Integer reporth = 0;//小时
		Integer reportm = 0;//分
		
		//流程策略设定信息查询条件实例化
		IG334SearchCondImpl condIg334 = new IG334SearchCondImpl();
		//流程策略设定信息查询
		condIg334.setPdid_like(pdid);
		List<IG334VWInfo> lstTactics = this.ig334BL.findByCondTactics(condIg334);
		
		//没有流程策略设定信息时不激活报告上级策略
		if(lstTactics == null || lstTactics.size() <= 0){
			log.debug("流程类型ID为【"+pdid +"】的流程没有流程通知策略设置。");
			return;
		}
			
		//增加pidid非表单相关的判断
		String pidid = lstTactics.get(0).getPidid();		
		//表单名称
		String pidname = lstTactics.get(0).getPidname();
		
		//封装流程策略信息
		Map<String, Map<String, IG334VWInfo>> map = new LinkedHashMap<String, Map<String,IG334VWInfo>>();
		for (IG334VWInfo info : lstTactics) {
			if(map.get(info.getPsdcode()) != null){
				if(map.get(info.getPsdcode()).get(info.getPivalue()) == null){
					map.get(info.getPsdcode()).put(info.getPivalue(), info);
				}
			} else{
				Map<String, IG334VWInfo> mapIg334 = new LinkedHashMap<String, IG334VWInfo>();
				mapIg334.put(info.getPivalue(), info);
				map.put(info.getPsdcode(), mapIg334);
			}
		}
		
		//根据流程类型ID查询所有未关闭的流程
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");
		cond.setPrpdid(pdid);
		
		//流程状态信息
		if(StringUtils.isNotEmpty(psdid)){
			IG333Info ig333Info = this.ig333BL.searchIG333InfoByKey(psdid);
			cond.setPrstatus(ig333Info.getPsdcode());
		}
		
		//查询流程信息
		List<IG500Info> lstIG500Info = workFlowOperationBL.searchProcessRecord(cond);
		
		//没有未关闭流程不激活报告上级策略
		if(lstIG500Info != null && lstIG500Info.size() > 0){
			//当前流程指定表单的值
			String pivalue = "";
			for (IG500Info info : lstIG500Info) {
				if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
					//通知策略与表单无关
					pivalue = IGPRDCONSTANTS.PROCESS_UNRELFORM_VALUE;
				} else {
					pivalue = flowSearchBL.searchPublicProcessInfo(info.getPrid(), pidname);
					pivalue = StringUtils.isEmpty(pivalue) ? "#" : pivalue;					
				}
				//获取当前状态的策略设定信息
				if(map.get(info.getPrstatus()) == null ){
					log.debug("流程【"+info.getPrtitle() +"】中的对应状态标识为【"+info.getPrstatus()+"】的状态没有报告上级流程策略的设置。");
					continue;
				}
				
				//获取指定状态下指定表单值对应的策略设定信息
				IG334VWInfo tactics = map.get(info.getPrstatus()).get(pivalue);
				
				//当前状态指定表单值对应的流程策略不存在时进入下一次循环
				if(tactics == null){
					if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
						//通知策略与表单无关
						log.debug("流程【"+info.getPrtitle() +"】中没有报告上级的设置。");
					} else {
						log.debug("流程【"+info.getPrtitle() +"】中的对应【"+pidname+"】中【"+ ("#".equals(pivalue) ? "缺省" :pivalue)+"】没有报告上级的设置。");
					}
					continue;
				}
				reportd = tactics.getReportd();//天
				reporth = tactics.getReporth();//小时
				reportm = tactics.getReportm();//分
				//没有设定再次通知时间时进入下一次循环
				if((reportd == null || reportd == 0) 
						&& (reporth == null || reporth == 0) 
						&& (reportm == null || reportm == 0)){
					if(pidid.endsWith(IGPRDCONSTANTS.PROCESS_UNRELFORM_IDEND)){
						//通知策略与表单无关
						log.debug("流程【"+info.getPrtitle() +"】中的状态【"+ tactics.getPsdname()+"】没有设置报告上级间隔时间。");
					} else {
						log.debug("流程【"+info.getPrtitle() +"】中的状态【"+ tactics.getPsdname()+"】对应【"+pidname+"】中【"+("#".equals(pivalue) ? "缺省" :pivalue)+"】没有设置报告上级间隔时间。");
					}
					continue;
				}
				
				//查询是否发过提醒信息
				IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
				ig256Cond.setPrid(info.getPrid());
				ig256Cond.setPrstatus(info.getPrstatus());
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_SEND_MANAGER);// 通知标识 值域 0:通知 1:超时2:报告上级
				List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
				//已发送过提醒通知不需要再次激活报告上级策略
				if(ig256Infos != null && ig256Infos.size() > 0){
					continue;
				}
				
				//是否发送过报告上级标识
				boolean sendflag = false;
				
				//获取上报信息模板
				getSendMessage();
				
				//发送信息参数
				List<String> args = new ArrayList<String>();
				args.add(String.valueOf(info.getPrserialnum()));//流程工单号
				args.add(String.valueOf(info.getPrtitle()));//流程名称
				args.add(String.valueOf(tactics.getPsdname()));//流程状态
				args.add(getReportTime(reportd, reporth, reportm));//报告上级时间
				
				
				//查询参与人员
				//根据流程状态与流程ID获取该状态下的参与者信息
				List<Integer> lstRoleid = new ArrayList<Integer>();
				List<IG337Info> ig337Infos = workFlowOperationBL.searchProcessParticipant(info.getPrid(), info.getPrstatus());
				if(ig337Infos.size() == 0 || !getNotifyTime(reportd, reporth, reportm, ig337Infos.get(0).getPpinittime())){
					continue;
				}
				
				//上报给角色负责人
				if(IGPRDCONSTANTS.STRATEGY_NOTIFIER_TYPE_ROLEMANAGER.equals(tactics.getRolemanager())){
					//给负责人发送短信
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(tactics.getSms())){
						for (IG337Info info337 : ig337Infos) {
							//同一角色不需要给负责人重复发送短信
							if(!lstRoleid.contains(info337.getPproleid())){
								lstRoleid.add(info337.getPproleid());
								args.add(getCurrentPersonOrRoleName(tactics,info337));
								//上报给角色负责人
								sendMessage(info337.getPproleid(),null,smsReport,args);
							}
							
						}
						sendflag = true;
					}
					//给负责人发送邮件
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(tactics.getEmail())){
						for (IG337Info info337 : ig337Infos) {
							//同一角色不需要给负责人重复发送短信
							if(!lstRoleid.contains(info337.getPproleid())){
								lstRoleid.add(info337.getPproleid());
								args.add(getCurrentPersonOrRoleName(tactics,info337));
								//上报给角色负责人
								sendMail(mailTitilReport,args,mailContectReport,args,info337.getPproleid(),null);
							}
							
						}
						sendflag = true;
					}
					
				//上报给指定人选
				} else if(IGPRDCONSTANTS.STRATEGY_NOTIFIER_TYPE_USER.equalsIgnoreCase(tactics.getRolemanager())){
					//给指定人选发送短信
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(tactics.getSms())){
						//上报给指定人选
						IG237SearchCondImpl cond237 = new IG237SearchCondImpl();
						cond237.setPsdid(tactics.getPsdid());
						cond237.setPsdconfirm(tactics.getPsdconfirm());
						List<IG237Info> userInfoList = processNoticeStrategyUserBL.searchIG237Info(cond237);
						if(userInfoList!=null && userInfoList.size()>0){
						    //封装所有处理人
						    StringBuffer ppusname = new StringBuffer();
						    ppusname.append("人为【");
						    for (int i = 0; i < ig337Infos.size(); i ++) {
						        ppusname.append(ig337Infos.get(i).getPpusername());
						        if(i < ig337Infos.size() - 1){
						            ppusname.append(" , ");
						        }
						    }
						    ppusname.append("】");
						    args.add(ppusname.toString());
						    
							for(IG237Info userInfo : userInfoList){
								sendMessage(null,userInfo.getUserid(),smsReport,args);
							}
						}
						sendflag = true;
					}
					//给指定人选发送邮件
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(tactics.getEmail())){
						IG237SearchCondImpl cond237 = new IG237SearchCondImpl();
						cond237.setPsdid(tactics.getPsdid());
						cond237.setPsdconfirm(tactics.getPsdconfirm());
						List<IG237Info> userInfoList = processNoticeStrategyUserBL.searchIG237Info(cond237);
						if(userInfoList!=null && userInfoList.size()>0){
						  //封装所有处理人
                            StringBuffer ppusname = new StringBuffer();
                            ppusname.append("人为【");
                            for (int i = 0; i < ig337Infos.size(); i ++) {
                                ppusname.append(ig337Infos.get(i).getPpusername());
                                if(i < ig337Infos.size() - 1){
                                    ppusname.append(" , ");
                                }
                            }
                            ppusname.append("】");
                            args.add(ppusname.toString());
                            
							for(IG237Info userInfo : userInfoList){
								sendMail(mailTitilReport,args,mailContectReport,args,null,userInfo.getUserid());
							}
						}
						sendflag = true;
					}
				}
				
				//记录报告时间提醒的
				if(sendflag){
					saveRemindMessage(info.getPrid(), pdid, info.getPrstatus(), null, null, IGPRDCONSTANTS.PROCESS_STATUS_SEND_MANAGER);
				}
			}//end for
		}//end if
	}
	
	/**
	 * 流程状态规则判断
	 * 
	 * @param pdid 
	 * @throws BLException
	 */
	public void regulation(String pdid, String psdid) throws BLException {}
	
	/**
	 * 流程状态策略触发的动作事件
	 * 
	 * @param ig334VWInfo 
	 * @param action_flag 动作标识(true:处理超时；false:处理提醒)
	 * @throws BLException
	 */
	public void event(IG334VWInfo ig334VWInfo, IG500Info info, Integer begintime, boolean action_flag) throws BLException {
		/**
		 * 1、查询是否发过提醒或逾期
		 * 2、根据动作标识如果是超时，且发过提醒则更新状态为已超时
		 * 3、未发过提醒则先发提醒在记录超时（正常情况下不存在）
		 * 4、根据动作标识如果是提醒，且发过提醒则不做任何操作
		 * 5、未发过提醒则查询该状态下的所有参与人，并发提醒信息
		 */
		//获取流程ID
		Integer prid = info.getPrid();
		//获取流程当前状态
		String prstatus = info.getPrstatus();
		
		//超时提醒时间设定
		Integer notifyd = ig334VWInfo.getNotifyd();//天
		Integer notifyh = ig334VWInfo.getNotifyh();//小时
		Integer notifym = ig334VWInfo.getNotifym();//分
		
		//没有设定再次通知时间
		if((notifyd == null || notifyd == 0) 
				&& (notifyh == null || notifyh == 0) 
				&& (notifym == null || notifym == 0)){
			log.debug(ig334VWInfo.getPsdname()+"状态没有设置超时提醒间隔时间");
			return;
		}
		
		//获取上报信息模板
		getSendMessage();
		if(begintime != null && begintime > 0){
			smsNotify = "工作提醒：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态将在【{3}】内超时，请您及时处理！";
			mailTitleNotify = "工作提醒：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态将在【{3}】内超时，请您及时处理！";
			mailContentNotify = "工作提醒：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态将在【{3}】内超时，请您及时处理！";
		}
		
		//发送信息参数
		List<String> args = new ArrayList<String>();
		args.add(String.valueOf(info.getPrserialnum()));
		args.add(String.valueOf(info.getPrtitle()));
		args.add(String.valueOf(ig334VWInfo.getPsdname()));
		if(begintime != null && begintime > 0){
			args.add(begintime+"分钟");
		} else{
			Integer finishtime = 0;
			if(notifyd != null && notifyd > 0){
				finishtime += notifyd * 24 * 60;
			}
			if(notifyh != null && notifyh > 0){
				finishtime += notifyh * 60;
			}
			if(notifym != null && notifym > 0){
				finishtime += notifym;
			}
			args.add(finishtime+"分钟");
		}
		
		//查询是否发过提醒信息
		IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
		ig256Cond.setPrid(prid);
		ig256Cond.setPrstatus(prstatus);
		ig256Cond.setFlag_in(new String[]{IGPRDCONSTANTS.PROCESS_STATUS_SEND,IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME});// 通知标识 值域 0:通知 1:超时
		List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
		//已发过提醒信息
		if(!ig256Infos.isEmpty()){
			//判断是否是超时动作
			if(action_flag){
				//超时更新flag值为1
				for (IG256Info ig256Info : ig256Infos) {
					IG256TB ig256tb = (IG256TB)SerializationUtils.clone(ig256Info);
					ig256tb.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
					ig256BL.updateIG256(ig256tb);
				}
				//查询是否记录过状态超时信息
				ig256Cond = new IG256SearchCondImpl();
				ig256Cond.setPrid(prid);
				ig256Cond.setPrstatus(prstatus);
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
				ig256Infos = ig256BL.searchIG256(ig256Cond);
				//没有则记录流程状态超时信息
				if(ig256Infos.isEmpty()) {
					//记录流程状态超时信息
					saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, null, ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
				}
			}
		//未发过提醒信息
		} else{
			//给指定角色发送短信
			if(ig334VWInfo.getRoleid() != null && ig334VWInfo.getRoleid() > 0){
				UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
				urcond.setRoleid(ig334VWInfo.getRoleid());
				List<UserRole> searchUserRole = userRoleBL.searchUserRole(urcond);
				if(searchUserRole != null && searchUserRole.size() > 0){
					for(UserRole userRole : searchUserRole) {
						//根据策略发送通知
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(ig334VWInfo.getEmail())){//邮件通知
							sendMail(mailTitleNotify, args, mailContentNotify, args, null, userRole.getUserid());
							
						}
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(ig334VWInfo.getSms())){//短信通知
							sendMessage(null, userRole.getUserid(), smsNotify, args);
						}
						//判断动作标识
						if(action_flag) {
							//记录提醒信息为超时
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRole.getUserid(), ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
						} else{
							//记录提醒信息为提醒
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRole.getUserid(), ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_SEND);
						}
					}
				}
			}
			
			//根据流程状态与流程ID获取该状态下的参与者信息
			List<IG337Info> ig337Infos = workFlowOperationBL.searchProcessParticipant(prid, prstatus);
			for(int i = 0; i < ig337Infos.size(); i++) {
				//如果参与者指定到角色 通过角色id获取角色下所有人发通知
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
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(ig334VWInfo.getEmail())){//邮件通知
							sendMail(mailTitleNotify, args, mailContentNotify, args, null, userRoleInfos.get(j).getUserid());
							
						}
						if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(ig334VWInfo.getSms())){//短信通知
							sendMessage(null, userRoleInfos.get(j).getUserid(), smsNotify,args);
						}
						//判断动作标识
						if(action_flag) {
							//记录提醒信息为超时
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRoleInfos.get(j).getUserid(), userRoleInfos.get(j).getUsername(), IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
						} else{
							//记录提醒信息为提醒
							saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, userRoleInfos.get(j).getUserid(), userRoleInfos.get(j).getUsername(), IGPRDCONSTANTS.PROCESS_STATUS_SEND);
						}
					}
				//指定到人直接发通知
				} else{
					//邮件通知
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(ig334VWInfo.getEmail())) {
						sendMail(mailTitleNotify,args,mailContentNotify,args,null,ig337Infos.get(i).getPpuserid());
					}
					//短信通知
					if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(ig334VWInfo.getSms())){
						sendMessage(null,ig337Infos.get(i).getPpuserid(),smsNotify,args);
					}
					//判断动作标识
					if(action_flag) {
						//记录提醒信息为超时
						saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, ig337Infos.get(i).getPpuserid(), ig337Infos.get(i).getPpusername(), IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
					} else{
						//记录提醒信息为提醒
						saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, ig337Infos.get(i).getPpuserid(), ig337Infos.get(i).getPpusername(), IGPRDCONSTANTS.PROCESS_STATUS_SEND);
					}
				}//end if
			}//end for
			//记录流程状态超时信息
			if(action_flag) {
				saveRemindMessage(prid, ig334VWInfo.getPdid(), prstatus, null, ig334VWInfo.getPsdname(), IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
			}
		}//end if
	}
	
	/**
	 * 比较状态添加参与人时间和时间
	 * @param timed
	 * @param timeh
	 * @param timem
	 * @return
	 */
	private boolean getNotifyTime(Integer timed, Integer timeh,Integer timem,String ppinittime){
		long timeNumber = 0; 
		long mins = 60L * 1000L;
		//天
		if(timed != null && timed > 0){
			timeNumber = timed * 24 * 60;
		}
		//小时
		if(timeh != null && timeh > 0  && timeNumber == 0){
			timeNumber = timeh * 60;
		}
		//分钟
		if(timem != null && timem > 0  && timeNumber == 0){
			timeNumber = timem;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date d1 = null;
		try {
			d1 = df.parse(ppinittime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date d2 = new Date();
		return ((d2.getTime() - d1.getTime()) / mins - timeNumber ) > 0;
	}
	
	/**
	 * 获取是通知到指定人员还是角色负责人
	 * @param info
	 * @return
	 */
	private String getCurrentPersonOrRoleName(IG334VWInfo info,IG337Info info337){
		if(IGPRDCONSTANTS.STRATEGY_NOTIFIER_TYPE_ROLEMANAGER.equals(info.getRolemanager())){
			return "角色为【"+info337.getPprolename()+"】";
		}else{
			return "人为【"+info337.getPpusername()+"】";
		}
	}
	
	/**
	 * 取得通知信息中的时间变量
	 * @param timed
	 * @param timeh
	 * @param timem
	 * @return
	 */
	private String getReportTime(Integer timed, Integer timeh,Integer timem){	
		//天
		if(timed != null && timed > 0){
			return timed+"天";
		}
		//小时
		if(timeh != null && timeh > 0){
			return timeh+"小时";
		}
		//分钟
		if(timem != null && timem > 0){
			return timem+"分钟";
		}
		return "";
	}
	
	/**
	 * 获得信息提示模板
	 */
	public void getSendMessage(){
		CodeDetailSearchCondImpl codecond = new CodeDetailSearchCondImpl();
		codecond.setCcid("156");
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(codecond, 2);//不排序
		for(CodeDetail detail : codeDetailList){
			//短信通知提醒内容
			if("3".equalsIgnoreCase(detail.getCid())){
				smsNotify = detail.getCvalue();
			}
			//短信上报提醒内容
			if("4".equalsIgnoreCase(detail.getCid())){
				smsReport = detail.getCvalue();
			}
			//邮件通知提醒标题
			if("5".equalsIgnoreCase(detail.getCid())){
				mailTitleNotify = detail.getCvalue();
			}
			//邮件通知提醒内容
			if("6".equalsIgnoreCase(detail.getCid())){
				mailContentNotify = detail.getCvalue();
			}
			//邮件上报提醒标题
			if("7".equalsIgnoreCase(detail.getCid())){
				mailTitilReport = detail.getCvalue();
			}
			//邮件上报提醒内容
			if("8".equalsIgnoreCase(detail.getCid())){
				mailContectReport = detail.getCvalue();
			}
		}
		smsNotify = StringUtils.isEmpty(smsNotify)?"工作提醒：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态未在【{3}】内处理！":smsNotify;
		smsReport = StringUtils.isEmpty(smsReport)?"上报通知：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态未在【{3}】内处理，当前处理{4},请关注！":smsReport;
		
		mailTitleNotify = StringUtils.isEmpty(mailTitleNotify)?"工作提醒：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态未在【{3}】内处理！":mailTitleNotify;
		mailContentNotify = StringUtils.isEmpty(mailContentNotify)?"工作提醒：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态未在【{3}】内处理！":mailContentNotify;
		mailTitilReport = StringUtils.isEmpty(mailTitilReport)?"上报通知：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态未在【{3}】内处理，当前处理{4}，请关注！":mailTitilReport;
		mailContectReport = StringUtils.isEmpty(mailContectReport)?"上报通知：工单号为【{0}】的 【{1}】流程已停在【{2}】状态，该状态未在【{3}】内处理，当前处理{4}，请关注！":mailContectReport;
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