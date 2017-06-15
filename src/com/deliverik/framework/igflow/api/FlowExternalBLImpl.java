/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.igflow.api;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG992BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowExternalExecuteBL;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
 * 流程外部事件处理API
 */
public class FlowExternalBLImpl implements FlowExternalBL{
	
	static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
	
	/** 外部调用处理类 */
	IG992BL ig992BL;
	
	/**
	 * 外部调用处理类注入
	 * @param ig992BL
	 */
	public void setIg992BL(IG992BL ig992BL) {
		this.ig992BL = ig992BL;
	}

	/**
	 * 外部事件调用方法
	 * 
	 * @param eventID 事件ID
	 * @param param 参数信息
	 * @throws BLException
	 */
	public void eventHandler(String eventID, ExternalParameterInfo param) throws BLException{
	    igflowlog.debug(">>>流程外部调用处理开始");
		if(StringUtils.isEmpty(eventID) || StringUtils.isEmpty(eventID.trim())){
			throw new BLException("IGEXTERNAL.E001","事件eventID为空！");
		}
		if(ig992BL == null) {
			throw new BLException("IGEXTERNAL.E001","获取外部调用处理类出错！");
		}
		//获取所有登记的外部调用实体
		List<IG992Info> lstProcessExternalDefInfo = ig992BL.searchIG992Info();
		if(lstProcessExternalDefInfo == null || lstProcessExternalDefInfo.size() == 0){
			throw new BLException("IGEXTERNAL.E001","没有定义外部调用实现类,请先在流程定义、外部调用配置中进行登记！");
		}
		WorkFlowExternalExecuteBL bl = null;
		boolean searchBl = false;
		//根据eventID查询外部调用实现类
		for(IG992Info info : lstProcessExternalDefInfo){
			if(info.getPedeventid().equals(eventID)){
				//取得外部调用实现类
				try {
					bl = (WorkFlowExternalExecuteBL)WebApplicationSupport.getBean(info.getPedaction());
				} catch (Exception e) {
					throw new BLException("IGEXTERNAL.E001","没有找到"+eventID+"对应的"+info.getPedaction()+"的实现类,请确认配置文件正确！");
				}
				searchBl = true;
				//调用实际处理类
				bl.eventExecute(eventID, param);
			}
		}
		if(!searchBl){
			throw new BLException("IGEXTERNAL.E001","没有找到"+eventID+",请确认是否登记过！");
		}
		igflowlog.debug(">>>流程外部调用处理结束");
	}
}
 