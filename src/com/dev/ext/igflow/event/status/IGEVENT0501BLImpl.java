/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * 问题流程等待程序开发节点前处理
 * 作用： 删除该节点的处理人  
 * </p>
 */
public class IGEVENT0501BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0501BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	/**
	 * 更新功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 流程状态前处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========等待程序开发节点前处理删除参与者处理开始========");
		
		 //日志参数信息设定
        StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
        //封装流程状态名称
        spInfo.setStatusname("等待程序开发");
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(spInfo);
        
		log.debug("========等待程序开发节点前处理删除参与者处理结束========");
	}

	/**
	 * 流程状态后处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
