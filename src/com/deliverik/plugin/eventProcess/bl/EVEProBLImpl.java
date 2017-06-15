/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.plugin.eventProcess.bl;

import java.util.Date;
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
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG256BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG256Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG256SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG256TB;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚机配置同步插件BL实现
 * </p>
 * 
 * @author shikailong@deliverik.com
 * @version 1.0
 */
public class EVEProBLImpl extends BaseBLImpl implements EVEProBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(EVEProBLImpl.class);
	
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
	
	/** 流程参与用户信息业务BL */
	protected IG337BL ig337BL;
	
	/** 数据分类信息BL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** 数据详细信息BL */
	protected CodeDetailBL codeDetailBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** 服务台角色id*/
	protected static final Integer SERVER_ROLEID = 1205;
	
	/** 科技总经理角色id*/
	protected static final Integer MANAGER_ROLEID = 1221;
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
	 * 流程参与用户信息业务BL
	 * @param ig337bl 流程参与用户信息业务
	 */
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}
	/**
	 * 事件流程超时提醒同步
	 * @throws BLException
	 */
	public void dataSynchronism() throws BLException{
		log.debug("=========事件流程超时提醒同步=========");
		this.regulation("01080");
    	log.debug("=========事件流程超时提醒同步=========");
    }
	
	/**
	 * 流程状态策略判断的规则的事件
	 * 
	 * @param pdid 
	 * @param psdid 
	 * @throws BLException
	 */
	public void regulation(String pdid) throws BLException{
		String type = "ⅠⅡⅢⅣⅤ";
		String flag = "";
		//没有流程类型ID时不激活报告上级策略
		if(StringUtils.isEmpty(pdid)){
			log.debug("流程类型ID为不能为空。");
			return;
		}else{
			IG380SearchCondImpl ig380Cond = new IG380SearchCondImpl();
			ig380Cond.setPdid_like(pdid);
			//根据流程类型查询流程类型名称
			List<IG380Info> ig380InfoList = ig380BL.searchIG380Info(ig380Cond);
			if(ig380InfoList == null || ig380InfoList.size()==0){
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
				//查询是否发过提醒信息
				IG256SearchCondImpl ig256Cond = new IG256SearchCondImpl();
				ig256Cond.setPrid(info.getPrid());
				ig256Cond.setPrstatus(info.getPrstatus());
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);// 通知标识 值域 0:通知 1:超时2:报告上级
				List<IG256Info>	ig256Infos = ig256BL.searchIG256(ig256Cond);
				//已发送过提醒通知不需要再次激活报告上级策略（已发送短信给科技总经理和服务台）
				if(ig256Infos != null && ig256Infos.size() > 0){
					continue;
				}
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
				IG599SearchCondImpl picond = new IG599SearchCondImpl();
				picond.setPrid(info.getPrid());//流程ID
				List<IG599Info> piList = workFlowOperationBL.searchProcessInfoByCond(picond);
				Map<String, String> piMap = new HashMap<String, String>();
				for(IG599Info pi:piList){
					piMap.put(pi.getPivarname(), pi.getPivarvalue());
				}
				String reason = piMap.get("交易故障/中断");
				if(StringUtils.isBlank(reason)){
					continue;
				}
				String initTimeDate = ig337InfoList.get(0).getPpinittime();//流程的发起日期时间
				String currTimeDate = IGStringUtils.getCurrentDateTime();//系统当前时间
				String grade = piMap.get("事件级别");
				String eventtype = piMap.get("事件来源");
				Integer reportd = 0;
				Integer reporth = 0;
				Integer reportm = 0;
				//查询是否发过提醒信息
				ig256Cond.setFlag(IGPRDCONSTANTS.PROCESS_STATUS_SEND);// 通知标识 值域 0:通知 1:超时2:报告上级
				List<IG256Info>	ig256Infos2 = ig256BL.searchIG256(ig256Cond);
				//普通事件：时间点A起（事件到达处理节点），5分钟内处理人未确认事件则重发提醒短信。
				//告警事件：时间点A起（事件到达处理节点），2分钟内处理人未确认事件则重发提醒短信。 
				//此事件为告警时间并且没有发过重发提醒短信(第一次重发短信)
				if(ig256Infos2 ==null || ig256Infos2.size() < 1){
					IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
					cond337.setPpbacktime_isNull("1");
					cond337.setPpstatus("W");
					cond337.setPpproctimeIsNull("Y");
					cond337.setPrid(prid);
					List<IG337Info> info337 = ig337BL.getIG337Infos(cond337);
					if(info337 != null){
						if("监控告警".equals(eventtype)){
							reportm = 2;
							//如果是监控告警则只进行着一次提醒
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
							
						}else{
							reportm = 5;
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
						}
					}else{
						if("监控告警".equals(eventtype)){
							//如果是监控告警则只进行着一次提醒
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
							//如果是监控告警，则插入4
							saveRemindMessageAndDate(info.getPrid(),
									info.getPrpdid(),info.getPrstatus() , 
									"000000", "000000" , 
									IGPRDCONSTANTS.PROCESS_STATUS_FLAG,
									CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
						}else{
							flag = IGPRDCONSTANTS.PROCESS_STATUS_SEND;
							//该事件已经确认完成
							saveRemindMessageAndDate(info.getPrid(),
									info.getPrpdid(),info.getPrstatus() , 
									"000000", "000000" , 
									flag,
									CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
						}
						continue;
					}
				}else if(ig256Infos2!=null && ig256Infos2.size() > 0){
					//
					if("监控告警".equals(eventtype)){
						for(IG256Info ig256info :ig256Infos2){
							((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							ig256BL.registIG256(ig256info);
						}
						continue;
					}
					if(StringUtils.isBlank(grade)){
						//表单信息不存在
						for(IG256Info ig256info :ig256Infos2){
							((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							ig256BL.registIG256(ig256info);
						}
						continue;
					}
					if(type.indexOf(grade) == 2){
						//Ⅲ级事件默认短信轮发间隔10分钟
						reportm = 10;
						flag = IGPRDCONSTANTS.PROCESS_STATUS_FLAG;
					}else if(type.indexOf(grade) == 3){
						//Ⅳ级事件
						if(StringUtils.isNotBlank(reason)){
							if(reason.equals("故障")){
								//Ⅳ级故障事件短信轮发设置为1小时
								reporth = 1;
								flag = IGPRDCONSTANTS.PROCESS_STATUS_FLAG;
							}else if(reason.equals("中断")){
								//Ⅳ级中断事件短信轮发设置为30分钟
								reportm = 30;
								flag = IGPRDCONSTANTS.PROCESS_STATUS_FLAG;
							}
						}else{
							//没有填写交易故障/中断表单
							for(IG256Info ig256info :ig256Infos2){
								((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
								ig256BL.registIG256(ig256info);
							}
							continue;
						}
					}else{
						//不是Ⅲ级和Ⅳ级
						for(IG256Info ig256info :ig256Infos2){
							((IG256TB)ig256info).setFlag(IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							ig256BL.registIG256(ig256info);
						}
						continue;
					}
				}
				Long nodifyMin = getWholeNodifyMinutes(reportd, reporth, reportm);//获取流程整体超时通知策略设置的超时时间
				Long dMin = DateUtils.getTimeDifferenceByMinutes(initTimeDate, currTimeDate);//获取当前时间差
				if(dMin >= nodifyMin){//当当前时间差大于流程整体超时设置时间时发送超时通知
					//超时通知设置并在IG500表中记录已发送超时提醒
					IG500TB ig500TB = (IG500TB)SerializationUtils.clone(info);
					ig500TB.setPrPriority(IGPRDCONSTANTS.PROCESS_STATUS_OVERTIME);
					IG500Info ig500Info = workFlowOperationBL.updateProcessRecord(ig500TB);
					
					//如果是第一次报警，则向所有的参与人发送短信提醒
					if( IGPRDCONSTANTS.PROCESS_STATUS_SEND.equals(flag)){
						if("监控告警".equals(eventtype)){
							for(IG337Info ig337info : ig337InfoList){
								//发送超时通知信息
								this.processSend(ig334Info, ig500Info, currTimeDate,ig337info.getPpuserid(),IGPRDCONSTANTS.PROCESS_STATUS_FLAG);
							}
						}else{
							for(IG337Info ig337info : ig337InfoList){
								//发送超时通知信息
								this.processSend(ig334Info, ig500Info, currTimeDate,ig337info.getPpuserid(),IGPRDCONSTANTS.PROCESS_STATUS_SEND);
							}
						}
						
					}else if(IGPRDCONSTANTS.PROCESS_STATUS_FLAG.equals(flag)){
						//查询科技总经理
						UserRoleVWSearchCondImpl userRoleVWSearchCondImpl = new UserRoleVWSearchCondImpl();
						userRoleVWSearchCondImpl.setRoleid(MANAGER_ROLEID);
						List<UserRoleInfo> userRoleManager = userRoleBL.searchUserRoleVW(userRoleVWSearchCondImpl);
						if(userRoleManager!=null && userRoleManager.size()>0){
							for(UserRoleInfo userRoleInfo : userRoleManager){
								//发送超时通知信息
								this.processSend(ig334Info, ig500Info, currTimeDate,userRoleInfo.getUserid(),flag);
							}
						}
						//查询服务台
						UserRoleVWSearchCondImpl userRoleVWSearchCondServer = new UserRoleVWSearchCondImpl();
						userRoleVWSearchCondServer.setRoleid(SERVER_ROLEID);
						List<UserRoleInfo> userRoleServer = userRoleBL.searchUserRoleVW(userRoleVWSearchCondServer);
						if(userRoleServer!=null && userRoleServer.size()>0){
							for(UserRoleInfo userRoleInfo : userRoleServer){
								//发送超时通知信息
								this.processSend(ig334Info, ig500Info, currTimeDate,userRoleInfo.getUserid(),flag);
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
	public void processSend(IG334Info info, IG500Info ig500Info, String now,String reportUserid,String process_status) throws BLException{
		/**
		 * 根据流程查询当前处理人 并发送短信或邮件，人员或角色
		 */
		//根据userid查询user
		User reportUser = userBL.searchUserByKey(reportUserid);
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
		
		//邮件通知
		if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(info.getEmail())) {
			
			if(StringUtils.isEmpty(reportUser.getUseremail())){
				log.debug("用户"+reportUser.getUserid()+"没有设置邮箱！无法发送邮件");
				return;
			}
			String[] address = new String[1];
			address[0] = reportUser.getUseremail();
			//存放发送用户信息
			sendMailUserInfo.put(reportUser.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now, address[0]});
//					sendMailBL.sendMail(messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now), address);
		}
		//短信通知
		if (IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(info.getSms())){
			//存放发送用户信息
			sendSmsUserInfo.put(reportUser.getUserid(), new String[]{psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now});
//					sendMessageBL.sendSmsToUser(ig337Infos.get(i).getPpuserid(), messageFormatFactory(psdName, ig500Info.getPrserialnum(), ig500Info.getPrtitle(), now));
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
		saveRemindMessageAndDate(ig500Info.getPrid(),
						ig500Info.getPrpdid(),ig500Info.getPrstatus() , 
						reportUser.getUserid(), reportUser.getUsername() , 
						process_status ,
						CommonDefineUtils.DATETIME_SECOND_FORMAT.format(new Date()));
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
	 * 提醒信息保存
	 * @param prid 流程ID
	 * @param pdid 流程定义ID
	 * @param prstatus 流程状态
	 * @param ppuserid 参与人id
	 * @param ppusername 参与人名称
	 * @param flag 提醒或超时标记
	 * @param date 发短信的时间
	 * @throws BLException
	 */
	private void saveRemindMessageAndDate(Integer prid, String pdid, String prstatus, String ppuserid, String ppusername, String flag,String date) throws BLException {
		IG256TB ig256tb = ig256BL.getIG256TBInstance();
		ig256tb.setFlag(flag);
		ig256tb.setPdid(pdid);
		ig256tb.setPrid(prid);
		ig256tb.setPpuserid(ppuserid);
		ig256tb.setPpusername(ppusername);
		ig256tb.setPrstatus(prstatus);
		ig256tb.setFingerPrint(date);
		ig256BL.registIG256(ig256tb);
	}
	
}
