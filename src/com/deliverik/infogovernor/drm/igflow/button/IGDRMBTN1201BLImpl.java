package com.deliverik.infogovernor.drm.igflow.button;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.PrivateProcessFormInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * 整改方案-节点按钮事件
 * 
 * </p>
 */
public class IGDRMBTN1201BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN1201BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    
	/**
	 * 更新功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }


	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	    
		log.debug("========整改计划审批按钮事件设定是否驳回开始========");
    	
    	// 查询评估结果
    	List<PrivateProcessFormInfo> ppfList = this.flowSearchBL.searchPrivateProcessInfo(bean.getLogInfo().getPrid(), "评审意见");
    	
    	// 是否驳回
    	String backflag = "否";
    	
    	// 如果有人否决了，则打回
    	for (PrivateProcessFormInfo ppfInfo : ppfList) {
    		if ("否决".equals(ppfInfo.getValue())) {
    			backflag = "是";
    		}
    	}
    	
    	// 更新是否驳回表单信息
    	PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
        ppivInfo.setFormname("是否驳回");
        ppivInfo.setFormvalue(backflag);
        this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
    	
    	log.debug("========整改计划审批按钮事件设定是否驳回结束========");
	}

}
