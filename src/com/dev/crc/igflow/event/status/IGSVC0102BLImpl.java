/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.igflow.resultset.ProcessStatusInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * 问题流程 - 根据相关流程发起 设定等待流程 表单值
 * @author zhangqiang
 *
 */
public class IGSVC0102BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGSVC0102BLImpl.class);
	
	/**问题流程ID*/
	protected final static String QUESPRDID = "01083";

	/**业务服务流程ID*/
	protected final static String SERVICEPRDID = "01101";
	
	/**科技服务请求ID*/
	protected final static String TECHPRDID = "01100";
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
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
	 * 查询类功能API类设定
	 * @param flowSearchBL 查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
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
		//获取主流程ID
		Integer mainPrid = this.flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		
		//判断是否存在主流程
		if(mainPrid != null && mainPrid > 0){
			//若此主流程存在多个相关流程则判断只有在当前流程是最后一个
			List<Integer> exPridList = flowSearchBL.searchProcessRelationForCld(mainPrid);
			boolean flag = true;
			int num = 1;
			if(exPridList != null && exPridList.size()>0){
				for(Integer exPrid : exPridList){
					List<ProcessRecordInfo> pList = flowSearchBL.searchProcessInfo(exPrid, null);
					if(StringUtils.isEmpty(pList.get(0).getPrclosetime())&&
							StringUtils.isNotEmpty(pList.get(0).getPrpdid())
							&& pList.get(0).getPrpdid().substring(0,5).equals("01102")){
						num++;
					}
				}
			}
			if(num>1){
				flag = false;//存在多个子流程未进行处理的
			}
			if(flag){
				//根据流程id获取流程相关信息
				List<ProcessRecordInfo> searchInfo = flowSearchBL.searchProcessInfo(mainPrid, null);
				//获取主流程ID
				String prpdid=searchInfo.get(0).getPrpdid();
				//判断主流程状态
				List<ProcessStatusInfo> statusList = flowSearchBL.searchCurrentStatus(mainPrid);
				//判断主流程是问题流程、业务服务请求、科技服务请求。
				if(statusList!=null && ("S".equals(statusList.get(0).getPsdcode())
						|| "Y".equals(statusList.get(0).getPsdcode())
						|| "W".equals(statusList.get(0).getPsdcode()))){
					if(prpdid.contains(QUESPRDID)||prpdid.contains(SERVICEPRDID)||prpdid.contains(TECHPRDID)){
						//实例化日志对象
						WorkFlowLog  mainLogInfo = new WorkFlowLog();
						mainLogInfo.setPrid(mainPrid);
						mainLogInfo.setExecutorid(bean.getLogInfo().getExecutorid());
						mainLogInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
						//实例化公有表单值对象
						PublicProcessInfoValue info = new PublicProcessInfoValue(mainLogInfo);
						info.setFormname("等待流程");
						info.setFormvalue("0");
						//设定公有表单信息
						flowSetBL.setPublicProcessInfoValue(info);
						//设置参与人
						StatusParticipant participant = new StatusParticipant(mainLogInfo);
						participant.setStatusname("等待程序开发");
						participant.setUserid(bean.getLogInfo().getExecutorid());
						participant.setRoleid(bean.getLogInfo().getExecutorRoleid());
						flowSetBL.setStatusParticipant(participant);
						//流程跃迁
						flowOptBL.transitionProcess(mainPrid, bean.getLogInfo().getExecutorid(), "更新结束", IGStringUtils.getCurrentDateTime());
					}					
				}
			}
		}
		
	}
	
	/**后处理*/
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
