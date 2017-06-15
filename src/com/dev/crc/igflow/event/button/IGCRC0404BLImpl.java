/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.crc.igflow.event.button;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设置变更驳回次数
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC0404BLImpl implements WorkFlowStatusButtonHandlerBL{
	
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC0404BLImpl.class);
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info)
			throws BLException {
		log.debug("============设置表单值操作开始============");
		PublicProcessInfoValue value = new PublicProcessInfoValue(info.getLogInfo());
		value.setFormname("驳回次数");
		value.setFormvalue("1");
		flowSetBL.setPublicProcessInfoValue(value);
		log.debug("============设置表单值操作结束============");
	}

}
