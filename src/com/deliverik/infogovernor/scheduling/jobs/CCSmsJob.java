package com.deliverik.infogovernor.scheduling.jobs;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.infogovernor.adapter.CCSmsAdapter;

/**
 * @Description: QUARTZ短信发送
 * @Author  
 * @History 2009-8-18     新建 
 * @Version V2.0
 */
public class CCSmsJob implements Job {

    private static Log log = LogFactory.getLog(CCSmsJob.class);
    public static final String GROUP_NAME = "CCSMS_GROUP";
	public static final String JOB_NAME = "SMSJOB";


	
	/**
     * <p>
     * 构造方法
     * </p>
     */
	public CCSmsJob(){
		
	}
    
	/**
     * <p>
     * 要执行的job（发送短信）
     * </p>
     * 
     * @throws JobExecutionException
     *             if there is an exception while executing the job.
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {

        // 调用发送短信的实现类
        log.info("CCSMS is start to send! - " + new Date());
        String res = "";
        //String prid = String.valueOf(context.getJobDetail().getName());
		String telephone = String.valueOf(context.getJobDetail().getJobDataMap().get("telephone"));
		String message = String.valueOf(context.getJobDetail().getJobDataMap().get("message"));
		context.getJobDetail().getJobDataMap().clear();
		
		try{
			
			CCSmsAdapter cc = CCSmsAdapter.getOnly();

			res = cc.send(telephone,message);
			if("0000".equals(res)){
			}else{
				//电话号码或信息为空,或服务器端返回错误码
				log.debug("-------SMS fail Reasons---------");
				log.debug(res);

			}				
		} catch (Exception e){
			log.debug("-----SMS　Exception----- 其它异常");;
			log.debug("-----目标手机号-----"+telephone);
			log.debug("-----发送信息-----"+message);
			e.printStackTrace();
			
		}

        
    }

}