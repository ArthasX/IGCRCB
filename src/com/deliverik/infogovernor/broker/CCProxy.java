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
//	 * 取得CCProxy对象的一个实例
//	 */
//	public static CCProxy getOnlyCCProxy() {
//		return new CCProxy("a");
//	}
	
	
	
	/**
	 * 检查是否开启短信发送功能
	 * @return
	 */
	public int isStartSms() {
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String is_send = ctlBL.getCodeValue(CodeDefinition.SMS, "", "", CodeDefinition.SMS_IS_SEND);
		int result = 1 ;
		if("1".equals(is_send)){
			result = 1 ;
		}else{
			result = 0;//短信发送功能已关闭
		}

		return result;
	}
	
	/**
	 * 取得CODEDETAIL值
	 * @return
	 */
	public String getCodeDetailValue(String key) {
		CodeListUtils ctlBL = (CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		String sendPort = ctlBL.getCodeValue(CodeDefinition.SMS, "", "", key);
		return sendPort;
	}
	
	/**
	 * 判断使用哪种平台发送短信
	 *  ENDSMSMODE_CODE = 0 时 使用短信平台进行发送短信，
	 *  当SENDSMSMODE_CODE = 1时使用诺亚短信猫进行发送短信。
	 * @return 0 or 1
	 */
	public String getSendMode() {
		String SENDSMSMODE_CODE = ResourceUtility.getString("SENDSMSMODE_CODE");//发送短信模块取得
		return SENDSMSMODE_CODE;
	}
	
	/**
	 * 发送短息
	 * @param telephone
	 * @param message
	 * @return
	 */
	public void sendSmsMessage(String telephone, String message){
		//判断是否开启短信功能
		try{
			if(isStartSms()==1){
				QueueBL queuelBL = (QueueBL) WebApplicationSupport.getBean("queueBL");
				QueueTB queueTB = new QueueTB();
				queueTB.setTel(telephone);
				queueTB.setSmscontext(message);
				queueTB.setAlerttime(IGStringUtils.getCurrentDateTime());
				queuelBL.registQueueInfo(queueTB);
//				if("1".equals(getSendMode())){ //如果使用短信猫模式发送短信时
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
//		// TODO 自动生成方法存根
//		
//	 try {   
//		 	System.out.println("------CCSMS TEST one Start------");
//		 	CCProxy.getOnlyCCProxy().sendSmsMessage("13791056918", "你好！测试一。");
//		 	System.out.println("------CCSMS TEST two Start------");
//		 	CCProxy.getOnlyCCProxy().sendSmsMessage("13888888888", "你好！测试二。");
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
//			// TODO 自动生成 catch 块
//			e.printStackTrace();
//			
//		}
//
//	}
	
	
	
	
	/**
	 * 发送短息
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
//						//电话号码或信息为空,或服务器端返回错误码
//						log.debug("-------SMS fail Reasons---------");
//						log.debug(res);
//						result = 0;
//					}
//				}else{
//					log.debug("-------SMS fail Reasons---------");
//					log.debug("无法与SMS Server 建立连接");
//					result = 0;
//				}
//				
//			}catch (UnknownHostException e) {
//				// 未找到主机
//				log.debug("-----SMS　Exception-----");
//				log.debug("-----目标手机号-----"+telephone);
//				log.debug("-----发送信息-----"+message);
//				log.debug(e.getMessage());
//				result = 0;//fail
//
//			} catch (IOException e) {
//				// 接发消息异常
//				log.debug("-----SMS　Exception-----");;
//				log.debug("-----目标手机号-----"+telephone);
//				log.debug("-----发送信息-----"+message);
//				log.debug(e.getMessage());
//				result = 0;//fail
//
//			} catch(Exception e){
//				log.debug("-----SMS　Exception-----");
//				log.debug("-----目标手机号-----"+telephone);
//				log.debug("-----发送信息-----"+message);
//				log.debug(e.getMessage());
//				result = 0;//fail
//			}
//		//}else{
//		//	result = 2;//短信发送功能已关闭
//		//}
//		return result;
//	}
	
	
	
//	public static void main(String[] args){
//		
//		CCProxy.getOnlyCCProxy().sendSmsMessage("13791056918", "你好！测试。");
//		//System.out.println("a="+a);
//	}

}
