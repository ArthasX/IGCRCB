package com.deliverik.plugin.sms;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import com.openmind.service.SendServiceImpl;
import com.openmind.service.SendServiceImplService;
import java.text.*;
/**
 * 微信线程run
 * @author Lu Jiayuan
 *
 */
public class WXThread implements Runnable {
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	/**日志文件 **/
	private static Log log = LogFactory.getLog(WXThread.class);
	/** 微信是否开启 */
	private static boolean wxOpen = true;
	/** 未发送的累计数量 */
	private static int sum;
	
	/** 标识是否返回9999 */
	private static boolean resFlag = false;
	
	/**单例对象**/
	private static WXThread instance = null;
	/** 同步BL */
	protected static SmsQueueBL smsQueueBL = (SmsQueueBL) WebApplicationSupport.getBean("smsQueueBL");
	
	protected static SendSmsLogBL sendSmsLogBL = (SendSmsLogBL) WebApplicationSupport.getBean("sendSmsLogBL");
	

	private WXThread(){
		
	}
	
	public static synchronized WXThread getInstance(){
		if(instance == null){
			instance = new WXThread();
		}
		return instance;
	}
	
	/** run方法中执行需要的轮询 */
	public void run() {
		while(wxOpen){
			try{
				List<SmsQueueInfo> smsList = smsQueueBL.searchSmsQueueInfo();
				//CCSmsAdapter sender = CCSmsAdapter.getOnly();//
				SendServiceImplService factory= new SendServiceImplService();
				SendServiceImpl sendService = factory.getSendServiceImplPort();
				String smsContext = null;
				if(smsList!=null){
					for(SmsQueueInfo smsBean:smsList){
						smsContext = smsBean.getSmsContext();//+"\n消息发送时间：\n"+sdf.format(calendar.getTime());
						//String result = sendSmsBySocket(sender,smsBean.getTel(),smsContext);
						sendService.setMessageText(smsContext, 3, smsBean.getTel());
						String result = sendService.send();
						JSONObject jsonObject = JSON.parseObject(result);
						if("0".equals(jsonObject.getInteger("errcode").toString())){
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
								logTB.setFingerPrint("微信超时,错误码"+result);
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
					log.info("微信发送线程休眠5分钟");
					Thread.sleep(300000); //线程休眠5分钟
				} catch (InterruptedException e1) {
					//setwxOpen(false);
					log.error("微信发送线程出现故障,停止发送服务",e1);
				}
				log.error("微信发送出现故障",e);
			}
			if(resFlag==false){
				sum++;
				try {
					log.info("微信发送线程休眠5分钟");
					Thread.sleep(300000);
				} catch (InterruptedException e2) {
					//setwxOpen(false);
					log.error("微信发送线程出现故障,停止发送服务",e2);
				}
			}
			if (sum == -1) {
				sum = 0;
				//log.error("微信发送出现故障次数过多,停止发送服务");
				//setwxOpen(false);
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
	 * 微信是否开启取得
	 *
	 * @return wxOpen 微信是否开启
	 */
	public static boolean iswxOpen() {
		return wxOpen;
	}
	/**
	 * 微信是否开启设定
	 *
	 * @param wxOpen 微信是否开启
	 */
	public static void setwxOpen(boolean wxOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("160","6"));
		try {
			if(wxOpen){
				codeDetail.setCvalue("1");
				codeDetailBL.updateCodeDetail(codeDetail);
			}else{
				codeDetail.setCvalue("0");
				codeDetailBL.updateCodeDetail(codeDetail);
			}
		} catch (BLException e) {
			log.error("微信发送出现故障",e);
		}
		WXThread.wxOpen = wxOpen;
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
	 * 工作提醒微信是否开启设定
	 *
	 * @param wxOpen 微信是否开启
	 */
	public static void setWorkManagerwxOpen(boolean wxOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("160","6"));
		IGDBM13BL ctlBL = (IGDBM13BL) WebApplicationSupport.getBean("igdbm13BL");
		try {
			if(wxOpen){
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
			log.error("微信发送出现故障",e);
		}
		WXThread.wxOpen = wxOpen;
	}

}
