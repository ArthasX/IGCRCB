/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.dev.vim.igflow.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD01BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD04BL;
import com.deliverik.infogovernor.soc.vir.model.VCD01Info;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.vcd.VCDBL;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化管理_资源申请_自动部署(vcloud)
 * </p>
 * 
 * @version 1.0
 */

public class IGVIM3001JOB implements Job {

	private static Log log = LogFactory.getLog(IGVIM3001JOB.class);
	
    public static final String JOB_NAME = "VCLOUD_AUTODEPLOY_JOB_";
    public static final String JOB_GROUP_NAME = "VCLOUD_AUTODEPLOY_JOB_GROUP";
    public static final String TRIGGER_NAME = "VCLOUD_AUTODEPLOY_TRIGGER_";
    public static final String TRIGGER_GROUP_NAME = "VCLOUD_AUTODEPLOY_TRIGGER_GROUP";
    
	/**
	 * 入口
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
	    log.debug("============== Quartz任务克隆虚机处理开始 =============");
	    JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
	    Integer pid = (Integer) jobDataMap.get("pid");
	    Integer vmid = (Integer) jobDataMap.get("vmid");
	    Integer vcid = (Integer) jobDataMap.get("vcid");
	   
	    try {
	    	VCD01BL vcd01BL = (VCD01BL) WebApplicationSupport.getBean("vcd01BL");
	    	VCD03BL vcd03BL = (VCD03BL) WebApplicationSupport.getBean("vcd03BL");
	    	VCD04BL vcd04BL = (VCD04BL) WebApplicationSupport.getBean("vcd04BL");
	    	VCDBL vcdBL = (VCDBL) WebApplicationSupport.getBean("vcdBL");
	    	VCD03Info info = vcd03BL.searchVCD03ByPK(vmid);
            
            VcloudCloneProgressMonitor cpm = new VcloudCloneProgressMonitor();
            cpm.setVcd03(info);
            cpm.setVcd03BL(vcd03BL);
            cpm.setVcd04BL(vcd04BL);
            cpm.setPid(pid);
            VCD01Info vcd01 = vcd01BL.searchVCD01ByPK(vcid);
            vcdBL.cloneVM(vcd01, "dlk", "test", "vApp_system_20", "admin的组织目录1", info.getTemplateName(), "fgfdg777", "", "", "", cpm);
            
        } catch (NumberFormatException e) {
            log.error("Quartz任务克隆虚机虚机[" + vmid + "]异常", e);
        } catch (BLException e) {
            log.error("Quartz任务克隆虚机虚机[" + vmid + "]异常", e);
        }
	    log.debug("============== Quartz任务克隆虚机处理结束 =============");
	}
}