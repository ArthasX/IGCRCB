package com.dev.ext.igflow.event.button;

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
 * 服务请求流程发起状态提交按钮动作定义
 * 判断一级审批人是否存在，设定一级审批人是否存在表单值
 * </p>
 */
public class IGEVENT0301BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0301BLImpl.class);
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	/**
	 * 查询类功能API类设定
	 * 
	 * @param flowSearchBL 更新功能API类查询类功能API类
	 */
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
		
		if (bean.getLogInfo().getPrid()!=null){
			//查询一级审批人
			List<ParticipantInfo> pInfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "一级审批");
			
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			
			//表单名
			ppivInfo.setFormname("一级审批是否存在");
	
			if (pInfoList != null && pInfoList.size() > 0){
				//设置一级审批人是否存在表单值为1			
				//表单值
				ppivInfo.setFormvalue("1");			
			} else {
				//设置一级审批人是否存在表单值为0			
				//表单值
				ppivInfo.setFormvalue("0");			
			}
			this.flowSetBL.setPublicProcessInfoValue(ppivInfo);
		}
		
	}

}
