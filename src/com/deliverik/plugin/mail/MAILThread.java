package com.deliverik.plugin.mail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.plugin.mail.bl.task.AlermSendMailQueueBL;
import com.deliverik.plugin.mail.model.AlermSendMailQueueInfo;
import com.deliverik.plugin.mail.model.condition.AlermSendMailQueueSearchCondImpl;
import com.deliverik.plugin.mail.model.entity.AlermSendMailQueueTB;

/**
 * 邮件线程run
 * @author Xudong Wang 
 */
public class MAILThread implements Runnable {
	
	/** 日志文件  */
	private static Log log = LogFactory.getLog(MAILThread.class);
	/** 邮件是否开启 */
	private static boolean mailOpen = false;
	/** 单例对象 */
	private static MAILThread instance = null;
	/** 错误计数 */
	private int sum=0;
	/** 邮件执行间隔 默认60s */
	private int iINV_SLEEP_TIME=60*1000;
	/**isFirstRun*/
	private int iIsFirstRun = 0;
	
	/** MAIL QUEUE BL */
	protected static AlermSendMailQueueBL alermSendMailQueueBL = (AlermSendMailQueueBL) WebApplicationSupport.getBean("alermSendMailQueueBL");
	protected static SendMailBL sendMailBL = (SendMailBL) WebApplicationSupport.getBean("sendMailBL");
	
	//mail info
	String mail_TITLE="";
	String mail_CONTENT="";
	String[] mail_UserList=null;
	//tempList
	List<UserInfo> uivwList=null;
	
	//struct
	private MAILThread(){
		initBaseInfo();
	}
	
	//更新接收人设定
	private void flushMailToList(){
		//for mail_UserList
		UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
		UserInfoSearchCondImpl cond_user =new UserInfoSearchCondImpl();
		cond_user.setRoleida(9999);
		uivwList=userBL.searchUserInfo(cond_user);
		if(uivwList == null){return;}
		if(uivwList.size() == 0){return;}
		mail_UserList= new String[uivwList.size()];
		for(int i=0;i< uivwList.size();i++) {
			mail_UserList[i]=uivwList.get(i).getUseremail();
		}
	}
	//更新时间设定
	private void flushTimeData(){
		//for config data
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetail cDetail1 = codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("170","1"));//invTime
		int inv=Integer.parseInt(cDetail1.getCvalue());
		if(inv <= 60 ){
			iINV_SLEEP_TIME=60*1000;
		}else{
			iINV_SLEEP_TIME=inv*1000;
		}
	}
	//检查是否要删除日志
	private void flushLogConfig(){
		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetail cDetail2 = codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("170","2"));//rowNums
		int totalCount=Integer.parseInt(cDetail2.getCvalue());
		if(iIsFirstRun == 0){
			if(totalCount <= 1000){
				clearLOG(1000);
			}else{
				clearLOG(totalCount);
			}
		}
	}
	//每次启动执行
	private void initBaseInfo(){
		flushMailToList();
		flushTimeData();
		flushLogConfig();
	}
	//清空多余记录
	private void clearLOG(int rowNums){
		AlermSendMailQueueSearchCondImpl cond=new AlermSendMailQueueSearchCondImpl();
		cond.setSentstatus_eq('1');//查已发送
		int test=alermSendMailQueueBL.getSearchCount(cond);
		if(test > rowNums){
			List<AlermSendMailQueueInfo> delList=alermSendMailQueueBL.searchAlermSendMailQueueInfo(cond);
			for (AlermSendMailQueueInfo alermSendMailQueueInfo : delList) {
				try {
					alermSendMailQueueBL.deleteAlermSendMailQueueInfoByPK(alermSendMailQueueInfo.getMid());
				} catch (BLException e) {
					e.printStackTrace();
				}
			}
			iIsFirstRun=1;
		}
	}
	
	public static synchronized MAILThread getInstance(){
		if(instance == null){
			instance = new MAILThread();
		}
		return instance;
	}

	/** run方法中执行需要的轮询 */
	AlermSendMailQueueTB mailTB =null;
	
	public void run() {
		while(mailOpen){
			flushTimeData();
			if(mail_UserList == null){
				flushMailToList();
			}
			if(IGStringUtils.getCurrentDateTime().substring(11).equals("00:00")){// min 60s recycle ,so no bug here.
				iIsFirstRun = 0;
				flushLogConfig();
			}
			try{
				AlermSendMailQueueSearchCondImpl cond=new AlermSendMailQueueSearchCondImpl();
				cond.setSentstatus_eq('0');//查询未发送
				List<AlermSendMailQueueInfo> mailInforList = alermSendMailQueueBL.searchAlermSendMailQueueInfo(cond);
				for (AlermSendMailQueueInfo mailInfo : mailInforList) {
					mail_TITLE="告警邮件   等级: "+getLevelTEXT( mailInfo.getCrm04TB().getRulelevel() )+" 位置: "+mailInfo.getCrm04TB().getServerip()+"_"+mailInfo.getCrm04TB().getServername()+"_"+mailInfo.getCrm04TB().getCategory();
					mail_CONTENT="告警信息描述: \n"+mailInfo.getCrm04TB().getAlarmmsg()+"\n .";
					mailTB=(AlermSendMailQueueTB)SerializationUtils.clone(mailInfo);
					try {
						sendMailBL.sendMail(mail_TITLE,mail_CONTENT,mail_UserList,null);
						mailTB.setSentstatus('1');
						mailTB.setSenttime(getNowTime());
						alermSendMailQueueBL.updateAlermSendMailQueueInfo(mailTB);
					} catch (Exception e) {
						mailTB.setSentstatus('0');
						mailTB.setSenttime(getNowTime());
						alermSendMailQueueBL.updateAlermSendMailQueueInfo(mailTB);
						log.error("邮件发送过程中出现错误:"+e.getStackTrace());
					}
				}
				Thread.sleep(iINV_SLEEP_TIME);// min = 60s or high
			}catch(Exception e){
				sum++;
				try {
					Thread.sleep(60*1000);// 1min
				} catch (InterruptedException e1) {
					setMailOpen(false);
					log.error("邮件发送线程出现故障,停止发送服务",e1);
				}
				log.error("邮件发送线程出现故障",e);
			}
			if(sum >= 50){
				sum = 0;
				log.error("邮件发送线程出现故障次数过多,停止发送服务");
				setMailOpen(false);
				return;
			}
		}
    }

	//获取告警等级文字信息
	private String getLevelTEXT(Integer lv){
		if(lv.toString().equals("0")){return "未知";}
		if(lv.toString().equals("1")){return "信息";}
		if(lv.toString().equals("2")){return "警告";}
		if(lv.toString().equals("3")){return "次要";}
		if(lv.toString().equals("4")){return "严重";}
		if(lv.toString().equals("5")){return "致命";}
		return "未知";
	}
	/**
	 * 邮件是否开启取得
	 *
	 * @return mailOpen 邮件是否开启
	 */
	public static boolean isMailOpen() {
		return mailOpen;
	}
	/**
	 * 邮件是否开启设定
	 *
	 * @param mailOpen 邮件是否开启
	 */
	public static void setMailOpen(boolean mailOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("170","3"));
		try {
			if(mailOpen){
				codeDetail.setCvalue("1");
				codeDetailBL.updateCodeDetail(codeDetail);
			}else{
				codeDetail.setCvalue("0");
				codeDetailBL.updateCodeDetail(codeDetail);
			}
		} catch (BLException e) {
			log.error("邮件发送线程出现故障",e);
		}
		MAILThread.mailOpen = mailOpen;
	}
	/**
	 * 获取当前时间
	 */
	private static String getNowTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
}
