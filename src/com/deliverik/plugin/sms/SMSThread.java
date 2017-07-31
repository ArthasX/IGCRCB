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
 * �����߳�run
 * @author Lu Jiayuan
 *
 */
public class SMSThread implements Runnable {
	
	/**��־�ļ� **/
	private static Log log = LogFactory.getLog(SMSThread.class);
	/** �����Ƿ��� */
	private static boolean smsOpen = true;
	/** δ���͵��ۼ����� */
	private static int sum;
	
	/** ��ʶ�Ƿ񷵻�9999 */
	private static boolean resFlag = false;
	
	/**��������**/
	private static SMSThread instance = null;
	/** ͬ��BL */
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
	
	/** run������ִ����Ҫ����ѯ */
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
								logTB.setFingerPrint("���ų�ʱ,������"+result);
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
					Thread.sleep(280000); //�߳�����5����
				} catch (InterruptedException e1) {
					setSmsOpen(false);
					log.error("����ƽ̨�̳߳��ֹ���,ֹͣ���ͷ���",e1);
				}
				log.error("����ƽ̨���ֹ���",e);
			}
			if(resFlag==false){
				sum++;
				try {
					Thread.sleep(300000);
				} catch (InterruptedException e2) {
					setSmsOpen(false);
					log.error("����ƽ̨�̳߳��ֹ���,ֹͣ���ͷ���",e2);
				}
			}
			if (sum == -1) {
				sum = 0;
				log.error("����ƽ̨���ֹ��ϴ�������,ֹͣ���ͷ���");
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
	 * �����Ƿ���ȡ��
	 *
	 * @return smsOpen �����Ƿ���
	 */
	public static boolean isSmsOpen() {
		return smsOpen;
	}
	/**
	 * �����Ƿ����趨
	 *
	 * @param smsOpen �����Ƿ���
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
			log.error("����ƽ̨���ֹ���",e);
		}
		SMSThread.smsOpen = smsOpen;
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
	 * �������Ѷ����Ƿ����趨
	 *
	 * @param smsOpen �����Ƿ���
	 */
	public static void setWorkManagerSmsOpen(boolean smsOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("159","6"));
		IGDBM13BL ctlBL = (IGDBM13BL) WebApplicationSupport.getBean("igdbm13BL");
		try {
			if(smsOpen){
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
			log.error("����ƽ̨���ֹ���",e);
		}
		SMSThread.smsOpen = smsOpen;
	}
	
	/**
	 * ������������ѿ����趨
	 *
	 * @param smsOpen �����Ƿ���
	 */
	public static void setWorkItemSmsOpen(boolean smsOpen) {

		CodeDetailBL codeDetailBL = (CodeDetailBL)WebApplicationSupport.getBean("codeDetailBL");
		CodeDetailTB codeDetail = (CodeDetailTB)codeDetailBL.searchCodeDetailByPK(new CodeDetailTBPK("177","6"));
		IGDBM13BL ctlBL = (IGDBM13BL) WebApplicationSupport.getBean("igdbm13BL");
		try {
			if(smsOpen){
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
			log.error("����ƽ̨���ֹ���",e);
		}
		SMSThread.smsOpen = smsOpen;
	}

}
