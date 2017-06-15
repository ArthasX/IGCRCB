/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.vim.igflow.event.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.soc.vir.bl.task.VCD03BL;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD03SearchCondImpl;
import com.dev.vim.igflow.jobs.IGVIM3001JOB;
import com.dev.vim.igflow.jobs.IGVIM3002JOB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟机克隆操作
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIM3002BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象取得 */
	private static Log log = LogFactory.getLog(IGVIM3002BLImpl.class);
	
	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** VMBL */
	protected VCD03BL vcd03BL;

    /**
	 * 查询类api设定
	 * @param flowSearchBL 查询类api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * VMBL设定
	 * @param vcd03BL VMBL
	 */
	public void setVcd03BL(VCD03BL vcd03bl) {
		vcd03BL = vcd03bl;
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
         VCD03SearchCondImpl cond = new VCD03SearchCondImpl();
         cond.setPid(Integer.parseInt(pid));
         cond.setPrid(bean.getLogInfo().getPrid());
         List<VCD03Info> list = vcd03BL.searchVCD03(cond);
         for(VCD03Info entity : list){
        	 String progress = entity.getProgress();
        	 if ("100".equals(progress)) {
                 continue;
             }
        	 Map<String, Object> map = new HashMap<String, Object>();
             map.put("pid", entity.getPid());
             map.put("vmid", entity.getId());
             map.put("vcid", entity.getVcid());
             map.put("prid", bean.getLogInfo().getPrid());
             map.put("executorid", bean.getLogInfo().getExecutorid());
             try{
            	 JobManager.addRealTimeJob(IGVIM3001JOB.JOB_NAME + entity.getId(), IGVIM3001JOB.JOB_GROUP_NAME, IGVIM3001JOB.TRIGGER_NAME + entity.getId(), 
            			 IGVIM3001JOB.TRIGGER_GROUP_NAME, new IGVIM3001JOB(), map);
             }catch(Exception e){
            	 log.error("",e);
             }
         }
         
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("pid", Integer.parseInt(pid));
         map.put("prid", bean.getLogInfo().getPrid());
         map.put("executorid", bean.getLogInfo().getExecutorid());
         
         try {
             JobManager.addRealTimeJob(IGVIM3002JOB.JOB_NAME + pid, IGVIM3002JOB.JOB_GROUP_NAME, IGVIM3002JOB.TRIGGER_NAME + pid, 
                     IGVIM3002JOB.TRIGGER_GROUP_NAME, new IGVIM3002JOB(), map);
         } catch (Exception e) {
             e.printStackTrace();
         }
    	 log.debug("========资源申请自动部署前处理结束========");
    }
}
