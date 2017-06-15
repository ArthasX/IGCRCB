/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;

/**
 * 应急指挥流程-资源协调节点后处理
 * 
 * 初始化签到信息
 * 
 * @author zyl
 *
 *         2015年3月19日11:22:49
 */
public class IGDRMEVENT0905BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0905BLImpl.class);
    
	private FlowSearchBL flowSearchBL;

	private SigninBL signinBL;

	private WorkFlowOperationBL workFlowOperationBL;

	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	/**
	 * 初始化签到信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {


    }
	

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("============应急指挥流程资源协调节点前处理开始===============");
		// 获取应急演练流程id
		String drillPrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.PRACTISE_PRID_LABEL);
		// 如果不是演练发起的指挥流程需要初始化签到信息
		if (StringUtils.isEmpty(drillPrid)) {
			// ------------------ 初始化签到信息-----------------
			signinBL.registerSigninInfo(null, bean.getLogInfo().getPrid(), null, "WDP", workFlowOperationBL.getSceneParticipant(bean.getLogInfo().getPrid()));
				//请求地址通过业务系统ID更新业务系统应急演练状态
			IGDRMEmergencyTools.changeSystemState(bean.getLogInfo().getPrid(), "业务系统", "7",null);
		}
		log.debug("============应急指挥流程资源协调节点前处理完成===============");
	}
}
