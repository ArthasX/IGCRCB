/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.cyb.igflow.event.status;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0102BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0102BLImpl.class);
    private FlowSetBL flowSetBL;
    
    /** 流程查询功能BL*/
    private FlowSearchBL flowSearchBL;

    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    /**
	 * 流程查询功能BL设定
	 * @param flowSearchBL the 流程查询功能BL
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}


	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========发起结点后处理添加发起人为默认审核人开始========");

        //日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        participant.setStatusname("事件审核");
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);
        
        StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
        participant1.setStatusname("事件审核");
        participant1.setUserid(bean.getCrtuserid());
        participant1.setRoleid(bean.getCrtroleid());
        this.flowSetBL.setStatusParticipant(participant1);
        
        //告警流程发起则处理人为当前处理人
        String alarmName = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "事件来源");
        if(StringUtils.isNotBlank(alarmName) && alarmName.equals("监控告警")){
        	//封装流程状态名称
        	participant.setStatusname("事件分派");
        	//删除跃迁节点的原有参与者
        	flowSetBL.deleteStatusParticipant(participant);
        	StatusParticipant participant2 = new StatusParticipant(bean.getLogInfo());
        	participant2.setStatusname("事件分派");
        	participant2.setUserid(bean.getCrtuserid());
        	participant2.setRoleid(bean.getCrtroleid());
        	this.flowSetBL.setStatusParticipant(participant2);
        }
        log.debug("========发起结点后处理添加发起人为默认审核人结束========");
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
}
