package com.deliverik.infogovernor.drm.igflow.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
/**
 * 通过业务系统ID更新业务系统应急演练状态
 * @author zhangbo
 *2016年9月21日
 */
public class IGDRMEVENT0705BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	static Log log = LogFactory.getLog(IGDRMEVENT0705BLImpl.class);
	
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 演练方案定义后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		Integer prid = bean.getLogInfo().getPrid();
		//请求地址通过业务系统ID更新业务系统应急演练状态
		
		IGDRMEmergencyTools.changeSystemState(prid, "业务系统", "1",null);
	}

}
