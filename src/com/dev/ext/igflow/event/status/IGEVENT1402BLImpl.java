/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.event.status;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ParticipantStatusFormInfo;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT;
import com.deliverik.infogovernor.smr.bl.task.ApproveSuggestionBL;
import com.deliverik.infogovernor.smr.model.ApproveSuggestionInfo;
import com.deliverik.infogovernor.smr.model.condition.ApproveSuggestionSearchCondImpl;

/**
 * 清空指定填报人处理完成时间
 *
 */
public class IGEVENT1402BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGEVENT1402BLImpl.class);
	
	/** 查询功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	/** 审批意见业务BL */
	private ApproveSuggestionBL approveSuggestionBL;

	/**
	 * 注入查询功能API类
	 * 
	 * @param flowSearchBL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
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
		
	}
	
	/**
	 * 清空全部参与者处理完成时间
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    log.debug("========清空指定填报人处理完成时间开始========");
	    //查询有效的表单审批意见
	    ApproveSuggestionSearchCondImpl cond = new ApproveSuggestionSearchCondImpl();
	    cond.setPrid_eq(bean.getLogInfo().getPrid());
	    cond.setStatus_eq(IGSMRCONSTANT.APPROVE_STATUS_YES);//有效
	    List<ApproveSuggestionInfo> lst_ApproveSuggestionInfo = this.approveSuggestionBL.searchApproveSuggestionInfo(cond);
	    //查询填报状态下的参与者
	    List<ParticipantInfo> lst_ParticipantInfo = 
	    		this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), IGSMRCONSTANT.PRSTATUSNAME_REPORT);
	    boolean flag = true;
	    Set<String> set_Participant = new HashSet<String>();
	    for(ParticipantInfo participant : lst_ParticipantInfo) {
	    	//查询该参与角色在该状态下的表单权限
	    	List<ParticipantStatusFormInfo> lst_ParticipantStatusFormInfo =
	    		this.flowSearchBL.searchParticipantStatusFormInfo(bean.getPdid(), IGSMRCONSTANT.PRSTATUSNAME_REPORT, participant.getRoleid());
	    	for(ApproveSuggestionInfo info : lst_ApproveSuggestionInfo) {
	    		for(ParticipantStatusFormInfo form : lst_ParticipantStatusFormInfo) {
	    			//匹配表单定义ID和可写权限
	    			if(info.getPidid().equals(form.getPidid())
	    					&& IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(form.getPidaccess())) {
	    				//清空该参与者处理完成时间
	    				if(!set_Participant.contains(participant.getRoleid() + "_" + participant.getUserid())) {
	    					flowSetBL.setStatusParticipantRehandle(bean.getLogInfo().getPrid(),
	    							IGSMRCONSTANT.PRSTATUSNAME_REPORT, participant.getRoleid(), participant.getUserid());
	    					set_Participant.add(participant.getRoleid() + "_" + participant.getUserid());
	    					flag = false;
	    					break;
	    				}
	    			}
	    		}
	    	}
	    }
	    //当没找到对应参与者（如没填审批意见）时清空所有参与者的处理时间
	    if(flag) {
	    	for(ParticipantInfo participant : lst_ParticipantInfo) {
				flowSetBL.setStatusParticipantRehandle(bean.getLogInfo().getPrid(),
						IGSMRCONSTANT.PRSTATUSNAME_REPORT, participant.getRoleid(), participant.getUserid());
		    }
	    }
		log.debug("========清空指定填报人处理完成时间结束========");
	}

}

