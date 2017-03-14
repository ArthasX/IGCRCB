/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * 指派工作流程 - （执行工作）节点前处理预置处理人表单所选人员为执行工作节点处理人
 * @author wanglei
 *
 */
public class IGCRC0901BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC0901BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /** 执行工作*/
    private String STATUSNAME_ZXGZ = "执行工作";
    
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    /**
     * @param 查询类功能API类 the flowSearchBL to set
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

	/**
     * 后处理
     */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
	
	/**
	 * 前处理添加参与者
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========指派工作流程部门审批前处理设置参与者处理开始========");

	    //日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        participant.setStatusname(STATUSNAME_ZXGZ);
        
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);
        
        // 设置部门审批人
        setParticipant(bean);
        
		log.debug("========指派工作流程部门审批前处理设置参与者处理结束========");
	}

	/**
	 * 设置处理人
	 * @param bean
	 * @param applevel
	 * @param roleid
	 * @throws BLException
	 */
	private void setParticipant(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
		List<ParticipantInfo> ppList = flowSearchBL.searchPublicParticipantFormValue(bean.getLogInfo().getPrid(), "处理人");
		
	    if (ppList == null || ppList.size() == 0) {
	        throw new BLException("IGEWA0107.E001");
	    }
	    for (ParticipantInfo participantInfo : ppList) {
			
	        //日志参数信息设定
	        StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
	      
	        //封装流程状态名称
	        participants.setStatusname(STATUSNAME_ZXGZ);
	        
	        //封装流程处理人id
	        participants.setUserid(participantInfo.getUserid());
	      
	        //封装流程处理角色id
	        participants.setRoleid(participantInfo.getRoleid());
	      
	        //参与角色和参与人添加
	        flowSetBL.setStatusParticipant(participants);
	
	    }
	}
}

