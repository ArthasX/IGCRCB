/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.Date;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.DrillplanitemBL;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
 * 应急演练流程-关闭节点前处理
 * 
 * 更新演练计划表和计划任务表 修改状态为已演练
 * 
 * @author zyl
 *
 * 2015年3月16日13:34:06
 */
public class IGDRMEVENT0703BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0703BLImpl.class);
    /**流程API*/
    private FlowSearchBL flowSearchBL;
    /**计划任务BL*/
    private DrillplanitemBL drillplanitemBL;
    /**
     * 演练计划发起后处理
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
	
	/**
	 * 演练计划发起前处理
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	log.debug("========演练计划发起后处理更新演练计划表和计划任务表开始========");
		Integer prid = bean.getLogInfo().getPrid();
		
		//计划任务id 
		String jobId = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.PLAN_JOB_NAME);
		if(jobId!=null&&!"".equals(jobId)){

			DrillplanitemInfo rpiInfo = drillplanitemBL.searchDrillplanitemByPK(Integer.parseInt(jobId));
			if(rpiInfo!=null){
				
				DrillplanitemTB dpiTB = (DrillplanitemTB) SerializationUtils.clone(rpiInfo);
				//实际开始时间设定
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				dpiTB.setStatus("已演练");
				dpiTB.setActstarttime(datetime);
				dpiTB.setPrid(prid);
				drillplanitemBL.updateDrillplanitem(dpiTB);
			}
		}
		
		log.debug("========演练计划发起后处理更新演练计划表和计划任务表结束========");
		
		//请求地址通过业务系统ID更新业务系统应急演练状态
		IGDRMEmergencyTools.changeSystemState(prid, "业务系统", "0",null);
    }

	/**
	 * @param 流程API the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * @param 计划任务BL the drillplanitemBL to set
	 */
	public void setDrillplanitemBL(DrillplanitemBL drillplanitemBL) {
		this.drillplanitemBL = drillplanitemBL;
	}


    
}
