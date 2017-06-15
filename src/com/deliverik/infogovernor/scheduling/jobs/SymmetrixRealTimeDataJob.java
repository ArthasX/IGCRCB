package com.deliverik.infogovernor.scheduling.jobs;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.soc.dbs.bl.IGDBS01BL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;

/**
 * @Description: DashBoard实时数据导入
 * @Author  DUCHONG
 * @History 2010 12 15     新建 
 * @Version V1.0
 */
public class SymmetrixRealTimeDataJob implements Job {

    private static Log log = LogFactory.getLog(SymmetrixRealTimeDataJob.class);
    public static final String JOB_GROUP_NAME = "DASHBOARD_JOB_GROUP";
	public static final String JOB_NAME = "DASHBOARD_JOB";
	public static final String TRIGGER_GROUP_NAME = "DASHBOARD_TRIGGER_GROUP";
	public static final String TRIGGER_NAME = "DASHBOARD_TRIGGER";

	
	/**
     * <p>
     * 构造方法
     * </p>
     */
	public SymmetrixRealTimeDataJob(){
		
	}
    
	/**
     * <p>
     * 要执行的job
     * </p>
     * 
     * @throws JobExecutionException
     *             if there is an exception while executing the job.
     */
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	IGDBS01BL ctlBL = (IGDBS01BL) WebApplicationSupport.getBean("igDBS01BL");
    	try {
    		List<Collect_Symmetrix_Monitor_Rt> dataListAll=ctlBL.getSymmetrixMonitorData();
    		ctlBL.getWarnInfo(dataListAll);
    	} catch (Exception e) {
    		log.debug(e.getMessage());
    	}
        
    }

}