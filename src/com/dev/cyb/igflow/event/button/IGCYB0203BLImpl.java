package com.dev.cyb.igflow.event.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * 发起提交按钮判断是否存在合作人
 * 
 * </p>
 */
public class IGCYB0203BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGCYB0203BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	private FlowSearchBL flowSearchBL;

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
	    this.flowSearchBL = flowSearchBL;
    }

	/**
	 * 更新功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}


	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
	    log.debug("========发起提交按钮判断是否存在合作人按钮事件处理开始========");
		
	    List<ParticipantInfo> p4InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "合作人确认");

        PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
       
        ppivInfo.setFormname("是否存在合作人");
        if ((p4InfoList != null) && (p4InfoList.size() > 0))
            ppivInfo.setFormvalue("1");
        else {
            ppivInfo.setFormvalue("0");
        }
        this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
		
		log.debug("========发起提交按钮判断是否存在合作人按钮事件处理结束========");
	}

}
