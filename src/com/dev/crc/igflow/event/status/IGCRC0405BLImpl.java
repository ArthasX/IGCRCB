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

/***
 * 变更流程 - UAT变更测试分派节点处理人初始化
 * @time 2014/08/26
 * @author wanglei
 * @version 1.0
 * @mail wanglei@deliverik.com
 */
public class IGCRC0405BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC0401BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
    
    /** 流程查询功能API类 */
    private FlowSearchBL flowSearchBL;
    
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    /**
     * @param 流程查询功能API类 the flowSearchBL to set
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
		
	    log.debug("========变更流程UAT变更测试分派前处理开始========");
	    //清空全部参与者处理完成时间
        flowSetBL.setStatusParticipantAllRehandle(bean.getLogInfo().getPrid(), bean.getAfstatus());
	    //获取流程参与者信息
	    List<ParticipantInfo> participantInfos =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "变更评审");
	    for (ParticipantInfo participantInfo : participantInfos) {
	    	//设定状态参与者
	    	StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
	    	statusParticipant.setStatusname("UAT变更测试分派");
	    	statusParticipant.setUserid(participantInfo.getUserid());
	    	statusParticipant.setRoleid(participantInfo.getRoleid());
	    	//添加参与角色和参与人
	    	flowSetBL.setStatusParticipant(statusParticipant);
		}
	    
		log.debug("========变更流程UAT变更测试分派前处理结束========");
	}
}

