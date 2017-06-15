/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.vim.igflow.jobs;

import java.text.ParseException;
import java.util.List;

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
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 回收进度监控
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIM0402JOB implements Job{

	private static Log log = LogFactory.getLog(IGVIM0402JOB.class);
	
	private static VIM03BL vim03BL = (VIM03BL) WebApplicationSupport.getBean("vim03BL");
	private static FlowOptBL flowOptBL = (FlowOptBL) WebApplicationSupport.getBean("flowOptBL");
    public static final String JOB_NAME = "RECYCLE_MONITOR_JOB_";
    public static final String JOB_GROUP_NAME = "RECYCLE_MONITOR_JOB_GROUP";
    public static final String TRIGGER_NAME = "RECYCLE_MONITOR_TRIGGER_";
    public static final String TRIGGER_GROUP_NAME = "RECYCLE_MONITOR_TRIGGER_GROUP";
    
    /**
	 * 入口
	 * 
	 * @param context
	 */
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("============== Quartz任务回收虚机处理开始 =============");
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
        Integer pid = (Integer) jobDataMap.get("pid");
        Integer prid = (Integer) jobDataMap.get("prid");
        String executorid = (String) jobDataMap.get("executorid");

        Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        boolean stop = false;
        while(!stop) {
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
                    boolean jobAdded = JobManager.isJobAdded(IGVIM0401JOB.JOB_NAME + vim03Info.getId(),
                            IGVIM0401JOB.JOB_GROUP_NAME);
                    if (jobAdded) {
                        completed = false;
                    }
                    
                }
                
                // 部署完成
                if (completed) {
                    String butName = "";
                    if (!hasError) {
                        butName = "回收成功";
                    } else {
                        butName = "回收异常";
                    }
                    
                    log.debug("============= 部署完成 跃迁流程状态处理开始 ===================");
                    flowOptBL.transitionProcess(prid, executorid, butName, IGStringUtils.getCurrentDateTime());
                    log.debug("============= 部署完成 跃迁流程状态处理结束 ===================");
                    
                    stop = true;
                } else {
                    Thread.sleep(3 * 1000);
                }
                
            } catch (SchedulerException e) {
            } catch (ParseException e) {
            } catch (BLException e) {
                log.debug("=============== 跃迁流程状态时异常 ===============");
                log.error("跃迁流程状态时异常", e);
            } 
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.debug("============== Quartz任务回收虚机处理结束 =============");
    }

}
