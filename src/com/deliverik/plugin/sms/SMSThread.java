package com.deliverik.plugin.sms;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.entity.CodeDetailTB;
import com.deliverik.framework.model.entity.CodeDetailTBPK;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.adapter.CCSmsAdapter;
import com.deliverik.infogovernor.dbm.bl.IGDBM13BL;
import com.deliverik.plugin.sms.bl.task.SendSmsLogBL;
import com.deliverik.plugin.sms.bl.task.SmsQueueBL;
import com.deliverik.plugin.sms.model.SmsQueueInfo;
import com.deliverik.plugin.sms.model.entity.SendSmsLogTB;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * 短信线程run
 * @author Lu Jiayuan
 *
 */
public class SMSThread implements Runnable {
	
	/**日志文件 **/
	private static Log log = LogFactory.getLog(SMSThread.class);
	/** 短信是否开启 */
	private static boolean smsOpen = true;
	/** 未发送的累计数量 */
	private static int sum;
	
	/** 标识是否返回9999 */
	private static boolean resFlag = false;
	
	/**单例对象**/
	private static SMSThread instance = null;
	/** 同步BL */
	protected static SmsQueueBL smsQueueBL = (SmsQueueBL) WebApplicationSupport.getBean("smsQueueBL");
	
	protected static SendSmsLogBL sendSmsLogBL = (SendSmsLogBL) WebApplicationSupport.getBean("sendSmsLogBL");
	

	private SMSThread(){
		
	}
	
	public static synchronized SMSThread getInstance(){
		if(instance == null){
			instance = new SMSThread();
		}
		return instance;
	}
	
	/** run方法中执行需要的轮询 */
	public void run() {
		while(smsOpen){
			try{
				List<SmsQueueInfo> smsList = smsQueueBL.searchSmsQueueInfo();
				CCSmsAdapter sender = CCSmsAdapter.getOnly();
				String smsContext = null;
				if(smsList!=null){
					for(SmsQueueInfo smsBean:smsList){
						smsContext = smsBean.getSmsContext();
						String result = sendSmsBySocket(sender,smsBean.getTel(),smsContext);
						if("0".equals(result)){
							//发送成功
							smsQueueBL.deleteSmsQueueInfo(smsBean);
							SendSmsLogTB logTB = new SendSmsLogTB();
							logTB.setTel(smsBean.getTel());
							logTB.setSmsContext(smsContext);
							logTB.setSendTime(getNowTime());
							logTB.setUserId(smsBean.getUserId());
							logTB.setAlertTime(smsBean.getAlertTime());
							logTB.setSendStatus("1");
							logTB.setFingerPrint(result);
							sendSmsLogBL.registSendSmsLogInfo(logTB);
							sum = 0;
							resFlag = true;
						}else{
							SendSmsLogTB logTB = new SendSmsLogTB();
							if(hourSub(tranLongTime(smsBean.getAlertTime()))>24){
								smsQueueBL.deleteSmsQueueInfo(smsBean);
								logTB.setFingerPrint("短信超时,错误码"+result);
							}else{
								logTB.setFingerPrint("错误码"+result);
							}
							logTB.setTel(smsBean.getTel());
							logTB.setSmsContext(smsContext);
							logTB.setSendTime(getNowTime());
							logTB.setUserId(smsBean.getUserId());
							logTB.setAlertTime(smsBean.getAlertTime());
							logTB.setSendStatus("0");
							sendSmsLogBL.registSendSmsLogInfo(logTB);
							resFlag = false;
						}
					}
				}
				Thread.sleep(20000);//线程休眠20秒
			}catch(Exception e){
				sum++;
				try {
					Thread.sleep(280000); //线程休眠5分钟
				} catch (InterruptedException e1) {
					setSmsOpen(false);
					log.error("短信平台线程出现故障,停止发送服务",e1);
				}
				log.error("短信平台出现故障",e);
			}
			if(resFlag==false){
				sum++;
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e2) {
					setSmsOpen(false);
					log.error("短信平台线程出现故障,停止发送服务",e2);
				}
			}
			if (sum == -1) {
				sum = 0;
				log.error("短信平台出现故障次数过多,停止发送服务");
				setSmsOpen(false);
				return;
			}
		}
    }
	
	public int hourSub(long dateTime){
		long start = System.currentTimeMillis();
		long value = start - dateTime;
		return (int)(value /(1000*60*60));
	}
	
	/**
	 * 将时间转换成长整型
	 * @throws ParseException 
	 */
	private long tranLongTime(String dateTime) throws ParseException{
		Date date = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy/MM/dd HH:mm");
		date = sdf.parse(dateTime);
		return date.getTime();
	}
	
	private String sendSmsBySocket(CCSmsAdapter send,String tel,String text) throws Exception{
		return send.send(tel,text);
	}

	/**
	 * 短信是否开启取得
	 *
	 * @return smsOpen 短信是否开启
	 */
	public static boolean isSmsOpen() {
		return smsOpen;
	}
	/**
	 * 短信是否开启设定
	 *
	 * @param smsOpen 短信是否开启
	 */
	public static void setSmsOpen(boolean smsOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("153","6"));
		try {
			if(smsOpen){
				codeDetail.setCvalue("1");
				codeDetailBL.updateCodeDetail(codeDetail);
			}else{
				codeDetail.setCvalue("0");
				codeDetailBL.updateCodeDetail(codeDetail);
			}
		} catch (BLException e) {
			log.error("短信平台出现故障",e);
		}
		SMSThread.smsOpen = smsOpen;
	}
	
	/**
	 * 获取当前时间
	 */
	private static String getNowTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		return sdf.format(date);
	}
	
	/**
	 * 工作提醒短信是否开启设定
	 *
	 * @param smsOpen 短信是否开启
	 */
	public static void setWorkManagerSmsOpen(boolean smsOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("159","6"));
		IGDBM13BL ctlBL = (IGDBM13BL) WebApplicationSupport.getBean("igdbm13BL");
		try {
			if(smsOpen){
				codeDetail.setCvalue("1");
				codeDetailBL.updateCodeDetail(codeDetail);
				//插入检查每日待处理工作定时任务
				ctlBL.insertEveryDayjob();
			}else{
				codeDetail.setCvalue("0");
				codeDetailBL.updateCodeDetail(codeDetail);
				//删除检查每日待处理工作定时任务
				ctlBL.delEveryDayjob();
			}
		} catch (BLException e) {
			log.error("短信平台出现故障",e);
		}
		SMSThread.smsOpen = smsOpen;
	}

}
