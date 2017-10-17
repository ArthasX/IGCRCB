/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.dev.hac.util.ComUtil;
/**
 * 变更关闭  节点调用HAC
 * @author lvxin
 * @mail lvxin@deliverik.com
 * @time 2017-08-18
 *
 */
public class IGSVC0601BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGSVC0601BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	/**
     * 后处理
     */
	public void afterTreatmentExecute(final WorkFlowStatusEventBeanInfo bean) throws BLException {
		  log.debug("========变更流程关闭节点向堡垒机发送关闭请求前处理========");
		    
		    final List<ProcessRecordInfo> processInfo = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(),null);
		    
		    //流程单号
		    String workNoteNumber = processInfo.get(0).getPrserialnum();
		    
		    //调用HTTP接口请求
		    String url = ResourceUtility.getString("WORKNOTESTATUS_URL")+workNoteNumber;
		    
		    final Map<String,Object> jsonmap =  ComUtil.httpRequest(url, "PUT", null);

		    if(jsonmap==null){
		    	log.error("变更流程复核节点后处理调用堡垒机接口失败，接口未连通");
	        	Thread deployThread = new Thread(){
	     			@Override
	     			public void run() {
	     				//添加流程日志表
	     				WorkFlowLog wfl = new WorkFlowLog();
	     				wfl.setPrid(bean.getLogInfo().getPrid());
	     				wfl.setExecutorid(processInfo.get(0).getPruserid());	
	     				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
	     				wfl.setAuthuserid("");
	     				wfl.setComment("堡垒机变更流程关闭请求接口无法连通:conncet failed");
	     				try {
	 						flowSetBL.setProcessLog(wfl, "与堡垒机流程关闭请求接口通讯失败", Constants.PROCESS_LOG_TYPE_PROCESSING);
	 					} catch (BLException e) {
	 						e.printStackTrace();
	 					}
	     			}
	     		};
	     		deployThread.start();
	         	throw new BLException("IGHAC0101.E001", "与堡垒机流程关闭请求接口通讯失败");
	        }else{
	        	 if(jsonmap.get("success").toString()=="false"){
	         		Thread deployThread = new Thread(){
	         			@Override
	         			public void run() {
	         				//添加流程日志表
	         				WorkFlowLog wfl = new WorkFlowLog();
	         				wfl.setPrid(bean.getLogInfo().getPrid());
	         				wfl.setExecutorid(processInfo.get(0).getPruserid());	
	         				wfl.setExecutorRoleid(processInfo.get(0).getPrroleid());
	         				wfl.setAuthuserid("");
	         				wfl.setComment("错误码："+jsonmap.get("errorCode").toString()+"；错误信息："+jsonmap.get("errorMessage").toString()+"；");
	         				try {
	     						flowSetBL.setProcessLog(wfl, "与堡垒机通讯失败", Constants.PROCESS_LOG_TYPE_PROCESSING);
	     					} catch (BLException e) {
	     						e.printStackTrace();
	     					}
	         			}
	         		};
	         		deployThread.start();
	             	throw new BLException("IGHAC0101.E001", jsonmap.get("errorMessage").toString());
	             }
	        }
			log.debug("========变更流程关闭节点向堡垒机发送关闭请求前处理结束========");
	}
	
	/**
	 * 前处理添加参与者
	 */
	public void preTreatmentExecute(final WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
	
	public static void main(String[] args){
		 String url = ResourceUtility.getString("WORKNOTESTATUS_URL")+"C20171012001";
		 final Map<String,Object> jsonmap =  ComUtil.httpRequest(url, "PUT", null);
		 System.out.println(jsonmap);
	}
}

