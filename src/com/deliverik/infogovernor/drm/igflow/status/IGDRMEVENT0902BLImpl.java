/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.drm.igflow.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;

/**
 * 应急指挥流程-待发起(事件上报) 节点 后处理
 * 
 * 判断是否是通过普通事件升级的应急流程如果是则根据事件的名称设置指挥流程的名称
 * 
 * @author 张剑
 *
 *         2015-3-11 上午10:24:34
 */
public class IGDRMEVENT0902BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
    static Log log = LogFactory.getLog(IGDRMEVENT0902BLImpl.class);
    
    private FlowSearchBL flowSearchBL;
    
    private FlowSetBL flowSetBL;
    
    private IG500BL ig500BL;
    
	/**
	 * flowSetBL   设定
	 * @param flowSetBL flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 保存演练流程中的预案资产和预案资产
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
		Integer prid = bean.getLogInfo().getPrid();
		//2015年5月25日12:46:42，事件管理中紧急事件升级二级事件，自动发起应急指挥
    	String pridForHurry = flowSearchBL.searchPublicProcessInfo(prid, "紧急事件prid");
    	if(StringUtils.isNotEmpty(pridForHurry)){
    		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(Integer.parseInt(pridForHurry));
    		IG500TB ig500TB = (IG500TB) SerializationUtils.clone(ig500Info);
    		ig500TB.setPrstatus("#");
    		ig500BL.updateIG500Info(ig500TB);
    	}
		////把<演练内容>表单值复制到prdesc字段中
		IG500TB ig500tb = (IG500TB)ig500BL.searchIG500InfoByKey(prid);
		ig500tb.setPrdesc(flowSearchBL.searchPublicProcessInfo(prid, IGDRMCONSTANTS.EC_FORM_ECDESC));
		ig500tb.setPrtitle(flowSearchBL.searchPublicProcessInfo(prid, IGDRMCONSTANTS.EC_FORM_ECNAME));
		ig500BL.updateIG500Info(ig500tb);
    }
	
	/**
	 * 
	 */
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
    	
    }

	/**
	 * ig500BL   设定
	 * @param ig500BL ig500BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
}
