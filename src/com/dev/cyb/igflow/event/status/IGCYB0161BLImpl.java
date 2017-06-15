/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.cyb.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

public class IGCYB0161BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0160BLImpl.class);
    private FlowSetBL flowSetBL;

    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========指派工作发起后处理添加当前人为默认工作审核认开始========");
        
        //日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        participant.setStatusname("工作审核");
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);
        
        StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
        participant1.setStatusname("工作审核");
        participant1.setUserid(bean.getLogInfo().getExecutorid());
        participant1.setRoleid(bean.getLogInfo().getExecutorRoleid());
        this.flowSetBL.setStatusParticipant(participant1);
        
        log.debug("========指派工作发起后处理添加当前人为默认工作审核人结束========");
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }
}
