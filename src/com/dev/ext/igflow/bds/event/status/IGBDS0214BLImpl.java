/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.bds.event.status;

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
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 升级流程-跟踪反馈节点添加参与者
 * </p>
 * 
 * @author yangyining@deliverik.com
 * @version 1.0
 */
public class IGBDS0214BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {

    /** 日志对象取得 */
    static Log log = LogFactory.getLog(IGBDS0214BLImpl.class);

    /** 更新功能API类 */
    private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
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
     * 查询类功能API类设定
     */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        
    }

    /**
     * 前处理添加参与者
     */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
        log.debug("========升级流程-跟踪反馈节点添加参与者处理开始========");
        
        
        List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "记录并分析问题");
        if(pInfoList == null || pInfoList.size() <= 0){
            throw new BLException("IGPRR0102.E006", "记录并分析问题");
        }
        
        if(pInfoList != null && pInfoList.size() > 0){
            //日志参数信息设定
            StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
            //封装流程状态名称
            participant.setStatusname("跟踪反馈");
            //删除跃迁节点的原有参与者
            flowSetBL.deleteStatusParticipant(participant);
            
            // 添加参与者
            for(ParticipantInfo info :pInfoList){
                //日志参数信息设定
                StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
                //封装流程处理人id
                participants.setUserid(info.getUserid());
                //封装流程处理角色id
                participants.setRoleid(info.getRoleid());
                //封装流程状态名称
                participants.setStatusname("跟踪反馈");
                //参与角色和参与人添加
                flowSetBL.setStatusParticipant(participants);
            }
        }else{
            throw new BLException("IGEWA0113.E001");
        }
        
        log.debug("========升级流程-跟踪反馈节点添加参与者处理结束========");
    
    }

}
