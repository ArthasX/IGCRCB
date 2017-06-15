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
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * 审计流程 - 检查问题流程关闭节点前处理设置实际完成时间
 * @author Administrator
 *
 */
public class IGEVENT9903BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGEVENT9903BLImpl.class);
	
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
    
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
	
	/**
	 * 前处理添加参与者
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========检查问题流程关闭节点前处理设置实际完成时间处理开始========");

        PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());

        ppivInfo.setFormname("实际完成时间");
        ppivInfo.setFormvalue(IGStringUtils.getCurrentDateTime());
        
        this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
	    
		log.debug("========检查问题流程关闭节点前处理设置实际完成时间处理结束========");
	}

}

