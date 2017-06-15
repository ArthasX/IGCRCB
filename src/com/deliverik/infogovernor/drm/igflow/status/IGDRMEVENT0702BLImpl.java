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
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.task.SigninBL;

/**
 * 应急演练流程-演练准备节点前处理
 * 
 * 签到参与人入库
 * 
 * @author zyl
 *
 *         2015年3月12日21:03:48
 */
public class IGDRMEVENT0702BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0702BLImpl.class);
    /**流程API*/
    private FlowSearchBL flowSearchBL;
    /**签到表BL*/
    private SigninBL signinBL;
	private WorkFlowOperationBL workFlowOperationBL;



	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

		// ------------------------给参与人发送短信-----------------------
		// 发送邮件   改为发送短信  张剑  2017年6月7日17:00:49
		
				// 专项预案
				String emcproeiname = null;
				// 演练场景
				ProcessInfoEntityInfo sceneEntityInfo = this.flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.EMERGENCY_SCENE_NAME).get(0);
				//场景名称
				String sceneeiname = sceneEntityInfo.getEiname();
				//获取场景中的流程定义id
				String scenePdid = flowSearchBL.searchEntityItemConfigValue(sceneEntityInfo.getEiid(), IGDRMCONSTANTS.PROCESS_DEF_ID);
				if(StringUtils.isEmpty(scenePdid)){
					throw new BLException("IGEXTERNAL.E001","未查询到场景中关联的流程模版");
				}
				
				workFlowOperationBL.send(bean.getLogInfo().getPrid(), emcproeiname, sceneeiname, scenePdid, IGStringUtils.getCurrentDateTime());

	}

	/**
	 * 应急演练流程-演练实施前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========应急演练中演练准备节点前处理添加签到人员开始========");
    	
		// ------------------------给参与人发送邮件-----------------------
		// 专项预案
//		String emcproeiname = this.flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.SPECIAL_PLAN_NAME).get(0).getEiname();
//		// 演练场景
//		String sceneeiname = this.flowSearchBL.searchProcessEntityItem(bean.getLogInfo().getPrid(), IGDRMCONSTANTS.EMERGENCY_SCENE_NAME).get(0).getEiname();
//		// 发送邮件   改为发送短信  张剑  2017年6月7日17:00:49
//		if(sceneeiname!=null)
//		
//		workFlowOperationBL.send(bean.getLogInfo().getPrid(), emcproeiname, sceneeiname, bean.getPdid(), IGStringUtils.getCurrentDateTime());

		// ------------------ 初始化签到信息-----------------
		signinBL.registerSigninInfo(bean.getLogInfo().getPrid(), null, null, "WDP", workFlowOperationBL.getSceneParticipant(bean.getLogInfo().getPrid()));

		log.debug("========应急演练中演练准备节点前处理添加签到人员结束========");
	}

	/**
	 * @param 流程API the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	/**
	 * @param 签到表BL the signinBL to set
	 */
	public void setSigninBL(SigninBL signinBL) {
		this.signinBL = signinBL;
	}


}
