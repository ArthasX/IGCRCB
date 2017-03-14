/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.vim.igflow.event.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.soc.vir.bl.task.VIM07BL;
import com.deliverik.infogovernor.soc.vir.model.VIM07Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM07SearchCondImpl;
import com.dev.vim.igflow.jobs.IGVIM0401JOB;
import com.dev.vim.igflow.jobs.IGVIM0402JOB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源回收
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIM0402BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 资源调整BL */
	protected VIM07BL vim07BL;

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 资源调整BL设定
	 * @param vim07BL 资源调整BL
	 */
	public void setVim07BL(VIM07BL vim07bl) {
		vim07BL = vim07bl;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		String pid = this.flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "项目主键");
        if(StringUtils.isEmpty(pid)){
            return;
        }
        
        VIM07SearchCondImpl cond = new VIM07SearchCondImpl();
        cond.setPrid(bean.getLogInfo().getPrid());
        cond.setPid(Integer.valueOf(pid));
        List<VIM07Info> list = vim07BL.searchVim07(cond);
        //添加回收任务
        for(VIM07Info info:list){
        	try{
        		 Map<String, Object> map = new HashMap<String, Object>();
                 map.put("pid", info.getPid());
                 map.put("vmid", info.getVmid());
                 map.put("prid", bean.getLogInfo().getPrid());
                 map.put("executorid", bean.getLogInfo().getExecutorid());
                 JobManager.addRealTimeJob(IGVIM0401JOB.JOB_NAME + info.getVmid(), 
                		 IGVIM0401JOB.JOB_GROUP_NAME, IGVIM0401JOB.TRIGGER_NAME + info.getVmid(), 
                         IGVIM0401JOB.TRIGGER_GROUP_NAME, new IGVIM0401JOB(), map);
        	}catch (Exception e) {
        		e.printStackTrace();
			}
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pid", Integer.parseInt(pid));
        map.put("prid", bean.getLogInfo().getPrid());
        map.put("executorid", bean.getLogInfo().getExecutorid());
        try{
        	JobManager.addRealTimeJob(IGVIM0402JOB.JOB_NAME + pid, IGVIM0402JOB.JOB_GROUP_NAME, 
        			IGVIM0402JOB.TRIGGER_NAME + pid, 
                    IGVIM0402JOB.TRIGGER_GROUP_NAME, new IGVIM0402JOB(), map);
        }catch (Exception e) {
        	e.printStackTrace();
		}
	}

}
