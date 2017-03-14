/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * 问题流程 - 根据相关流程发起 设定等待流程 表单值
 * @author zhangqiang
 *
 */
public class IGSVC0101BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGSVC0101BLImpl.class);
	
	/**问题流程ID*/
	protected final static String QUESPRDID = "01083";
	
	/**服务流程ID*/
	protected final static String SERVICEPRDID = "01101";
	/**科技服务请求ID*/
	protected final static String TECHPRDID = "01100";
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
    /**
	 * 查询类功能API类设定
	 * @param flowSearchBL 查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/** 处理类API类*/
    private FlowOptBL flowOptBL;
	/**
	 * 更新功能API类设定
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	/**
	 * 处理类API类设定
	 * @param flowOptBL 处理类API类
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**前处理*/
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		
	}
	
	/**后处理*/
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//获取主流程
		Integer mainPrid = this.flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		
		if(mainPrid != null && mainPrid > 0){
			List<ProcessRecordInfo> searchInfo = flowSearchBL.searchProcessInfo(mainPrid, null);
			//实例化日志对象
			WorkFlowLog  mainLogInfo = new WorkFlowLog();
			mainLogInfo.setPrid(mainPrid);
			mainLogInfo.setExecutorid(bean.getLogInfo().getExecutorid());
			mainLogInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
			//获取主流程ID
			String prpdid=searchInfo.get(0).getPrpdid();
			if(prpdid.contains(QUESPRDID)||prpdid.contains(SERVICEPRDID)||prpdid.contains(TECHPRDID)){
				//实例化公有表单值对象
				PublicProcessInfoValue info = new PublicProcessInfoValue(mainLogInfo);
				info.setFormname("等待流程");
				info.setFormvalue("1");
			    //设定公有表单信息
				flowSetBL.setPublicProcessInfoValue(info);
				//判断主流程是问题流程
				if(prpdid.contains(QUESPRDID)){
					//流程跃迁
					flowOptBL.transitionProcess(mainPrid, bean.getLogInfo().getExecutorid(), "申请审核", IGStringUtils.getCurrentDateTime());
				//判断主流程是业务服务请求或者是科技服务请求	
				}else if (prpdid.contains(SERVICEPRDID)||prpdid.contains(TECHPRDID)){
					//流程跃迁
					flowOptBL.transitionProcess(mainPrid, bean.getLogInfo().getExecutorid(), "申请验证", IGStringUtils.getCurrentDateTime());
				}
			}
		}		
	}

}
