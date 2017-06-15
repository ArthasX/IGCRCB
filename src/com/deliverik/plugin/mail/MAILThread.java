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
 * �ʼ��߳�run
 * @author Xudong Wang 
 */
public class MAILThread implements Runnable {
	
	/** ��־�ļ�  */
	private static Log log = LogFactory.getLog(MAILThread.class);
	/** �ʼ��Ƿ��� */
	private static boolean mailOpen = false;
	/** �������� */
	private static MAILThread instance = null;
	/** ������� */
	private int sum=0;
	/** �ʼ�ִ�м�� Ĭ��60s */
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
	
	//���½������趨
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
	//����ʱ���趨
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
	//����Ƿ�Ҫɾ����־
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
	//ÿ������ִ��
	private void initBaseInfo(){
		flushMailToList();
		flushTimeData();
		flushLogConfig();
	}
	//��ն����¼
	private void clearLOG(int rowNums){
		AlermSendMailQueueSearchCondImpl cond=new AlermSendMailQueueSearchCondImpl();
		cond.setSentstatus_eq('1');//���ѷ���
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

	/** run������ִ����Ҫ����ѯ */
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
				cond.setSentstatus_eq('0');//��ѯδ����
				List<AlermSendMailQueueInfo> mailInforList = alermSendMailQueueBL.searchAlermSendMailQueueInfo(cond);
				for (AlermSendMailQueueInfo mailInfo : mailInforList) {
					mail_TITLE="�澯�ʼ�   �ȼ�: "+getLevelTEXT( mailInfo.getCrm04TB().getRulelevel() )+" λ��: "+mailInfo.getCrm04TB().getServerip()+"_"+mailInfo.getCrm04TB().getServername()+"_"+mailInfo.getCrm04TB().getCategory();
					mail_CONTENT="�澯��Ϣ����: \n"+mailInfo.getCrm04TB().getAlarmmsg()+"\n .";
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
						log.error("�ʼ����͹����г��ִ���:"+e.getStackTrace());
					}
				}
				Thread.sleep(iINV_SLEEP_TIME);// min = 60s or high
			}catch(Exception e){
				sum++;
				try {
					Thread.sleep(60*1000);// 1min
				} catch (InterruptedException e1) {
					setMailOpen(false);
					log.error("�ʼ������̳߳��ֹ���,ֹͣ���ͷ���",e1);
				}
				log.error("�ʼ������̳߳��ֹ���",e);
			}
			if(sum >= 50){
				sum = 0;
				log.error("�ʼ������̳߳��ֹ��ϴ�������,ֹͣ���ͷ���");
				setMailOpen(false);
				return;
			}
		}
    }

	//��ȡ�澯�ȼ�������Ϣ
	private String getLevelTEXT(Integer lv){
		if(lv.toString().equals("0")){return "δ֪";}
		if(lv.toString().equals("1")){return "��Ϣ";}
		if(lv.toString().equals("2")){return "����";}
		if(lv.toString().equals("3")){return "��Ҫ";}
		if(lv.toString().equals("4")){return "����";}
		if(lv.toString().equals("5")){return "����";}
		return "δ֪";
	}
	/**
	 * �ʼ��Ƿ���ȡ��
	 *
	 * @return mailOpen �ʼ��Ƿ���
	 */
	public static boolean isMailOpen() {
		return mailOpen;
	}
	/**
	 * �ʼ��Ƿ����趨
	 *
	 * @param mailOpen �ʼ��Ƿ���
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
			log.error("�ʼ������̳߳��ֹ���",e);
		}
		MAILThread.mailOpen = mailOpen;
	}
	/**
	 * ��ȡ��ǰʱ��
	 */
	private static String getNowTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}
}
