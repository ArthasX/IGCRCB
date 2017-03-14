/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����״̬���Ѽ��ϱ�������
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
	
	//����BL
	private static SendMessageBL sendMessageBL = (SendMessageBL) WebApplicationSupport.getBean("sendMessageBL");
	//�ʼ�BL
	private static SendMailBL sendMailBL = (SendMailBL) WebApplicationSupport.getBean("sendMailBL");
	//�û�BL
	private static UserBL userBL = (UserBL)WebApplicationSupport.getBean("userBL");
	//�û���ɫ
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
	 * ���
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		log.debug("========����״̬���Ѽ��ϱ������࿪ʼ========");
		//��ѯ��ͼȡ�õ�ǰ��������״̬
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
		log.debug("========����״̬���Ѽ��ϱ����������========");
	}

	/**
	 * �ٴ�֪ͨ
	 * 
	 * @param IG064Info
	 * @throws JobExecutionException 
	 * @throws BLException 
	 * @throws Exception
	 */
	private IG394Info notifySend(IG064Info info,IG394Info sendInfo) throws JobExecutionException{
		
		Integer notifyd = info.getNotifyd();//��
		Integer notifyh = info.getNotifyh();//Сʱ
		Integer notifym = info.getNotifym();//��
		//û���趨�ٴ�֪ͨʱ��
		if(notifyd == null && notifyh == null && notifym == null){
			log.debug(info.getPsdname()+"״̬û�������ٴ�֪ͨʱ��");
			return sendInfo;
		}
		//ȡ����ʼʱ�䣬�����ӵ�������ӽӵ�����ʱ�俪ʼ��ʱ�������״̬��ʼʱ�俪ʼ��ʱ
		String inittime =  "1".equalsIgnoreCase(info.getPpsubstatus())?info.getPpbacktime():info.getPpinittime();
		try {
			//�ж�ʱ���Ƿ���Ҫ����֪ͨ
			if(getNotifyTime(notifyd,notifyh,notifym,inittime)){
				IG394TB instance = this.getSendedInfo(info,sendInfo);
				boolean needInsert = false;
				List<String> args = new ArrayList<String>();
				args.add(String.valueOf(info.getPrserialnum()));
				args.add(String.valueOf(info.getPrtitle()));
				args.add(getReportTime(notifyd,notifyh,notifym));
				//���Ͷ���
				if("1".equalsIgnoreCase(info.getSms()) && StringUtils.isEmpty(instance.getNotifysmstime())){
					sendMessage(info.getPproleid(),info.getPpuserid(),smsNotify,args);
					instance.setNotifysmstime(IGStringUtils.getCurrentDateTime());
					needInsert = true;
				}
				//�����ʼ�
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
	 * �ϱ�֪ͨ
	 * 
	 * @param IG064Info
	 * @throws JobExecutionException 
	 * @throws Exception
	 */
	private void reportSend(IG064Info info,IG394Info sendInfo) throws JobExecutionException{
		//û�������ϱ�֪ͨ
		if(info.getRolemanager() == null || StringUtils.isEmpty(info.getRolemanager().trim())){
			return;
		}
		Integer reportd = info.getReportd();//��
		Integer reporth = info.getReporth();//Сʱ
		Integer reportm = info.getReportm();//��
		//û���趨�ٴ�֪ͨʱ��
		if(reportd == null && reporth == null && reportm == null){
			log.debug(info.getPsdname()+"״̬û�������ϱ����ʱ��");
			return;
		}
		//ȡ����ʼʱ�䣬�����ӵ�������ӽӵ�����ʱ�俪ʼ��ʱ�������״̬��ʼʱ�俪ʼ��ʱ
		String inittime =  "1".equalsIgnoreCase(info.getPpsubstatus())?info.getPpbacktime():info.getPpinittime();
		try {
			//�ж�ʱ���Ƿ���Ҫ����֪ͨ
			if(getNotifyTime(reportd,reporth,reportm,inittime)){
				IG394TB instance = this.getSendedInfo(info,sendInfo);
				boolean needInsert = false;
				//������Ϣ����
				List<String> args = new ArrayList<String>();
				args.add(String.valueOf(info.getPrserialnum()));
				args.add(String.valueOf(info.getPrtitle()));
				args.add(getReportTime(reportd,reporth,reportm));
				args.add(getCurrentPersonOrRoleName(info));
				//���Ͷ���
				if("1".equalsIgnoreCase(info.getSms()) && StringUtils.isEmpty(instance.getReportsmstime())){
					if("0".equalsIgnoreCase(info.getRolemanager())){
						//�ϱ�����ɫ������
						sendMessage(info.getPproleid(),null,smsReport,args);
					}else if("1".equalsIgnoreCase(info.getRolemanager())){
						//�ϱ���ָ����ѡ
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
				//�����ʼ�
				if("1".equalsIgnoreCase(info.getEmail()) && StringUtils.isEmpty(instance.getReportemailtime())){
					if("0".equalsIgnoreCase(info.getRolemanager())){
						//�ϱ�����ɫ������
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
			return "��ɫΪ��"+info.getPprolename()+"��";
		}else{
			return "��Ϊ��"+info.getPpusername()+"��";
		}
	}
	/**
	 * ȡ���ϱ�ʱ��
	 * @param timed
	 * @param timeh
	 * @param timem
	 * @return
	 */
	private boolean getNotifyTime(Integer timed, Integer timeh,Integer timem,String ppinittime){
		long timeNumber = 0; 
		long mins = 60L * 1000L;
		//��
		if(timed != null && timed > 0){
			timeNumber = timed * 24 * 60;
		}
		//Сʱ
		if(timeh != null && timeh > 0 && timeNumber == 0){
			timeNumber = timeh * 60;
		}
		//����
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
	 * ȡ��֪ͨ��Ϣ�е�ʱ�����
	 * @param timed
	 * @param timeh
	 * @param timem
	 * @return
	 */
	private String getReportTime(Integer timed, Integer timeh,Integer timem){
		//��
		if(timed != null && timed > 0){
			return timed+"��";
		}
		//Сʱ
		if(timeh != null && timeh > 0){
			return timeh+"Сʱ";
		}
		//����
		if(timem != null && timem > 0){
			return timem+"����";
		}
		return "";
	}
	/**
	 * ��ѯ�ٴ�������Ϣ�Ƿ��͹�
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
		List<CodeDetail> codeDetailList = codeDetailBL.searchCodeDetail(codecond, 2);//������
		for(CodeDetail detail : codeDetailList){
			//����֪ͨ��������
			if("3".equalsIgnoreCase(detail.getCid())){
				smsNotify = detail.getCvalue();
			}
			//�����ϱ���������
			if("4".equalsIgnoreCase(detail.getCid())){
				smsReport = detail.getCvalue();
			}
			//�ʼ�֪ͨ���ѱ���
			if("5".equalsIgnoreCase(detail.getCid())){
				mailTitleNotify = detail.getCvalue();
			}
			//�ʼ�֪ͨ��������
			if("6".equalsIgnoreCase(detail.getCid())){
				mailContentNotify = detail.getCvalue();
			}
			//�ʼ��ϱ����ѱ���
			if("7".equalsIgnoreCase(detail.getCid())){
				mailTitilReport = detail.getCvalue();
			}
			//�ʼ��ϱ���������
			if("8".equalsIgnoreCase(detail.getCid())){
				mailContectReport = detail.getCvalue();
			}
		}
		smsNotify = StringUtils.isEmpty(smsNotify)?"�������ѣ�������Ϊ��{0}���� ��{1}������δ�ڡ�{2}���ڴ���":smsNotify;
		smsReport = StringUtils.isEmpty(smsReport)?"�ϱ�֪ͨ��������Ϊ��{0}���� ��{1}������δ�ڡ�{2}���ڴ���,��ǰ����{3},���ע��":smsReport;
		
		mailTitleNotify = StringUtils.isEmpty(mailTitleNotify)?"�������ѣ�������Ϊ��{0}���� ��{1}������δ�ڡ�{2}���ڴ���":mailTitleNotify;
		mailContentNotify = StringUtils.isEmpty(mailContentNotify)?"�������ѣ�������Ϊ��{0}���� ��{1}������δ�ڡ�{2}���ڴ���":mailContentNotify;
		mailTitilReport = StringUtils.isEmpty(mailTitilReport)?"�ϱ�֪ͨ��������Ϊ��{0}���� ��{1}������δ�ڡ�{2}���ڴ���,��ǰ����{3},���ע��":mailTitilReport;
		mailContectReport = StringUtils.isEmpty(mailContectReport)?"�ϱ�֪ͨ��������Ϊ��{0}���� ��{1}������δ�ڡ�{2}���ڴ���,��ǰ����{3},���ע��":mailContectReport;
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
	 * ������
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
	 * ���û�������
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
	 * ����ɫ�������ֻ�������
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
	 * ���ʼ�
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
	 * ���û����ʼ�
	 * 
	 * @param userid
	 * @param message
	 * @throws BLException 
	 * @throws Exception
	 */
	private void sendMailToUser(String title,List<String> argsTitle,String content,List<String> argsContent, String userid) throws BLException{
		User user = userBL.searchUserByKey(userid);
		if(StringUtils.isEmpty(user.getUseremail())){
			log.debug("�û�"+user.getUserid()+"û���������䣡�޷������ʼ�");
			return;
		}
		title = getMessage(title,argsTitle);
		content = getMessage(content,argsContent);
		
		String[] address = new String[1];
		address[0] = user.getUseremail();
		sendMailBL.sendMail(title, content, address, null);
	}
}