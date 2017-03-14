package com.dev.qlb.igflow.event.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * 
 * 功能：指派检查工作。发起节点如果选择分派人员，则进入分派节点，如果选择处理人，则会进入执行节点
 * @author 史凯龙   2014-9-9
 */
public class IGCRC0408BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** 日志对象取得 */
	static Log log = LogFactory.getLog(IGCRC0408BLImpl.class);

	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 风险检查信息BL */
	protected RiskCheckResultBL riskCheckResultBL;

	/**
	 * @param 查询类功能API类
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * @param riskCheckResultBL the riskCheckResultBL to set
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}

	/** 前处理 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** 后处理 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========指派工作流程部门审批前处理设置参与者处理开始========");
	        setNextPoint(bean);
	        	        
			log.debug("========指派工作流程部门审批前处理设置参与者处理结束========");
	}
	
	/**
	 * 设置下一个节点
	 * @param bean
	 */
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub
		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "人员");
//		String people = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "处理人");
        if(StringUtils.isNotEmpty(rcrid)){
//        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setAssignprid(bean.getLogInfo().getPrid());
//        		rcrTB.setRcrusername(people);
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}			
        }        
	}
}