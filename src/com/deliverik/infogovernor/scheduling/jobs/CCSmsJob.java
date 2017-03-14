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
 * @Description: QUARTZ���ŷ���
 * @Author  
 * @History 2009-8-18     �½� 
 * @Version V2.0
 */
public class CCSmsJob implements Job {

    private static Log log = LogFactory.getLog(CCSmsJob.class);
    public static final String GROUP_NAME = "CCSMS_GROUP";
	public static final String JOB_NAME = "SMSJOB";


	
	/**
     * <p>
     * ���췽��
     * </p>
     */
	public CCSmsJob(){
		
	}
    
	/**
     * <p>
     * Ҫִ�е�job�����Ͷ��ţ�
     * </p>
     * 
     * @throws JobExecutionException
     *             if there is an exception while executing the job.
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {

        // ���÷��Ͷ��ŵ�ʵ����
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
				//�绰�������ϢΪ��,��������˷��ش�����
				log.debug("-------SMS fail Reasons---------");
				log.debug(res);

			}				
		} catch (Exception e){
			log.debug("-----SMS��Exception----- �����쳣");;
			log.debug("-----Ŀ���ֻ���-----"+telephone);
			log.debug("-----������Ϣ-----"+message);
			e.printStackTrace();
			
		}

        
    }

}