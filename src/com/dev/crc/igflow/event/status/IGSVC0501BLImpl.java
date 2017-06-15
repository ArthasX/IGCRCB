/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.infogovernor.drm.util.IGDRMEmergencyTools;
import com.deliverik.plugin.change.bl.IGCHANGE01BLImpl;
import com.deliverik.plugin.change.socket.IgChangeThread;
/**
 * 变更关闭  节点调用WebServers
 * @author zhangqiang
 * @mail zhangq@deliverik.com
 * @time 2015-09-15
 *
 */
public class IGSVC0501BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGSVC0501BLImpl.class);
	
	protected IGCHANGE01BLImpl iGCHANGE01BLImpl;
	
	
    
	/**
	 * iGCHANGE01BLImpl设定
	 * @param iGCHANGE01BLImpl iGCHANGE01BLImpl
	 */
	public void setiGCHANGE01BLImpl(IGCHANGE01BLImpl iGCHANGE01BLImpl) {
		this.iGCHANGE01BLImpl = iGCHANGE01BLImpl;
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
		
	    log.debug("========变更流程关闭节点前处理========");

	    //流程prid
	    Integer prid = bean.getLogInfo().getPrid();
	    
	    Thread thread = new Thread(new IgChangeThread(prid));
		//线程调用开始
		thread.start();
      
		log.debug("========变更流程关闭节点前处理结束========");
		//请求地址通过业务系统ID更新业务系统应急演练状态
		IGDRMEmergencyTools.changeFlowSystemState(prid, "0",null);
	}

}

