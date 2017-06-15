/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.crc.igflow.event.button;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/***
 * 问题整改管理待发起的提交按钮事件
 * @time 2014/06/18
 * @author wanglei
 * @version 1.0
 * @mail wanglei@deliverik.com
 */
public class IGFXK0603BLImpl implements WorkFlowStatusButtonHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGFXK0603BLImpl.class);
	
	/** 查询类API */
	private FlowSearchBL flowSearchBL;
	
	/** 流程更新API */
	private FlowSetBL flowSetBL;
	
	/** 资产属性业务BL */
	private SOC0107BL soc0107BL;
	
	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	/**
	 * 流程更新API设定
	 * @param flowSetBL 流程更新API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info)
			throws BLException {
		log.debug("=====================问题整改管理待发起的提交按钮事件处理开始=====================");
		
		/** 如果流程是由风险事件发起，更新相关风险事件 */
		String eiid = flowSearchBL.searchPublicProcessInfo(info.getLogInfo().getPrid(), "资产ID");
		if(StringUtils.isNotEmpty(eiid)){
			SOC0107SearchCondImpl configCond = new SOC0107SearchCondImpl();
			configCond.setCid("CI200000000020");
			configCond.setEiid(eiid);
			List<SOC0107Info> configList = soc0107BL.searchSOC0107(configCond);
			SOC0107TB config = (SOC0107TB)SerializationUtils.clone(configList.get(0));
			config.setCivalue(info.getLogInfo().getPrid().toString());
			soc0107BL.updateSOC0107(config);
		}
		
		log.debug("=====================问题整改管理待发起的提交按钮事件处理结束=====================");
	
	}
	
	
}
