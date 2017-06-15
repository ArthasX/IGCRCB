/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import java.util.Date;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.DrillplanitemBL;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;

/**
 * 应急演练流程-演练计划发起后处理
 * 
 * 更新演练计划表和计划任务表
 * 
 * @author zyl
 *
 * 2015年3月16日13:34:06
 */
public class IGDRMEVENT0701BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0701BLImpl.class);
    /**流程API*/
    private FlowSearchBL flowSearchBL;
    /**计划任务BL*/
    private DrillplanitemBL drillplanitemBL;
    /**流程实例BL*/
    private IG500BL ig500BL;
    
    /**
     * 演练计划发起后处理
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========演练计划发起后处理更新演练计划表和计划任务表开始========");
		Integer prid = bean.getLogInfo().getPrid();
		
		////把<演练内容>表单值复制到prdesc字段中
		IG500TB ig500tb = (IG500TB)ig500BL.searchIG500InfoByKey(prid);
		ig500tb.setPrdesc(flowSearchBL.searchPublicProcessInfo(prid, IGDRMCONSTANTS.DRILL_FORM_DRCONTENT));
		ig500BL.updateIG500Info(ig500tb);
		
		//计划任务id 
		String jobId = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.PLAN_JOB_NAME);
		if(jobId!=null&&!"".equals(jobId)){

			DrillplanitemInfo rpiInfo = drillplanitemBL.searchDrillplanitemByPK(Integer.parseInt(jobId));
			if(rpiInfo!=null){
				//计划内发起时 设置任务名称为流程的名称
				ig500tb.setPrtitle(rpiInfo.getDiname());
				ig500BL.updateIG500Info(ig500tb);
				
				DrillplanitemTB dpiTB = (DrillplanitemTB) SerializationUtils.clone(rpiInfo);
				//实际开始时间设定
				Date nowDateTime = new Date();
				String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
				dpiTB.setStatus("演练中");
				dpiTB.setActstarttime(datetime);
				dpiTB.setPrid(prid);
				drillplanitemBL.updateDrillplanitem(dpiTB);
			}
		}else{
			//计划任务名称
			String jobname = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),IGDRMCONSTANTS.PLAN_JOB_FORM_NAME);
			//计划内发起时 设置任务名称为流程的名称
			if(StringUtils.isNotEmpty(jobname)){
				ig500tb.setPrtitle(jobname);
				ig500BL.updateIG500Info(ig500tb);
			}
		}
		
		log.debug("========演练计划发起后处理更新演练计划表和计划任务表结束========");
		
    }
	
	/**
	 * 
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
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

	/**
	 * @param ig500bl the 流程实例BL to set
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}


    
}
