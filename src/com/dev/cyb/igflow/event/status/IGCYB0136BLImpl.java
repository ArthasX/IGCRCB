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

public class IGCYB0136BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGCYB0136BLImpl.class);
    /** 更新功能API类 */
    private FlowSetBL flowSetBL;

    /**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
    public void setFlowSetBL(FlowSetBL flowSetBL) {
        this.flowSetBL = flowSetBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    }

    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	 log.debug("========机房进出管理流程审核节点添加发起人为审核节点参与者开始========");

         //日志参数信息设定
         StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
         
         //封装流程状态名称
         participant.setStatusname("机房离开确认");
         //删除跃迁节点的原有参与者
         flowSetBL.deleteStatusParticipant(participant);
         
         StatusParticipant participant1 = new StatusParticipant(bean.getLogInfo());
         participant1.setStatusname("机房离开确认");
         participant1.setUserid(bean.getCrtuserid());
         participant1.setRoleid(bean.getCrtroleid());
         this.flowSetBL.setStatusParticipant(participant1);
         
         log.debug("========机房进出管理流程审核节点添加发起人为审核节点参与者结束========");
    }
}
