/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
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
 * 程序开发流程 - 分派节点处理人初始化
 * @time 2014/07/13
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGSVC0103BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
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
		
	    log.debug("========程序开发流程分派节点前处理开始========");

	    //获取流程参与者信息
	    List<ParticipantInfo> participantInfos =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "处理");
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	    ParticipantInfo info = null;
	    long l = 0;
	    for(ParticipantInfo pp:participantInfos){
	    	if(StringUtils.isNotEmpty(pp.getPpproctime())){
	    		try {
	    			Date date = sdf.parse(pp.getPpproctime());
	    			if(date.getTime() > l){
	    				l = date.getTime();
	    				info = pp;
	    			}
	    		} catch (ParseException e) {
	    			log.error("",e);
	    		}
	    	}
	    }
	    //设定状态参与者
	    StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
	    statusParticipant.setStatusname("分派");
	    statusParticipant.setUserid(info.getUserid());
	    statusParticipant.setRoleid(info.getRoleid());
	    //添加参与角色和参与人
	    flowSetBL.setStatusParticipant(statusParticipant);
	    
		log.debug("========程序开发流程分派节点前处理结束========");
	}
}

