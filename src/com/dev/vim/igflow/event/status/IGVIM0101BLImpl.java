/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.vim.igflow.event.status;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.SchedulerException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM03BL;
import com.deliverik.infogovernor.soc.vir.model.VIM03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.Vim03SearchCondImpl;
import com.dev.vim.igflow.jobs.IGVIM0101JOB;
import com.dev.vim.igflow.jobs.IGVIM0102JOB;

public class IGVIM0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGVIM0101BLImpl.class);
    private FlowSearchBL flowSearchBL;

    /** 资源申请虚机信息表业务逻辑 */
    protected VIM03BL vim03BL;
    
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * 设置资源申请虚机信息表业务逻辑
     * @param vim03BL 资源申请虚机信息表业务逻辑
     */
    public void setVim03BL(VIM03BL vim03bl) {
        vim03BL = vim03bl;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        log.debug("========资源申请自动部署前处理开始========");
        
        String pid = this.flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "项目主键");
        if(StringUtils.isEmpty(pid)){
            
            log.error("项目主键不存在");
            return;
        }
        
        // 根据项目查询虚机信息
        Vim03SearchCondImpl cond = new Vim03SearchCondImpl();
        cond.setPid_eq(Integer.parseInt(pid));
        List<VIM03Info> searchVim03 = this.vim03BL.searchVim03(cond);
        // 遍历虚机添加克隆任务
        for (VIM03Info vim03Info : searchVim03) {
            String progress = vim03Info.getProgress();
            // 当进度为100时不再重新部署虚机
            // 用于当第一次部署失败重新自动部署时
            if ("100".equals(progress)) {
                continue;
            }
            try {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("pid", vim03Info.getPid());
                map.put("vmid", vim03Info.getId());
                map.put("prid", bean.getLogInfo().getPrid());
                map.put("executorid", bean.getLogInfo().getExecutorid());
                JobManager.addRealTimeJob(IGVIM0101JOB.JOB_NAME + vim03Info.getId(), IGVIM0101JOB.JOB_GROUP_NAME, IGVIM0101JOB.TRIGGER_NAME + vim03Info.getId(), 
                        IGVIM0101JOB.TRIGGER_GROUP_NAME, new IGVIM0101JOB(), map);
            } catch (SchedulerException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
//        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pid", Integer.parseInt(pid));
        map.put("prid", bean.getLogInfo().getPrid());
        map.put("executorid", bean.getLogInfo().getExecutorid());
        
        try {
            JobManager.addRealTimeJob(IGVIM0102JOB.JOB_NAME + pid, IGVIM0102JOB.JOB_GROUP_NAME, IGVIM0102JOB.TRIGGER_NAME + pid, 
                    IGVIM0102JOB.TRIGGER_GROUP_NAME, new IGVIM0102JOB(), map);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        log.debug("========资源申请自动部署前处理结束========");

    
    }
}
