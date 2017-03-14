/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.ApproveSuggestionTB;

/**
 * 填报状态后处理
 * 清空有效的审批意见
 *
 */
public class IGEVENT1404BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGEVENT1404BLImpl.class);
	
	/** 审批意见业务BL */
	private ApproveSuggestionBL approveSuggestionBL;

	/**
	 * 审批意见业务BL设定
	 * 
	 * @param approveSuggestionBL 审批意见业务BL
	 */
	public void setApproveSuggestionBL(ApproveSuggestionBL approveSuggestionBL) {
		this.approveSuggestionBL = approveSuggestionBL;
	}



	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("========清空指定填报人处理完成时间开始========");
	    //查询有效的表单审批意见
	    ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
	    cond.setPrid_eq(bean.getLogInfo().getPrid());
	    cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);//有效
	    List<ApproveSuggestionInfo> lst_ApproveSuggestionInfo = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
    	for(ApproveSuggestionInfo info : lst_ApproveSuggestionInfo) {
    		ApproveSuggestionTB tb = (ApproveSuggestionTB)SerializationUtils.clone(info);
    		tb.setStatus(IGSMRCONSTANT.APPROVE_STATUS_NO);//无效
    		this.approveSuggestionBL.updateApproveSuggestionInfo(tb);
    	}
		log.debug("========清空指定填报人处理完成时间结束========");
	}
	
	/**
	 * 清空全部参与者处理完成时间
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
	}

}

