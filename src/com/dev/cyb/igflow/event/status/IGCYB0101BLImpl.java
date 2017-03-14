/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.cyb.igflow.event.status;

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

public class IGCYB0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0101BLImpl.class);
    private FlowSetBL flowSetBL;
    private FlowSearchBL flowSearchBL;

    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========变更发起后处理添加参与者开始========");
        //日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        participant.setStatusname("变更处理");
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);
        
        //变更处理节点添加发起人
        participant.setUserid(bean.getCrtuserid());
        participant.setRoleid(bean.getCrtroleid());
        this.flowSetBL.setStatusParticipant(participant);
       
//        //如果有合作人添加合作人到处理节点
//        List<ParticipantInfo> p1InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "合作人确认");
//        if ((p1InfoList != null) && (p1InfoList.size() > 0)) {
//            for (ParticipantInfo pInfo : p1InfoList) {
//                participant = new StatusParticipant(bean.getLogInfo());
//                participant.setStatusname("变更处理");
//                participant.setUserid(pInfo.getUserid());
//                participant.setRoleid(pInfo.getRoleid());
//                this.flowSetBL.setStatusParticipant(participant);
//            }
//        }
//        
//        //封装流程状态名称
//        participant.setStatusname("变更复核");
//        //删除跃迁节点的原有参与者
//        flowSetBL.deleteStatusParticipant(participant);
//        
//        //添加复核人到复核人确认节点
//        List<ParticipantInfo> p2InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "复核人确认");
//        if ((p2InfoList != null) && (p2InfoList.size() > 0)) {
//            for (ParticipantInfo pInfo : p2InfoList) {
//                participant = new StatusParticipant(bean.getLogInfo());
//                participant.setStatusname("变更复核");
//                participant.setUserid(pInfo.getUserid());
//                participant.setRoleid(pInfo.getRoleid());
//                this.flowSetBL.setStatusParticipant(participant);
//            }
//        }
//        
        log.debug("========变更发起后处理添加参与者结束========");

    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }
}
