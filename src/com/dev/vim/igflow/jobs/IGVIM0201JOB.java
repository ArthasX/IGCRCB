/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.dev.vim.igflow.jobs;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM04BL;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM03TB;
import com.deliverik.infogovernor.soc.vir.model.entity.VIM04TB;
import com.deliverik.infogovernor.soc.vir.vim.CloneProgressMonitorBase;
import com.deliverik.infogovernor.soc.vir.vim.VIMBL;
import com.deliverik.infogovernor.soc.vir.vim.model.Template;
import com.vmware.vim25.TaskInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化管理_资源申请_自动部署
 * </p>
 * 
 * @version 1.0
 */

public class IGVIM0201JOB implements Job {

	private static Log log = LogFactory.getLog(IGVIM0201JOB.class);
	
	private static VIM03BL vim03BL = (VIM03BL) WebApplicationSupport.getBean("vim03BL");
	private static VIM04BL vim04BL = (VIM04BL) WebApplicationSupport.getBean("vim04BL");
	private static VIMBL vimBL = (VIMBL) WebApplicationSupport.getBean("vimBL");
    public static final String JOB_NAME = "AUTOREVISE_JOB_";
    public static final String JOB_GROUP_NAME = "AUTOREVISE_JOB_GROUP";
    public static final String TRIGGER_NAME = "AUTOREVISE_TRIGGER_";
    public static final String TRIGGER_GROUP_NAME = "AUTOREVISE_TRIGGER_GROUP";
    
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
	   
	    try {
	        VIM03Info info = vim03BL.searchVim03ByPK(vmid);
	        
            Template template = new Template();
            template.setVcid(info.getVcid());
            template.setVcname(info.getVcName());
            template.setMemoryGB(info.getVmMem());
            template.setNumCPU(info.getVmCpus());
            template.setDiskGB(info.getVmDisk());
            template.setName(info.getTemplateName());
            template.setNetName(info.getNetworkName());
            
            CloneProgressMonitorImpl cpm = new CloneProgressMonitorImpl();
            cpm.setInfo(info);
            cpm.setVim03BL(vim03BL);
            String[] result = vimBL.reconfigVM(template, info.getVmName(), cpm);
            
            // 储存虚机创建日志
            VIM04TB vim04TB = vim04BL.getVIM04TBInstance();
            vim04TB.setPid(pid);
            vim04TB.setVmName(info.getVmName());
            vim04TB.setFlag(result[0]);
            vim04TB.setContent(result[1]);
            vim04TB.setUpdateTime(IGStringUtils.getCurrentDate());
            vim04BL.registVIM04(vim04TB);
            
        } catch (NumberFormatException e) {
            log.error("Quartz任务克隆虚机虚机[" + vmid + "]异常", e);
        } catch (BLException e) {
            log.error("Quartz任务克隆虚机虚机[" + vmid + "]异常", e);
        }
	    log.debug("============== Quartz任务克隆虚机处理结束 =============");
	}

	/**
	 * 进度监控类
	 * 
	 * @author DLK)YangYining
	 * @version 1.0.0
	 */
    private class CloneProgressMonitorImpl extends CloneProgressMonitorBase {

        /** 虚机信息 */
        protected VIM03Info info;

        /** 虚机业务BL */
        protected VIM03BL vim03BL;

        // 部署完成标识 
        boolean created = false;

        public void run() {
            while (!created) {
                log.debug("-------------- 更新虚机进度处理开始 -----------------");
                
                if (this.getInfo() == null) {
                    continue;
                }

                VIM03TB vim03tb = (VIM03TB) SerializationUtils.clone(this.getInfo());

                try {
                    // 如果克隆时异常，停止线程
                    if (this.isError()) {
                        vim03tb.setProgress("-1");
                        this.getVim03BL().updateVim03(vim03tb);
                        created = true;
                    }

                    if (null == this.getTask()) {
                        break;
                    }
                    try {
                        TaskInfo taskInfo = this.getTask().getTaskInfo();
                        if (null != taskInfo) {
                            // 创建进度
                            Integer progress = taskInfo.getProgress();

                            if (null == progress) {
                                continue;
                            }

                            vim03tb.setProgress(progress + "");
                            this.getVim03BL().updateVim03(vim03tb);

                            // 创建完成
                            if (100 == progress) {
                                created = true;
                            }
                        }

                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    // 创建成功
                    if (this.isSuccessed()) {
                        vim03tb.setProgress("100");
                        this.getVim03BL().updateVim03(vim03tb);
                        created = true;
                        log.debug("--------------- 虚机配置调整完成 ---------------");
                    } else {
                        log.debug("-------------- 更新虚机进度处理结束 -----------------");
                        Thread.sleep(5 * 1000);
                    }

                } catch (Exception e) {
                }

            }
        }

        /**
         * 获取虚机信息
         * 
         * @return 虚机信息
         */
        public VIM03Info getInfo() {
            return info;
        }

        /**
         * 设置虚机信息
         * 
         * @param info
         *            虚机信息
         */
        public void setInfo(VIM03Info info) {
            this.info = info;
        }

        /**
         * 获取虚机业务BL
         * 
         * @return 虚机业务BL
         */
        public VIM03BL getVim03BL() {
            return vim03BL;
        }

        /**
         * 设置虚机业务BL
         * 
         * @param vim03BL
         *            虚机业务BL
         */
        public void setVim03BL(VIM03BL vim03bl) {
            vim03BL = vim03bl;
        }
    }
}