/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.scheduling.jobs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG237BL;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG064BL;
import com.deliverik.framework.workflow.prr.bl.task.IG394BL;
import com.deliverik.framework.workflow.prr.model.IG064Info;
import com.deliverik.framework.workflow.prr.model.IG394Info;
import com.deliverik.framework.workflow.prr.model.condition.IG064SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG394SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG394TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程状态提醒及上报处理类
 * </p>
 * 
 * @author wanglongyu@deliverik.com
 * @version 1.0
 */

public class IGProcessNoticeStrategyJOB implements Job {

	private static Log log = LogFactory.getLog(IGProcessNoticeStrategyJOB.class);
	
	public static final String GROUP_NAME = "IGPROCESSNOTIEC_GROUP";
	public static final String JOB_NAME = "IGPROCESSNOTIEC_JOB";
	public static final String TRI_GROUP = "IGPROCESSNOTIEC_TRI_GROUP";
	public static final String TRI = "IGPROCESSNOTIEC_TRI";
	
	//短信BL
	private static SendMessageBL sendMessageBL = (SendMessageBL) WebApplicationSupport.getBean("sendMessageBL");
	//邮件BL
	private static SendMailBL sendMailBL = (SendMailBL) WebApplicationSupport.getBean("sendMailBL");
	//用户BL
	private static UserBL userBL = (UserBL)WebApplicationSupport.getBean("userBL");
	//用户角色
	private static UserRoleBL userRoleBL = (UserRoleBL)WebApplicationSupport.getBean("userRoleBL");
	private static CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
	
	private static IG064BL processRecordStatusNoticeVWBL = (IG064BL) WebApplicationSupport.getBean("ig064BL");
	private static IG394BL processNoticeStrategySendBL = (IG394BL) WebApplicationSupport.getBean("ig394BL");
	private static IG237BL processNoticeStrategyUserBL = (IG237BL) WebApplicationSupport.getBean("ig237BL");
	
	private String smsNotify;
	private String smsReport;
	private String mailTitleNotify;
	private String mailContentNotify;
	private String mailTitilReport;
	private String mailContectReport;
	
	/**
	 * 入口
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("========流程状态提醒及上报处理类开始========");
		//查询视图取得当前流程所处状态
		IG064SearchCondImpl condImpl = new IG064SearchCondImpl();
		List<IG064Info> infoList = processRecordStatusNoticeVWBL.searchIG064Info(condImpl);
		if(infoList != null && infoList.size() >= 0){
			getSendMessage();
			for(IG064Info info : infoList){
				IG394Info sendInfo = null;
				sendInfo = notifySend(info,sendInfo);
				reportSend(info,sendInfo);
			}
		}
		log.debug("========流程状态提醒及上报处理类结束========");
	}

	/**
	 * 再次通知
	 * 
	 * @param IG064Info
	 * @throws JobExecutionException 
	 * @throws BLException 
	 * @throws Exception
	 */
	private IG394Info notifySend(IG064Info info,IG394Info sendInfo) throws JobExecutionException{
		
		Integer notifyd = info.getNotifyd();//天
		Integer notifyh = info.getNotifyh();//小时
		Integer notifym = info.getNotifym();//分
		//没有设定再次通知时间
		if(notifyd == null && notifyh == null && notifym == null){
			log.debug(info.getPsdname()+"状态没有设置再次通知时间");
			return sendInfo;
		}
		//取得起始时间，做过接单操作则从接单操作时间开始计时，否则从状态起始时间开始计时
		String inittime =  "1".equalsIgnoreCase(info.getPpsubstatus())?info.getPpbacktime():info.getPpinittime();
		try {
			//判断时间是否需要发送通知
			if(getNotifyTime(notifyd,notifyh,notifym,inittime)){
				IG394TB instance = this.getSendedInfo(info,sendInfo);
				boolean needInsert = false;
				List<String> args = new ArrayList<String>();
				args.add(String.valueOf(info.getPrserialnum()));
				args.add(String.valueOf(info.getPrtitle()));
				args.add(getReportTime(notifyd,notifyh,notifym));
				//发送短信
				if("1".equalsIgnoreCase(info.getSms()) && StringUtils.isEmpty(instance.getNotifysmstime())){
					sendMessage(info.getPproleid(),info.getPpuserid(),smsNotify,args);
					instance.setNotifysmstime(IGStringUtils.getCurrentDateTime());
					needInsert = true;
				}
				//发送邮件
				if("1".equalsIgnoreCase(info.getEmail()) && StringUtils.isEmpty(instance.getNotifyemailtime())){
					sendMail(mailTitleNotify,args,mailContentNotify,args,info.getPproleid(),info.getPpuserid());
					instance.setNotifyemailtime(IGStringUtils.getCurrentDateTime());
					needInsert = true;
				}
				if(needInsert){
					sendInfo = processNoticeStrategySendBL.registIG394Info(instance);
				}
			}
		} catch (BLException e) {
			throw new JobExecutionException();
		}
		return sendInfo;
	}
	
	/**
	 * 上报通知
	 * 
	 * @param IG064Info
	 * @throws JobExecutionException 
	 * @throws Exception
	 */
	private void reportSend(IG064Info info,IG394Info sendInfo) throws JobExecutionException{
		//没有设置上报通知
		if(info.getRolemanager() == null || StringUtils.isEmpty(info.getRolemanager().trim())){
			return;
		}
		Integer reportd = info.getReportd();//天
		Integer reporth = info.getReporth();//小时
		Integer reportm = info.getReportm();//分
		//没有设定再次通知时间
		if(reportd == null && reporth == null && reportm == null){
			log.debug(info.getPsdname()+"状态没有设置上报间隔时间");
			return;
		}
		//取得起始时间，做过接单操作则从接单操作时间开始计时，否则从状态起始时间开始计时
		String inittime =  "1".equalsIgnoreCase(info.getPpsubstatus())?info.getPpbacktime():info.getPpinittime();
		try {
			//判断时间是否需要发送通知
			if(getNotifyTime(reportd,reporth,reportm,inittime)){
				IG394TB instance = this.getSendedInfo(info,sendInfo);
				boolean needInsert = false;
				//发送信息参数
				List<String> args = new ArrayList<String>();
				args.add(String.valueOf(info.getPrserialnum()));
				args.add(String.valueOf(info.getPrtitle()));
				args.add(getReportTime(reportd,reporth,reportm));
				args.add(getCurrentPersonOrRoleName(info));
				//发送短信
				if("1".equalsIgnoreCase(info.getSms()) && StringUtils.isEmpty(instance.getReportsmstime())){
					if("0".equalsIgnoreCase(info.getRolemanager())){
						//上报给角色负责人
						sendMessage(info.getPproleid(),null,smsReport,args);
					}else if("1".equalsIgnoreCase(info.getRolemanager())){
						//上报给指定人选
						IG237SearchCondImpl cond = new IG237SearchCondImpl();
						cond.setPsdid(info.getPnsdpsdid());
						cond.setPsdconfirm(info.getPnsdconfirm());
						List<IG237Info> userInfoList = processNoticeStrategyUserBL.searchIG237Info(cond);
						if(userInfoList!=null && userInfoList.size()>0){
							for(IG237Info userInfo : userInfoList){
								sendMessage(null,userInfo.getUserid(),smsReport,args);
							}
						}
					}
					instance.setReportsmstime(IGStringUtils.getCurrentDateTime());
					needInsert = true;
				}
				//发送邮件
				if("1".equalsIgnoreCase(info.getEmail()) && StringUtils.isEmpty(instance.getReportemailtime())){
					if("0".equalsIgnoreCase(info.getRolemanager())){
						//上报给角色负责人
						sendMail(mailTitilReport,args,mailContectReport,args,info.getPproleid(),null);
					}else if("1".equalsIgnoreCase(info.getRolemanager())){
						IG237SearchCondImpl cond = new IG237SearchCondImpl();
						cond.setPsdid(info.getPnsdpsdid());
						cond.setPsdconfirm(info.getPnsdconfirm());
						List<IG237Info> userInfoList = processNoticeStrategyUserBL.searchIG237Info(cond);
						if(userInfoList!=null && userInfoList.size()>0){
							for(IG237Info userInfo : userInfoList){
								sendMail(mailTitilReport,args,mailContectReport,args,null,userInfo.getUserid());
							}
						}
					}
					instance.setReportemailtime(IGStringUtils.getCurrentDateTime());
					needInsert = true;
				}
				if(needInsert){
					processNoticeStrategySendBL.registIG394Info(instance);
				}
			}
		} catch (BLException e) {
			throw new JobExecutionException();
		}
	}
	
	private String getCurrentPersonOrRoleName(IG064Info info){
		if(StringUtils.isEmpty(info.getPpuserid())){
			return "角色为【"+info.getPprolename()+"】";
		}else{
			return "人为【"+info.getPpusername()+"】";
		}
	}
	/**
	 * 取得上报时间
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
		if(timeh != null && timeh > 0 && timeNumber == 0){
			timeNumber = timeh * 60;
		}
		//分钟
		if(timem != null && timem > 0 && timeNumber == 0){
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
	 * 查询再次提醒信息是否发送过
	 * 
	 * @throws Exception
	 */
	private IG394TB getSendedInfo(IG064Info info,IG394Info sendInfo){
		IG394TB tb = null;
		if(sendInfo == null){
			IG394SearchCondImpl cond = new IG394SearchCondImpl();
			cond.setPrid(info.getPrid());
			cond.setPsdid(info.getPsdid());
			cond.setPsdconfirm(info.getPnsdconfirm());
			cond.setRoleid(info.getPproleid());
			cond.setUserid(info.getPpuserid());
			List<IG394Info> infoList = processNoticeStrategySendBL.searchIG394Info(cond);
			if(infoList == null || infoList.size() == 0){
				tb = new IG394TB();
				tb.setPrid(info.getPrid());
				tb.setPsdid(info.getPsdid());
				tb.setPsdconfirm(info.getPnsdconfirm());
				tb.setRoleid(info.getPproleid());
				tb.setUserid(info.getPpuserid());
			}else{
				tb = (IG394TB)SerializationUtils.clone(infoList.get(0));
			}
		}else{
			tb = (IG394TB)SerializationUtils.clone(sendInfo);
		}
		return tb;
	}
	
	private void getSendMessage(){
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
		smsNotify = StringUtils.isEmpty(smsNotify)?"工作提醒：工单号为【{0}】的 【{1}】流程未在【{2}】内处理！":smsNotify;
		smsReport = StringUtils.isEmpty(smsReport)?"上报通知：工单号为【{0}】的 【{1}】流程未在【{2}】内处理,当前处理{3},请关注！":smsReport;
		
		mailTitleNotify = StringUtils.isEmpty(mailTitleNotify)?"工作提醒：工单号为【{0}】的 【{1}】流程未在【{2}】内处理！":mailTitleNotify;
		mailContentNotify = StringUtils.isEmpty(mailContentNotify)?"工作提醒：工单号为【{0}】的 【{1}】流程未在【{2}】内处理！":mailContentNotify;
		mailTitilReport = StringUtils.isEmpty(mailTitilReport)?"上报通知：工单号为【{0}】的 【{1}】流程未在【{2}】内处理,当前处理{3},请关注！":mailTitilReport;
		mailContectReport = StringUtils.isEmpty(mailContectReport)?"上报通知：工单号为【{0}】的 【{1}】流程未在【{2}】内处理,当前处理{3},请关注！":mailContectReport;
	}
	
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
		sendMailBL.sendMail(title, content, address, null);
	}
}