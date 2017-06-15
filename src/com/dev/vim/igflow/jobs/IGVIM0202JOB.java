/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.dev.vim.igflow.jobs;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM02BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.model.VIM02Info;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM02TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化管理_资源申请_自动部署完成监控
 * </p>
 * 
 * @version 1.0
 */

public class IGVIM0202JOB implements Job {

	private static Log log = LogFactory.getLog(IGVIM0202JOB.class);
	
	private static VIM02BL vim02BL = (VIM02BL) WebApplicationSupport.getBean("vim02BL");
	private static VIM03BL vim03BL = (VIM03BL) WebApplicationSupport.getBean("vim03BL");
	private static FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
    public static final String JOB_NAME = "AUTOREVISE_MONITOR_JOB_";
    public static final String JOB_GROUP_NAME = "AUTOREVISE_MONITOR_JOB_GROUP";
    public static final String TRIGGER_NAME = "AUTOREVISE_MONITOR_TRIGGER_";
    public static final String TRIGGER_GROUP_NAME = "AUTOREVISE_MONITOR_TRIGGER_GROUP";
    
	/**
	 * 入口
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("============== Quartz任务克隆虚机处理开始 =============");
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Integer pid = (Integer) jobDataMap.get("pid");
        Integer prid = (Integer) jobDataMap.get("prid");
        String executorid = (String) jobDataMap.get("executorid");

        Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        boolean stop = false;
        while(!stop) {
            log.debug("***************** 看看部署完成没 ****************");
            cond.setPid_eq(pid);
            List<VIM03Info> vim03List = vim03BL.searchVim03(cond);
            boolean completed = true;
            boolean hasError = false;
            try {
                
                // 遍历虚机信息
                for (VIM03Info vim03Info : vim03List) {
                    
                    // 存在异常的虚机
                    if ("-1".equals(vim03Info.getProgress())) {
                        hasError = true;
                    }
                    
                    // 存在为部署完成的虚机
                    boolean jobAdded = JobManager.isJobAdded(IGVIM0201JOB.JOB_NAME + vim03Info.getId(),
                            IGVIM0201JOB.JOB_GROUP_NAME);
                    if (jobAdded) {
                        completed = false;
                    }
                    
                }
                
                // 部署完成
                if (completed) {
                    String butName = "";
                    
                    VIM02Info vim02info = vim02BL.searchVIM02ByPK(pid);
                    VIM02TB vim02tb = (VIM02TB) SerializationUtils.clone(vim02info);
                    if (!hasError) {
                        butName = "调整成功";
                        vim02tb.setProgress("100");
                    } else {
                        butName = "调整异常";
                        vim02tb.setProgress("-1");
                    }
                    vim02BL.updateVIM02(vim02tb);
                    
                    log.debug("============= 部署完成 跃迁流程状态处理开始 ===================");
                    flowOptBL.transitionProcess(prid, executorid, butName, IGStringUtils.getCurrentDateTime());
                    log.debug("============= 部署完成 跃迁流程状态处理结束 ===================");
                    log.debug("***************** 部署完成了 ****************");
                    
                    stop = true;
                } else {
                    
                    log.debug("***************** 靠，你还没完事 ****************");
                    Thread.sleep(3 * 1000);
                }
                
            } catch (SchedulerException e) {
            } catch (ParseException e) {
            } catch (BLException e) {
                log.debug("=============== 跃迁流程状态时异常 ===============");
                log.error("跃迁流程状态时异常", e);
            } 
            catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        log.debug("============== Quartz任务克隆虚机处理结束 =============");
    }

}