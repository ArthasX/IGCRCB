/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.event.external;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowExternalExecuteBL;

public class ExampleBLImpl implements WorkFlowExternalExecuteBL{
	
	static Log log = LogFactory.getLog(ExampleBLImpl.class);

	public void eventExecute(String eventID, ExternalParameterInfo param) throws BLException {
		log.debug("==================打印参数开始===============");
		log.debug("eventID:"+eventID);
		log.debug("==================打印参数结束===============");
	}
}
