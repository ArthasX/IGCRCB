package com.deliverik.infogovernor.broker;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.adapter.CodeDefinition;
import com.deliverik.infogovernor.sym.bl.task.QueueBL;
import com.deliverik.infogovernor.sym.model.entity.QueueTB;


public class CCProxy extends BaseBLImpl {

	private static Log log = LogFactory.getLog(CCProxy.class);
//	private ServletContext application;
//	public void setServletContext(ServletContext application) {
//		this.application = application;
//	}
	
	private CCProxy(){}
	
//	
//	/**
//	 * ȡ��CCProxy�����һ��ʵ��
//	 */
//	public static CCProxy getOnlyCCProxy() {
//		return new CCProxy("a");
//	}
	
	
	
	/**
	 * ����Ƿ������ŷ��͹���
	 * @return
	 */
	public int isStartSms() {
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String is_send = ctlBL.getCodeValue(CodeDefinition.SMS, "", "", CodeDefinition.SMS_IS_SEND);
		int result = 1 ;
		if("1".equals(is_send)){
			result = 1 ;
		}else{
			result = 0;//���ŷ��͹����ѹر�
		}

		return result;
	}
	
	/**
	 * ȡ��CODEDETAILֵ
	 * @return
	 */
	public String getCodeDetailValue(String key) {
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String sendPort = ctlBL.getCodeValue(CodeDefinition.SMS, "", "", key);
		return sendPort;
	}
	
	/**
	 * �ж�ʹ������ƽ̨���Ͷ���
	 *  ENDSMSMODE_CODE = 0 ʱ ʹ�ö���ƽ̨���з��Ͷ��ţ�
	 *  ��SENDSMSMODE_CODE = 1ʱʹ��ŵ�Ƕ���è���з��Ͷ��š�
	 * @return 0 or 1
	 */
	public String getSendMode() {
		String SENDSMSMODE_CODE = ResourceUtility.getString("SENDSMSMODE_CODE");//���Ͷ���ģ��ȡ��
		return SENDSMSMODE_CODE;
	}
	
	/**
	 * ���Ͷ�Ϣ
	 * @param telephone
	 * @param message
	 * @return
	 */
	public void sendSmsMessage(String telephone, String message){
		//�ж��Ƿ������Ź���
		try{
			if(isStartSms()==1){
				QueueBL queuelBL = (QueueBL) WebApplicationSupport.getBean("queueBL");
				QueueTB queueTB = new QueueTB();
				queueTB.setTel(telephone);
				queueTB.setSmscontext(message);
				queueTB.setAlerttime(IGStringUtils.getCurrentDateTime());
				queuelBL.registQueueInfo(queueTB);
//				if("1".equals(getSendMode())){ //���ʹ�ö���èģʽ���Ͷ���ʱ
//					SMSLogBL ctlBL = (SMSLogBL) WebApplicationSupport.getBean("smslogBL");
//					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
//					String cdate = sdf.format(new Date());
//
//					SMSLogTB smsTB = new SMSLogTB();
//					smsTB.setTelnumber(telephone);
//					smsTB.setSmstext(message);
//					smsTB.setSendcount(0);
//					smsTB.setCtime(cdate);
//					smsTB.setUtime(cdate);
//					smsTB.setSendstatus("0");
//					ctlBL.saveSMSLog(smsTB);
//					String ip = getCodeDetailValue("11");
//					String port = getCodeDetailValue("10");
//					Socket socket = new Socket(ip, Integer.parseInt(port));
//					socket.getOutputStream().write("SEND".getBytes());
//					socket.close();
//
//				}else{
//					String prid = IGStringUtils.getSmsKey();
//				    Map<String,String> args = new HashMap<String, String>();
//				    args.put("telephone", telephone);
//				    args.put("message", message);
//				    List<String> keyname = new ArrayList<String>();
//				    keyname.add("telephone");
//				    keyname.add("message");
//					JobManager.addJob(prid,CCSmsJob.GROUP_NAME,prid, new CCSmsJob(),keyname, args);
//				}
			}
		}catch(Exception e){
			log.debug("-----CCSMS Exception-----");
			log.debug(e.getMessage());
		}
		
	}




	/**
	 * @param args
	 * @throws ParseException 
	 */
//	public static void main(String[] args) throws ParseException {
//		// TODO �Զ����ɷ������
//		
//	 try {   
//		 	System.out.println("------CCSMS TEST one Start------");
//		 	CCProxy.getOnlyCCProxy().sendSmsMessage("13791056918", "��ã�����һ��");
//		 	System.out.println("------CCSMS TEST two Start------");
//		 	CCProxy.getOnlyCCProxy().sendSmsMessage("13888888888", "��ã����Զ���");
//			//System.out.println("a="+a);
////        	Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();   
////
////        	JobDetail jobDetail = new JobDetail(CCSmsJob.JOB_NAME,CCSmsJob.GROUP_NAME,CCSmsJob.class);
////			String cronexPression = "0 */1 * */1 * ?"; 
////			CronTrigger ct = new CronTrigger("CCSMS",CCSmsJob.GROUP_NAME,cronexPression);
////			
////			scheduler.scheduleJob(jobDetail, ct);   
////            scheduler.start();   
////			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler(); 
////			csj = new CCSmsJob();
////			JobDetail jobDetail = new JobDetail(CCSmsJob.JOB_NAME,CCSmsJob.GROUP_NAME,csj.getClass());
////			
////			jobDetail.getJobDataMap().put("telephone", telephone);
////			jobDetail.getJobDataMap().put("message", message);
////			//jobDetail.getJobDataMap().put("prid", prid);
////			
////			String cronExpression = "* * * * * ?"; 
////			CronTrigger trigger = new CronTrigger("is_my_test","trigger_group");
////			trigger.setCronExpression(cronExpression);
////			
////			
////			scheduler.scheduleJob(jobDetail, trigger);   
////            scheduler.start();   
//    
//            //log.debug("CCsms ("+telephone+"--"+message+") was started at " + new Date());   
//
//		} catch (Exception e) {
//			// TODO �Զ����� catch ��
//			e.printStackTrace();
//			
//		}
//
//	}
	
	
	
	
	/**
	 * ���Ͷ�Ϣ
	 * @param telephone
	 * @param message
	 * @return
	 */
//	public int sendSmsMessage(String telephone, String message) {
//		//String is_send = ResourceUtility.getString("IS_SEND");
//		int result = 0 ;
//		//if("YES".equals(is_send)){
//			try{
//				String res = "";
//				CCSmsAdapter cc = CCSmsAdapter.getOnly();
//				res = cc.doConnect();
//				if("success".equals(res)){
//					res = cc.send(telephone,message);
//					if("0000".equals(res)){
//						result = 1;//success
//					}else{
//						//�绰�������ϢΪ��,��������˷��ش�����
//						log.debug("-------SMS fail Reasons---------");
//						log.debug(res);
//						result = 0;
//					}
//				}else{
//					log.debug("-------SMS fail Reasons---------");
//					log.debug("�޷���SMS Server ��������");
//					result = 0;
//				}
//				
//			}catch (UnknownHostException e) {
//				// δ�ҵ�����
//				log.debug("-----SMS��Exception-----");
//				log.debug("-----Ŀ���ֻ���-----"+telephone);
//				log.debug("-----������Ϣ-----"+message);
//				log.debug(e.getMessage());
//				result = 0;//fail
//
//			} catch (IOException e) {
//				// �ӷ���Ϣ�쳣
//				log.debug("-----SMS��Exception-----");;
//				log.debug("-----Ŀ���ֻ���-----"+telephone);
//				log.debug("-----������Ϣ-----"+message);
//				log.debug(e.getMessage());
//				result = 0;//fail
//
//			} catch(Exception e){
//				log.debug("-----SMS��Exception-----");
//				log.debug("-----Ŀ���ֻ���-----"+telephone);
//				log.debug("-----������Ϣ-----"+message);
//				log.debug(e.getMessage());
//				result = 0;//fail
//			}
//		//}else{
//		//	result = 2;//���ŷ��͹����ѹر�
//		//}
//		return result;
//	}
	
	
	
//	public static void main(String[] args){
//		
//		CCProxy.getOnlyCCProxy().sendSmsMessage("13791056918", "��ã����ԡ�");
//		//System.out.println("a="+a);
//	}

}
