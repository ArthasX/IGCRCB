package com.deliverik.plugin.sms;

import java.text.ParseException;
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

/**
 * ΢���߳�run
 * @author Lu Jiayuan
 *
 */
public class WXThread implements Runnable {
	
	/**��־�ļ� **/
	private static Log log = LogFactory.getLog(WXThread.class);
	/** ΢���Ƿ��� */
	private static boolean wxOpen = true;
	/** δ���͵��ۼ����� */
	private static int sum;
	
	/** ��ʶ�Ƿ񷵻�9999 */
	private static boolean resFlag = false;
	
	/**��������**/
	private static WXThread instance = null;
	/** ͬ��BL */
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
	
	/** run������ִ����Ҫ����ѯ */
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
						smsContext = smsBean.getSmsContext();
						//String result = sendSmsBySocket(sender,smsBean.getTel(),smsContext);
						sendService.setMessageText(smsContext, 3, smsBean.getTel());
						String result = sendService.send();
						JSONObject jsonObject = JSON.parseObject(result);
						if("0".equals(jsonObject.getInteger("errcode").toString())){
							//���ͳɹ�
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
								logTB.setFingerPrint("΢�ų�ʱ,������"+result);
							}else{
								logTB.setFingerPrint("������"+result);
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
				Thread.sleep(20000);//�߳�����20��
			}catch(Exception e){
				sum++;
				try {
					log.info("΢�ŷ����߳�����5����");
					Thread.sleep(300000); //�߳�����5����
				} catch (InterruptedException e1) {
					//setwxOpen(false);
					log.error("΢�ŷ����̳߳��ֹ���,ֹͣ���ͷ���",e1);
				}
				log.error("΢�ŷ��ͳ��ֹ���",e);
			}
			if(resFlag==false){
				sum++;
				try {
					log.info("΢�ŷ����߳�����5����");
					Thread.sleep(300000);
				} catch (InterruptedException e2) {
					//setwxOpen(false);
					log.error("΢�ŷ����̳߳��ֹ���,ֹͣ���ͷ���",e2);
				}
			}
			if (sum == -1) {
				sum = 0;
				//log.error("΢�ŷ��ͳ��ֹ��ϴ�������,ֹͣ���ͷ���");
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
	 * ��ʱ��ת���ɳ�����
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
	 * ΢���Ƿ���ȡ��
	 *
	 * @return wxOpen ΢���Ƿ���
	 */
	public static boolean iswxOpen() {
		return wxOpen;
	}
	/**
	 * ΢���Ƿ����趨
	 *
	 * @param wxOpen ΢���Ƿ���
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
			log.error("΢�ŷ��ͳ��ֹ���",e);
		}
		WXThread.wxOpen = wxOpen;
	}
	
	/**
	 * ��ȡ��ǰʱ��
	 */
	private static String getNowTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		return sdf.format(date);
	}
	
	/**
	 * ��������΢���Ƿ����趨
	 *
	 * @param wxOpen ΢���Ƿ���
	 */
	public static void setWorkManagerwxOpen(boolean wxOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("160","6"));
		IGDBM13BL ctlBL = (IGDBM13BL) WebApplicationSupport.getBean("igdbm13BL");
		try {
			if(wxOpen){
				codeDetail.setCvalue("1");
				codeDetailBL.updateCodeDetail(codeDetail);
				//������ÿ�մ���������ʱ����
				ctlBL.insertEveryDayjob();
			}else{
				codeDetail.setCvalue("0");
				codeDetailBL.updateCodeDetail(codeDetail);
				//ɾ�����ÿ�մ���������ʱ����
				ctlBL.delEveryDayjob();
			}
		} catch (BLException e) {
			log.error("΢�ŷ��ͳ��ֹ���",e);
		}
		WXThread.wxOpen = wxOpen;
	}

}
